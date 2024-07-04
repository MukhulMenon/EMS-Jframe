package employee.management.system;


import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

        Splash(){
            // Creating splash image //
            ImageIcon i1=  new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
            Image i2=i1.getImage().getScaledInstance(1280,800, Image.SCALE_DEFAULT);
            ImageIcon i3= new ImageIcon(i2);
            JLabel image= new JLabel(i3);
            image.setBounds(-10,-10,1280,800);
            add(image);

            // Creating splash frame //
            setSize(1280,800);
            setLayout(null);
            setVisible(true);
            setLocation(320,160);
            try{
                Thread.sleep(5000);
                setVisible(false);
                new Login();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    public static void main(String[] args) {
        new Splash();
    }
}
