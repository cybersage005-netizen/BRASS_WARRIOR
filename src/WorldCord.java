public class WorldCord {
    int x;
    int y;

    public WorldCord(int x, int y){
        this.x = x;
        this.y = y;
    }

    public WorldCord up()    { return new WorldCord(x, y - 1); }
    public WorldCord down()  { return new WorldCord(x, y + 1); }
    public WorldCord left()  { return new WorldCord(x - 1, y); }
    public WorldCord right() { return new WorldCord(x + 1, y); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorldCord other)) return false;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}