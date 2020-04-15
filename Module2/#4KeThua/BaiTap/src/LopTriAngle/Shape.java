package LopTriAngle;

public class Shape {
    public double side1 = 1.0;
    public double side2 = 1.0;
    public double side3 = 1.0;

    public Shape() {
    }

    public Shape(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        double h = 2 * (Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3))) / this.side1;
        return (h * this.side1) / 2;
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public String getInformation() {
        return "chu vi : " + getPerimeter() +
                "\ndien tich : " + getArea();
    }
}
