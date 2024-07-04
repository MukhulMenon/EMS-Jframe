package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tdesignation,tphone,taadhar,temail,tsalary;
    JButton update,back;
    JLabel tempid;
    String number;

    UpdateEmployee(String number ){
        this.number=number;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2= i1.getImage().getScaledInstance(1280,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img =  new JLabel(i3);
        img.setBounds(0,0,1280,900);
        add(img);

        JLabel name= new JLabel("Name ");
        name.setBounds(250,250,200,40);
        name.setForeground(Color.white);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(name);

        JLabel tname = new JLabel();
        tname.setBounds(320,250,200,40);
        tname.setForeground(Color.white);
        tname.setFont(new Font("Tahoma",Font.BOLD,20));
        img.add(tname);

        JLabel phone= new JLabel("Phone ");
        phone.setBounds(250,350,200,40);
        phone.setForeground(Color.white);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(phone);

        tphone = new JTextField();
        tphone.setBounds(320,350,200,40);
        img.add(tphone);

        JLabel email= new JLabel("E-mail ");
        email.setBounds(250,450,200,40);
        email.setForeground(Color.white);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(email);

        temail = new JTextField();
        temail.setBounds(320,450,200,40);
        img.add(temail);

        JLabel dob= new JLabel("DOB");
        dob.setBounds(250,550,200,40);
        dob.setForeground(Color.white);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(320,550,200,40);
        tdob.setForeground(Color.white);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
        img.add(tdob);

        JLabel aadhar= new JLabel("Aadhaar ");
        aadhar.setBounds(600,250,200,40);
        aadhar.setForeground(Color.white);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setForeground(Color.white);
        taadhar.setFont(new Font("Tahoma",Font.BOLD,20));
        taadhar.setBounds(690,250,200,40);
        img.add(taadhar);

        JLabel salary= new JLabel("Salary ");
        salary.setBounds( 600,350,200,40);
        salary.setForeground(Color.white);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(680,350,200,40);
        img.add(tsalary);

        JLabel designation= new JLabel("Designation ");
        designation.setBounds(600,450,200,40);
        designation.setForeground(Color.white);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(designation);

        JLabel tdesignation = new JLabel();
        tdesignation.setForeground(Color.white);
        tdesignation.setFont(new Font("Tahoma",Font.BOLD,20));
        tdesignation.setBounds(730,450,250,40);
        img.add(tdesignation);

        JLabel joining= new JLabel("Joining Date");
        joining.setBounds(600,550,200,40);
        joining.setForeground(Color.white);
        joining.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(joining);

        JLabel tjoining = new JLabel();
        tjoining.setBounds(730,550,200,40);
        tjoining.setForeground(Color.white);
        tjoining.setFont(new Font("Tahoma",Font.BOLD,20));
        img.add(tjoining);

        JLabel empid= new JLabel("Employee ID :");
        empid.setBounds(300,200,150,40);
        empid.setForeground(Color.white);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(empid);

        tempid= new JLabel();
        tempid.setBounds(450,200,150,40);
        tempid.setForeground(Color.white);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(tempid);

        try {
            DBConnection conn = new DBConnection();
            String query = "select * from employee where empid='"+number+"'";
            ResultSet rs =conn.statement.executeQuery(query);
            while (rs.next()){
                tname.setText(rs.getString("name"));
                taadhar.setText(rs.getString("aadhar"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                tdob.setText(rs.getString("dob"));
                tsalary.setText(rs.getString("salary"));
                tdesignation.setText(rs.getString("designation"));
                tjoining.setText(rs.getString("joiningDate"));
                tempid.setText(rs.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        update=new JButton("Update");
        update.setBounds(400,650,200,40);
        update.setBackground(Color.white);
        update.setBorder(new LineBorder(Color.BLACK));
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        img.add(update);

        back=new JButton("Return");
        back.setBounds(650,650,200,40);
        back.setBackground(Color.lightGray);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setForeground(Color.black);
        back.addActionListener(this);
        img.add(back);

        setSize(1280,900);
        setVisible(true);
        setLayout(null);
        setLocation(300,120);


        JLabel header = new JLabel("Employee Details");
        header.setBounds(550,80,500,50);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("serif",Font.BOLD,25));
        img.add(header);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==update){
            String phone= tphone.getText();
            String email = temail.getText();
            String salary =tsalary.getText();
            try{
                DBConnection conn= new DBConnection();
                String query = "update employee set phone='"+phone+"',email='"+email+"',salary='"+salary+"' where empid='"+number+"'";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated Successfully");
                setVisible(false);
                new Home();

            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new ViewEmployee();
        }

    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
