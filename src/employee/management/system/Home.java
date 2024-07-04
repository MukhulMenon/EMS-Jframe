package employee.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    Home(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1280,900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1280,900);
        add(img);

        JLabel header = new JLabel("Employee Management System");
        header.setBounds(150,100,450,40);
        header.setFont(new Font("Times",Font.BOLD,27));
        img.add(header);

        JButton add= new JButton("Add Employee");
        add.setBounds(150,200,150,40);
        add.setForeground(Color.BLACK);
        add.setBackground(Color.WHITE);
        add.setBorder(new LineBorder(Color.BLACK));
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view= new JButton("View Employee");
        view.setBounds(400,200,150,40);
        view.setForeground(Color.BLACK);
        view.setBackground(Color.LIGHT_GRAY);
        view.setBorder(new LineBorder(Color.BLACK));
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewEmployee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton remove= new JButton("Remove Employee");
        remove.setBounds(280,300,150,40);
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.DARK_GRAY);
        remove.setBorder(new LineBorder(Color.BLACK));
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new RemoveEmployee();
            setVisible(false);
            }
        });
        img.add(remove);

        JButton exit= new JButton("Exit");
        exit.setBounds(600,600,150,40);
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.WHITE);
        exit.setBorder(new LineBorder(Color.BLACK));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        img.add(exit);

        setSize(1280,900);
        setVisible(true);
        setLayout(null);
        setLocation(300,120);

    }
    public static void main(String[] args) {
    new Home();
    }
}
