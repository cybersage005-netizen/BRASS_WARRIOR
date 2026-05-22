public class AppleFeature extends ConsumableFeature implements EatableFood {
    AppleFeature( PlayerCord cord,  World world) {
        super(ConsumableType.APPLE, cord, 'A', world);
    }

    @Override
    public double getSaturation() {
        return 10;
    }
}
