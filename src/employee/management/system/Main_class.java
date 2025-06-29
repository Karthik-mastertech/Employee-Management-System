package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home5.png"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);

        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(340,40,500,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(heading);

        JButton add=new JButton("Add Employee");
        add.setBounds(325,220,150,40);
        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view=new JButton("View Employee");
        view.setBounds(620,220,150,40);
        view.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton rmv=new JButton("Remove Employee");
        rmv.setBounds(470,320,150,40);
        rmv.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                   new RemoveEmployee();
            }
        });
        img.add(rmv);

        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new Main_class();
    }
}
