package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    JButton delete,back;
    Choice id;
    RemoveEmployee(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img =  new JLabel(i3);
        img.setBounds(0,0,900,600);
        add(img);

        JLabel header = new JLabel("Remove Employee");
        header.setBounds(335,60,200,40);
        header.setForeground(Color.white);
        header.setFont(new Font("serif",Font.BOLD,25));
        img.add(header);

        JLabel empid = new JLabel("Employee ID : ");
        empid.setBounds(150,150,150,30);
        empid.setForeground(Color.white);
        empid.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(empid);

        id = new Choice();
        id.setBounds(300,155,150,30);
        img.add(id);

        try{
            DBConnection conn= new DBConnection();
            ResultSet rs =conn.statement.executeQuery("select * from employee");
            while(rs.next()){
                id.add(rs.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel name = new JLabel("Name : ");
        name.setBounds(150,200,150,30);
        name.setForeground(Color.white);
        name.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(name);

        JLabel tname = new JLabel();
        tname.setBounds(300,200,150,30);
        tname.setForeground(Color.white);
        tname.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(tname);

        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(150,250,150,30);
        phone.setForeground(Color.white);
        phone.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(phone);

        JLabel tphone = new JLabel();
        tphone.setBounds(300,250,150,30);
        tphone.setForeground(Color.white);
        tphone.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(tphone);

        JLabel email = new JLabel("Email : ");
        email.setBounds(150,300,150,30);
        email.setForeground(Color.white);
        email.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(email);

        JLabel temail = new JLabel();
        temail.setBounds(300,300,300,30);
        temail.setForeground(Color.white);
        temail.setFont(new Font("Tahoma",Font.BOLD,15));
        img.add(temail);

        try{
            DBConnection conn = new DBConnection();
            ResultSet rs= conn.statement.executeQuery("select * from employee where empid='"+id.getSelectedItem()+"'");
            while (rs.next()){
                tname.setText(rs.getString("name"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        id.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    DBConnection conn = new DBConnection();
                    ResultSet rs= conn.statement.executeQuery("select * from employee where empid='"+id.getSelectedItem()+"'");
                    while (rs.next()){
                        tname.setText(rs.getString("name"));
                        tphone.setText(rs.getString("phone"));
                        temail.setText(rs.getString("email"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(250,400,150,30);
        delete.setBackground(Color.GRAY);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        img.add(delete);

        back = new JButton("Return");
        back.setBounds(450,400,150,30);
        back.setBackground(Color.lightGray);
        back.setForeground(Color.black);
        back.addActionListener(this);
        img.add(back);


        setSize(900,600);
        setLocation(500,190);
        setVisible(true);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==delete){
            try{
                DBConnection conn =  new DBConnection();
                String query = "Delete from employee where empid ='"+id.getSelectedItem()+"'";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee deleted!");
                setVisible(false);
                new Home();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
