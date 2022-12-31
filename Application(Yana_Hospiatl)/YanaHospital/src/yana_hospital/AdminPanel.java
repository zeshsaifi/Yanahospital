package yana_hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Random;
class Adminpanelinterface{
    static  String patient_id_value,patient_name_value,father_name_value,address_value,patient_phone_value,disease_value;
    static  String ward_value,time_of_admit_value,time_of_discharge_value,amount_value,payment_value;
    static String username_value,phone_value,generate_key_value;
    Adminpanelinterface(){
        JFrame frame=new JFrame("Yana Hospital");

        JLabel background=new JLabel();
        JLabel patient_id=new JLabel("Patient ID :");
        JLabel patient_name=new JLabel("Patient name :");
        JLabel father_name=new JLabel("Father's name :");
        JLabel address=new JLabel("Address :");
        JLabel patient_phone=new JLabel("Phone number :");
        JLabel disease=new JLabel("Disease :");
        JLabel ward=new JLabel("Ward :");
        JLabel time_of_admit=new JLabel("Time of Admit :");
        JLabel time_of_discharge=new JLabel("Time of discharge :");
        JLabel amount=new JLabel("Amount :");
        JLabel payment=new JLabel("Payment :");
        JLabel username=new JLabel("Username :");
        JLabel genrate_key=new JLabel("Generate key :");
        JLabel user_phone=new JLabel("Phone number :");

        JTextField patient_id_field=new JTextField();
        JTextField patient_name_field=new JTextField();
        JTextField father_name_field=new JTextField();
        JTextField address_field=new JTextField();
        JTextField phone_field=new JTextField();
        JTextField patient_phone_field=new JTextField();
        JTextField disease_field=new JTextField();
        JTextField ward_field=new JTextField();
        JTextField time_of_admit_field=new JTextField("0000-00-00 00:00:00");
        JTextField time_of_discharge_field=new JTextField("0000-00-00 00:00:00");
        JTextField amount_field=new JTextField();
        JTextField payment_field=new JTextField();
        JTextField username_field=new JTextField();
        JTextField genrate_key_field=new JTextField();
        JTextField user_phone_field=new JTextField();

        ImageIcon exit_logo=new ImageIcon("images/exit_logo.png");
        ImageIcon signout_logo=new ImageIcon("images/back_logo.png");
        ImageIcon main_logo=new ImageIcon("images/main_logo.png");
        ImageIcon adminpanel_background=new ImageIcon("images/adminpanel_background.png");
        ImageIcon key_logo=new ImageIcon("images/key_logo.png");
        ImageIcon newrecord_logo=new ImageIcon("images/new_record_logo.png");
        ImageIcon search_logo=new ImageIcon("images/search_logo.png");
        ImageIcon all_logo=new ImageIcon("images/all_logo.png");
        ImageIcon update_logo=new ImageIcon("images/update_logo.png");
        ImageIcon delete_logo=new ImageIcon("images/delete_logo.png");
        ImageIcon login_history_logo=new ImageIcon("images/login_history_logo.png");

        JPanel panelA=new JPanel();
        JPanel panelB=new JPanel();

        JButton signout_button=new JButton("SIGN OUT");
        JButton exit=new JButton("EXIT");
        JButton insert_button=new JButton();
        JButton reset_button=new JButton("Reset");
        JButton refresh_button=new JButton("Refresh");
        JButton new_record=new JButton("New Record");
        JButton search_record=new JButton("Search Record");
        JButton all_record=new JButton("All Record");
        JButton update_record=new JButton("Update Record");
        JButton generate_key=new JButton("Generate Key");
        JButton login_history=new JButton("Login History");
        JButton user_record=new JButton("User Record");
        JButton delete_user=new JButton("Delete User");

        Object rowData1[][] = {{"Row1-Column1", "Row1-Column2"}};
        Object columnNames1[] = {"Username","Time"};
        DefaultTableModel model1 = new DefaultTableModel(rowData1, columnNames1);
        JTable table1 = new JTable(model1);
        JScrollPane scroll1= new JScrollPane(table1);
        scroll1.setBounds(75,250,1200,450);
        scroll1.setVisible(false);
        table1.setFont(new Font("ARIAL",0,18));
        table1.getTableHeader().setFont(new Font("ARIAL",1,20));
        table1.getTableHeader().setBackground(new Color(157,236,249));
        table1.setRowHeight(30);

        Object rowData2[][] = {{"Row1-Column1","Row1-Column2","Row1-Column3","Row1-Column4","Row1-Column5","Row1-Column6","Row1-Column7","Row1-Column8","Row1-Column9","Row1-Column10","Row1-Column11"}};
        Object columnNames2[] = {"Patient ID","Patient Name","Patient Father's Name","Address","Phone Number","Diseases","Ward","Time of Admit","Time of Discharge","Amount","Payment"};
        DefaultTableModel model2 = new DefaultTableModel(rowData2, columnNames2);
        JTable table2 = new JTable(model2);
        JScrollPane scroll2= new JScrollPane(table2);
        scroll2.setBounds(75,250,1200,450);
        scroll2.setVisible(false);
        table2.getColumnModel().getColumn(2).setPreferredWidth(140);
        table2.getColumnModel().getColumn(4).setPreferredWidth(100);
        table2.getColumnModel().getColumn(7).setPreferredWidth(100);
        table2.getColumnModel().getColumn(8).setPreferredWidth(110);
        table2.getTableHeader().setFont(new Font("ARIAL",1,14));
        table2.getTableHeader().setBackground(new Color(157,236,249));

        Object rowData3[][] = {{"Row1-Column1", "Row1-Column2","Row1-Column3"}};
        Object columnNames3[] = {"Username","Phone Number","Key"};
        DefaultTableModel model3 = new DefaultTableModel(rowData3, columnNames3);
        JTable table3 = new JTable(model3);
        JScrollPane scroll3= new JScrollPane(table3);
        scroll3.setBounds(75,250,1200,450);
        scroll3.setVisible(false);
        table3.setFont(new Font("ARIAL",0,18));
        table3.getTableHeader().setFont(new Font("ARIAL",1,20));
        table3.getTableHeader().setBackground(new Color(157,236,249));
        table3.setRowHeight(30);

        signout_button.setIcon(signout_logo);
        signout_button.setBounds(10,10,125,50);
        signout_button.setBorder(null);
        signout_button.setBackground(null);
        signout_button.setFont(new Font("ARIAL",Font.BOLD,16));
        signout_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main m=new Main();
                Maininterface m1=new Maininterface();
                frame.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                signout_button.setBorder(BorderFactory.createMatteBorder(
                        2, 2, 2, 2, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signout_button.setBorder(null);
            }
        });

