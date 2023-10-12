import java.awt.*;    
import javax.swing.*;    


public class Main extends JFrame{
    
    private final int DELAY = 150;
    private Timer timer;
    
    public Main(){
        
        ControlPanel cPanel = new ControlPanel();

        add(cPanel);
        setLayout(new FlowLayout());
        setResizable(true);
        pack();

        setSize(600,450);
        setTitle("Robot path");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args){
        new Main();
    }

    
}
