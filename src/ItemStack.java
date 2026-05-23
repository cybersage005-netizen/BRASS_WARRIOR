public class ItemStack extends ConsumableFeature {

    private final Items item;
    private int count = 1;

    public ItemStack(Items item, PlayerCord cord, World world) {
        super(ConsumableType.ITEM, cord, item.ch, world);
        this.item = item;
    }
    public ItemStack(Items item, PlayerCord cord, World world, int count) {
        super(ConsumableType.ITEM, cord, item.ch, world);
        this.count = count;
        this.item = item;
    }

    @Override
    public void onInteract(PlayerEntity player) {
        if(this.isEaten)return;
        player.inventory.addItem(this);
        this.isEaten = true;
    }

    public Items getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = Math.max(1, count);
    }

    public void increase(int amount) {
        this.count = Math.min(count + amount, item.maxCount);
    }

    public void decrease(int amount) {
        this.count = Math.max(0, this.count - amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemStack other)) return false;
        return this.item == other.item;
    }

    @Override
    public String toString() {
        String name = item.name;
        if (name.isEmpty()) {
            return "Unknown";
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    @Override
    public int hashCode() {
        return item.hashCode();
    }
}