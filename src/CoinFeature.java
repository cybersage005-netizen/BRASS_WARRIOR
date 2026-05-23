public class CoinFeature extends ConsumableFeature{
    CoinFeature(PlayerCord cord, char ch, World world) {
        super(ConsumableType.COIN, cord, ch, world);
    }

    @Override
    public void onInteract(PlayerEntity player){
        if(this.isEaten)return;
        player.currency += 1;
        this.isEaten = true;
    }
}
