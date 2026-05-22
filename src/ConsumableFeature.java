public class ConsumableFeature extends MapFeature implements EatableFood{
    ConsumableType type;
    PlayerCord cord;
    boolean isEaten;
    char ch;
    World world;
    ConsumableFeature(ConsumableType consumableType, PlayerCord cord, char ch, World world) {
        super(FeatureType.CONSUMABLE, cord, ch, world);

        this.type = consumableType;
        this.cord = cord;
        this.ch = ch;
        this.world = world;
    }

    @Override
    public double getSaturation() {
        return 0;
    }
}
