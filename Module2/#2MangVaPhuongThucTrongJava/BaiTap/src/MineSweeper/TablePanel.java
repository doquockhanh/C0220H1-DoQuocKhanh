package MineSweeper;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JFrame {
    public TablePanel(){
        GameTable gameTable = new GameTable();
        for (int i = 0; i < gameTable.getTableWidth(); i++) {
            for (int j = 0; j < gameTable.getTableHeight(); j++) {
                new Label();
            }
        }
    }
}
