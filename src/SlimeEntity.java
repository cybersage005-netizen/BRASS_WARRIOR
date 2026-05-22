
public class SlimeEntity extends EnemyEntity{
    SlimeEntity(int id, int maxHP, int damage, char ch, int sr,PlayerCord cord, World world) {
        super(id, maxHP, damage, ch,  sr, cord, world);
    }

    @Override
    public int getDamage() {
        return 10;
    }
}
