package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdraw, fCash, mini, pChange, balEnquiry, exit;
    String form,pin;


    Transaction(String formNum, String pin)
    {
        form = formNum;
        this.pin = pin;
        setLayout(null);


        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(310,200,400,20);
        text.setForeground(Color.WHITE);
        add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(225,280,200,40);
        deposit.addActionListener(this);
        add(deposit);

        withdraw = new JButton("CASH WITHDRAWL");
        withdraw.setBounds(475,280,200,40);
        withdraw.addActionListener(this);
        add(withdraw);

        fCash = new JButton("FAST CASH");
        fCash.setBounds(225,330,200,40);
        fCash.addActionListener(this);
        add(fCash);

        mini = new JButton("MINI STATEMENT");
        mini.setBounds(475,330,200,40);
        mini.addActionListener(this);
        add(mini);

        pChange = new JButton("PIN CHANGE");
        pChange.setBounds(225,380,200,40);
        pChange.addActionListener(this);
        add(pChange);

        balEnquiry = new JButton("BALANCE ENQUIRY");
        balEnquiry.setBounds(475,380,200,40);
        balEnquiry.addActionListener(this);
        add(balEnquiry);

        exit = new JButton("EXIT");
        exit.setBounds(475,430,200,40);
        exit.addActionListener(this);
        add(exit);


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
        if(ae.getSource() == exit)
        {
            System.exit(0);
        }
        else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(form,pin).setVisible(true);
        }
        else if (ae.getSource() == withdraw) {
            setVisible(false);
            new withdrawl(form,pin).setVisible(true);
        }
        else if(ae.getSource() == fCash)
        {
            setVisible(false);
            new FastCash(form,pin).setVisible(true);
        }
        else if(ae.getSource() == pChange)
        {
            setVisible(false);
            new PinChange(form,pin).setVisible(true);
        }
        else if(ae.getSource() == balEnquiry)
        {
            setVisible(false);
            new Balance(form,pin).setVisible(true);
        }
        else if(ae.getSource() == mini)
        {

            new MiniStatement(form,pin).setVisible(true);
        }
    }
}
