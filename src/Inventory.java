import java.util.Arrays;

public class Inventory {

    private static final int SIZE = 9;
    private final ItemStack[] items = new ItemStack[SIZE];

    public void addItem(ItemStack item) {

        for (int i = 0; i < SIZE; i++) {
            if(items[i] != null && items[i].equals(item)){
                items[i].increase(item.getCount());
                return;
            }
            if (items[i] == null) {
                items[i] = item;
                return;
            }
        }
        throw new IllegalStateException("Inventory is full");
    }

    public void setItem(int slot, ItemStack item) {
        checkSlot(slot);
        items[slot] = item;
    }

    public ItemStack getItem(int slot) {
        checkSlot(slot);
        return items[slot];
    }

    public void removeItem(int slot) {
        checkSlot(slot);
        items[slot] = null;
    }

    public boolean isEmpty(int slot) {
        checkSlot(slot);
        return items[slot] == null;
    }

    public void clear() {
        Arrays.fill(items, null);
    }

    private void checkSlot(int slot) {
        if (slot < 0 || slot >= SIZE) {
            throw new IndexOutOfBoundsException("Invalid slot: " + slot);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (ItemStack stack : this.items) {
            if (stack == null) continue;

            res.append(stack)
                    .append(" x ")
                    .append(stack.getCount())
                    .append(", ");
        }

        if (res.length() > 2) {
            res.setLength(res.length() - 2);
        }

        return res.toString();
    }
}
