package yana_hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class UserPanelinterface{
    static  String patient_id_value,patient_name_value,father_name_value,address_value,patient_phone_value,disease_value;
    static  String ward_value,time_of_admit_value,time_of_discharge_value,amount_value,payment_value;
    UserPanelinterface(){
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

        JTextField patient_id_field=new JTextField();
        JTextField patient_name_field=new JTextField();
        JTextField father_name_field=new JTextField();
        JTextField address_field=new JTextField();
        JTextField patient_phone_field=new JTextField();
        JTextField disease_field=new JTextField();
        JTextField ward_field=new JTextField();
        JTextField time_of_admit_field=new JTextField();
        JTextField time_of_discharge_field=new JTextField();
        JTextField amount_field=new JTextField();
        JTextField payment_field=new JTextField();

        JPanel panelA=new JPanel();
        JPanel panelB=new JPanel();

        ImageIcon exit_logo=new ImageIcon("images/exit_logo.png");
        ImageIcon signout_logo=new ImageIcon("images/back_logo.png");
        ImageIcon main_logo=new ImageIcon("images/main_logo.png");
        ImageIcon userpanel_background=new ImageIcon("images/userpanel_background.png");
        ImageIcon newrecord_logo=new ImageIcon("images/new_record_logo.png");
        ImageIcon search_logo=new ImageIcon("images/search_logo.png");
        ImageIcon update_logo=new ImageIcon("images/update_logo.png");
        ImageIcon all_logo=new ImageIcon("images/all_logo.png");

        JButton signout_button=new JButton("SIGN OUT");
        JButton exit=new JButton("EXIT");
        JButton new_record=new JButton("New Record");
        JButton insert_button=new JButton();
        JButton reset_button=new JButton("Reset");
        JButton search_record=new JButton("Search Record");
        JButton all_record=new JButton("All Record");
        JButton update_record=new JButton("Update Record");

        Object rowData[][] = {{"Row1-Column1","Row1-Column2","Row1-Column3","Row1-Column4","Row1-Column5","Row1-Column6","Row1-Column7","Row1-Column8","Row1-Column9","Row1-Column10","Row1-Column11"}};
        Object columnNames[] = {"Patient ID","Patient Name","Patient Father's Name","Address","Phone Number","Diseases","Ward","Time of Admit","Time of Discharge","Amount","Payment"};
        DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
        JTable table = new JTable(model);
        JScrollPane scroll= new JScrollPane(table);
        scroll.setBounds(75,250,1200,450);
        scroll.setVisible(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(140);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setPreferredWidth(110);
        table.getTableHeader().setFont(new Font("ARIAL",1,14));
        table.getTableHeader().setBackground(new Color(157,236,249));

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

        background.setIcon(userpanel_background);
        background.setBounds(35,0,1280,720);

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


        new_record.setIcon(newrecord_logo);
        new_record.setBounds(76,101, 300,98);
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
                scroll.setVisible(false);

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
        search_record.setBounds(376,101, 298,98);
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
                scroll.setVisible(false);

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
        all_record.setBounds(676,101, 298,98);
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
                scroll.setVisible(false);

                //JDBC
                scroll.setVisible(true);

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                    Statement stmt = con.createStatement();
                    String query = "SELECT * FROM `patient_information`";
                    ResultSet rs = stmt.executeQuery(query);

                    model.removeRow(0);

                    Object[] rows;

                    while (rs.next()) {
                        rows = new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11)};
                        model.addRow(rows);
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
        update_record.setBounds(976,101, 298,98);
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
                scroll.setVisible(false);

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

        frame.add(scroll);

        frame.add(insert_button);
        frame.add(reset_button);
        frame.add(panelB);
        frame.add(background);
    }
}
class UserPanel{
    public static void main(String[] args) {

        UserPanelinterface u=new UserPanelinterface();
    }
}
