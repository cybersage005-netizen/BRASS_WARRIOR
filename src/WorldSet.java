import java.util.HashMap;
import java.util.Map;

public class WorldSet {
    static Map<WorldCord, World> WORLD_MAP = new HashMap<>();

    public static void addWorld( World world){
        WORLD_MAP.put(world.cord, world);
    }

    public static World getWorld(WorldCord cord){
        return WORLD_MAP.getOrDefault(cord, getRoot());
    }

    public static World getRoot(){
        return WORLD_MAP.get(new WorldCord(0,0));
    }
}
