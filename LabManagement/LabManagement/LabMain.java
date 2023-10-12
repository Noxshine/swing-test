import javax.swing.JFrame;

public class LabMain extends JFrame {
    

    public LabMain(){
        initUI();
    }

    private void initUI(){
        getContentPane().add(new LabManage());
        
        setResizable(false);
        pack();
        
        setTitle("Lab Management");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args){
        JFrame ex = new LabMain();
    }
}
