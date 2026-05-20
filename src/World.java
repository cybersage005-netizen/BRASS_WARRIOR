import java.util.ArrayList;
import java.util.List;

public class World {
    WorldCord cord;
    PlayerCord playerCord;
    List<PortalFeature> PORTALS = new ArrayList<>();
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
        this.playerCord.x = newCord.x;
        this.playerCord.y = newCord.y;
        this.map[newCord.y][newCord.x] = 'P';
    }

    public void display(){
        for(PortalFeature portal : PORTALS){
            map[portal.cord.y][portal.cord.x] = '0';
        }
        for(int i = 0; i < mapLenY; i++){
            for(int j = 0; j < mapLenX; j++){
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
