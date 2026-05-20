public class PlayerEntity extends CharacterEntity{
    boolean canRun = true;
    World currentWorld = WorldSet.getWorld(new WorldCord(0,0));
    PlayerEntity(int id, int maxHP) {
        super(id, maxHP);
    }

    public void tick(World world, char choice){
        switch (choice) {
            case 'w' -> world.movePlayerTo(world.playerCord.up());
            case 's' -> world.movePlayerTo(world.playerCord.down());
            case 'a' -> world.movePlayerTo(world.playerCord.left());
            case 'd' -> world.movePlayerTo(world.playerCord.right());
            case '.' -> canRun = false;
        }
        for(PortalFeature feature : world.PORTALS){
            if(!feature.cord.equals(world.playerCord)){
                world.drawChar(feature.cord, '0');
            }else {
                this.currentWorld = WorldSet.getWorld(feature.leadingWorldCord);
            }

        }
        world.drawChar(world.playerCord, 'P');
    }
}
