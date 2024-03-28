package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton hun,fHun,thou,fThou,twThou,tenThou,back;

    String form,pin;
    FastCash(String form, String pin)
    {

        this.form = form;
        this.pin = pin;
        setLayout(null);


        JLabel text = new JLabel("Please select amount to be withdrawn");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(310,200,400,20);
        text.setForeground(Color.WHITE);
        add(text);

        hun = new JButton("Rs 100");
        hun.setBounds(225,280,200,40);
        hun.addActionListener(this);
        add(hun);

        fHun = new JButton("Rs 500");
        fHun.setBounds(475,280,200,40);
        fHun.addActionListener(this);
        add(fHun);

        thou = new JButton("Rs 1000");
        thou.setBounds(225,330,200,40);
        thou.addActionListener(this);
        add(thou);

        twThou = new JButton("Rs 2000");
        twThou.setBounds(475,330,200,40);
        twThou.addActionListener(this);
        add(twThou);

        fThou = new JButton("Rs 5000");
        fThou.setBounds(225,380,200,40);
        fThou.addActionListener(this);
        add(fThou);

        tenThou = new JButton("Rs 10000");
        tenThou.setBounds(475,380,200,40);
        tenThou.addActionListener(this);
        add(tenThou);

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
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Transaction(form,pin).setVisible(true);
        }
        else
        {
            String amt = ((JButton)ae.getSource()).getText().substring(3); //500 or 1000 or etc
            Date date = new Date();
            try {
                Conn c = new Conn();

                ResultSet rSet = c.s.executeQuery("select * from bank where formNum = '" + form + "'" );
                int balance = 0;
                while (rSet.next())
                {
                    if(rSet.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(rSet.getString("amount"));
                    }
                    else
                    {
                        balance -= Integer.parseInt(rSet.getString("amount"));
                    }
                }

                if(balance < Integer.parseInt(amt))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                }
                else
                {
                    String querry = "insert into bank values('" + form + "', '" + pin + "', '" + date + "', 'Withdraw', '" + amt + "')";
                    c.s.executeUpdate(querry);
                    JOptionPane.showMessageDialog(null,"Rs " + amt + " successfully withdrawn.");
                    setVisible(false);
                    new Transaction(form,pin).setVisible(true);
                }

            }catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }

}
