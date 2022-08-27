//package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.table.DefaultTableModel;

public class ShowAllWorker extends JFrame {

    WorkerProcess aa;
    JLabel label;
    JPanel panel;
    JButton btn2;
    //SellerActivity sa;
    
    JTable table;
    DefaultTableModel model;
    JScrollPane scroll;

    String columns[] = {"Worker Name", "Worker ID", "Password", "PhoneNumber"};
    String rows[] = new String[4];

    public ShowAllWorker() {

        this.setSize(800, 450);
        this.setResizable(false);
        this.setTitle("Rent Management");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Border border = BorderFactory.createLineBorder(Color.black, 3);
        Font font = new Font("Segoe UI Black", 1, 20);
        Font f2 = new Font("Segoe UI Black", Font.PLAIN, 25);

        panel = new JPanel();
        panel.setLayout(null);

        btn2 = new JButton("OK");
        btn2.setBounds(340, 325, 215, 50);
        btn2.setFont(f2);
        //btn2.setCursor(cursor);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        panel.add(btn2);

        label = new JLabel();
        label.setBounds(0, 0, 684, 311);
        label.setBackground(new Color(204, 255, 255));
        //label.setBorder(border);
        panel.add(label);

        //Table
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        
        table.setFont(font);
        table.setSelectionBackground(Color.green);
        table.setBackground(Color.WHITE);
        table.setRowHeight(40);     

        // Back Button
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                setVisible(false);
                WorkerProcess frame = new WorkerProcess();
                frame.setVisible(true);
            }
        });   

        scroll = new JScrollPane(table);
        //scroll.setBorder(border);
        scroll.setBounds(0, 0, 690, 320);
        panel.add(scroll);

        try {

            String filePath = "WorkerList.txt";
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] lines = br.lines().toArray();

            for (int i = 0; i < lines.length; i++) {
                String[] row = lines[i].toString().split(" ");
                model.addRow(row);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Here: " + ex);
        }

        this.add(panel);
    }

}
