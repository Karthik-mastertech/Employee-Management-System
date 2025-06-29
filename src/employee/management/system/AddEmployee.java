package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class AddEmployee extends JFrame implements ActionListener {
    Random ran=new Random();
    int number =ran.nextInt(999999);
    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox Boxeducation;
    JButton add,back;
    AddEmployee(){

        getContentPane().setBackground(new Color(0,0,255));

        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        //Name
        JLabel name=new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname=new JTextField();
        tname.setBounds(200,150,150,30);
        add(tname);

        //Father's Name
        JLabel fname=new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        add(tfname);

        //DOB
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD,20));
        add(dob);

        tdob=new JDateChooser();
        tdob.setBounds(200,200,150,30);
        add(tdob);

        //salary
        JLabel salary=new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary=new JTextField();
        tsalary.setBounds(600,200,150,30);
        add(tsalary);

        //Address
        JLabel address=new JLabel("Address");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress=new JTextField();
        taddress.setBounds(200,250,150,30);
        add(taddress);

        //Phone
        JLabel phone=new JLabel("Phone");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);

        //email
        JLabel email=new JLabel("Email");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail=new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);

        //education
        JLabel education=new JLabel("Highest Education");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        String items[]={"BBA","B.Tech","BCA","BA","BSC","B.COM","MBA","MCA","MA","MTech","MSC","PHD"};
        Boxeducation=new JComboBox(items);
        Boxeducation.setBounds(600,300,150,30);
        Boxeducation.setBackground(new Color(0,0,255));
        add(Boxeducation);

        //Aadhar
        JLabel aadhar=new JLabel("Aadhar");
        aadhar.setBounds(50,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);

        taadhar=new JTextField();
        taadhar.setBounds(200,350,150,30);
        add(taadhar);

        //Designation
        JLabel designation=new JLabel("Designation");
        designation.setBounds(400,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation=new JTextField();
        tdesignation.setBounds(600,350,150,30);
        add(tdesignation);

        //empid
        JLabel empid=new JLabel("Employee Id");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid=new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        add=new JButton("ADD");
        add.setBounds(250,550,150,40);
        add.setForeground(Color.BLUE);
        add.addActionListener( this);
        add(add);

        back=new JButton("BACK");
        back.setBounds(450,550,150,40);
        back.setForeground(Color.BLUE);
        back.addActionListener( this);
        add(back);

        //Frame
        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name=tname.getText();
            String fname=tfname.getText();
            String dob=((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=(String) Boxeducation.getSelectedItem();
            String aadhar=taadhar.getText();
            String designation=tdesignation.getText();
            String empID=tempid.getText();

            try{
                conn c=new conn();
                String query="insert into employee1 values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empID+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
                setVisible(false);
                new Main_class();
            }catch(Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
