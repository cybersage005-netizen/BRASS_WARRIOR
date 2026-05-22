import java.util.Random;

public class PlayerCord extends WorldCord {
    World world;

    public PlayerCord(int x, int y, World world) {
        super(x, y);

        this.world = world;

        if (world.mapLenY <= y || world.mapLenX <= x || x < 0 || y < 0) {
            throw new IndexOutOfBoundsException("Invalid player position");
        }
    }

    public boolean isWithinBoundary() {
        return x > 0 && y > 0 &&
                x < world.mapLenX - 1 &&
                y < world.mapLenY - 1;
    }

    private static final Random RANDOM = new Random();

    public PlayerCord getRandomDirection(){
        int r = RANDOM.nextInt(4);
        return switch (r) {
            case 0 -> this.up();
            case 1 -> this.right();
            case 2 -> this.left();
            default -> this.down();
        };
    }

    public int distanceTo(PlayerCord point2){
        return Math.abs(this.x - point2.x) + Math.abs(this.y - point2.y);
    }

    @Override
    public PlayerCord up() {
        return new PlayerCord(x, y - 1, world);
    }

    @Override
    public PlayerCord down() {
        return new PlayerCord(x, y + 1, world);
    }

    @Override
    public PlayerCord left() {
        return new PlayerCord(x - 1, y, world);
    }

    @Override
    public PlayerCord right() {
        return new PlayerCord(x + 1, y, world);
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}