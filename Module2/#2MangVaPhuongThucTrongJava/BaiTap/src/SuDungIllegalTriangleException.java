import jdk.jfr.events.ThrowablesEvent;

import java.util.Scanner;

public class SuDungIllegalTriangleException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vao 3 canh cua tam giac (gia tri so nguyen)");
        System.out.print("a = ");
        int a = scanner.nextInt();
        System.out.println();
        System.out.print("b = ");
        int b = scanner.nextInt();
        System.out.println();
        System.out.print("c = ");
        int c = scanner.nextInt();
        System.out.println();
        try {
            if (a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0) {
                System.out.println("ba canh hop le");
            }else {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("khong phai 3 canh cua tam giac");
        }
    }
}
