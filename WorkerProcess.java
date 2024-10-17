//package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

public class WorkerProcess extends JFrame implements ActionListener, MouseListener {

    Container c;
    JLabel WorkerProcess, WorkerInfo, WorkerName, WorkerPass, SearchWorker, removeWorker, WorkerID, PhoneNumber, x;
    JTextField WorkerNameTF, WorkerPassTF, WorkerIDTF, SearchWorkerTF, PhoneNumberTF, RemoveTF;
    JButton JBtnInsert, JBtnExit, JBtnClear, JBtnBack, JBtnSearch, JBtnRemove, JBtnShowAll;
    ImageIcon backG, icon;
    JLabel imgLabel;

    ListIterator li = null;
    ArrayList<Worker> al = new ArrayList<>();
    DefaultTableModel dtm;
    String header[] = new String[]{"Worker Name", "Worker ID", "Worker Password", "Phone Number"};

    int row;
    Worker data;
    JTable jt;

    @SuppressWarnings("deprecation")
    public WorkerProcess() {

        this.setSize(1400, 700);
        this.setResizable(false);
        this.setTitle("Rent Management");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        Border border = BorderFactory.createLineBorder(Color.black, 2);

        c = new Container();
        c.setLayout(null);
        c.resize(1400, 700);
        c.setBackground(Color.decode("#d9ebf6"));
        this.add(c);


        // Icon
        icon = new ImageIcon(getClass().getResource("/images/icon.png"));
        this.setIconImage(icon.getImage());


        //Table
        jt = new JTable();
        jt.setName("Worker List");
        jt.setBorder(border);
        jt.setBounds(700, 150, 600, 250);
        //jt.setSize(600, 400);

        JScrollPane jps = new JScrollPane();
        add(jps);
        jt.setPreferredScrollableViewportSize(new Dimension(600, 400));
        jt.setFillsViewportHeight(true);
        jt.setFont(new Font("Segoe UI", 1, 16));
        //JScrollPane jScrollPane = new JScrollPane(jps);

        this.getContentPane().add(jps);

        al = new ArrayList<>();
        dtm = new DefaultTableModel(header, 0);
        jt.setModel(dtm);
        c.add(jt);

        // WorkerProcess Label
        WorkerProcess = new JLabel();
        WorkerProcess.setText("WORKER'S PROCESS");
        WorkerProcess.setBounds(570, 25, 450, 50);
        WorkerProcess.setFont(new Font("Segoe UI Black", 1, 36));
        WorkerProcess.setForeground(new Color(102, 102, 102));
        c.add(WorkerProcess);

        //WorkerInfo Label
        WorkerInfo = new JLabel();
        WorkerInfo.setText("Input Worker's Informations: ");
        WorkerInfo.setBounds(30, 100, 650, 60);
        WorkerInfo.setFont(new Font("Segoe UI Black", 1, 35));
        WorkerInfo.setForeground(new Color(102, 102, 102));
        c.add(WorkerInfo);

        //WorkerName Label
        WorkerName = new JLabel();
        WorkerName.setText("Name: ");
        WorkerName.setBounds(30, 200, 500, 60);
        WorkerName.setFont(new Font("Segoe UI Black", 1, 25));
        WorkerName.setForeground(new Color(102, 102, 102));
        c.add(WorkerName);

        //WorkerID Label
        WorkerID = new JLabel();
        WorkerID.setText("ID: ");
        WorkerID.setBounds(30, 300, 500, 60);
        WorkerID.setFont(new Font("Segoe UI Black", 1, 25));
        WorkerID.setForeground(new Color(102, 102, 102));
        c.add(WorkerID);

        //WorkerPass Label
        WorkerPass = new JLabel();
        WorkerPass.setText("Password: ");
        WorkerPass.setBounds(30, 250, 500, 60);
        WorkerPass.setFont(new Font("Segoe UI Black", 1, 25));
        WorkerPass.setForeground(new Color(102, 102, 102));
        c.add(WorkerPass);

        //PhoneNumber Label
        PhoneNumber = new JLabel();
        PhoneNumber.setText("Phone Number: ");
        PhoneNumber.setBounds(30, 325, 500, 100);
        PhoneNumber.setFont(new Font("Segoe UI Black", 1, 25));
        PhoneNumber.setForeground(new Color(102, 102, 102));
        c.add(PhoneNumber);

        //x Label
        x = new JLabel();
        x.setText("Name:                 ID:                 Password:              Phone No:");
        x.setBounds(700, 100, 900, 60);
        x.setFont(new Font("Segoe UI Black", 1, 20));
        x.setForeground(new Color(102, 102, 102));
        c.add(x);

        

        //WorkerNameTF TextField
        WorkerNameTF = new JTextField();
        WorkerNameTF.setBounds(250, 210, 300, 40);
        WorkerNameTF.setFont(new Font("Segoe UI Black", 1, 20));
        WorkerNameTF.setBorder(border);
        c.add(WorkerNameTF);

        //WorkerPassTF TextField
        WorkerPassTF = new JTextField();
        WorkerPassTF.setBounds(250, 260, 300, 40);
        WorkerPassTF.setFont(new Font("Segoe UI Black", 1, 20));
        WorkerPassTF.setBorder(border);
        c.add(WorkerPassTF);

        //WorkerIDTF TextField
        WorkerIDTF = new JTextField();
        WorkerIDTF.setBounds(250, 310, 300, 40);
        WorkerIDTF.setFont(new Font("Segoe UI Black", 1, 20));
        WorkerIDTF.setBorder(border);
        c.add(WorkerIDTF);

        //PhoneNumberTF TextField
        PhoneNumberTF = new JTextField();
        PhoneNumberTF.setBounds(250, 360, 300, 40);
        PhoneNumberTF.setFont(new Font("Segoe UI Black", 1, 20));
        PhoneNumberTF.setBorder(border);
        c.add(PhoneNumberTF);

        //removeWorker Label
        removeWorker = new JLabel();
        removeWorker.setText("Remove Worker: ");
        removeWorker.setBounds(700, 405, 400, 50);
        removeWorker.setFont(new Font("Segoe UI Black", 1, 30));
        removeWorker.setForeground(new Color(102, 102, 102));
        c.add(removeWorker);

        //SearchWorker Label
        SearchWorker = new JLabel();
        SearchWorker.setText("Search Worker: ");
        SearchWorker.setBounds(700, 505, 400, 50);
        SearchWorker.setFont(new Font("Segoe UI Black", 1, 30));
        SearchWorker.setForeground(new Color(102, 102, 102));
        c.add(SearchWorker);


        //Worker Remove ID Label
        WorkerID = new JLabel();
        WorkerID.setText("ID: ");
        WorkerID.setBounds(700, 435, 500, 60);
        WorkerID.setFont(new Font("Segoe UI Black", 1, 25));
        WorkerID.setForeground(new Color(102, 102, 102));
        c.add(WorkerID);

        //Worker Search ID Label
        WorkerID = new JLabel();
        WorkerID.setText("ID: ");
        WorkerID.setBounds(700, 535, 500, 60);
        WorkerID.setFont(new Font("Segoe UI Black", 1, 25));
        WorkerID.setForeground(new Color(102, 102, 102));
        c.add(WorkerID);

        
        //remove Worker TextField
        RemoveTF = new JTextField();
        RemoveTF.setBounds(750, 450, 150, 40);
        RemoveTF.setFont(new Font("Segoe UI Black", 1, 20));
        RemoveTF.setBorder(border);
        c.add(RemoveTF);

        //SearchWorker TextField
        SearchWorkerTF = new JTextField();
        SearchWorkerTF.setBounds(750, 550, 150, 40);
        SearchWorkerTF.setFont(new Font("Segoe UI Black", 1, 20));
        SearchWorkerTF.setBorder(border);
        c.add(SearchWorkerTF);


        // Search Button      
        JBtnSearch = new JButton();
        JBtnSearch.addActionListener(this);
        JBtnSearch.addMouseListener(this);
        JBtnSearch.setText("Search");
        JBtnSearch.setFont(new Font("Segoe UI Black", 1, 30));
        JBtnSearch.setForeground(new Color(255, 255, 255));
        JBtnSearch.setBackground(new Color(0, 107, 60));
        JBtnSearch.setFocusable(false);
        JBtnSearch.setBounds(925, 550, 160, 55);
        c.add(JBtnSearch);
        //JBtnSearch.setBorder(border);

        // Remove Button      
        JBtnRemove = new JButton();
        JBtnRemove.addActionListener(this);
        JBtnRemove.addMouseListener(this);
        JBtnRemove.setText("Remove");
        JBtnRemove.setFont(new Font("Segoe UI Black", 1, 30));
        JBtnRemove.setForeground(new Color(255, 255, 255));
        JBtnRemove.setBackground(new Color(0, 107, 60));
        JBtnRemove.setFocusable(false);
        JBtnRemove.setBounds(925, 450, 160, 55);
        c.add(JBtnRemove);
        //JBtnRemove.setBorder(border);

        // ShowAll Button      
        JBtnShowAll = new JButton();
        JBtnShowAll.addActionListener(this);
        JBtnShowAll.addMouseListener(this);
        JBtnShowAll.setText("Show All");
        JBtnShowAll.setFont(new Font("Segoe UI Black", 1, 20));
        JBtnShowAll.setForeground(new Color(255, 255, 255));
        JBtnShowAll.setBackground(new Color(154,206, 235));
        JBtnShowAll.setFocusable(false);
        JBtnShowAll.setBounds(1150, 460, 150, 150);
        c.add(JBtnShowAll);
        JBtnShowAll.setBorder(border);

        // Exit Button
        JBtnExit = new JButton();
        JBtnExit.addActionListener(this);
        JBtnExit.addMouseListener(this);
        JBtnExit.setText("Exit");
        JBtnExit.setFont(new Font("Segoe UI Black", 1, 30));
        JBtnExit.setForeground(new Color(255, 255, 255));
        JBtnExit.setBackground(new Color(160, 16, 16));
        JBtnExit.setFocusable(false);
        JBtnExit.setBounds(70, 570, 200, 60);
        c.add(JBtnExit);
    
        // Back Button
        JBtnBack = new JButton();
        JBtnBack.addActionListener(this);
        JBtnBack.addMouseListener(this);
        JBtnBack.setText("Back");
        JBtnBack.setFont(new Font("Segoe UI Black", 1, 30));
        JBtnBack.setForeground(new Color(255, 255, 255));
        JBtnBack.setBackground(new Color(0,128, 0));
        JBtnBack.setFocusable(false);
        JBtnBack.setBounds(320, 570, 200, 60);
        c.add(JBtnBack);

        // Insert Button      
        JBtnInsert = new JButton();
        JBtnInsert.addActionListener(this);
        JBtnInsert.addMouseListener(this);
        JBtnInsert.setText("Insert");
        JBtnInsert.setFont(new Font("Segoe UI Black", 1, 30));
        JBtnInsert.setForeground(new Color(255, 255, 255));
        JBtnInsert.setBackground(new Color(0, 107, 60));
        JBtnInsert.setFocusable(false);
        JBtnInsert.setBounds(250, 415, 150, 50);
        c.add(JBtnInsert);
       

        //Clear Button
        JBtnClear = new JButton();
        JBtnClear.addActionListener(this);
        JBtnClear.addMouseListener(this);
        JBtnClear.setText("Clear");
        JBtnClear.setFont(new Font("Segoe UI Black", 1, 30));
        JBtnClear.setForeground(new Color(255, 255, 255));
        JBtnClear.setBackground(new Color(0, 107, 60));
        JBtnClear.setFocusable(false);
        JBtnClear.setBounds(430, 415, 150, 50);
        c.add(JBtnClear);
       

    }

