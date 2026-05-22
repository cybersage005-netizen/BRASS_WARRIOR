import java.util.List;

public abstract class EnemyEntity extends CharacterEntity{
    int damage;
    PlayerCord entityCord;
    int searchRadius;
    char ch;
    List<PlayerCord> path;
    int relativeTick = 0;
    EnemyEntity(int id, int maxHP, int damage, char ch, int searchRadius, PlayerCord cord, World world) {
        super(id, maxHP);
        this.damage = damage;
        this.entityCord = cord;
        this.searchRadius =searchRadius;
        this.ch =ch;
        this.path = getPath(world, cord, world.playerCord);
    }

    public static List<PlayerCord> getPath(World world, PlayerCord start, PlayerCord end){
        return new PathFinder().findPath(world, start, end);
    }

    public void tick(){
        relativeTick+=1;
    }

    public abstract int getDamage();
}
