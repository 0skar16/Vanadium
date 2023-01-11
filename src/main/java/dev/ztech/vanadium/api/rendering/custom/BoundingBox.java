package dev.ztech.vanadium.api.rendering.custom;

import dev.ztech.vanadium.api.base.Position;
import net.minecraft.util.AxisAlignedBB;

public class BoundingBox {
    private AxisAlignedBB base;
    public BoundingBox(Position a, Position b){
        this.base = new AxisAlignedBB(a.getX(), a.getY(), a.getZ(), b.getX(), b.getY(), b.getZ());
    }
    public BoundingBox(AxisAlignedBB base){
        this.base= base;
    }
    public double getMinX(){
        return this.base.minX;
    }
    public double getMinY(){
        return this.base.minY;
    }
    public double getMinZ(){
        return this.base.minZ;
    }
    public double getMaxX(){
        return this.base.maxX;
    }
    public double getMaxY(){
        return this.base.maxY;
    }
    public double getMaxZ(){
        return this.base.maxZ;
    }


}
