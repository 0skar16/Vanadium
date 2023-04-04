package dev.ztech.vanadium.api.item;

public interface ItemStack {
    void render(int x, int y);
    boolean isDamageable();
    int getDurability();
    int getMaxDurability();

}
