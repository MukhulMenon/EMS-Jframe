package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    Choice emp;
    JButton search,print,update,back;
    JTable dataTable;
    ViewEmployee(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2= i1.getImage().getScaledInstance(1280,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img =  new JLabel(i3);
        img.setBounds(0,0,1280,900);
        add(img);

        JLabel header = new JLabel("Search by Employee ID");
        header.setBounds(500,100,500,50);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("serif",Font.BOLD,25));
        img.add(header);

        JLabel empId = new JLabel("Emplyee ID :");
        empId.setBounds(200,170,150,30);
        empId.setForeground(Color.WHITE);
        empId.setFont(new Font("serif",Font.BOLD,25));
        img.add(empId);

        emp= new Choice();
        emp.setBounds(350,170,200,30);
        emp.setForeground(Color.BLACK);
        emp.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        img.add(emp);
        try{
            DBConnection conn = new DBConnection();
            ResultSet rs= conn.statement.executeQuery("select * from employee;");
            while(rs.next()){
                emp.add(rs.getString("empid"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        dataTable = new JTable();
        try{
            DBConnection conn= new DBConnection();
            ResultSet rs= conn.statement.executeQuery("select * from employee");
            dataTable.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(dataTable);
        jp.setBounds(167,300,947,498);
        img.add(jp);

        search=new JButton("Search");
        search.setBounds(560,250,150,30);
        search.addActionListener(this);
        img.add(search);

        print=new JButton("Print");
        print.setBounds(760,250,150,30);
        print.addActionListener(this);
        img.add(print);

        update=new JButton("Update");
        update.setBounds(960,250,150,30);
        update.addActionListener(this);
        img.add(update);

        back=new JButton("Back");
        back.setBounds(950,120,150,30);
        back.addActionListener(this);
        img.add(back);

        setSize(1280,900);
        setLocation(300,120);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

          if(e.getSource()== search) {
              String query = "select * from employee where empid ='" + emp.getSelectedItem() + "'";
              try{
                  DBConnection conn = new DBConnection();
                  ResultSet rs= conn.statement.executeQuery(query);
                  dataTable.setModel(DbUtils.resultSetToTableModel(rs));

              }catch (Exception E){
                  E.printStackTrace();
              }
          } else if (e.getSource()==print) {
                  String query = "select * from employee where empid ='" + emp.getSelectedItem() + "'";
                  try{
                      dataTable.print();

                  }catch (Exception E){
                      E.printStackTrace();
                  }
          } else if (e.getSource()==update) {
              setVisible(false);
              new UpdateEmployee(emp.getSelectedItem());

          } else{
              setVisible(false);
              new Home();
          }


    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
