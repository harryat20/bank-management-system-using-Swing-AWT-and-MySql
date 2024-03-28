package banking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.*;

public class SignUpPage1 extends JFrame implements ActionListener
{
    int randNum;
    JTextField nameTF,fNameTF,mailTF,addrTF,cityTF,stateTF,pinTF;
    JDateChooser date;
    JRadioButton gender_m,gender_f,married,unmarried,other;


    SignUpPage1()
    {

        Random ran = new Random();
        randNum = 1000 + ran.nextInt(9000);

        //Form Number
        JLabel formNo = new JLabel("Form Number : " + randNum);
        formNo.setFont(new Font("Raleway",Font.BOLD,35));
        formNo.setBounds(224,30,403,40);
        add(formNo);

        //Page 1
        JLabel page1 = new JLabel("Page 1: Personal Details");
        page1.setFont(new Font("Raleway", Font.BOLD,18));
        page1.setBounds(300,90,250,20);
        add(page1);


        //----------------------------------------------------------------------------


        //Name Text
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        //Name Text Field
        nameTF = new JTextField();
        nameTF.setFont(new Font("Serif",Font.BOLD,16));
        nameTF.setBounds(350,140,450,30);
        add(nameTF);

        //Fathers Name Text
        JLabel fName = new JLabel("Father's Name : ");
        fName.setFont(new Font("Raleway",Font.BOLD,20));
        fName.setBounds(100,190,200,30);
        add(fName);

        //FName Text Field
        fNameTF = new JTextField();
        fNameTF.setFont(new Font("Serif",Font.BOLD,16));
        fNameTF.setBounds(350,190,450,30);
        add(fNameTF);

        //DOB
        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        //Date Chooser
        date = new JDateChooser();
        date.setBounds(350,240,450,30);
        add(date);


        //Gender
        JLabel gen = new JLabel("Gender : ");
        gen.setFont(new Font("Raleway",Font.BOLD,20));
        gen.setBounds(100,290,200,30);
        add(gen);

        //Radio Button
        gender_m = new JRadioButton("Male");
        gender_m.setBounds(350,290,110,30);
        gender_m.setBackground(Color.WHITE);

        gender_f = new JRadioButton("Female");
        gender_f.setBounds(520,290,110,30);
        gender_f.setBackground(Color.WHITE);

        ButtonGroup gender = new ButtonGroup();
        gender.add(gender_f);
        gender.add(gender_m);

        add(gender_m);
        add(gender_f);


        //E-Mail
        JLabel mail = new JLabel("Email : ");
        mail.setFont(new Font("Raleway",Font.BOLD,20));
        mail.setBounds(100,340,200,30);
        add(mail);

        //mail Text Field
        mailTF = new JTextField();
        mailTF.setFont(new Font("Serif",Font.BOLD,16));
        mailTF.setBounds(350,340,450,30);
        add(mailTF);

        //Marital Status
        JLabel mar = new JLabel("Marital Status : ");
        mar.setFont(new Font("Raleway",Font.BOLD,20));
        mar.setBounds(100,390,200,30);
        add(mar);

        //Radio
        married = new JRadioButton("Married");
        married.setBounds(350,390,110,30);
        married.setBackground(Color.WHITE);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(520,390,110,30);
        unmarried.setBackground(Color.WHITE);

        other = new JRadioButton("Other");
        other.setBounds(690,390,110,30);
        other.setBackground(Color.WHITE);

        ButtonGroup marital = new ButtonGroup();
        marital.add(married);
        marital.add(unmarried);
        marital.add(other);

        add(married);
        add(unmarried);
        add(other);

        //Address
        JLabel addr = new JLabel("Address : ");
        addr.setFont(new Font("Raleway",Font.BOLD,20));
        addr.setBounds(100,440,200,30);
        add(addr);

        //address Text Field
        addrTF = new JTextField();
        addrTF.setFont(new Font("Serif",Font.BOLD,16));
        addrTF.setBounds(350,440,450,30);
        add(addrTF);

        //City
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        //City Text Field
        cityTF = new JTextField();
        cityTF.setFont(new Font("Serif",Font.BOLD,16));
        cityTF.setBounds(350,490,450,30);
        add(cityTF);

        //State
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        //State Text Field
        stateTF = new JTextField();
        stateTF.setFont(new Font("Serif",Font.BOLD,16));
        stateTF.setBounds(350,540,450,30);
        add(stateTF);

        //Pin Code
        JLabel pin = new JLabel("Pin Code : ");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,590,200,30);
        add(pin);

        //State Text Field
        pinTF = new JTextField();
        pinTF.setFont(new Font("Serif",Font.BOLD,16));
        pinTF.setBounds(350,590,450,30);
        add(pinTF);


        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(720,660,80,30);
        next.addActionListener(this);

        add(next);


        setTitle("SIGN UP Page : 1");
        setLayout(null);

        //Background Image
        ImageIcon backImg = new ImageIcon("/home/harry/IdeaProjects/Bank_Management_System/src/main/resources/icons/a.jpeg");
        Image b2 = backImg.getImage().getScaledInstance(850,870,Image.SCALE_DEFAULT);
        backImg = new ImageIcon(b2);

        JLabel backLbl = new JLabel(backImg);
        backLbl.setBounds(0,0,850,870);
        add(backLbl);

        setSize(850,870);
        setVisible(true);
        setLocation(350,10);


    }

    public void actionPerformed(ActionEvent ae)
    {
        String formNo = "" + randNum;
        String name = nameTF.getText();
        String f_name = fNameTF.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender = "";
        if(gender_m.isSelected())
        {
            gender = "Male";
        } else if (gender_f.isSelected())
        {
            gender = "Female";
        }
        String email = mailTF.getText();
        String marital = "";
        if(married.isSelected())
        {
            marital = "Married";
        }
        else if(unmarried.isSelected())
        {
            marital = "Unmarried";
        }
        else if(other.isSelected())
        {
            marital = "Other";
        }
        String address = addrTF.getText();
        String city = cityTF.getText();
        String state = stateTF.getText();
        String pincode = pinTF.getText();

        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Name is required");
            } else if (f_name.equals("")) {
                JOptionPane.showMessageDialog(null,"Father's Name is required");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null,"Date Of Birth is required");
            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null,"Gender is required");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null,"Email is required");
            } else if (marital.equals("")) {
                JOptionPane.showMessageDialog(null,"Marital Status is required");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null,"Address is required");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null,"City is required");
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null,"State is required");
            } else if (pincode.equals("")) {
                JOptionPane.showMessageDialog(null,"Pin Code is required");
            }

            else
            {
                Conn c = new Conn();
                String querry = "insert into signup values ('" + formNo + "', '" + name + "', '" + f_name + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pincode + "')";
                c.s.executeUpdate(querry);
                setVisible(false);
                new SignUpPage2(formNo).setVisible(true);
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

}
