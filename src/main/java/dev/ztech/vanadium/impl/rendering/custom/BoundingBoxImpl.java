package dev.ztech.vanadium.impl.rendering.custom;

import dev.ztech.vanadium.api.base.Position;
import dev.ztech.vanadium.api.rendering.custom.BoundingBox;
import net.minecraft.util.AxisAlignedBB;

public class BoundingBoxImpl implements BoundingBox {
    private AxisAlignedBB base;
    public BoundingBoxImpl(Position a, Position b){
        this.base = new AxisAlignedBB(a.getX(), a.getY(), a.getZ(), b.getX(), b.getY(), b.getZ());
    }
    public BoundingBoxImpl(AxisAlignedBB base){
        this.base= base;
    }

    @Override
    public Position getMin() {
        return new Position(base.minX, base.minY, base.minZ);
    }

    @Override
    public Position getMax() {
        return new Position(base.maxX, base.maxY, base.maxZ);
    }
}
