package LopTriAngle;

import java.util.Scanner;

public class TriAngle extends Shape {

    public double side1 = 1.0;
    public double side2 = 1.0;
    public double side3 = 1.0;

    public TriAngle() {
    }

    public TriAngle(double side1, double side2, double side3) {
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

    public String getInformation(){
        return "canh 1 : " + side1+
                "\ncanh 2 : " + side2+
                "\ncanh 3 : " + side3 +
                "\nchu vi : " + getPerimeter() +
                "\ndien tich : " + getArea();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vao ba canh cua tam giac \ncanh 1 = ");
        double canh1 = scanner.nextDouble();
        System.out.println("canh 2 = ");
        double canh2 = scanner.nextDouble();
        System.out.println("canh 3 = ");
        double canh3 = scanner.nextDouble();

        if (canh1 + canh2 > canh3 && canh2 + canh3 > canh1 && canh1 + canh3 > canh2 && canh1 > 0 && canh2 > 0 && canh3 > 0) {
            TriAngle triAngle = new TriAngle(canh1, canh2, canh3);
            System.out.println(triAngle.getInformation());
        } else {
            System.out.println("tam giac vua nhap khong hop le");
        }
    }
}
