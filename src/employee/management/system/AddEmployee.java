package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener{

    JTextField tname,tphone,taadhar,temail,tsalary;
    JDateChooser tdob,tjoining;
    JComboBox<String> tdesignation;
    JButton add,back;
    JLabel tempid;
    Random ran =new Random();
    int number= ran.nextInt(999999);

    AddEmployee(){

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

        tname = new JTextField();
        tname.setBounds(320,250,200,40);
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

        tdob = new JDateChooser();
        tdob.setBounds(320,550,200,40);
        img.add(tdob);

        JLabel aadhar= new JLabel("Aadhaar ");
        aadhar.setBounds(600,250,200,40);
        aadhar.setForeground(Color.white);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(aadhar);

        taadhar = new JTextField();
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

        String items[]={"Software Developer I","Technical Consultant I","Product Engineer II","Data Analyst II","Functional Consultant III","Technical Lead","Product Head","Team Lead"};
        tdesignation = new JComboBox(items);
        tdesignation.setBounds(720,450,200,40);
        img.add(tdesignation);

        JLabel joining= new JLabel("Joining Date");
        joining.setBounds(600,550,200,40);
        joining.setForeground(Color.white);
        joining.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(joining);

        tjoining = new JDateChooser();
        tjoining.setBounds(720,550,200,40);
        img.add(tjoining);

        add=new JButton("Add");
        add.setBounds(400,650,200,40);
        add.setBackground(Color.white);
        add.setBorder(new LineBorder(Color.BLACK));
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        img.add(add);

        back=new JButton("Return");
        back.setBounds(650,650,200,40);
        back.setBackground(Color.lightGray);
        back.setBorder(new LineBorder(Color.BLACK));
        back.setForeground(Color.black);
        back.addActionListener(this);
        img.add(back);

        JLabel empid= new JLabel("Employee ID :");
        empid.setBounds(300,200,150,40);
        empid.setForeground(Color.white);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(empid);

        tempid= new JLabel(""+number);
        tempid.setBounds(450,200,150,40);
        tempid.setForeground(Color.white);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(tempid);



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
        if(e.getSource()==add){
            String empid=tempid.getText();
            String name=tname.getText();
            String phone=tphone.getText();
            String aadhaar= taadhar.getText();
            String email= temail.getText();
            String dob = ((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String salary= tsalary.getText();
            String doj = ((JTextField)tjoining.getDateEditor().getUiComponent()).getText();
            String designation= (String) tdesignation.getSelectedItem();

            try{
                DBConnection conn = new DBConnection();
                String query="INSERT into employee VALUES('"+empid+"','"+name+"','"+dob+"','"+phone+"','"+email+"','"+aadhaar+"','"+designation+"','"+salary+"','"+doj+"')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data added successfully");
                setVisible(false);
                new Home();
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            new Home();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
