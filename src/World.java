import java.util.ArrayList;
import java.util.List;

public class World {
    WorldCord cord;
    PlayerCord playerCord;
    public List<PortalFeature> PORTALS = new ArrayList<>();
    public List<ConsumableFeature> CONSUMABLES = new ArrayList<>();
    public List<EnemyEntity> ENEMIES = new ArrayList<>();
    int mapLenX;
    int mapLenY;
    char[][] map;

    World(WorldCord cord, int xLen, int yLen){
        this.cord = cord;
        this.mapLenX = xLen;
        this.mapLenY = yLen;
        playerCord = new PlayerCord(5,5,this);
        this.map = this.createWorld();
    }

    public void initPlayerAt(PlayerCord cord){
        movePlayerTo(cord);
    }

    public char[][] createWorld(){
        char[][] tempMap = new char[mapLenY][mapLenX];
        for(int i = 0; i < mapLenY; i++){
            for(int j = 0; j < mapLenX; j++){
                if(i == 0 || j == 0 || i == mapLenY - 1 || j == mapLenX - 1){
                    tempMap[i][j] = '#';
                } else {
                    tempMap[i][j] = ' ';
                }
            }
        }
        return tempMap;
    }

    public void drawChar(PlayerCord cord, char ch){
        this.map[cord.y][cord.x] = ch;
    }

    public void movePlayerTo(PlayerCord newCord){
        if(!newCord.isWithinBoundary()) return;
        this.map[playerCord.y][playerCord.x] = ' ';
        this.playerCord= newCord;
        this.map[newCord.y][newCord.x] = 'P';
    }

    public void summonEntity(){
        for(EnemyEntity entity : this.ENEMIES){
            this.map[entity.entityCord.y][entity.entityCord.x] = entity.ch;
        }
    }

    public void moveEntity(EnemyEntity entity){
        if (entity.relativeTick % 3 == 0) return;
        this.map[entity.entityCord.y][entity.entityCord.x] = ' ';
        int dist = entity.entityCord.distanceTo(this.playerCord);
        if (dist <= entity.searchRadius) {
            List<PlayerCord> path = EnemyEntity.getPath(this, entity.entityCord, playerCord);
            if (!path.isEmpty()) {
                entity.entityCord = path.getFirst();
            }
            if(this.playerCord.equals(entity.entityCord)){
                entity.entityCord = entity.entityCord.getRandomDirection();
            }

        } else {
            PlayerCord next = entity.entityCord.getRandomDirection();
            if (next.isWithinBoundary()) {
                entity.entityCord = next;
            }
        }
        this.map[entity.entityCord.y][entity.entityCord.x] = entity.ch;
    }

    public void display(double hp){
        for(PortalFeature portal : PORTALS){
            map[portal.cord.y][portal.cord.x] = '0';
        }
        for(ConsumableFeature feature : CONSUMABLES){
            if(feature.isEaten) {
                map[feature.cord.y][feature.cord.x] = ' ';
            }else{
                map[feature.cord.y][feature.cord.x] = feature.ch;
            }
        }

        for(int i = 0; i < mapLenY; i++){
            for(int j = 0; j < mapLenX; j++){
                if(i==0 && j == mapLenX-1){
                    System.out.print("# \t Player Health: " + hp);
                    continue;
                }
                if(playerCord.x == j && playerCord.y == i){
                    System.out.print('P');
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }
}
