import java.util.Scanner;

public class TimGiaTriLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("tao mang 2 chieu bat ki");
        System.out.println("nhap chieu thu nhat");
        int i = scanner.nextInt();
        System.out.println("nhap chieu thu hai");
        int j = scanner.nextInt();
        double[][] array = new double[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                array[k][l] = Math.random()*100;
            }
        }
        double max = array[0][0];
        double min = array[0][0];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
               if(array[k][l] > max){
                   max = array[k][l];
               }
               if(array[k][l] < min){
                   min = array[k][l];
               }
            }
        }
        System.out.println("gia tri lon nhat sinh ngau nhien trong mang vua tao la " + max );
        System.out.println("gia tri nho nhat sinh ngau nhien trong mang vua tao la " + min );
    }
}
