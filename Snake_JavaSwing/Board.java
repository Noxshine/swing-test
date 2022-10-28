
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.FontMetrics;

public class Board extends JPanel implements ActionListener{
    private final int B_WIDTH = 400;
    private final int B_HEIGHT = 400;
    private final int BL_SIZE = 20;
    private final int ALL_BL = 400;
    private final int DELAY = 80;

    private boolean leftDirection = false;
    private boolean rightDirection = false;
    private boolean upDirection = false;
    private boolean downDirection = false;

    public boolean ingame = true;

    private int block ;
    private int apple_x;
    private int apple_y;


    private final int x[] = new int[ALL_BL];
    private final int y[] = new int[ALL_BL];

    private Timer timer;
    
    public Board(){
        initBoard();
    }

    private void initBoard(){        
        addKeyListener(new Mykey());
        setBackground(Color.green);
        setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));       
        //initGame();
        setFocusable(true);
        requestFocusInWindow();

        initGame();
    }

    private void initGame(){
        block = 3;
        for (int z = 0; z < block; z++) {
            x[z] = 60 - z * 20;
            y[z] = 60;
        }

        Apple_Locate();

        timer = new Timer(DELAY, this);
        timer.start();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(ingame){
            move();
            checkApple();
            checkCrash();
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        if (ingame){

            g.setColor(Color.YELLOW);
            g.fillRect(apple_x, apple_y, BL_SIZE, BL_SIZE);
            
            g.setColor(Color.RED);
            g.fillRect(x[0], y[0], BL_SIZE, BL_SIZE);
            for(int i=1;i< block;i++){
                    g.setColor(Color.BLUE);
                    g.fillRect(x[i], y[i], BL_SIZE, BL_SIZE);
                
            }
        } else {
            gameOver(g);
        }
        
        //Toolkit.getDefaultToolkit().sync();
    }

    
    private class Mykey extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                if(rightDirection)return;

                leftDirection = true;
                upDirection = false;
                downDirection = false;
                rightDirection = false;
            }

            if (key == KeyEvent.VK_RIGHT) {
                if(leftDirection)return;

                rightDirection = true;
                upDirection = false;
                downDirection = false;
                leftDirection = false;

            }

            if (key == KeyEvent.VK_UP) {
                if(downDirection)return;

                upDirection = true;
                rightDirection = false;
                leftDirection = false;
                downDirection = false;

            }

            if (key == KeyEvent.VK_DOWN) {
                if(upDirection)return;

                downDirection = true;
                rightDirection = false;
                leftDirection = false;
                upDirection = false;
            }
        }
    }
    private void move() {
        for (int i = block; i > 0; i--) {
            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }

        if (leftDirection) {
            if(x[0]==0) x[0]= B_WIDTH-BL_SIZE;
            else x[0] -= BL_SIZE;
        }
        else if (rightDirection) {
            if(x[0]==B_WIDTH-BL_SIZE) x[0]= 0;
            else x[0] += BL_SIZE;
        }

        else if (upDirection) {
            if(y[0]==0) y[0]= B_HEIGHT-BL_SIZE;
            else y[0] -= BL_SIZE;
        }
        else if (downDirection) {
            if(y[0]==B_HEIGHT-BL_SIZE) y[0]= 0;
            else y[0] += BL_SIZE;
        }
    }
    public void Apple_Locate(){
        int r = (int) (Math.random() * 19);
        apple_x = ((r * BL_SIZE));

        r = (int) (Math.random() * 19);
        apple_y = ((r * BL_SIZE));
    }
    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            block++;
            Apple_Locate();
        }
    }
    private void checkCrash(){
        for(int i=4;i<block;i++){
            if(x[0]==x[i]&&y[0]==y[i]) ingame =false;
        }
        if(!ingame){
            timer.stop();
        }
    }
    private void gameOver(Graphics g){
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        
    }

}