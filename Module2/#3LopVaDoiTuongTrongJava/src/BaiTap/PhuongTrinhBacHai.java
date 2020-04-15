package BaiTap;

import java.util.Scanner;

public class PhuongTrinhBacHai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap a : ");
        int a = scanner.nextInt();
        System.out.print("nhap b : ");
        int b = scanner.nextInt();
        System.out.print("nhap c : ");
        int c = scanner.nextInt();
        PhuongTrinhBacHai pt = new PhuongTrinhBacHai();
        System.out.println(pt.PhuongTrinhBacHai(a, b, c));
    }

    public String PhuongTrinhBacHai(int a, int b, int c) {
        double x1, x2;
        int delta = b * b - 4 * a * c;
        if (a != 0) {
            if (b != 0) {
                if (delta >= 0) {
                    x1 = (-b - Math.sqrt(delta)) / 2 * a;
                    x2 = (-b + Math.sqrt(delta)) / 2 * a;
                    return "phuong trinh co nghiem : x1 = " + x1 + ", x2 = " + x2;
                } else {
                    return "phuong trinh vo nghiem";
                }
            }
        } else if (b != 0) {
            x1 = -c / b;
            return "phuong trinh co nghiem : x1 = " + x1;
        } else if (c != 0) {
            return "phuong trinh vo nghiem";
        } else {
            return "phuong trinh vo so nghiem";
        }
        return "";
    }
}
