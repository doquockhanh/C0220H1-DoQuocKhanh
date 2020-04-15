import java.util.Scanner;

public class GiaTriNhoNhatMang1Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap do lon mang 1 chieu bat ki");
        int i = scanner.nextInt();
        double[] array = new double[i];
        for (int k = 0; k < i; k++) {
            array[k] = Math.random() * 100;
        }
        double min = array[0];
        for (int k = 0; k < i; k++) {
            if (array[k] < min) {
                min = array[k];
            }
        }
        System.out.println("gia tri nho nhat sinh ngau nhien trong mang vua tao la " + min);
    }
}
