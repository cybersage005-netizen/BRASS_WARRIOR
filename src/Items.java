public enum Items {
    BANANA("banana", 32, 'B');

    final String name;
    final int maxCount;
    final char ch;

    Items(String name, int maxCount, char ch){
        this.name = name.toLowerCase();
        this.maxCount = maxCount;
        this.ch = ch;
    }
}
