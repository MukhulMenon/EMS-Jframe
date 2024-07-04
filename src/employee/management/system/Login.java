package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
   JTextField tusername ;
   JPasswordField tpassword;
   JButton login,back;

    Login(){

        JLabel username = new JLabel("Username : ");
        username.setBounds(300,200,200,30);
        username.setForeground(Color.white);
        add(username);

        tusername= new JTextField();
        tusername.setBounds(375,200,200,30);
        add(tusername);

        JLabel password = new JLabel("Password : ");
        password.setBounds(300,275,200,30);
        password.setForeground(Color.white);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(375,275,200,30);
        add(tpassword);

        login=new JButton("Login");
        login.setBounds(250,350,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back=new JButton("Return");
        back.setBackground(Color.darkGray);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(450,350,150,30);
        add(back);

        ImageIcon logI = new ImageIcon(ClassLoader.getSystemResource("icons/lock.png"));
        Image logI2= logI.getImage().getScaledInstance(100,120,Image.SCALE_DEFAULT);
        ImageIcon logI3 = new ImageIcon(logI2);
        JLabel imgI =  new JLabel(logI3);
        imgI.setBounds(640,60,100,120);
        add(imgI);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img =  new JLabel(i3);
        img.setBounds(0,0,900,600);
        add(img);

        setSize(900,600);
        setLocation(500,190);
        setVisible(true);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login ){
            try{
                String username=tusername.getText();
                String password=tpassword.getText();

                DBConnection conn = new DBConnection();
                String query ="select * from login where username ='"+username+"' and password ='"+password+"'";
                ResultSet rs= conn.statement.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Home();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==back){
           System.exit(90);

        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
