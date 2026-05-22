import java.util.ArrayList;

public class WorldManager {
    static ArrayList<World> WORLDS = new ArrayList<>();
    public static void addALlWorlds(){
        for(World w : WORLDS){
            WorldSet.addWorld(w);
        }
    }



    public static void init(){
        System.out.println("Created Worlds");
    }

    static {
        World B0_B0 = createWorld(0, 0, 10, 8);
        B0_B0.PORTALS.add(new PortalFeature(new PlayerCord(5,6, B0_B0), B0_B0, new WorldCord(0, 1)));

        World B0_A1 = createWorld(0, 1, 10, 10);
        B0_A1.PORTALS.add(new PortalFeature(new PlayerCord(8 , 8, B0_A1), B0_A1, new WorldCord(0, 2)));

        World B0_A2 = createWorld(0, 2, 15, 15);
        B0_A2.CONSUMABLES.add(new AppleFeature(new PlayerCord(8, 11, B0_A2), B0_A2));
        B0_A2.ENEMIES.add(new SlimeEntity(0, 30, 10, 'S',5, new PlayerCord(11,11, B0_A2), B0_A2));
        B0_A2.summonEntity();

    }

    private static World createWorld(int x, int y, int w, int h) {
        World world = new World(new WorldCord(x, y), w, h);
        WORLDS.add(world);
        return world;
    }
}
