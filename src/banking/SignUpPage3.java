package banking;
//import com.toedter.components.JTitlePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpPage3 extends JFrame implements ActionListener {

    JRadioButton Saving,Current,Fixed,Recurring;
    JCheckBox atm,intBank,mobBank,mailSms,chBook,eStatement,finall;
    JButton submit,cancel;
    String formNum;
    SignUpPage3(String formNum)
    {

        setTitle("SIGN UP Page : 3");
        this.formNum = formNum;

        setVisible(true);
        setLayout(null);

        JLabel page3 = new JLabel("Page 3: Account Details");
        page3.setFont(new Font("Raleway",Font.BOLD,19));
        page3.setBounds(300,70,280,20);
        add(page3);

        JLabel acc = new JLabel("Account Type:");
        acc.setFont(new Font("Raleway",Font.BOLD,20));
        acc.setBounds(100,140,200,30);
        add(acc);

        Saving = new JRadioButton("Savings Account");
        Current = new JRadioButton("Current Account");
        Fixed = new JRadioButton("Fixed Deposit Account");
        Recurring = new JRadioButton("Recurring Deposit Account");

        Saving.setBackground(Color.pink);
        Current.setBackground(Color.pink);
        Fixed.setBackground(Color.pink);
        Recurring.setBackground(Color.pink);

        Saving.setBounds(100,190,250,35);
        Current.setBounds(100,230,250,35);
        Fixed.setBounds(380,190,250,35);
        Recurring.setBounds(380,230,250,35);

        ButtonGroup accountType = new ButtonGroup();
        accountType.add(Saving);
        accountType.add(Current);
        accountType.add(Fixed);
        accountType.add(Recurring);

        add(Saving);
        add(Current);
        add(Fixed);
        add(Recurring);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,290,200,30);
        add(card);

        JLabel cardNum = new JLabel("XXXX-XXXX-XXXX-1234");
        cardNum.setFont(new Font("Raleway",Font.BOLD,20));
        cardNum.setBounds(350,290,300,30);
        add(cardNum);

        JLabel cardDetail = new JLabel("(Your 16 Digit Card Number)");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,11));
        cardDetail.setBounds(100,320,200,30);
        add(cardDetail);


        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,380,200,30);
        add(pin);

        JLabel pinNum = new JLabel("XXXX");
        pinNum.setFont(new Font("Raleway",Font.BOLD,20));
        pinNum.setBounds(350,380,300,30);
        add(pinNum);

        JLabel pinDetail = new JLabel("(Your 4 Digit PIN)");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,11));
        pinDetail.setBounds(100,410,200,30);
        add(pinDetail);

        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway",Font.BOLD,20));
        service.setBounds(100,470,250,30);
        add(service);



        atm = new JCheckBox("ATM Card");
        mobBank = new JCheckBox("Mobile Banking");
        chBook = new JCheckBox("Cheque Book");
        intBank = new JCheckBox("Internet Banking");
        mailSms = new JCheckBox("Email & SMS Alerts");
        eStatement = new JCheckBox("E-Statement");

        atm.setBackground(Color.black);
        intBank.setBackground(Color.black);
        mobBank.setBackground(Color.black);
        mailSms.setBackground(Color.black);
        chBook.setBackground(Color.black);
        eStatement.setBackground(Color.black);
        intBank.setForeground(Color.WHITE);
        mobBank.setForeground(Color.WHITE);
        mailSms.setForeground(Color.WHITE);
        chBook.setForeground(Color.WHITE);
        atm.setForeground(Color.WHITE);
        eStatement.setForeground(Color.WHITE);

        atm.setFont(new Font("Raleway",Font.BOLD,14));
        intBank.setFont(new Font("Raleway",Font.BOLD,14));
        mobBank.setFont(new Font("Raleway",Font.BOLD,14));
        mailSms.setFont(new Font("Raleway",Font.BOLD,14));
        chBook.setFont(new Font("Raleway",Font.BOLD,14));
        eStatement.setFont(new Font("Raleway", Font.BOLD,14));

        atm.setBounds(100,515,250,40);
        intBank.setBounds(100,565,250,40);
        mobBank.setBounds(100,615,250,40);
        mailSms.setBounds(380,515,250,40);
        chBook.setBounds(380,565,250,40);
        eStatement.setBounds(380,615,250,40);

        add(atm);
        add(intBank);
        add(mailSms);
        add(mobBank);
        add(chBook);
        add(eStatement);

        finall = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge ");
        finall.setBounds(100,730,660,15);
        add(finall);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,12));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,770,100,30);
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,12));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450,770,100,30);
        cancel.addActionListener(this);
        add(cancel);

        //Background Img
        ImageIcon i1 = new ImageIcon("/home/harry/IdeaProjects/Bank_Management_System/src/main/resources/icons/a.jpeg");
        Image i2 = i1.getImage().getScaledInstance(900,870,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel background = new JLabel(i1);
        background.setBounds(0,0,850,870);
        add(background);


        setSize(850,870);
        setLocation(350,10);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String account = "";
            if(Saving.isSelected())
            {
                account = "Saving Account";
            } else if (Current.isSelected()) {
                account = "Current Account";
            } else if (Fixed.isSelected()) {
                account = "Fixed Deposit Account";
            } else if (Recurring.isSelected()) {
                account = "Recurring Deposit Account";
            }

            Random r = new Random();
            String cardNum = "" + Math.abs(r.nextLong(99999999) + 1234696900000000L);
            String pinNum = "" + Math.abs(r.nextInt(9000) + 1000);

            String Services = "";
            if(atm.isSelected())
            {
                Services = Services + " ATM Card";
            } if (mailSms.isSelected()) {
                Services = Services + " Email & SMS Alerts";
            } if (intBank.isSelected()) {
                Services = Services + " Internet Banking";
            } if (chBook.isSelected()) {
                Services = Services + " Cheque Book";
            } if (mobBank.isSelected()) {
                Services = Services + " Mobile Banking";
            } if (eStatement.isSelected()) {
                Services = Services + " E-Statement";
            }

            String last = "";
            if(finall.isSelected()){
                last = "yes";
            }
            else{
                last = "no";
            }

            try {
                if (account.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required");
                } else if (last.equals("no")) {
                    JOptionPane.showMessageDialog(null,"Check the Declaration Box");
                }

                else {
                    Conn c = new Conn();
                    String querry1 = "insert into signup3 values ('" + this.formNum + "', '" + account + "', '" + cardNum + "', '" + pinNum + "', '" + Services + "')";
                    String querry2 = "insert into login values ('" + this.formNum + "', '" + cardNum + "', '" + pinNum + "')";
                    c.s.executeUpdate(querry1);
                    c.s.executeUpdate(querry2);

                    JOptionPane.showMessageDialog(null, "Your Card Number : " + cardNum + "\n Your Pin : " + pinNum);
                    setVisible(false);
                    new Deposit(formNum,pinNum).setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e);
            }


        }
        else if (ae.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

}
