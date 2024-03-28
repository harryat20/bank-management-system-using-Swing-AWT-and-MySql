package banking;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    MiniStatement(String form, String pin)
    {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel bank = new JLabel("Harjinder Bank");
        bank.setBounds(140,20,150,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(30,80,400,20);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,300);
        add(mini);

        int bal = 0;


        try{
            Conn c = new Conn();
            ResultSet rSet = c.s.executeQuery("select * from bank where formNum = '" + form + "'" );
            while (rSet.next())
            {
                if(rSet.getString("type").equals("Deposit"))
                {
                    bal += Integer.parseInt(rSet.getString("amount"));
                }
                else if(rSet.getString("amount").contains(" "))
                {
                    continue;
                }
                else
                {
                    bal -= Integer.parseInt(rSet.getString("amount"));
                }
            }


        } catch(Exception e)
        {
            System.out.println(e);
        }


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where formno = '" + form + "'");
            while (rs.next())
            {
                card.setText("Card Number : " + rs.getString("cardNumber").substring(0,4) + "-XXXX-XXXX" + rs.getString("cardNumber").substring(12));
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs2 = c.s.executeQuery("SELECT * FROM bank WHERE formNum = '" + form + "' ORDER BY date DESC ");
            mini.setText("");
            while (rs2.next())
            {
                String date = rs2.getString("date");
                String amount = rs2.getString("amount");
                String type = rs2.getString("type");
                mini.setText(mini.getText() + "<html>" + date + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + amount + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + type + "<br><br><html>");
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }

        JLabel balance = new JLabel("Total Balance = " + bal);
        balance.setFont(new Font("Serif",Font.BOLD,18));
        balance.setBounds(20,480,300,30);
        add(balance);




        setSize(400,600);
        setLocation(100,100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

}
