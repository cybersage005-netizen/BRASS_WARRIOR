public abstract class MapFeature {
    FeatureType type;
    public PlayerCord cord;
    char ch;
    World world;

    MapFeature(FeatureType type, PlayerCord cord, char ch, World world){
        this.type = type;
        this.cord = cord;
        this.ch = ch;
        this.world = world;
    }




}
