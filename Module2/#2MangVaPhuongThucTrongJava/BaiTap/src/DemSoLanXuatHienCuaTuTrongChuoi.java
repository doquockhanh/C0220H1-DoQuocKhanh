import java.util.Scanner;

public class DemSoLanXuatHienCuaTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = "Mang hai chieu la mang cua cac mang mot chieu," +
                " va mang ba chieu la mang cua cac mang hai chieu.\n" +
                "Đoi khi, ta gap nhung du lieu can đuocc bieu dien" +
                " theo dang mang-n-chieu. Voi Java, su dung cau truc mang cua cac mang," +
                " voi bat cu so nguyen duong n nao, ta co the tao ra mang voi n chieu.";
        System.out.println(inputString);
        System.out.println();
        char[] arrayChar = new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            arrayChar[i] = inputString.charAt(i);
        }
        System.out.println("nhap ki tu muon dem trong chuoi tren");
        char a = scanner.next().charAt(0);
        int count = 0;

        for (int i = 0; i < inputString.length(); i++) {
            if (a == arrayChar[i]) {
                count++;
            }
        }
        System.out.println("so lan xuat hien cua ki tu " + a + " la " + count);
    }
}