        background.setIcon(adminpanel_background);
        background.setBounds(20,0,1280,720);

        panelA.setBackground(Color.WHITE);
        panelA.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        panelA.setBounds(75,100,1200,100);

        panelB.setBackground(Color.WHITE);
        panelB.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        panelB.setBounds(75,250,1200,450);
        panelB.setVisible(false);

        //1
        patient_id.setBounds(125,300,150,25);
        patient_id.setFont(new Font("ARIAL",Font.BOLD,20));
        patient_id.setVisible(false);
        //2
        patient_name.setBounds(125,350,150,25);
        patient_name.setFont(new Font("ARIAL",Font.BOLD,20));
        patient_name.setVisible(false);
        //3
        father_name.setBounds(125,400,150,25);
        father_name.setFont(new Font("ARIAL",Font.BOLD,20));
        father_name.setVisible(false);
        //4
        address.setBounds(125,450,150,25);
        address.setFont(new Font("ARIAL",Font.BOLD,20));
        address.setVisible(false);
        //5
        patient_phone.setBounds(125,500,200,25);
        patient_phone.setFont(new Font("ARIAL",Font.BOLD,20));
        patient_phone.setVisible(false);
        //6
        disease.setBounds(125,550,150,25);
        disease.setFont(new Font("ARIAL",Font.BOLD,20));
        disease.setVisible(false);
        //7
        ward.setBounds(700,300,150,25);
        ward.setFont(new Font("ARIAL",Font.BOLD,20));
        ward.setVisible(false);
        //8
        time_of_admit.setBounds(700,350,150,25);
        time_of_admit.setFont(new Font("ARIAL",Font.BOLD,20));
        time_of_admit.setVisible(false);
        //9
        time_of_discharge.setBounds(700,400,190,25);
        time_of_discharge.setFont(new Font("ARIAL",Font.BOLD,20));
        time_of_discharge.setVisible(false);
        //10
        amount.setBounds(700,450,150,25);
        amount.setFont(new Font("ARIAL",Font.BOLD,20));
        amount.setVisible(false);
        //11
        payment.setBounds(700,500,150,25);
        payment.setFont(new Font("ARIAL",Font.BOLD,20));
        payment.setVisible(false);

        //buttons 1
        reset_button.setBounds(850,600,150,50);
        reset_button.setBackground(new Color(250,128,114));
        reset_button.setFont(new Font("ARIAL",Font.BOLD,20));
        reset_button.setBorder(null);
        reset_button.setVisible(false);
        //button 2
        insert_button.setBounds(1050,600,150,50);
        insert_button.setBackground(new Color(157,236,249));
        insert_button.setFont(new Font("ARIAL",Font.BOLD,20));
        insert_button.setBorder(null);
        insert_button.setVisible(false);
        //button3
        refresh_button.setBounds(550,300,100,25);
        refresh_button.setBackground(new Color(144,238,144));
        refresh_button.setFont(new Font("ARIAL",Font.BOLD,16));
        refresh_button.setBorder(null);
        refresh_button.setVisible(false);

        //1
        patient_id_field.setBounds(300,300,200,25);
        patient_id_field.setFont(new Font("ARIAL",0,20));
        patient_id_field.setVisible(false);
        //2
        patient_name_field.setBounds(300,350,200,25);
        patient_name_field.setFont(new Font("ARIAL",0,20));
        patient_name_field.setVisible(false);
        //3
        father_name_field.setBounds(300,400,200,25);
        father_name_field.setFont(new Font("ARIAL",0,20));
        father_name_field.setVisible(false);
        //4
        address_field.setBounds(300,450,200,25);
        address_field.setFont(new Font("ARIAL",0,20));
        address_field.setVisible(false);
        //5
        patient_phone_field.setBounds(300,500,200,25);
        patient_phone_field.setFont(new Font("ARIAL",0,20));
        patient_phone_field.setVisible(false);
        //6
        disease_field.setBounds(300,550,200,25);
        disease_field.setFont(new Font("ARIAL",0,20));
        disease_field.setVisible(false);
        //7
        ward_field.setBounds(900,300,200,25);
        ward_field.setFont(new Font("ARIAL",0,20));
        ward_field.setVisible(false);
        //8
        time_of_admit_field.setBounds(900,350,200,25);
        time_of_admit_field.setFont(new Font("ARIAL",0,20));
        time_of_admit_field.setVisible(false);
        //9
        time_of_discharge_field.setBounds(900,400,200,25);
        time_of_discharge_field.setFont(new Font("ARIAL",0,20));
        time_of_discharge_field.setVisible(false);
        //10
        amount_field.setBounds(900,450,200,25);
        amount_field.setFont(new Font("ARIAL",0,20));
        amount_field.setVisible(false);
        //11
        payment_field.setBounds(900,500,200,25);
        payment_field.setFont(new Font("ARIAL",0,20));
        payment_field.setVisible(false);

        //delete user 1
        username.setBounds(125,300,150,25);
        username.setFont(new Font("ARIAL",Font.BOLD,20));
        username.setVisible(false);
        //delete user 2
        user_phone.setBounds(125,350,200,25);
        user_phone.setFont(new Font("ARIAL",Font.BOLD,20));
        user_phone.setVisible(false);
        //delete user 3
        username_field.setBounds(300,300,200,25);
        username_field.setFont(new Font("ARIAL",0,20));
        username_field.setVisible(false);
        //delete user 4
        user_phone_field.setBounds(300,350,200,25);
        user_phone_field.setFont(new Font("ARIAL",0,20));
        user_phone_field.setVisible(false);

