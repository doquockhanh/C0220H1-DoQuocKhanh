package TrienkhaiInterfaceResizeable;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Square square = new Square();
        Shape[] a = new Shape[10];
        a[0] = circle;
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println("truoc khi tang kich thuoc" + formatter.format(a[0].getArea()));
        double b = Math.random()*100;
        System.out.println("ti le tang " + formatter.format(b) + "%");
        a[0].resize(b);
        System.out.println("sau khi tang kich thuoc : " + formatter.format(a[0].getArea()));
    }
}
