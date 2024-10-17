import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AboutUS extends JFrame {

    private Container c;
    private ImageIcon icon, logo, welcome;
    private JLabel imgLabel;
    private JLabel label1;
    private Font f1;
    private JButton btn1, btn2, nBtn;
    private Cursor cursor;

    AboutUS() {
        // Frame Layout
        this.setTitle("Rent Management");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));


        // Icon
        icon = new ImageIcon(getClass().getResource("/images/icon.png"));
        this.setIconImage(icon.getImage());

        // Logo and Images
        logo = new ImageIcon(getClass().getResource("/images/AboutUs.jpg"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(0, 0, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);
        
        // Font
       // f1 = new Font("Segoe UI Semibold", Font.PLAIN, 35);

        /*// Title
        label1 = new JLabel();
        label1.setText("About Us");
        label1.setBounds(625, 15, 200, 50);
        label1.setFont(f1);
        c.add(label1);*/


        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("OK");
        btn1.setBounds(425, 600, 200, 50);
        btn1.setFont(f1);
        btn1.setCursor(cursor);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);

        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);

        // Action Listener for JButtons
        // OK Button
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Welcome frame = new Welcome();
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        AboutUS frame = new AboutUS();
        frame.setVisible(true);
    }
}
