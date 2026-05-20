public class PortalFeature extends MapFeature{
    WorldCord leadingWorldCord;
    PortalFeature(PlayerCord cord, World world, WorldCord newWorldCord) {
        this.leadingWorldCord = newWorldCord;
        super(FeatureType.PORTAL, cord, '0', world);
    }
}
