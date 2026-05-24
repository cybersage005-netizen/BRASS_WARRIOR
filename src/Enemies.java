public enum Enemies {
    SLIME(30, 10, 5,'S');

    final int maxHp;
    final int damage;
    final int sr;
    final char ch;
    Enemies(int maxHp, int damage, int sr, char ch){
        this.maxHp = maxHp;
        this.damage = damage;
        this.sr = sr;
        this.ch = ch;
    }
}
