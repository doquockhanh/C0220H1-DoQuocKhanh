package TrienKhaiInterfaceColorable;

import TrienkhaiInterfaceResizeable.Circle;
import TrienkhaiInterfaceResizeable.Shape;
import TrienkhaiInterfaceResizeable.Square;

public class Main {
    public static void main(String[] args) {
        Square square = new Square();
        Circle circle = new Circle(3, "white", true);
        Shape[] a = new Shape[2];
        a[0] = square;
        a[1] = circle;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == square) {
                square.howToColor();
            }
            System.out.println(a[i].toString() + "\nArea = " + a[i].getArea());
            System.out.println();
        }
    }
}
