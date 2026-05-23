public class ObstacleFeature extends MapFeature{
    ObstacleFeature(PlayerCord cord,  World world) {
        super(FeatureType.OBSTACLE, cord, '#', world);
    }

    @Override
    public boolean isBlocking(){
        return true;
    }

}
