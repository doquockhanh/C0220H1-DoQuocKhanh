package LopCircleVaCylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getV (){
         return getArea()*height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ",volume=" + getV() +
                '}';
    }
}
