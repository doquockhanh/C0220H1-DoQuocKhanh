package LopPoint2DVa3D;

import java.lang.reflect.Array;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[] getXY(){
        float[] value = new float[2];
        value[0] = x;
        value[1] = y;
        return value;
    }

    @Override
    public String toString() {
        getXY();
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
