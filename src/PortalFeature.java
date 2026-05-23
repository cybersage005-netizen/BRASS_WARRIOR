public class PortalFeature extends MapFeature {
    WorldCord leadingWorldCord;
    public PortalFeature(PlayerCord cord, World world, WorldCord newWorldCord) {
        this.leadingWorldCord = newWorldCord;
        super(FeatureType.PORTAL, cord, '0', world);
    }

    @Override
    public void onInteract(PlayerEntity player){
        player.currentWorld = WorldSet.getWorld(leadingWorldCord);
    }
}
