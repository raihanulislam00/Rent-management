import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Options extends JFrame {

    private Container c;
    private ImageIcon icon;
    private JLabel label1, imgLabel;
    private Font f1, f2, f3;
    private ImageIcon logo;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;
    private JRadioButton workerManagement, houseManagement;
    private ButtonGroup jButtonGroup;
    private int option = 0;

    Options() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rent Management");
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("/images/icon.png"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("/images/Logo.jpg"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(20, 20, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);

        // Fonts
        f1 = new Font("Segoe UI Black", Font.PLAIN, 40);
        f2 = new Font("Segoe UI Semibold", Font.PLAIN, 20);
        f3 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Cursor for JButtons and Radio Buttons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Title
        label1 = new JLabel();
        label1.setText("Choose Your Option:");
        label1.setBounds(425, 40, 500, 50);
        label1.setFont(f1);
        c.add(label1);

        workerManagement = new JRadioButton("Worker Management");
        workerManagement.setBounds(445, 160, 300, 50);
        workerManagement.setFont(f2);
        workerManagement.setCursor(cursor);
        workerManagement.setBackground(Color.decode("#F2F2F2"));
        c.add(workerManagement);

        houseManagement = new JRadioButton("House Management");
        houseManagement.setBounds(445, 220, 300, 50);
        houseManagement.setFont(f2);
        houseManagement.setCursor(cursor);
        houseManagement.setBackground(Color.decode("#F2F2F2"));
        c.add(houseManagement);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);
        jButtonGroup = new ButtonGroup();
        jButtonGroup.add(workerManagement);
        jButtonGroup.add(houseManagement);

        btn1 = new JButton("Exit");
        btn1.setBounds(340, 345, 170, 50);
        btn1.setFont(f3);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#C00000"));
        c.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(90, 345, 170, 50);
        btn2.setFont(f3);
        btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#226135"));
        c.add(btn2);

        btn3 = new JButton("Next");
        btn3.setBounds(590, 345, 170, 50);
        btn3.setFont(f3);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#226135"));
        c.add(btn3);
        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        Handler handler = new Handler();
        workerManagement.addActionListener(handler);
        houseManagement.addActionListener(handler);

        // Exit Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminLogin frame = new AdminLogin();
                frame.setVisible(true);
            }
        });

       // Next Button
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (option == 1) {
                    setVisible(false);
                    WorkerOptions frame = new WorkerOptions();
                    frame.setVisible(true);
                } else if (option == 2) {
                    setVisible(false);
                    DefaultHouse frame = new DefaultHouse();
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "You forgot to select option!", "Warming!!!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == workerManagement) {
                option = 1;
            } else if (e.getSource() == houseManagement) {
                option = 2;
            }
        }
    }

    public static void main(String[] args) {

        Options frame = new Options();
        frame.setVisible(true);
    }
}



