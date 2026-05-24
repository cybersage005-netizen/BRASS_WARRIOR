//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    WorldManager.init();
    WorldManager.addALlWorlds();
    World currentWorld = WorldSet.getWorld(new WorldCord(0,0));
    currentWorld.initPlayerAt(new PlayerCord(5,5,currentWorld));
    PlayerEntity player = new PlayerEntity(0, 100);
    Scanner sc = new Scanner(System.in);

    while (player.canRun) {
        currentWorld.display(player);
        char input = sc.nextLine().charAt(0);
        player.tick(currentWorld, input);
        player.inventory.tickInventory(input, player);
        currentWorld = player.currentWorld;
    }

}
