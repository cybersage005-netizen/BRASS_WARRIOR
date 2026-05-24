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
        B0_B0.FEATURES.add(new PortalFeature(new PlayerCord(5,6, B0_B0), B0_B0, new WorldCord(0, 1)));
        B0_B0.FEATURES.add(new PortalFeature(new PlayerCord(1, 2, B0_B0), B0_B0, new WorldCord(-1, 0)));

        World B0_A1 = createWorld(0, 1, 10, 10);
        B0_A1.FEATURES.add(new PortalFeature(new PlayerCord(8 , 8, B0_A1), B0_A1, new WorldCord(0, 2)));
        B0_A1.FEATURES.add(new PortalFeature(new PlayerCord(3 , 1, B0_A1), B0_A1, new WorldCord(0, 0)));
        B0_A1.FEATURES.add(new CoinFeature(new PlayerCord(2 , 2, B0_A1), '$', B0_A1));
        B0_A1.FEATURES.add(new ItemStack(Items.BANANA, new PlayerCord(2 , 7, B0_A1),  B0_A1));

        World B0_A2 = createWorld(0, 2, 15, 15);
        B0_A2.FEATURES.add(new AppleFeature(new PlayerCord(8, 11, B0_A2), B0_A2));

        B0_A2.ENEMIES.add(new SlimeEntity(0, Enemies.SLIME, new PlayerCord(11,11, B0_A2), B0_A2));
        B0_A2.FEATURES.add(new ObstacleFeature(new PlayerCord(7,8, B0_A2), B0_A2));
        B0_A2.summonEntity();

        World C1_B0 = createWorld(-1, 0, 20, 20);
        C1_B0.FEATURES.add(new ItemStack(Items.BANANA, new PlayerCord(15, 15, C1_B0), C1_B0, 20));
        C1_B0.ENEMIES.add(new SlimeEntity(1, Enemies.SLIME, new PlayerCord(10, 14, C1_B0), C1_B0));
        C1_B0.summonEntity();


    }

    private static World createWorld(int x, int y, int w, int h) {
        World world = new World(new WorldCord(x, y), w, h);
        WORLDS.add(world);
        return world;
    }
}
