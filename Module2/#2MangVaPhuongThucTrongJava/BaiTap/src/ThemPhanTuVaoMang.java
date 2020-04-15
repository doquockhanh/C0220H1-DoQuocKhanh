import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vao do dai danh sach");
        int inputLengthArray = scanner.nextInt();
        double[] array = new double[inputLengthArray];
        int cont = 1;
        while (cont != 0) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " | ");
            }
            System.out.println();
            System.out.println("nhap vi tri phan tu can thay doi gia tri");
            int i = scanner.nextInt();
            System.out.println("nhap gia tri thay doi");
            array[i] = scanner.nextDouble();
            System.out.println("nhan \" 0 \" de thoat chinh sua");
            cont = scanner.nextInt();
        }
    }
}
