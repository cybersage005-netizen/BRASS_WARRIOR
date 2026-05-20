import java.util.List;

public class FeatureDrawer {
    public static void draw(World world, List<? extends MapFeature> features){
        for(MapFeature feature : features){
            world.drawChar(feature.cord, feature.ch);
        }
    }
}
