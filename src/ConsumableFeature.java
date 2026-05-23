public class ConsumableFeature extends MapFeature implements EatableFood{
    ConsumableType type;
    PlayerCord cord;
    boolean isEaten = false;
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

    @Override
    public boolean canRender(){
        return !this.isEaten;
    }

    @Override
    public void onInteract(PlayerEntity player) {
        if(this.isEaten)return;
        if((player.hp + this.getSaturation()) <= player.maxHP){
            player.hp += this.getSaturation();
            this.isEaten = true;
        }
    }
}
