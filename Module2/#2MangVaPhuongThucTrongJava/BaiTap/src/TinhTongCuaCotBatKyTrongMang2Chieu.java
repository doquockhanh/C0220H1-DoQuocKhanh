import java.util.Scanner;

public class TinhTongCuaCotBatKyTrongMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("tao mang 2 chieu bat ki");
        System.out.println("nhap chieu thu nhat");
        int i = scanner.nextInt();
        System.out.println("nhap chieu thu hai");
        int j = scanner.nextInt();
        int[][] array = new int[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                array[k][l] = (int) Math.floor(Math.random() * 100);
                System.out.print(array[k][l] + " | ");
            }
            System.out.println();
        }
        System.out.println("nhap dong muon tinh tong");
        int a = scanner.nextInt();
        int total = 0;
        for (int l = 0; l < i; l++) {
            total += array[a][l];
        }
        System.out.println("tong cua hang vua chon la : " + total);
    }
}

