import java.util.Scanner;

public class XoaPhanTuTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap do lon mang 1 chieu bat ki");
        int i = scanner.nextInt();
        int[] array = new int[i];
        for (int k = 0; k < i; k++) {
            array[k] =(int)Math.floor(Math.random() * 100);
            System.out.print(array[k] + " | ");
        }
        System.out.println();
        System.out.println("nhap vi tri muon xoa");
        int deleteIndex = scanner.nextInt();

        for (int j = deleteIndex; j < array.length - 1; j++) {
            array[j] = array[ j + 1] ;
        }
        array[array.length -1] = 0;
        for (int k = 0; k < i - 1; k++) {
            System.out.print(array[k] + " | ");
        }
    }
}
