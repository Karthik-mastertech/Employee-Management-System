package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.awt.event.ActionListener;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField teducation, tname, tfname, taddress, tphone, taadhar, temail, tsalary, tdesignation;

    JLabel tempid;

    JButton add, back;

    String number;


    UpdateEmployee(String number) {

        this.number = number;
        getContentPane().setBackground(new Color(0, 0, 255));

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        add(tname);

        //Father's Name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        JLabel tfname = new JLabel();
        tfname.setBounds(600, 150, 150, 30);
        add(tfname);

        //DOB
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tdob);

        //salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        add(tsalary);

        //Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        add(taddress);

        //Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        add(tphone);

        //email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        add(temail);

        //education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        add(teducation);

        //Aadhar
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(50, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        JLabel taadhar = new JLabel();
        taadhar.setBounds(200, 350, 150, 30);
        add(taadhar);

        //Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(400, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        try {
            conn c = new conn();
            String query = "select *from employee1 where empID='" + number + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                taadhar.setText(resultSet.getString("addhar"));
                tempid.setText(resultSet.getString("empID"));
                tdesignation.setText(resultSet.getString("designation"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        tdesignation = new JTextField();
        tdesignation.setBounds(600, 350, 150, 30);
        add(tdesignation);

        //empid
        JLabel empid = new JLabel("Employee Id");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel("" + number);
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        add = new JButton("UPDATE");
        add.setBounds(250, 550, 150, 40);
        add.setForeground(Color.BLUE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(450, 550, 150, 40);
        back.setForeground(Color.BLUE);
        back.addActionListener(this);
        add(back);

        //Frame
        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try {

                conn c = new conn();
                String query = "Update employee1 set salary='" + salary + "',address='" + address + "',phone='" + phone + "',email='" + email + "',education='" + education + "',designation='" + designation + "' where empID='" + number + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Main_class();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new View_Employee();
        }
    }

        public static void main(String[] args){
            new UpdateEmployee("");
        }
}