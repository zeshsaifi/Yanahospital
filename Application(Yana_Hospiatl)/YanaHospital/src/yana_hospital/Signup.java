package yana_hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Signupinterface{
    public String key_value,username_value,password_value,conform_password_value,phone_number_value,k;
    Signupinterface(){
        JFrame frame=new JFrame("Yana Hospital");

        JLabel key=new JLabel(" Key     :");
        JLabel username=new JLabel(" User Name   :");
        JLabel password=new JLabel("  Password    :");
        JLabel conform_password=new JLabel("  Conform Password    :");
        JLabel phone_number=new JLabel("  Phone Number    :");

        JPasswordField field_key=new JPasswordField();
        JTextField field_username=new JTextField();
        JPasswordField field_password=new JPasswordField();
        JTextField field_conform_password=new JTextField();
        JTextField field_phone_number=new JTextField();

        JLabel background=new JLabel();

        ImageIcon main_logo=new ImageIcon("images/main_logo.png");
        ImageIcon exit_logo=new ImageIcon("images/exit_logo.png");
        ImageIcon back_logo=new ImageIcon("images/back_logo.png");
        ImageIcon signup_logo=new ImageIcon("images/signup_logo.png");
        ImageIcon password_logo=new ImageIcon("images/password_logo.png");
        ImageIcon signup_background=new ImageIcon("images/signup_background.png");
        ImageIcon key_logo=new ImageIcon("images/key_logo.png");
        ImageIcon phone_logo=new ImageIcon("images/phone_logo.png");
        ImageIcon conform_password_logo=new ImageIcon("images/conform_password_logo.png");

        JButton exit=new JButton("EXIT");
        JButton back_button=new JButton("BACK");
        JButton signup=new JButton("SIGNUP");

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

        background.setIcon(signup_background);
        background.setBounds(0,0,714,780);

        key.setBounds(850,50,100,20);
        key.setFont(new Font("ARIAL",Font.BOLD,12));
        key.setIcon(key_logo);
        field_key.setBounds(940,50,200,20);
        field_key.setFont(new Font("ARIAL",0,12));

        username.setBounds(850,100,400,50);
        username.setFont(new Font("ARIAL",Font.BOLD,24));
        username.setIcon(signup_logo);
        field_username.setBounds(850,150,400,50);
        field_username.setFont(new Font("ARIAL",0,36));

        password.setBounds(850,250,400,50);
        password.setFont(new Font("ARIAL",Font.BOLD,24));
        password.setIcon(password_logo);
        field_password.setBounds(850,300,400,50);
        field_password.setFont(new Font("ARIAL",0,36));

        conform_password.setBounds(850,400,400,50);
        conform_password.setFont(new Font("ARIAL",Font.BOLD,24));
        conform_password.setIcon(conform_password_logo);
        field_conform_password.setBounds(850,450,400,50);
        field_conform_password.setFont(new Font("ARIAL",0,36));

        phone_number.setBounds(850,550,400,50);
        phone_number.setFont(new Font("ARIAL",Font.BOLD,24));
        phone_number.setIcon(phone_logo);
        field_phone_number.setBounds(850,600,400,50);
        field_phone_number.setFont(new Font("ARIAL",0,36));

        signup.setBounds(850,700, 200,50);
        signup.setBorder(null);
        signup.setBackground(Color.WHITE);
        signup.setBackground(new Color(157,236,249,255));
        signup.setFont(new Font("ARIAL",Font.BOLD,24));
        signup.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                key_value=field_key.getText();
                username_value=field_username.getText();
                password_value=field_password.getText();
                conform_password_value=field_conform_password.getText();
                phone_number_value=field_phone_number.getText();

                if(key_value.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"Please enter Key");
                }
                else if (key_value.length()!=16)
                {
                    JOptionPane.showMessageDialog(frame,"key must be 16 digits");
                }
                else
                {
                    if(username_value.isEmpty())
                    {
                        JOptionPane.showMessageDialog(frame,"Please enter Username");
                    }
                    else if (username_value.length()<6)
                    {
                        JOptionPane.showMessageDialog(frame,"username must be 6 character");
                    }
                    else
                    {
                        if(password_value.isEmpty())
                        {
                            JOptionPane.showMessageDialog(frame,"Please enter Password");
                        }
                        else if (password_value.length()<8)
                        {
                            JOptionPane.showMessageDialog(frame,"Password must be 8 character");
                        }
                        else
                        {
                            if(conform_password_value.equals(password_value))
                            {
                                if(phone_number_value.isEmpty())
                                {
                                    JOptionPane.showMessageDialog(frame,"Please enter Phone Number");
                                }
                                else if (phone_number_value.length()!=10)
                                {
                                    JOptionPane.showMessageDialog(frame,"Phone number must be 10 digits");
                                }
                                else
                                {
                                    //JDBC
                                    try{
                                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yana_hospital", "zeeshan", "zeeshan1234");
                                        Statement stmt= con.createStatement();
                                        ResultSet rs = stmt.executeQuery("SELECT * FROM `users` WHERE `key_value`='"+key_value+"'");

                                        while (rs.next())
                                        {
                                            k=rs.getString(4);
                                        }
                                        if(k.equals(key_value))
                                        {
                                            String command="UPDATE `users` SET `username`='"+username_value+"',`password`='"+password_value+"',`phone`='"+phone_number_value+"' WHERE `key_value`='"+key_value+"'";
                                            stmt.executeUpdate(command);
                                            JOptionPane.showMessageDialog(frame,"Signup Successfully, Please do 'Login in'");
                                        }
                                        else
                                        {
                                            JOptionPane.showMessageDialog(frame,"Key in Invalid");
                                        }
                                    }
                                    catch (Exception ex)
                                    {
                                        JOptionPane.showMessageDialog(frame,"ERROR = "+ex);
                                    }
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(frame,"Password is not matching");
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
                signup.setBorder(BorderFactory.createMatteBorder(
                        2, 2, 2, 2, Color.GRAY));
                signup.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signup.setBorder(null);
                signup.setBackground(new Color(157,236,249,255));
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
        frame.add(signup);
        frame.add(exit);
        frame.add(key);
        frame.add(field_key);
        frame.add(username);
        frame.add(field_username);
        frame.add(password);
        frame.add(field_password);
        frame.add(conform_password);
        frame.add(field_conform_password);
        frame.add(phone_number);
        frame.add(field_phone_number);
        frame.add(background);
    }

}
class Signup{
    public static void main(String[] args) {

        Signupinterface s=new Signupinterface();
    }
}