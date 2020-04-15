package MineSweeper;

public class GameTable {
    public int tableWidth = 15;
    public int tableHeight = 10;

    public GameTable(int tableWidth, int tableHeight) {
        this.tableWidth = tableWidth;
        this.tableHeight = tableHeight;
    }

    public int getTableWidth() {
        return tableWidth;
    }

    public int getTableHeight() {
        return tableHeight;
    }

    public GameTable() {
    }
}
