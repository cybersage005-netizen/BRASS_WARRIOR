import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.List;

public class World {
    WorldCord cord;
    PlayerCord playerCord;
    public List<MapFeature> FEATURES = new ArrayList<>();
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
        if(!newCord.isWithinBoundary() || this.isCollidingWithObstacles(newCord)) return;
        this.map[playerCord.y][playerCord.x] = ' ';
        this.playerCord= newCord;
        this.map[newCord.y][newCord.x] = 'P';
    }

    public void summonEntity(){
        for(EnemyEntity entity : this.ENEMIES){
            this.map[entity.entityCord.y][entity.entityCord.x] = entity.ch;
        }
    }

    public  boolean isCollidingWithObstacles(PlayerCord checkCord){
        for(MapFeature feature : FEATURES){
            if(feature.isBlocking() && feature.cord.equals(checkCord)){
                return true;
            }
        }
        return false;
    }

    public void moveEntity(EnemyEntity entity){
        if (entity.relativeTick % 3 == 0) return;
        this.map[entity.entityCord.y][entity.entityCord.x] = ' ';
        int dist = entity.entityCord.distanceTo(this.playerCord);
        if (dist <= entity.searchRadius) {
            List<PlayerCord> path = EnemyEntity.getPath(this, entity.entityCord, playerCord);
            if (!path.isEmpty()) {
                entity.entityCord = path.getFirst();
            } else {
                PlayerCord randomPos = entity.entityCord.getRandomDirection();
                if (!this.isCollidingWithObstacles(randomPos)) {
                    entity.entityCord = randomPos;
                }
            }

        } else {
            PlayerCord next = entity.entityCord.getRandomDirection();
            if (next.isWithinBoundary() && !this.isCollidingWithObstacles(next)) {
                entity.entityCord = next;
            }
        }
        this.map[entity.entityCord.y][entity.entityCord.x] = entity.ch;
    }

    public void display(PlayerEntity entity){

       for(MapFeature feature : FEATURES){
           if(!feature.canRender()) continue;
           this.map[feature.cord.y][feature.cord.x] = feature.ch;
       }

        for(int i = 0; i < mapLenY; i++){
            for(int j = 0; j < mapLenX; j++){
                if(i==0 && j == mapLenX-1){
                    System.out.print("# \t Player Health: " + entity.hp);
                    continue;
                }
                if(i==1 && j == mapLenX-1){
                    System.out.print("# \t Coins Collected: " + entity.currency);
                    continue;
                }
                if(i==2 && j == mapLenX-1){
                    System.out.print("# \t Inventory: " + entity.inventory);
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
