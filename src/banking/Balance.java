package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Balance extends JFrame implements ActionListener {

    String form,pin;
    JButton back;
    Balance(String form, String pin)
    {
        setLayout(null);

        this.form = form;
        this.pin = pin;

        JLabel text = new JLabel("Account Summary");
        text.setFont(new Font("Serif",Font.BOLD,16));
        text.setBounds(370,220,400,20);
        text.setForeground(Color.WHITE);
        add(text);

        JLabel acc = new JLabel("Account Number : ");
        acc.setFont(new Font("System",Font.BOLD,16));
        acc.setBounds(240,280,200,20);
        acc.setForeground(Color.WHITE);
        add(acc);

        JLabel bal = new JLabel("Available Balance : ");
        bal.setFont(new Font("System",Font.BOLD,16));
        bal.setBounds(240,330,200,20);
        bal.setForeground(Color.WHITE);
        add(bal);


        String cardNum = null;
        int balance = 0;

        try{
            Conn c = new Conn();
            ResultSet rSet = c.s.executeQuery("select * from bank where formNum = '" + form + "'" );
            while (rSet.next())
            {
                if(rSet.getString("type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rSet.getString("amount"));
                }
                else if(rSet.getString("amount").contains(" "))
                {
                    continue;
                }
                else
                {
                    balance -= Integer.parseInt(rSet.getString("amount"));
                }
            }

            ResultSet rSet2 = c.s.executeQuery("select * from login where formno = " + form);
            rSet2.next();
            cardNum = rSet2.getString("cardNumber");


        } catch(Exception e)
        {
            System.out.println(e);
        }
        

        JLabel accNo = new JLabel(cardNum);
        accNo.setFont(new Font("System",Font.BOLD,16));
        accNo.setBounds(440,280,400,20);
        accNo.setForeground(Color.WHITE);
        add(accNo);

        JLabel balVal = new JLabel(String.valueOf(balance));
        balVal.setFont(new Font("System",Font.BOLD,16));
        balVal.setBounds(440,330,400,20);
        balVal.setForeground(Color.WHITE);
        add(balVal);

        back = new JButton("BACK");
        back.setBounds(580,430,80,30);
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
    }

}
