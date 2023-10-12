import java.awt.*;    
import java.awt.event.*;  
import javax.swing.*;    
import java.io.FileInputStream;
import java.util.Scanner;

public class ControlPanel extends JPanel {

    public ControlPanel(){
        Board board = new Board(20,20);
        board.setBounds(0,0,400,400);
    
    
        ControlBoard cboard = new ControlBoard();
        cboard.setBounds(400,0,200,400);

        cboard.but1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                String address = cboard.text.getText();
                try{
                    FileInputStream fin = new FileInputStream(address);
                    System.setIn(fin);
                    Scanner input = new Scanner(System.in);
                    
                    for(int i=0;i<20;i++){
                        for(int j=0;j<20;j++){
                            board.mang[i][j] = input.nextInt();
                        }
                    }
                    board.PaintBoard(20,20);
                }catch (Exception s){
                    System.out.println(s);
                }
            }  
        });  // take matrix from file
    
        cboard.but2.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                //timer = new Timer(DELAY, this);
                //timer.start();
                try {
                    board.runFullPath();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }   
        });  // draw obstacle

    }
}
