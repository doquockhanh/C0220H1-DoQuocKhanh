package MineSweeper;

public class Main {
    public static void main(String[] args) {
        GameTable gameTable = new GameTable(15,10);
        int chieuRong = gameTable.getTableWidth();
        int chieuCao = gameTable.getTableHeight();
        int count = 0;
        String[][] mineSweeperMap = new String[chieuRong][chieuCao];
        for (int i = 0; i < chieuRong * chieuCao / 4; i++) {
            mineSweeperMap[(int) Math.floor(Math.random() * chieuRong)][(int) Math.floor(Math.random() * chieuCao)] = "*";
        }

        for (int i = 0; i < chieuRong; i++) {
            for (int j = 0; j < chieuCao; j++) {
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
            }
        }
        TablePanel tablePanel = new TablePanel();
    }
}
