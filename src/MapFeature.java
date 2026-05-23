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

    public void tryInteract(PlayerEntity player) {
        if (this.cord.equals(world.playerCord)) {
            onInteract(player);
        }
    }

    public  void onInteract(PlayerEntity player){
    }

    public boolean isBlocking(){
        return false;
    }

    public boolean canRender(){
        return true;
    }
}
