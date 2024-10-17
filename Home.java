import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame {

    private Container c;
    private ImageIcon icon, logo;
    private JLabel label1, imgLabel;
    private Font f1, f2;
    private JButton btn1, btn2, btn3, btn4, nBtn;
    private Cursor cursor;

     Home() {
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
        imgLabel.setBounds(20, 20,logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);

        // Fonts
        f1 = new Font("Tahoma", Font.BOLD, 40);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 20);

        // Title
        label1 = new JLabel();
        label1.setText("Rent");
        label1.setBounds(580, 55, 500, 65);
        label1.setFont(f1);
        c.add(label1);

        label1 = new JLabel();
        label1.setText("House/Worker");
        label1.setBounds(460, 120, 400, 50);
        label1.setFont(f1);
        c.add(label1);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

         // JButtons

        btn3 = new JButton("Exit");
        btn3.setBounds(90, 345, 200, 50);
        btn3.setFont(f2);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#C00000"));
        c.add(btn3);

        btn1 = new JButton("Login");
        btn1.setBounds(418, 345, 195, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.setFocusable(false);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#226135"));
        c.add(btn1);

        btn2 = new JButton("Register");
        btn2.setBounds(520, 235, 195, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.setFocusable(false);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#226135"));
        c.add(btn2);

        btn4 = new JButton("Admin Login");
        btn4.setBounds(634, 345, 195, 50);
        btn4.setFont(f2);
        btn4.setCursor(cursor);
        btn4.setFocusable(false);
        btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.decode("#226135"));
        c.add(btn4);
        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

                // Login
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                Login frame = new Login();
                frame.setVisible(true);
            }
        });

        // Register
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                Registration frame = new Registration();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        // Exit
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        // Admin Login
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                AdminLogin frame = new AdminLogin();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        Home frame = new Home();
        frame.setVisible(true);
    }
}







