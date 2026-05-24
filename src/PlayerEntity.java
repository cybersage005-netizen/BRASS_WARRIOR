import java.util.PriorityQueue;
import java.util.Queue;

public class PlayerEntity extends CharacterEntity {
    public boolean canRun = true;
    public World currentWorld = WorldSet.getWorld(new WorldCord(0,0));
    int currency = 0;
    double hp;
    Inventory inventory = new Inventory();
    int rememberTick = 0;
    Queue<ItemStack> effectQueue = new PriorityQueue<>();

    PlayerEntity(int id, int maxHP) {
        super(id, maxHP); this.hp = maxHP;
        inventory.clear();
    }

    public void tick(World world, char choice){
        this.tick+=1;
        if(this.hp <= 0){
            System.out.println("Player Fainted");
            this.canRun = false;
            return;
        }
        switch (choice) {
            case 'w' -> world.movePlayerTo(world.playerCord.up());
            case 's' -> world.movePlayerTo(world.playerCord.down());
            case 'a' -> world.movePlayerTo(world.playerCord.left());
            case 'd' -> world.movePlayerTo(world.playerCord.right());
            case '.' -> canRun = false;
        }
        for(MapFeature feature : world.FEATURES){
           feature.tryInteract(this);
        }

        for(EnemyEntity enemy : world.ENEMIES){
            enemy.tick();
            world.moveEntity(enemy);

            if(enemy.entityCord.equals(world.playerCord)){
                this.hp -= enemy.getDamage();
                enemy.relativeTick += 1;
                System.out.println("Your Player got hit by a slime");
            }

        }
        world.drawChar(world.playerCord, 'P');
    }
}
