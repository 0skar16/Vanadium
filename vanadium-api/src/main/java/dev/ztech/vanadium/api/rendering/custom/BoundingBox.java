package dev.ztech.vanadium.api.rendering.custom;

import dev.ztech.vanadium.api.base.Position;

public interface BoundingBox {
    Position getMin();
    Position getMax();

}
