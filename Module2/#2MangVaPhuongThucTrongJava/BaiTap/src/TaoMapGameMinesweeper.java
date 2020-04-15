import java.util.Scanner;

public class TaoMapGameMinesweeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vao kich thuoc map Mineswiper");
        System.out.println("chieu dai");
        int a = scanner.nextInt();
        System.out.println("chieu rong");
        int b = scanner.nextInt();
        int chieuDai, chieuRong;
        int count = 0;
        if (a > b) {
            chieuDai = b;
            chieuRong = a;
        } else {
            chieuDai = a;
            chieuRong = b;
        }
        String[][] mineSweeperMap = new String[chieuDai][chieuRong];
        for (int i = 0; i < chieuDai * chieuRong / 4; i++) {
            mineSweeperMap[(int) Math.floor(Math.random() * chieuDai)][(int) Math.floor(Math.random() * chieuRong)] = "*";
        }

        for (int i = 0; i < chieuDai; i++) {
            for (int j = 0; j < chieuRong; j++) {
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        try {
                            if (mineSweeperMap[k][l] == "*") {
                                count++;
                            }
                        } catch (Exception e) {
                            count += 0;
                        }
                    }
                }
                if (mineSweeperMap[i][j] != "*") {
                    mineSweeperMap[i][j] = "" + count;
                }
                count = 0;
                System.out.print(mineSweeperMap[i][j]);
            }
            System.out.println();
        }
    }
}
