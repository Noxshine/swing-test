import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.*;

public class LabManage extends JPanel  {
    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 400;

    private final int SMALL_FRAME_WIDTH = 360;
    private final int SMALL_FRAME_HEIGHT = 180;
    private final ImageIcon clock = new ImageIcon("icon/clock.png");
    private final ImageIcon computer = new ImageIcon("icon/computer.png");
    ImageIcon cpt = getScaledIcon(computer,100,100);
    ImageIcon cl = getScaledIcon(clock,100,100);

     public LabManage(){
        initLab();
    }

    private void initLab(){        
        // addKeyListener(new Mykey());
        // setBackground(Color.green);
        setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT)); 
        setLayout(null);      
        //initGame();
        setFocusable(true);
        requestFocusInWindow();

        JPanel smallFrame1 = createPanel("Computer1", 10, 10);
        add(smallFrame1);

        JPanel smallFrame2 = createPanel("Computer2",10, 210);
        add(smallFrame2);

        JPanel smallFrame3 = createNotePanel();
        add(smallFrame3);

        JButton button = createButton((JLabel)smallFrame1.getComponent(1), (JLabel)smallFrame2.getComponent(1));
        add(button);
    }

    private JPanel createSmallFrame(String lb) {
        JPanel smallFrame = new JPanel();
        smallFrame.setPreferredSize(new Dimension(SMALL_FRAME_WIDTH, SMALL_FRAME_HEIGHT));

        Border blackBorder = new LineBorder(Color.GRAY);
        smallFrame.setBorder(blackBorder);

        JLabel label = new JLabel(lb);
        label.setBounds(5, 5, 100, 20);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        smallFrame.add(label, BorderLayout.NORTH);
        // Customize the small frame as needed
        // Add components to the small frame as needed
        smallFrame.setLayout(null);
        return smallFrame;
    }

    private JButton createButton(JLabel icon1,
                                 JLabel icon2){
        JButton button = new JButton("End");
        button.setBounds(400, 210, SMALL_FRAME_WIDTH, SMALL_FRAME_HEIGHT); // Set button bounds
        // Add an action listener to the button (you can customize the behavior)
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(icon1.getIcon() == cl || icon2.getIcon() == cl){
                    JOptionPane.showMessageDialog(null, "There are computers on rent");
                } else { System.exit(0);}

                // if(icon1.getIcon() == cl){ 

                //     icon1.setIcon(cpt); 
                //     tf1.setText(""); 
                //     tf2.setText("");
                // }
                // if(icon2.getIcon() == cl){

                //     icon2.setIcon(cpt); 
                //     tf3.setText(""); 
                //     tf4.setText("");
                // }

                // Handle button click action hereu12
            }
        });
        return button;
    }

    private ImageIcon getScaledIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    private JPanel createPanel(String lb, int x, int y){
         // computer 1
        JPanel smallFrame1 = createSmallFrame(lb);
        smallFrame1.setBounds(x,y, SMALL_FRAME_WIDTH, SMALL_FRAME_HEIGHT);
        JLabel icon1 = new JLabel(cpt);
        final boolean[] icon1IsComputer = {true};
        icon1.setBounds(35, 35, 100, 100);
        smallFrame1.add(icon1);
        JTextField tf1 = new JTextField();
        tf1.setEditable(false);
        tf1.setBounds(150, 50,  120, 30);
        JTextField tf2 = new JTextField();
        tf2.setEditable(false);
        tf2.setBounds(150, 100,  120, 30);
        smallFrame1.add(tf1);
        smallFrame1.add(tf2);
        icon1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (icon1IsComputer[0]) {
                    icon1.setIcon(cl); // Change to clock
                    tf1.setText(timeNow(0));
                    tf2.setText(timeNow(6));

                } else {
                    String message = "<html><center>So gio thue la: 6<br>So tien phai tra la: 300</center></html>";
                    JOptionPane.showMessageDialog(null, message);
                    // icon1.setIcon(cpt); // Change back to computer
                }
                icon1IsComputer[0] = !icon1IsComputer[0]; 
            }
        });
        

        return smallFrame1;
    }

    private JPanel createNotePanel(){
        // computer3
        JPanel smallFrame3 = createSmallFrame("Note");
        smallFrame3.setBounds(400,10, SMALL_FRAME_WIDTH, SMALL_FRAME_HEIGHT);
        ImageIcon cptx = getScaledIcon(computer,70,70);
        ImageIcon clx = getScaledIcon(clock,70,70);
        JLabel iconComputer3 = new JLabel(cptx);
        JLabel iconClock3 = new JLabel(clx);

        //icon computer
        iconComputer3.setBounds(5, 5, 100, 100);
        JLabel label1 = new JLabel("Not rented yet");
        label1.setBounds(120, 45, 100, 20);
        smallFrame3.add(label1);
        smallFrame3.add(iconComputer3);
        // icon clock
        iconClock3.setBounds(5,80, 100, 100);
        JLabel label2 = new JLabel("Renting");
        label2.setBounds(120, 120, 100, 20);
        smallFrame3.add(label2);
        smallFrame3.add(iconClock3);    

        return smallFrame3;

    }

    private String timeNow(int plusTime){
        // Get the current time
        LocalTime currentTime = LocalTime.now();
        currentTime = currentTime.plusHours(plusTime);

        // Define a format for the time (e.g., HH:mm:ss)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Format the current time as a String
        String currentTimeString = currentTime.format(formatter);
        return currentTimeString;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // doDrawing(g);
    }

   



}