    public void ShowAllWorker() {
        dtm.setRowCount(0);
        for (int i = 0; i < al.size(); i++) {
            Object[] obj = {al.get(i).wName, al.get(i).wID, al.get(i).workerPwd, al.get(i).phonenNo};
            dtm.addRow(obj);
        }
    }

    public void ShowList() {

        li = al.listIterator();
        while (li.hasNext()) {

            //showMessageDialog(null, li.next());
            System.out.println("***********************************\n");
            System.out.println(li.next());
            System.out.println("");

        }
    }

    public void removeWorker() {
        boolean found = false;
        String id = RemoveTF.getText();
        li = al.listIterator();
        while (li.hasNext()) {
            Worker w = (Worker) li.next();
            if (w.wID.equals(id)) {
                try {
                    int choice = JOptionPane.showConfirmDialog(null, "Delete this data ?", "Delete", JOptionPane.YES_NO_OPTION);
                    if (choice == 0) {
                        li.remove();
                        dtm.removeRow(row);
                        //al.remove(row);
                        ShowAllWorker();
                    }
                    found = true;
                    showMessageDialog(null, "Worker Removed Successfully");
                    if (!found) {
                        showMessageDialog(null, "Worker Not found!");
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    showMessageDialog(null, "ArrayIndexOutOfBoundsException Handled ");

                }
            }
        }
    }

    public void searchWorker() {
        boolean found = false;
        String id = SearchWorkerTF.getText();
        li = al.listIterator();
        while (li.hasNext()) {
            Worker w = (Worker) li.next();
            if (w.wID.equals(id)) {
                showMessageDialog(null, w + " Worker Found");
                System.out.println(w);
                found = true;
            }
        }

        if (!found) {
            showMessageDialog(null, "Worker Not found!");
        }
        //System.out.println("Not Found!");

    }

    //Mouse performed by Mouse listner
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }


