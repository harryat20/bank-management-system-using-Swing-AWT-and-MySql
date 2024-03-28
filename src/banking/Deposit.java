package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener
{

    JTextField amt;
    JButton deposit,back;
    String form,pin;

    Deposit(String formNum, String pin)
    {
        setLayout(null);

        form = formNum;
        this.pin = pin;

        JLabel text = new JLabel("Enter amount to be deposited : ");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(310,250,400,20);
        text.setForeground(Color.WHITE);
        add(text);

        amt = new JTextField();
        amt.setFont(new Font("Raleway",Font.BOLD,18));
        amt.setBounds(290,320,320,30);
        add(amt);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(330,390,100,35);
        deposit.addActionListener(this);
        add(deposit);

        back = new JButton("BACK");
        back.setBounds(470,390,100,35);
        back.addActionListener(this);
        add(back);

        ImageIcon sc1 = new ImageIcon(ClassLoader.getSystemResource("icons/black1.png"));
        Image sc2 = sc1.getImage().getScaledInstance(507,350,Image.SCALE_DEFAULT);
        sc1 = new ImageIcon(sc2);
        JLabel screen = new JLabel(sc1);
        screen.setBounds(197,165,507,352);
        add(screen);

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/aatm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel background = new JLabel(i3);
        background.setBounds(0,0,900,900);
        add(background);


        setSize(900,900);
        setLocation(350,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Transaction(form,pin).setVisible(true);
        }
        else if (ae.getSource() == deposit)
        {
            String num = amt.getText();
            Date date = new Date();
            if(num.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter some amount to Deposit");
            }
            else if (num.contains(" ") || num.matches(".*[a-zA-Z].*")) {
                JOptionPane.showMessageDialog(null, "Remove spaces or alphabetic characters from amount");
            }

            else {
                try{
                    Conn c = new Conn();
                    String querry = "insert into bank values('" + form + "', '" + pin + "', '" + date + "', 'Deposit', '" + num + "')";
                    c.s.executeUpdate(querry);
                    JOptionPane.showMessageDialog(null,"Rs " + num + " has been successfully deposited.");
                    setVisible(false);
                    new Transaction(form,pin).setVisible(true);
                } catch(Exception e)
                {
                    System.out.println(e);
                }
            }

        }
    }
}
