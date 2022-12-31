package yana_hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Admininterface{

    public String username_value,password_value,key_value,p,k;
    Admininterface(){
        JFrame frame=new JFrame("Yana Hospital");

        JLabel username=new JLabel(" User Name   :");
        JLabel password=new JLabel("  Password    :");
        JLabel key=new JLabel("Key  :");

        JTextField field_username=new JTextField();
        JPasswordField field_password=new JPasswordField();
        JPasswordField field_key=new JPasswordField();
        JLabel background=new JLabel();

        ImageIcon main_logo=new ImageIcon("images/main_logo.png");
        ImageIcon exit_logo=new ImageIcon("images/exit_logo.png");
        ImageIcon back_logo=new ImageIcon("images/back_logo.png");
        ImageIcon admin_logo=new ImageIcon("images/admin_logo.png");
        ImageIcon password_logo=new ImageIcon("images/password_logo.png");
        ImageIcon admin_background=new ImageIcon("images/admin_background.png");
        ImageIcon key_logo=new ImageIcon("images/key_logo.png");

        JButton exit=new JButton("EXIT");
        JButton back_button=new JButton("BACK");
        JButton login=new JButton("LOGIN");

        back_button.setIcon(back_logo);
        back_button.setBounds(10,10,125,50);
        back_button.setBorder(null);
        back_button.setBackground(null);
        back_button.setFont(new Font("ARIAL",Font.BOLD,16));
        back_button.addMouseListener(new MouseListener() {
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
                back_button.setBorder(BorderFactory.createMatteBorder(
                        2, 2, 2, 2, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back_button.setBorder(null);
            }
        });

        background.setIcon(admin_background);
        background.setBounds(0,0,714,780);

        username.setBounds(850,100,400,50);
        username.setFont(new Font("ARIAL",Font.BOLD,24));
        username.setIcon(admin_logo);
        field_username.setBounds(850,150,400,50);
        field_username.setFont(new Font("ARIAL",0,36));

        password.setBounds(850,250,400,50);
        password.setFont(new Font("ARIAL",Font.BOLD,24));
        password.setIcon(password_logo);
        field_password.setBounds(850,300,400,50);
        field_password.setFont(new Font("ARIAL",0,36));

        key.setBounds(850,400,400,50);
        key.setFont(new Font("ARIAL",Font.BOLD,24));
        key.setIcon(key_logo);
        field_key.setBounds(850,450,400,50);
        field_key.setFont(new Font("ARIAL",0,36));

        login.setBounds(850,550, 200,50);
        login.setBorder(null);
        login.setBackground(Color.WHITE);
        login.setBackground(new Color(157,236,249,255));
        login.setFont(new Font("ARIAL",Font.BOLD,24));
        login.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    username_value = field_username.getText();
                    password_value = field_password.getText();
                    key_value = field_key.getText();

                    if (username_value.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please enter Username");
                    } else if (username_value.length() < 6) {
                        JOptionPane.showMessageDialog(frame, "Username must be 6 character");
                    } else {
                        if (password_value.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please enter Password(Minimum length 8 digits)");
                        } else if (password_value.length() < 8) {
                            JOptionPane.showMessageDialog(frame, "Password must be 6 character");
                        } else {
                            if (key_value.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "Please enter Key(16 digit)");
                            }
                            else if (key_value.length() != 16) {
                                JOptionPane.showMessageDialog(frame, "key must be 16 digits");
                            }
                            else
                            {
                                DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                                LocalDateTime dt=LocalDateTime.now();
                                //JDBC
                                try{
                                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                                    Statement stmt= con.createStatement();
                                    String command="INSERT INTO `history`(`username`, `time`) VALUES ('"+username_value+"','"+fmt.format(dt)+"')";
                                    stmt.executeUpdate(command);
                                    ResultSet rs = stmt.executeQuery("SELECT * FROM `users` WHERE `username`='"+username_value+"'");


                                    while (rs.next())
                                    {
                                        p=rs.getString(2);
                                        k=rs.getString(4);
                                    }

                                    if(password_value.equals(p) && key_value.equals(k))
                                    {
                                        JOptionPane.showMessageDialog(frame,"Login successful");
                                        Adminpanel a=new Adminpanel();
                                        Adminpanelinterface a1=new Adminpanelinterface();
                                        frame.dispose();
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,"Incorrect Username, Password or Key");
                                    }

                                }
                                catch (Exception ex)
                                {
                                    JOptionPane.showMessageDialog(frame,"ERROR = "+ex);
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
                login.setBorder(BorderFactory.createMatteBorder(
                        2, 2, 2, 2, Color.GRAY));
                login.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                login.setBorder(null);
                login.setBackground(new Color(157,236,249,255));

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

        frame.add(back_button);
        frame.add(login);
        frame.add(exit);
        frame.add(username);
        frame.add(field_username);
        frame.add(password);
        frame.add(field_password);
        frame.add(key);
        frame.add(field_key);
        frame.add(background);

    }
}
class Admin{
    public static void main(String[] args) {

        Admininterface a=new Admininterface();
    }
}
