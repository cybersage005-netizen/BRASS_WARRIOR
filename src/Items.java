public enum Items {
    BANANA("banana", 32, 'B'){
        @Override
        public void use(PlayerEntity entity){
            if(entity.hp+5 > entity.maxHP) return;
            entity.hp += 5;
        }
    }
    ;

    final String name;
    final int maxCount;
    final char ch;

    Items(String name, int maxCount, char ch){
        this.name = name.toLowerCase();
        this.maxCount = maxCount;
        this.ch = ch;
    }

    public abstract void use(PlayerEntity player);
}