    //Action Performed by Listener
    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        String name = WorkerNameTF.getText();
        String id = WorkerIDTF.getText();
        String pwd = WorkerPassTF.getText();
        String phn = PhoneNumberTF.getText();

        
        if (JBtnRemove.getText().equals(command)) {
            removeWorker();
        }
        if (JBtnShowAll.getText().equals(command)) {
        ShowAllWorker sa = new ShowAllWorker();
            this.setVisible(true);
            sa.setVisible(true);
            ShowList();
        }

        if (ae.getSource() == JBtnSearch) {

            searchWorker();
            
            FileWriter fw = null;
            
            try {
                String filePath = "WorkerList.txt";
                File file1 = new File(filePath);
                fw = new FileWriter(file1);
                BufferedWriter bw = new BufferedWriter(fw);

                for (int i = 0; i < jt.getRowCount(); i++) {//rows
                    for (int j = 0; j < jt.getColumnCount(); j++) {//columns
                        bw.write(jt.getValueAt(i, j).toString() + " ");
                    }
                    bw.newLine();
                }

                bw.close();
                fw.close();

            } catch (IOException ex) {

            }
            //ShowList();
        }


        if (JBtnInsert.getText().equals(command)) {

            FileWriter fw = null;
            try {
                String filePath = "WorkerFile.txt";
                File file = new File(filePath);
                fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                Worker Data = new Worker(name, id, pwd, phn);
                al.add(Data);
              
                //String data = Data.toString();                
                String data = "Name : " + WorkerNameTF.getText() + "\n" +WorkerIDTF.getText() + "\n" +WorkerPassTF.getText();
                bw.write(data);
                bw.close();
                fw.close();
                ShowAllWorker();
                showMessageDialog(null, "                     Congraturalation ! \n              Worker has been Inserted ", "Rent Management", JOptionPane.PLAIN_MESSAGE);
            } catch (IOException ex) {

            } 
            finally{
            
            }

        }
        if (JBtnClear.getText().equals(command)) {
            WorkerNameTF.setText(null);
            WorkerIDTF.setText(null);
            WorkerPassTF.setText(null);
            PhoneNumberTF.setText(null);

        }
        if (JBtnBack.getText().equals(command)) {
            WorkerOptions frame = new WorkerOptions();
            frame.setVisible(true);
            this.setVisible(false);
        }

        if (JBtnExit.getText().equals(command)) {
            System.exit(0);

        }

    }
    public static void main(String[] args){
       WorkerProcess frame= new WorkerProcess();
       frame.setVisible(true);
    }

}


