import javax.swing.*;

import java.awt.*;


public class Board extends JPanel {
    private int B_WIDTH = 400;
    private int B_HEIGHT = 400;
 

    private Component[][] cell;
    int [][]mang = new int[20][20];

    public Board(int row,int col){

        cell = new Component[row][col];

        setLayout(new GridLayout(row,col));
        setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));       
        setFocusable(true);
        requestFocusInWindow();
        for(int r =0; r < row; r ++){
            for(int c =0; c < col; c ++){
                Component cel = getCell();
                cell[r][c] = cel;
                add(cel);
            }
        }
        
    }
    Component getCell() {
        JLabel label = new JLabel();
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return label;
    }

    public void PaintBoard(int row,int col){
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(mang[i][j]==1) setColor(i, j, Color.green);
            }
        }
        setColor(0 ,0 ,Color.red );
    }
    //@Override
    //public void paintComponent(Graphics g) {
    //    super.paintComponent(g);
    //    doDrawing(g);
    //}
    //
    //private void doDrawing(Graphics g) {
//
    //}
    void setColor(int row, int col, Color color) {
        cell[row][col].setBackground(color);
    }

    void runFullPath() throws InterruptedException{
        for (int i=0;i<20;i++){
            for (int j=0;j<20;j++){
                //if(mang[i][j]==0){
                Thread.sleep(200);
                setColor(i, j, Color.yellow);
                //}
            }
        }
    }


}
