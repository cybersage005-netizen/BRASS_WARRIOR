public class PlayerEntity extends CharacterEntity {
    public boolean canRun = true;
    public World currentWorld = WorldSet.getWorld(new WorldCord(0,0));
    double hp;
    PlayerEntity(int id, int maxHP) {
        super(id, maxHP); this.hp = maxHP;
    }

    public void tick(World world, char choice){
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
        for(PortalFeature feature : world.PORTALS){
           if(feature.cord.equals(world.playerCord)) {
                this.currentWorld = WorldSet.getWorld(feature.leadingWorldCord);
           }
        }
        for(ConsumableFeature feature : world.CONSUMABLES){
            if(feature.cord.equals(world.playerCord) && (hp + feature.getSaturation()) <= maxHP){
                this.hp += feature.getSaturation();
                feature.isEaten = true;
            }
        }
        for(EnemyEntity enemy : world.ENEMIES){
            enemy.tick();
            world.moveEntity(enemy);

            if(enemy.entityCord.equals(world.playerCord)){
                this.hp -= 10;
                enemy.relativeTick += 1;
                System.out.println("Your Player got hit by a slime");
            }

        }
        world.drawChar(world.playerCord, 'P');
    }
}
