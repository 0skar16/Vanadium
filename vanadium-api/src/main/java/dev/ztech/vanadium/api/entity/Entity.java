package dev.ztech.vanadium.api.entity;

import dev.ztech.vanadium.api.base.Position;

public interface Entity {
    Position getPosition();
    float getHealth();
    void renderOnScreen(int x, int y, int scale);
    boolean isNull();
    float getMaxHealth();
    Player toPlayer();
    boolean isPlayer();
    boolean equals(Entity e);
    boolean isInvisible();
}
