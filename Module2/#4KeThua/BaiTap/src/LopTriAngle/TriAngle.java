package LopTriAngle;

import java.util.Scanner;

public class TriAngle extends Shape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vao ba canh cua tam giac \ncanh 1 = ");
        double canh1 = scanner.nextDouble();
        System.out.println("canh 2 = ");
        double canh2 = scanner.nextDouble();
        System.out.println("canh 3 = ");
        double canh3 = scanner.nextDouble();

        if (canh1 + canh2 > canh3 && canh2 + canh3 > canh1 && canh1 + canh3 > canh2 && canh1 > 0 && canh2 > 0 && canh3 > 0) {
            Shape shape = new Shape(canh1, canh2, canh3);
            System.out.println(shape.getInformation());
        } else {
            System.out.println("tam giac vua nhap khong hop le");
        }
    }
}
