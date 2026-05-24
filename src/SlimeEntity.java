
public class SlimeEntity extends EnemyEntity{
    SlimeEntity(int id, Enemies enemy,PlayerCord cord, World world) {
        super(id, enemy, cord, world);
    }

    @Override
    public int getDamage() {
        return 10;
    }
}
