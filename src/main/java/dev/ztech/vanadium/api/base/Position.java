package dev.ztech.vanadium.api.base;

import net.minecraft.util.MathHelper;

public class Position {
    private double x, y, z;
    public Position(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getDistance(Position pos){
        double d0 = pos.getX() - this.getX();
        double d1 = pos.getY() - this.getY();
        double d2 = pos.getZ() - this.getZ();
        return (double) MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);
    }
}
