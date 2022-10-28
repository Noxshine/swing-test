import javax.swing.JFrame;
import java.awt.EventQueue;

public class Snake extends JFrame {
    

    public Snake(){
        initUI();
    }

    private void initUI(){
        getContentPane().add(new Board());
        
        setResizable(false);
        pack();

        setTitle("Snake");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args){
        JFrame ex = new Snake();
    }
}
