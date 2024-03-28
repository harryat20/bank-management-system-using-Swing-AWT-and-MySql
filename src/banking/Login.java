package banking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JButton login, clear, signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login()
    {

        setTitle("Harry bhai ka ATM");
        setLayout(null);

        //Welcome To text
        JLabel text1 = new JLabel("Welcome To");
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("Osward",Font.BOLD,30));
        text1.setBounds(200,40,400,100);
        add(text1);

        //Harjinder Banking System Text
        JLabel text2 = new JLabel("Harjinder Banking SYSTEM");
        text2.setForeground(Color.yellow);
        text2.setFont(new Font("Osward",Font.BOLD,31));
        text2.setBounds(200,75,490,100);
        add(text2);

        //Card Number Text
        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setForeground(Color.white);
        cardNo.setFont(new Font("Raleway",Font.BOLD,25));
        cardNo.setBounds(120,190,200,190);
        add(cardNo);

        //Card Text Field
        cardTextField = new JTextField();
        cardTextField.setBounds(340, 270,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(cardTextField);

        //Pin Text
        JLabel pin = new JLabel("PIN:");
        pin.setForeground(Color.white);
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(120,250,200,190);
        add(pin);

        //Pin Text Field
        pinTextField = new JPasswordField();
        pinTextField.setBounds(340, 330,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(pinTextField);


        //Login BUTTON
        login = new JButton("SIGN IN");
        login.setBounds(340,400,100,35);
//        login.setBackground(Color.WHITE);
//        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        //Clear BUTTON
        clear = new JButton("CLEAR");
        clear.setBounds(470,400,100,35);
//        clear.setBackground(Color.WHITE);
//        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);

        //Sign Up BUTTON
        signUp = new JButton("SIGN UP");
        signUp.setBounds(340,450,230,35);
//        signUp.setBackground(Color.WHITE);
//        signUp.setForeground(Color.BLACK);
        signUp.addActionListener(this);
        add(signUp);



        //BANK ICON
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image ic2 = ic1.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(ic2);
        JLabel label1 = new JLabel(ic3);
        label1.setBounds(30,10,140,140);
        add(label1);

        //BACKGROUND IMAGE
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image bI1 = backgroundImage.getImage().getScaledInstance(700,650, Image.SCALE_DEFAULT);
        backgroundImage = new ImageIcon(bI1);

        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0,0,700,650);
        add(backgroundLabel);

        //JFRAME
        setSize(700,650);
        setVisible(true);
        setLocation(450,130);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login)
        {

            String cardNum = cardTextField.getText();
            String pinNum = pinTextField.getText();



            try {
                Conn c = new Conn();
                String querry = "select * from login where cardNumber = '" + cardNum + "' and pin = '" + pinNum + "'";
                ResultSet result = c.s.executeQuery(querry);
                if (result.next())
                {
                    String formNum = result.getString("formno");
                    String pin = pinNum;

                    setVisible(false);
                    new Transaction(formNum,pinNum).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            } catch (Exception e){
                System.out.println(e);
            }


        }
        else if(ae.getSource() == signUp)
        {
            setVisible(false);
            new SignUpPage1().setVisible(true);

        }

    }

}
