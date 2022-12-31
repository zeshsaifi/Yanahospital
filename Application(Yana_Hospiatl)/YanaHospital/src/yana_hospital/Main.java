package yana_hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Maininterface{
    Maininterface(){
        JFrame frame=new JFrame("Yana Hospital");

        JLabel main_background=new JLabel();
        JLabel yana=new JLabel("YANA");

        ImageIcon background=new ImageIcon("images/background.png");
        ImageIcon main_logo=new ImageIcon("images/main_logo.png");
        ImageIcon signup_logo=new ImageIcon("images/signup_logo.png");
        ImageIcon login_logo=new ImageIcon("images/login_logo.png");
        ImageIcon exit_logo=new ImageIcon("images/exit_logo.png");
        JButton login=new JButton("LOGIN");
        JButton signup=new JButton("SIGNUP");
        JButton exit=new JButton("EXIT");

        yana.setFont(new Font("ARIAL",Font.BOLD,42));
        yana.setBounds(625,240,120,50);
        yana.setForeground(new Color(219,72,54,255));

        main_background.setIcon(background);
        main_background.setBounds(0,0,1365,720);
        main_background.setHorizontalAlignment(JLabel.CENTER);

        login.setBounds(10,20, 200,50);
        login.setIcon(login_logo);
        login.setBackground(Color.WHITE);
        login.setBorder(null);
        login.setFont(new Font("ARIAL",Font.BOLD,30));
        login.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login l=new Login();
                Logininterface l1=new Logininterface();
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
                login.setBorder(BorderFactory.createMatteBorder(
                        2, 2, 2, 2, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                login.setBorder(null);
            }
        });

        signup.setBounds(10,100, 200,50);
        signup.setIcon(signup_logo);
        signup.setBackground(Color.WHITE);
        signup.setBorder(null);
        signup.setFont(new Font("ARIAL",Font.BOLD,30));
        signup.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Signup s=new Signup();
                Signupinterface s1=new Signupinterface();
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
                signup.setBorder(BorderFactory.createMatteBorder(
                        2, 2, 2, 2, Color.GRAY));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signup.setBorder(null);
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

        frame.add(yana);
        frame.add(login);
        frame.add(signup);
        frame.add(exit);
        frame.add(main_background);

    }
}



class Main{
    public static void main(String[] args) {

        Maininterface m=new Maininterface();
    }
}