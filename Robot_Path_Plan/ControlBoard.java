
import javax.swing.*;

public class ControlBoard extends JPanel {
    //private int B_WIDTH = 50;
    //private int B_HEIGHT = 400;
    
    
    JTextField text = new JTextField();
    JButton but1 = new JButton("Load");
    JButton but2 = new JButton("Run");


    public ControlBoard(){
        text.setBounds(50,10,50,30);
        but1.setBounds(50,40,50,30);
        but2.setBounds(50,70,50,30);

        //setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));       
        add(text); add(but1); add(but2);
        setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));    
    }
}
