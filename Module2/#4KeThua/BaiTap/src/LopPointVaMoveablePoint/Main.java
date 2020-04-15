package LopPointVaMoveablePoint;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovablePoint movablePoint = new MovablePoint(3, 4, 5, 6);
        System.out.println(movablePoint.toString());
        Point point = new Point(3, 4);
        System.out.println(point.toString());
        int numSelect = 0;
        while (numSelect != 2) {
            System.out.println("1 : di chuyen \n2 : thoat");
            numSelect = scanner.nextInt();
            switch (numSelect) {
                case 1:
                    System.out.println(movablePoint.move());
                    System.out.println();
                    break;
                case 2:
                    System.exit(0);
                    break;
            }
        }
    }
}
