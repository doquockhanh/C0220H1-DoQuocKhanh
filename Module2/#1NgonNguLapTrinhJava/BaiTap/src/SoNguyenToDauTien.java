public class SoNguyenToDauTien {
    public static void main(String[] args) {
        boolean check = true;
        int count = 0;
        for (int i = 2; count < 20; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                System.out.print(i + ", ");
                count++;
            } else {
                check = true;
            }
        }
    }
}