        //genrate key 1
        genrate_key.setBounds(125,300,150,25);
        genrate_key.setFont(new Font("ARIAL",Font.BOLD,20));
        genrate_key.setVisible(false);
        //genrate key 2
        genrate_key_field.setBounds(300,300,200,25);
        genrate_key_field.setFont(new Font("ARIAL",0,20));
        genrate_key_field.setEditable(false);
        genrate_key_field.setVisible(false);

        new_record.setIcon(newrecord_logo);
        new_record.setBounds(76,101, 300,48);
        new_record.setBackground(Color.WHITE);
        new_record.setBorder(null);
        new_record.setFont(new Font("ARIAL",Font.BOLD,24));
        new_record.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelB.setVisible(true);

                patient_id_field.setText("");
                patient_name_field.setText("");
                father_name_field.setText("");
                address_field.setText("");
                patient_phone_field.setText("");
                disease_field.setText("");
                ward_field.setText("");
                time_of_admit_field.setText("0000-00-00 00:00:00");
                time_of_discharge_field.setText("0000-00-00 00:00:00");
                amount_field.setText("");
                payment_field.setText("");

                patient_id.setVisible(false);
                patient_name.setVisible(false);
                father_name.setVisible(false);
                address.setVisible(false);
                patient_phone.setVisible(false);
                disease.setVisible(false);
                ward.setVisible(false);
                time_of_admit.setVisible(false);
                time_of_discharge.setVisible(false);
                amount.setVisible(false);
                payment.setVisible(false);
                patient_id.setVisible(false);
                genrate_key.setVisible(false);
                username.setVisible(false);
                user_phone.setVisible(false);

                patient_id_field.setVisible(false);
                patient_name_field.setVisible(false);
                father_name_field.setVisible(false);
                address_field.setVisible(false);
                patient_phone_field.setVisible(false);
                disease_field.setVisible(false);
                ward_field.setVisible(false);
                time_of_admit_field.setVisible(false);
                time_of_discharge_field.setVisible(false);
                amount_field.setVisible(false);
                payment_field.setVisible(false);
                patient_id_field.setVisible(false);
                genrate_key_field.setVisible(false);
                refresh_button.setVisible(false);
                insert_button.setVisible(false);
                reset_button.setVisible(false);
                username_field.setVisible(false);
                user_phone_field.setVisible(false);

                scroll1.setVisible(false);
                scroll2.setVisible(false);
                scroll3.setVisible(false);

                patient_id.setVisible(true);
                patient_name.setVisible(true);
                father_name.setVisible(true);
                address.setVisible(true);
                patient_phone.setVisible(true);
                disease.setVisible(true);
                ward.setVisible(true);
                time_of_admit.setVisible(true);
                time_of_discharge.setVisible(true);
                amount.setVisible(true);
                payment.setVisible(true);

                patient_id_field.setVisible(true);
                patient_name_field.setVisible(true);
                father_name_field.setVisible(true);
                address_field.setVisible(true);
                patient_phone_field.setVisible(false);
                disease_field.setVisible(true);
                patient_phone_field.setVisible(true);
                ward_field.setVisible(true);
                time_of_admit_field.setVisible(true);
                time_of_discharge_field.setVisible(true);
                amount_field.setVisible(true);
                payment_field.setVisible(true);

