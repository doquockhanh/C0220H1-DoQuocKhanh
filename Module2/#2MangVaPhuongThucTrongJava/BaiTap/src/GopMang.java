import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap do dai mang 1");
        int inputLengthArray1 = scanner.nextInt();
        System.out.println("nhap do dai mang 2");
        int inputLengthArray2 = scanner.nextInt();
        int[] array1 = new int[inputLengthArray1];
        int[] array2 = new int[inputLengthArray2];
        int[] array3 = new int[inputLengthArray2 + inputLengthArray1];
        System.out.println("gia tri ngau nhien cua mang 1");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) Math.floor(Math.random() * 100);
            System.out.print(array1[i] + " ");
        }
        System.out.println();
        System.out.println("gia tri ngau nhien cua mang 2");
        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int) Math.floor(Math.random() * 100);
            System.out.print(array2[i] + " ");
        }
        System.out.println();
        System.out.println("gop 2 mang");
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
            System.out.print(array3[i] + " ");
        }
        for (int i = array1.length; i < array3.length; i++) {
            array3[i] = array2[i - array1.length];
            System.out.print(array3[i] + " ");
        }
    }
}
