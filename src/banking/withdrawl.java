package banking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class withdrawl extends JFrame implements ActionListener
{

    JTextField amt;
    JButton with,back;
    String form,pin;

    withdrawl(String formNum, String pin)
    {

        setLayout(null);

        form = formNum;
        this.pin = pin;

        JLabel text = new JLabel("Enter amount to be withdrawn : ");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(310,250,400,20);
        text.setForeground(Color.WHITE);
        add(text);

        amt = new JTextField();
        amt.setFont(new Font("Raleway",Font.BOLD,18));
        amt.setBounds(290,320,320,30);
        add(amt);

        with = new JButton("WITHDRAW");
        with.setBounds(310,390,120,35);
        with.addActionListener(this);
        add(with);

        back = new JButton("BACK");
        back.setBounds(465,390,120,35);
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
        setLocation(345,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        String amount = amt.getText();
        Date date = new Date();

        if(ae.getSource() == back)
        {
            setVisible(false);
            new Transaction(form,pin).setVisible(true);
        } else if (ae.getSource() == with) {
            if(amount.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter amount to be withdrawn.");
            }
            else {

                int balance = 0;
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bank where formNum = '" + form + "'");
                    while (rs.next())
                    {
                        if(rs.getString("type").equals("Deposit"))
                        {
                            balance += Integer.parseInt(rs.getString("amount"));
                        }
                        else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                } catch (Exception e)
                {
                    System.out.println(e);
                }

                if(balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                }
                else {

                    try{
                        Conn c = new Conn();
                        String querry = "insert into bank values('" + form + "', '" + pin + "', '" + date + "', 'Withdraw', '" + amount + "')";
                        c.s.executeUpdate(querry);
                        JOptionPane.showMessageDialog(null,"Rs " + amount + " successfully withdrawn." );
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
}