                reset_button.setVisible(true);
                reset_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        patient_id_field.setText("");
                        patient_name_field.setText("");
                        father_name_field.setText("");
                        address_field.setText("");
                        patient_phone_field.setText("");
                        disease_field.setText("");
                        ward_field.setText("");
                        time_of_admit_field.setText("0000-00-00 00:00:00");
                        time_of_discharge_field.setText("0000-00-00 00:00:00");
                        amount_field.setText("");
                        payment_field.setText("");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        reset_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        reset_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        reset_button.setBorder(null);
                        reset_button.setBackground(new Color(250,128,114));
                    }
                });

                insert_button.setVisible(true);
                insert_button.setText("Insert");
                insert_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        patient_id_value=patient_id_field.getText();
                        patient_name_value=patient_name_field.getText();
                        father_name_value=father_name_field.getText();
                        address_value=address_field.getText();
                        patient_phone_value=patient_phone_field.getText();
                        disease_value=disease_field.getText();
                        ward_value=ward_field.getText();
                        time_of_admit_value=time_of_admit_field.getText();
                        time_of_discharge_value=time_of_discharge_field.getText();
                        amount_value=amount_field.getText();
                        payment_value=payment_field.getText();

                        //1
                        if(patient_id_value.isEmpty())
                        {
                            JOptionPane.showMessageDialog(frame,"Please enter valid ID");
                        }
                        else if(patient_id_value.length() < 8) {
                            JOptionPane.showMessageDialog(frame,"ID must be 8 character or more");
                        }
                        else
                        {
                            //2
                            if(patient_name_value.isEmpty())
                            {
                                JOptionPane.showMessageDialog(frame,"Please enter patient name");
                            }
                            else
                            {
                                //3
                                if(father_name_value.isEmpty())
                                {
                                    JOptionPane.showMessageDialog(frame,"Please enter father's name");
                                }
                                else
                                {
                                    //4
                                    if(address_value.isEmpty())
                                    {
                                        JOptionPane.showMessageDialog(frame,"Please enter address");
                                    }
                                    else
                                    {
                                        //5
                                        if(disease_value.isEmpty())
                                        {
                                            JOptionPane.showMessageDialog(frame,"Please enter disease");
                                        }
                                        else
                                        {
                                            //6
                                            if(ward_value.isEmpty())
                                            {
                                                JOptionPane.showMessageDialog(frame,"Please enter ward");
                                            }
                                            else
                                            {
                                                //7
                                                if(time_of_admit_value.isEmpty())
                                                {
                                                    JOptionPane.showMessageDialog(frame,"Please enter time of admit");
                                                }
                                                else
                                                {
                                                    //8
                                                    if(time_of_discharge_value.isEmpty())
                                                    {
                                                        JOptionPane.showMessageDialog(frame,"Please enter time of discharge");
                                                    }
                                                    else
                                                    {
                                                        //9
                                                        if(amount_value.isEmpty())
                                                        {
                                                            JOptionPane.showMessageDialog(frame,"Please enter amount");
                                                        }
                                                        else
                                                        {
                                                            //10
                                                            if(payment_value.isEmpty())
                                                            {
                                                                JOptionPane.showMessageDialog(frame,"Please enter payment");
                                                            }
                                                            else
                                                            {
                                                                //JDBC Connection
                                                                try{
                                                                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                                                                    Statement stmt= con.createStatement();
                                                                    String command="INSERT INTO `patient_information`(`patient_id`, `pateint_name`, `patient_father's_name`, `address`, `phone`, `diseases`, `ward`, `time_of_admit`, `time_of_discharge`, `amount`, `payment`) VALUES ('"+patient_id_value+"','"+patient_name_value+"','"+father_name_value+"','"+address_value+"','"+patient_phone_value+"','"+disease_value+"','"+ward_value+"','"+time_of_admit_value+"','"+time_of_discharge_value+"','"+amount_value+"','"+payment_value+"')";
                                                                    stmt.executeUpdate(command);
                                                                    JOptionPane.showMessageDialog(frame,"Data Inserted");
                                                                }
                                                                catch (Exception ex)
                                                                {
                                                                    JOptionPane.showMessageDialog(frame,"ERROR = "+ex);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        insert_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        insert_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        insert_button.setBorder(null);
                        insert_button.setBackground(new Color(157,236,249,255));
                    }
                });

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                new_record.setBorder(BorderFactory.createMatteBorder(
                        2, 2, 3, 3, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                new_record.setBorder(null);
            }
        });

        search_record.setIcon(search_logo);
        search_record.setBounds(376,101, 298,48);
        search_record.setBackground(Color.WHITE);
        search_record.setBorder(null);
        search_record.setFont(new Font("ARIAL",Font.BOLD,24));
        search_record.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelB.setVisible(true);

                patient_id_field.setText("");
                patient_name_field.setText("");
                father_name_field.setText("");
                address_field.setText("");
                patient_phone_field.setText("");
                disease_field.setText("");
                ward_field.setText("");
                time_of_admit_field.setText("0000-00-00 00:00:00");
                time_of_discharge_field.setText("0000-00-00 00:00:00");
                amount_field.setText("");
                payment_field.setText("");

                patient_id.setVisible(false);
                patient_name.setVisible(false);
                father_name.setVisible(false);
                address.setVisible(false);
                patient_phone.setVisible(false);
                disease.setVisible(false);
                ward.setVisible(false);
                time_of_admit.setVisible(false);
                time_of_discharge.setVisible(false);
                amount.setVisible(false);
                payment.setVisible(false);
                patient_id.setVisible(false);
                genrate_key.setVisible(false);
                username.setVisible(false);
                user_phone.setVisible(false);

                patient_id_field.setVisible(false);
                patient_name_field.setVisible(false);
                father_name_field.setVisible(false);
                address_field.setVisible(false);
                patient_phone_field.setVisible(false);
                disease_field.setVisible(false);
                ward_field.setVisible(false);
                time_of_admit_field.setVisible(false);
                time_of_discharge_field.setVisible(false);
                amount_field.setVisible(false);
                payment_field.setVisible(false);
                patient_id_field.setVisible(false);
                genrate_key_field.setVisible(false);
                refresh_button.setVisible(false);
                insert_button.setVisible(false);
                reset_button.setVisible(false);
                username_field.setVisible(false);
                user_phone_field.setVisible(false);

                scroll1.setVisible(false);
                scroll2.setVisible(false);
                scroll3.setVisible(false);


                patient_id.setVisible(true);
                patient_id_field.setVisible(true);

                reset_button.setVisible(true);
                reset_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        patient_id_field.setText("");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        reset_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        reset_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        reset_button.setBorder(null);
                        reset_button.setBackground(new Color(250,128,114));
                    }
                });

                insert_button.setVisible(true);
                insert_button.setText("Search");
                insert_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        patient_id_value=patient_id_field.getText();

                        //1
                        if(patient_id_value.isEmpty())
                        {
                            JOptionPane.showMessageDialog(frame,"Please enter valid ID");
                        }
                        else if(patient_id_value.length() < 8) {
                            JOptionPane.showMessageDialog(frame,"ID must be 8 character or more");
                        }
                        else
                        {
                            //JDBC
                            try {

                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                                Statement stmt= con.createStatement();
                                ResultSet rs = stmt.executeQuery("SELECT * FROM `patient_information` WHERE `patient_id`='"+patient_id_value+"'");

                                while(rs.next())
                                {
                                    patient_id.setVisible(true);
                                    patient_name.setVisible(true);
                                    father_name.setVisible(true);
                                    address.setVisible(true);
                                    patient_phone.setVisible(true);
                                    disease.setVisible(true);
                                    ward.setVisible(true);
                                    time_of_admit.setVisible(true);
                                    time_of_discharge.setVisible(true);
                                    amount.setVisible(true);
                                    payment.setVisible(true);

                                    patient_id_field.setVisible(true);
                                    patient_name_field.setVisible(true);
                                    father_name_field.setVisible(true);
                                    address_field.setVisible(true);
                                    patient_phone_field.setVisible(false);
                                    disease_field.setVisible(true);
                                    patient_phone_field.setVisible(true);
                                    ward_field.setVisible(true);
                                    time_of_admit_field.setVisible(true);
                                    time_of_discharge_field.setVisible(true);
                                    amount_field.setVisible(true);
                                    payment_field.setVisible(true);

                                    patient_id_field.setText(rs.getString(1));
                                    patient_name_field.setText(rs.getString(2));
                                    father_name_field.setText(rs.getString(3));
                                    address_field.setText(rs.getString(4));
                                    patient_phone_field.setText(rs.getString(5));
                                    disease_field.setText(rs.getString(6));
                                    ward_field.setText(rs.getString(7));
                                    time_of_admit_field.setText(rs.getString(8));
                                    time_of_discharge_field.setText(rs.getString(9));
                                    amount_field.setText(rs.getString(10));
                                    payment_field.setText(rs.getString(11));
                            }
                            }
                            catch (Exception ex)
                            {
                                System.out.println("Error = "+ex);
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        insert_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        insert_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        insert_button.setBorder(null);
                        insert_button.setBackground(new Color(157,236,249,255));
                    }
                });

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                search_record.setBorder(BorderFactory.createMatteBorder(
                        2, 3, 3, 3, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                search_record.setBorder(null);
            }
        });

        all_record.setIcon(all_logo);
        all_record.setBounds(676,101, 298,48);
        all_record.setBackground(Color.WHITE);
        all_record.setBorder(null);
        all_record.setFont(new Font("ARIAL",Font.BOLD,24));
        all_record.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelB.setVisible(true);

                patient_id_field.setText("");
                patient_name_field.setText("");
                father_name_field.setText("");
                address_field.setText("");
                patient_phone_field.setText("");
                disease_field.setText("");
                ward_field.setText("");
                time_of_admit_field.setText("0000-00-00 00:00:00");
                time_of_discharge_field.setText("0000-00-00 00:00:00");
                amount_field.setText("");
                payment_field.setText("");

                patient_id.setVisible(false);
                patient_name.setVisible(false);
                father_name.setVisible(false);
                address.setVisible(false);
                patient_phone.setVisible(false);
                disease.setVisible(false);
                ward.setVisible(false);
                time_of_admit.setVisible(false);
                time_of_discharge.setVisible(false);
                amount.setVisible(false);
                payment.setVisible(false);
                patient_id.setVisible(false);

                patient_id_field.setVisible(false);
                patient_name_field.setVisible(false);
                father_name_field.setVisible(false);
                address_field.setVisible(false);
                patient_phone_field.setVisible(false);
                disease_field.setVisible(false);
                ward_field.setVisible(false);
                time_of_admit_field.setVisible(false);
                time_of_discharge_field.setVisible(false);
                amount_field.setVisible(false);
                payment_field.setVisible(false);
                patient_id_field.setVisible(false);
                insert_button.setVisible(false);
                reset_button.setVisible(false);

                scroll1.setVisible(false);
                scroll2.setVisible(false);
                scroll3.setVisible(false);

                //JDBC
                scroll2.setVisible(true);

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                    Statement stmt = con.createStatement();
                    String query = "SELECT * FROM `patient_information`";
                    ResultSet rs = stmt.executeQuery(query);

                    model2.removeRow(0);

                    Object[] rows;

                    while (rs.next()) {
                        rows = new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)};
                        model2.addRow(rows);
                    }
                }
                catch (Exception ex)
                {
                    System.err.println("Error: " + ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                all_record.setBorder(BorderFactory.createMatteBorder(
                        3, 3, 3, 3, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                all_record.setBorder(null);
            }
        });

        update_record.setIcon(update_logo);
        update_record.setBounds(976,101, 298,49);
        update_record.setBackground(Color.WHITE);
        update_record.setBorder(null);
        update_record.setFont(new Font("ARIAL",Font.BOLD,24));
        update_record.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelB.setVisible(true);

                patient_id_field.setText("");
                patient_name_field.setText("");
                father_name_field.setText("");
                address_field.setText("");
                patient_phone_field.setText("");
                disease_field.setText("");
                ward_field.setText("");
                time_of_admit_field.setText("0000-00-00 00:00:00");
                time_of_discharge_field.setText("0000-00-00 00:00:00");
                amount_field.setText("");
                payment_field.setText("");

                patient_id.setVisible(false);
                patient_name.setVisible(false);
                father_name.setVisible(false);
                address.setVisible(false);
                patient_phone.setVisible(false);
                disease.setVisible(false);
                ward.setVisible(false);
                time_of_admit.setVisible(false);
                time_of_discharge.setVisible(false);
                amount.setVisible(false);
                payment.setVisible(false);
                patient_id.setVisible(false);
                genrate_key.setVisible(false);
                username.setVisible(false);
                user_phone.setVisible(false);

                patient_id_field.setVisible(false);
                patient_name_field.setVisible(false);
                father_name_field.setVisible(false);
                address_field.setVisible(false);
                patient_phone_field.setVisible(false);
                disease_field.setVisible(false);
                ward_field.setVisible(false);
                time_of_admit_field.setVisible(false);
                time_of_discharge_field.setVisible(false);
                amount_field.setVisible(false);
                payment_field.setVisible(false);
                patient_id_field.setVisible(false);
                genrate_key_field.setVisible(false);
                refresh_button.setVisible(false);
                insert_button.setVisible(false);
                reset_button.setVisible(false);
                username_field.setVisible(false);
                user_phone_field.setVisible(false);

                scroll1.setVisible(false);
                scroll2.setVisible(false);
                scroll3.setVisible(false);

                patient_id.setVisible(true);
                patient_name.setVisible(true);
                father_name.setVisible(true);
                address.setVisible(true);
                patient_phone.setVisible(true);
                disease.setVisible(true);
                ward.setVisible(true);
                time_of_admit.setVisible(true);
                time_of_discharge.setVisible(true);
                amount.setVisible(true);
                payment.setVisible(true);

                patient_id_field.setVisible(true);
                patient_name_field.setVisible(true);
                father_name_field.setVisible(true);
                address_field.setVisible(true);
                patient_phone_field.setVisible(true);
                disease_field.setVisible(true);
                ward_field.setVisible(true);
                time_of_admit_field.setVisible(true);
                time_of_discharge_field.setVisible(true);
                amount_field.setVisible(true);
                payment_field.setVisible(true);
                refresh_button.setVisible(false);
                username_field.setVisible(false);
                phone_field.setVisible(false);

                reset_button.setVisible(true);
                reset_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        patient_id_field.setText("");
                        patient_name_field.setText("");
                        father_name_field.setText("");
                        address_field.setText("");
                        patient_phone_field.setText("");
                        disease_field.setText("");
                        ward_field.setText("");
                        time_of_admit_field.setText("");
                        time_of_discharge_field.setText("");
                        amount_field.setText("");
                        payment_field.setText("");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        reset_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        reset_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        reset_button.setBorder(null);
                        reset_button.setBackground(new Color(250,128,114));
                    }
                });

                insert_button.setVisible(true);
                insert_button.setText("Update");
                insert_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        patient_id_value=patient_id_field.getText();
                        patient_name_value=patient_name_field.getText();
                        father_name_value=father_name_field.getText();
                        address_value=address_field.getText();
                        patient_phone_value=patient_id_field.getText();
                        disease_value=disease_field.getText();
                        ward_value=ward_field.getText();
                        time_of_admit_value=time_of_admit_field.getText();
                        time_of_discharge_value=time_of_discharge_field.getText();
                        amount_value=amount_field.getText();
                        payment_value=payment_field.getText();

                        //1
                        if(patient_id_value.isEmpty())
                        {
                            JOptionPane.showMessageDialog(frame,"Please enter valid ID");
                        }
                        else if(patient_id_value.length() < 8) {
                            JOptionPane.showMessageDialog(frame,"ID must be 8 character or more");
                        }
                        else
                        {
                            //2
                            if(patient_name_value.isEmpty())
                            {
                                JOptionPane.showMessageDialog(frame,"Please enter patient name");
                            }
                            else
                            {
                                //3
                                if(father_name_value.isEmpty())
                                {
                                    JOptionPane.showMessageDialog(frame,"Please enter father's name");
                                }
                                else
                                {
                                    //4
                                    if(address_value.isEmpty())
                                    {
                                        JOptionPane.showMessageDialog(frame,"Please enter address");
                                    }
                                    else
                                    {
                                        //5
                                        if(disease_value.isEmpty())
                                        {
                                            JOptionPane.showMessageDialog(frame,"Please enter disease");
                                        }
                                        else
                                        {
                                            //6
                                            if(ward_value.isEmpty())
                                            {
                                                JOptionPane.showMessageDialog(frame,"Please enter ward");
                                            }
                                            else
                                            {
                                                //7
                                                if(time_of_admit_value.isEmpty())
                                                {
                                                    JOptionPane.showMessageDialog(frame,"Please enter time of admit");
                                                }
                                                else
                                                {
                                                    //8
                                                    if(time_of_discharge_value.isEmpty())
                                                    {
                                                        JOptionPane.showMessageDialog(frame,"Please enter time of discharge");
                                                    }
                                                    else
                                                    {
                                                        //9
                                                        if(amount_value.isEmpty())
                                                        {
                                                            JOptionPane.showMessageDialog(frame,"Please enter amount");
                                                        }
                                                        else
                                                        {
                                                            //10
                                                            if(payment_value.isEmpty())
                                                            {
                                                                JOptionPane.showMessageDialog(frame,"Please enter payment");
                                                            }
                                                            else
                                                            {
                                                                //JDBC
                                                                try{
                                                                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                                                                    Statement stmt= con.createStatement();
                                                                    String command="UPDATE `patient_information` SET `pateint_name`='"+patient_name_value+"',`patient_father's_name`='"+father_name_value+"',`address`='"+address_value+"',`phone`='"+patient_phone_value+"',`diseases`='"+disease_value+"',`ward`='"+ward_value+"',`time_of_admit`='"+time_of_admit_value+"',`time_of_discharge`='"+time_of_discharge_value+"',`amount`='"+amount_value+"',`payment`='"+payment_value+"' WHERE `patient_id`='"+patient_id_value+"'";
                                                                    stmt.executeUpdate(command);
                                                                    JOptionPane.showMessageDialog(frame,"Data Updated");
                                                                }
                                                                catch (Exception ex)
                                                                {
                                                                    JOptionPane.showMessageDialog(frame,"ERROR = "+ex);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        insert_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        insert_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        insert_button.setBorder(null);
                        insert_button.setBackground(new Color(157,236,249,255));
                    }
                });

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                update_record.setBorder(BorderFactory.createMatteBorder(
                        2, 3, 3, 2, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                update_record.setBorder(null);
            }
        });


        generate_key.setIcon(key_logo);
        generate_key.setBounds(76,150, 298,49);
        generate_key.setBackground(Color.WHITE);
        generate_key.setBorder(null);
        generate_key.setFont(new Font("ARIAL",Font.BOLD,24));
        generate_key.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                patient_id_field.setText("");
                patient_name_field.setText("");
                father_name_field.setText("");
                address_field.setText("");
                patient_phone_field.setText("");
                disease_field.setText("");
                ward_field.setText("");
                time_of_admit_field.setText("0000-00-00 00:00:00");
                time_of_discharge_field.setText("0000-00-00 00:00:00");
                amount_field.setText("");
                payment_field.setText("");

                patient_id.setVisible(false);
                patient_name.setVisible(false);
                father_name.setVisible(false);
                address.setVisible(false);
                patient_phone.setVisible(false);
                disease.setVisible(false);
                ward.setVisible(false);
                time_of_admit.setVisible(false);
                time_of_discharge.setVisible(false);
                amount.setVisible(false);
                payment.setVisible(false);
                patient_id.setVisible(false);
                genrate_key.setVisible(false);
                username.setVisible(false);
                user_phone.setVisible(false);

                patient_id_field.setVisible(false);
                patient_name_field.setVisible(false);
                father_name_field.setVisible(false);
                address_field.setVisible(false);
                patient_phone_field.setVisible(false);
                disease_field.setVisible(false);
                ward_field.setVisible(false);
                time_of_admit_field.setVisible(false);
                time_of_discharge_field.setVisible(false);
                amount_field.setVisible(false);
                payment_field.setVisible(false);
                patient_id_field.setVisible(false);
                genrate_key_field.setVisible(false);
                refresh_button.setVisible(false);
                insert_button.setVisible(false);
                reset_button.setVisible(false);
                username_field.setVisible(false);
                user_phone_field.setVisible(false);

                scroll1.setVisible(false);
                scroll2.setVisible(false);
                scroll3.setVisible(false);

                panelB.setVisible(true);

                genrate_key.setVisible(true);
                genrate_key_field.setVisible(true);

                refresh_button.setVisible(true);
                refresh_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Random r=new Random();
                        int rand1=r.nextInt(999999999);
                        int rand2=r.nextInt(9999999);

                        String rand3=Integer.toString(rand1);
                        String rand4=Integer.toString(rand2);

                        genrate_key_field.setText(rand3+rand4);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        refresh_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        refresh_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        refresh_button.setBorder(null);
                        refresh_button.setBackground(new Color(144,238,144));
                    }
                });

                reset_button.setVisible(true);
                reset_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        patient_id_field.setText("");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        reset_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        reset_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        reset_button.setBorder(null);
                        reset_button.setBackground(new Color(250,128,114));
                    }
                });

                insert_button.setVisible(true);
                insert_button.setText("Generate");
                insert_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(genrate_key_field);
                        generate_key_value=genrate_key_field.getText();
                        //JDBC
                        try{
                            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                            Statement stmt= con.createStatement();
                            String command="INSERT INTO `users`(`username`, `password`, `phone`, `key_value`) VALUES ('0','0','0','"+generate_key_value+"')";
                            stmt.executeUpdate(command);
                            JOptionPane.showMessageDialog(frame,"Key Generated");
                        }
                        catch (Exception ex)
                        {
                            JOptionPane.showMessageDialog(frame,"ERROR = "+ex);
                        }

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        insert_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        insert_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        insert_button.setBorder(null);
                        insert_button.setBackground(new Color(157,236,249,255));
                    }
                });

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                generate_key.setBorder(BorderFactory.createMatteBorder(
                        3, 2, 2, 3, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                generate_key.setBorder(null);
            }
        });

        user_record.setIcon(login_history_logo);
        user_record.setBounds(676,150, 298,49);
        user_record.setBackground(Color.WHITE);
        user_record.setBorder(null);
        user_record.setFont(new Font("ARIAL",Font.BOLD,24));
        user_record.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelB.setVisible(true);

                patient_id_field.setText("");
                patient_name_field.setText("");
                father_name_field.setText("");
                address_field.setText("");
                patient_phone_field.setText("");
                disease_field.setText("");
                ward_field.setText("");
                time_of_admit_field.setText("0000-00-00 00:00:00");
                time_of_discharge_field.setText("0000-00-00 00:00:00");
                amount_field.setText("");
                payment_field.setText("");

                patient_id.setVisible(false);
                patient_name.setVisible(false);
                father_name.setVisible(false);
                address.setVisible(false);
                patient_phone.setVisible(false);
                disease.setVisible(false);
                ward.setVisible(false);
                time_of_admit.setVisible(false);
                time_of_discharge.setVisible(false);
                amount.setVisible(false);
                payment.setVisible(false);
                patient_id.setVisible(false);
                genrate_key.setVisible(false);
                username.setVisible(false);
                user_phone.setVisible(false);

                patient_id_field.setVisible(false);
                patient_name_field.setVisible(false);
                father_name_field.setVisible(false);
                address_field.setVisible(false);
                patient_phone_field.setVisible(false);
                disease_field.setVisible(false);
                ward_field.setVisible(false);
                time_of_admit_field.setVisible(false);
                time_of_discharge_field.setVisible(false);
                amount_field.setVisible(false);
                payment_field.setVisible(false);
                patient_id_field.setVisible(false);
                genrate_key_field.setVisible(false);
                refresh_button.setVisible(false);
                insert_button.setVisible(false);
                reset_button.setVisible(false);
                username_field.setVisible(false);
                user_phone_field.setVisible(false);

                scroll1.setVisible(false);
                scroll2.setVisible(false);
                scroll3.setVisible(false);

                scroll3.setVisible(true);
                //JDBC
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                    Statement stmt = con.createStatement();
                    String query = "SELECT * FROM `users`";
                    ResultSet rs = stmt.executeQuery(query);

                    model3.removeRow(0);

                    Object[] rows;

                    while (rs.next()) {
                        rows = new Object[]{rs.getString(1), rs.getString(3),rs.getString(4)};
                        model3.addRow(rows);
                    }
                }
                catch (Exception ex)
                {
                    System.err.println("Error: " + ex);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                user_record.setBorder(BorderFactory.createMatteBorder(
                        3, 3, 2, 3, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                user_record.setBorder(null);
            }
        });

        login_history.setIcon(login_history_logo);
        login_history.setBounds(376,150, 298,49);
        login_history.setBackground(Color.WHITE);
        login_history.setBorder(null);
        login_history.setFont(new Font("ARIAL",Font.BOLD,24));
        login_history.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelB.setVisible(true);

                patient_id_field.setText("");
                patient_name_field.setText("");
                father_name_field.setText("");
                address_field.setText("");
                patient_phone_field.setText("");
                disease_field.setText("");
                ward_field.setText("");
                time_of_admit_field.setText("0000-00-00 00:00:00");
                time_of_discharge_field.setText("0000-00-00 00:00:00");
                amount_field.setText("");
                payment_field.setText("");

                patient_id.setVisible(false);
                patient_name.setVisible(false);
                father_name.setVisible(false);
                address.setVisible(false);
                patient_phone.setVisible(false);
                disease.setVisible(false);
                ward.setVisible(false);
                time_of_admit.setVisible(false);
                time_of_discharge.setVisible(false);
                amount.setVisible(false);
                payment.setVisible(false);
                patient_id.setVisible(false);
                genrate_key.setVisible(false);
                username.setVisible(false);
                user_phone.setVisible(false);

                patient_id_field.setVisible(false);
                patient_name_field.setVisible(false);
                father_name_field.setVisible(false);
                address_field.setVisible(false);
                patient_phone_field.setVisible(false);
                disease_field.setVisible(false);
                ward_field.setVisible(false);
                time_of_admit_field.setVisible(false);
                time_of_discharge_field.setVisible(false);
                amount_field.setVisible(false);
                payment_field.setVisible(false);
                patient_id_field.setVisible(false);
                genrate_key_field.setVisible(false);
                refresh_button.setVisible(false);
                insert_button.setVisible(false);
                reset_button.setVisible(false);
                username_field.setVisible(false);
                user_phone_field.setVisible(false);
                scroll1.setVisible(false);
                scroll2.setVisible(false);
                scroll3.setVisible(false);

                scroll1.setVisible(true);

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                    Statement stmt = con.createStatement();
                    String query = "SELECT * FROM `history`";
                    ResultSet rs = stmt.executeQuery(query);

                    model1.removeRow(0);

                    Object[] rows;

                    while (rs.next()) {
                        rows = new Object[]{rs.getString(1), rs.getString(2)};
                        model1.addRow(rows);
                    }
                }
                catch (Exception ex)
                {
                    System.err.println("Error: " + ex);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                login_history.setBorder(BorderFactory.createMatteBorder(
                        3, 3, 2, 3, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                login_history.setBorder(null);
            }
        });

        delete_user.setIcon(delete_logo);
        delete_user.setBounds(976,150, 298,49);
        delete_user.setBackground(Color.WHITE);
        delete_user.setBorder(null);
        delete_user.setFont(new Font("ARIAL",Font.BOLD,24));
        delete_user.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelB.setVisible(true);

                patient_id_field.setText("");
                patient_name_field.setText("");
                father_name_field.setText("");
                address_field.setText("");
                patient_phone_field.setText("");
                disease_field.setText("");
                ward_field.setText("");
                time_of_admit_field.setText("0000-00-00 00:00:00");
                time_of_discharge_field.setText("0000-00-00 00:00:00");
                amount_field.setText("");
                payment_field.setText("");

                patient_id.setVisible(false);
                patient_name.setVisible(false);
                father_name.setVisible(false);
                address.setVisible(false);
                patient_phone.setVisible(false);
                disease.setVisible(false);
                ward.setVisible(false);
                time_of_admit.setVisible(false);
                time_of_discharge.setVisible(false);
                amount.setVisible(false);
                payment.setVisible(false);
                patient_id.setVisible(false);
                genrate_key.setVisible(false);
                username.setVisible(false);
                user_phone.setVisible(false);

                patient_id_field.setVisible(false);
                patient_name_field.setVisible(false);
                father_name_field.setVisible(false);
                address_field.setVisible(false);
                patient_phone_field.setVisible(false);
                disease_field.setVisible(false);
                ward_field.setVisible(false);
                time_of_admit_field.setVisible(false);
                time_of_discharge_field.setVisible(false);
                amount_field.setVisible(false);
                payment_field.setVisible(false);
                patient_id_field.setVisible(false);
                genrate_key_field.setVisible(false);
                refresh_button.setVisible(false);
                insert_button.setVisible(false);
                reset_button.setVisible(false);
                username_field.setVisible(false);
                user_phone_field.setVisible(false);

                scroll1.setVisible(false);
                scroll2.setVisible(false);
                scroll3.setVisible(false);

                username.setVisible(true);
                user_phone.setVisible(true);

                username_field.setVisible(true);
                user_phone_field.setVisible(true);

                reset_button.setVisible(true);
                reset_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        username_field.setText("");
                        user_phone_field.setText("");
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        reset_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        reset_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        reset_button.setBorder(null);
                        reset_button.setBackground(new Color(250,128,114));
                    }
                });

                insert_button.setVisible(true);
                insert_button.setText("Delete User");
                insert_button.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        username_value=username_field.getText();
                        phone_value=user_phone_field.getText();
                        //JDBC
                        try{
                            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                            Statement stmt= con.createStatement();
                            String command="DELETE FROM `users` WHERE `username`='"+username_value+"' AND `phone`='"+phone_value+"'";
                            stmt.executeUpdate(command);

                            JOptionPane.showMessageDialog(frame,"User Deleted");
                        }
                        catch (Exception ex)
                        {
                            JOptionPane.showMessageDialog(frame,"Invalid Username or Password");
                        }

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        insert_button.setBorder(BorderFactory.createMatteBorder(
                                2, 2, 2, 2, Color.GRAY));
                        insert_button.setBackground(Color.LIGHT_GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        insert_button.setBorder(null);
                        insert_button.setBackground(new Color(157,236,249,255));
                    }
                });

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                delete_user.setBorder(BorderFactory.createMatteBorder(
                        3, 3, 2, 2, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                delete_user.setBorder(null);
            }
        });

        exit.setIcon(exit_logo);
        exit.setBounds(1255,10, 100,50);
        exit.setBackground(Color.WHITE);
        exit.setBorder(null);
        exit.setFont(new Font("ARIAL",Font.BOLD,24));
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setBorder(BorderFactory.createMatteBorder(
                        2, 2, 2, 2, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit.setBorder(null);
            }
        });

        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setIconImage(main_logo.getImage());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(1650,780);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        frame.add(new_record);
        frame.add(search_record);
        frame.add(all_record);
        frame.add(update_record);
        frame.add(generate_key);
        frame.add(login_history);
        frame.add(user_record);
        frame.add(delete_user);
        frame.add(exit);
        frame.add(signout_button);
        frame.add(panelA);

        frame.add(patient_id);
        frame.add(patient_name);
        frame.add(father_name);
        frame.add(address);
        frame.add(patient_phone);
        frame.add(disease);
        frame.add(ward);
        frame.add(time_of_admit);
        frame.add(time_of_discharge);
        frame.add(amount);
        frame.add(payment);
        frame.add(username);
        frame.add(user_phone);
        frame.add(genrate_key);

        frame.add(patient_id_field);
        frame.add(patient_name_field);
        frame.add(father_name_field);
        frame.add(address_field);
        frame.add(patient_phone_field);
        frame.add(disease_field);
        frame.add(ward_field);
        frame.add(time_of_admit_field);
        frame.add(time_of_discharge_field);
        frame.add(amount_field);
        frame.add(payment_field);
        frame.add(username_field);
        frame.add(user_phone_field);
        frame.add(genrate_key_field);

        frame.add(scroll1);
        frame.add(scroll2);
        frame.add(scroll3);

        frame.add(refresh_button);
        frame.add(insert_button);
        frame.add(reset_button);
        frame.add(panelB);
        frame.add(background);

    }
}
class Adminpanel{
    public static void main(String[] args) {

        Adminpanelinterface a=new Adminpanelinterface();
    }
}

