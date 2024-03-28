package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener
{
    String form,pin;
    JButton change,back;
    JTextField newPin,rePin;

    PinChange(String form, String pin)
    {
        this.form = form;
        this.pin = pin;
        setLayout(null);


        JLabel text = new JLabel("CHANGE YOUR ACCOUNT PIN");
        text.setFont(new Font("System",Font.BOLD,18));
        text.setBounds(300,190,400,20);
        text.setForeground(Color.WHITE);
        add(text);

        JLabel enter = new JLabel("New Pin :");
        enter.setFont(new Font("System",Font.BOLD,16));
        enter.setBounds(215,250,100,30);
        enter.setForeground(Color.white);
        add(enter);

        JLabel reEnter = new JLabel("Re-Enter New Pin :");
        reEnter.setFont(new Font("System",Font.BOLD,15));
        reEnter.setBounds(215,305,200,30);
        reEnter.setForeground(Color.white);
        add(reEnter);

        newPin = new JTextField();
        newPin.setFont(new Font("Raleway",Font.BOLD,18));
        newPin.setBounds(385,250,290,30);
        add(newPin);

        rePin = new JTextField();
        rePin.setFont(new Font("Raleway",Font.BOLD,18));
        rePin.setBounds(385,305,290,30);
        add(rePin);

        change = new JButton("CHANGE");
        change.setBounds(475,380,200,40);
        change.addActionListener(this);
        add(change);

        back = new JButton("BACK");
        back.setBounds(475,430,200,40);
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


        String npin = newPin.getText();
        String rpin = rePin.getText();


        if(ae.getSource() == back)
        {
            setVisible(false);
            new Transaction(form,pin).setVisible(true);
        }
        else if(ae.getSource() == change)
        {
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null,"Entered Pin does not match. Please try again.");
            }
            else
            {
                try
                {
                    Conn c = new Conn();
                    String querry1 = "update login set pin = '" + npin + "' where formno = '" + form + "'";
                    String querry2 = "update bank set pinNum = '" + npin + "' where formNum = '" + form + "'";
                    String querry3 = "update signup3 set pin = '" + npin + "' where formno = '" + form + "'";

                    c.s.executeUpdate(querry1);
                    c.s.executeUpdate(querry2);
                    c.s.executeUpdate(querry3);

                    JOptionPane.showMessageDialog(null,"PIN Changed Successfully!");
                    setVisible(false);
                    new Transaction(form,pin).setVisible(true);
                } catch (Exception e)
                {
                    System.out.println(e);
                }
            }

        }
    }
}
