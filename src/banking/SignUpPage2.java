package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpPage2 extends JFrame implements ActionListener
{

    JComboBox religion,occup,cat,inc,educ;
    JTextField pann,Adh;
    JRadioButton yes,no,yes1,no1;
    int randNum;
    String formNum;

    SignUpPage2(String formNum)
    {
        this.formNum = formNum;
        Random ran = new Random();
        randNum = 1000 + ran.nextInt(9000);

        //Frame
        setLayout(null);
        setVisible(true);


        //PAGE 2
        JLabel page2 = new JLabel("Page 2 : Additional Details");
        page2.setFont(new Font("Raleway",Font.BOLD,18));
        page2.setBounds(285,70,280,20);
        add(page2);

        //----------------------------------------------------------------------

        //Religion Combo box
        String[] rel_list = {"Hindu","Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox(rel_list);
        religion.setBounds(350,145,450,30);
        religion.setBackground(Color.white);
        add(religion);

        //Category Combo box
        String[] cat_list = {"General","OBC", "SC", "ST", "Others"};
        cat = new JComboBox(cat_list);
        cat.setBounds(350,205,450,30);
        cat.setBackground(Color.white);
        add(cat);

        //Income Combo box
        String[] inc_list = {"Null","< 1,50,000", "b/w 1,50,000 - 2,50,000", "b/w 2,50,000 - 5,50,000", "> 5,50,000"};
        inc = new JComboBox(inc_list);
        inc.setBounds(350,265,450,30);
        inc.setBackground(Color.white);
        add(inc);

        //Edu Combo box
        String[] edu_list = {"Under-Graduate","Graduate", "Post-Graduate", "Doctorate", "Others"};
        educ = new JComboBox(edu_list);
        educ.setBounds(350,335,450,40);
        educ.setBackground(Color.white);
        add(educ);

        //Occupation Combo box
        String[] occu_list = {"Salarized","Self-Employed", "Business", "Student", "Retired", "Others"};
        occup = new JComboBox(occu_list);
        occup.setBounds(350,425,450,30);
        occup.setBackground(Color.white);
        add(occup);

        //Pan text area
        pann = new JTextField();
        pann.setFont(new Font("Raleway",Font.BOLD,15));
        pann.setBounds(350,495,450,30);
        add(pann);

        //Aadhaar text area
        Adh = new JTextField();
        Adh.setFont(new Font("Raleway",Font.BOLD,15));
        Adh.setBounds(350,565,450,30);
        add(Adh);

        //Citizen Radio Button
        yes = new JRadioButton("Yes");
        yes.setBounds(350,625,110,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        no = new JRadioButton("No");
        no.setBounds(520,625,110,30);
        no.setBackground(Color.WHITE);
        add(no);

        ButtonGroup citizen = new ButtonGroup();
        citizen.add(yes);
        citizen.add(no);

        //Existing Account
        yes1 = new JRadioButton("Yes");
        yes1.setBounds(350,685,110,30);
        yes1.setBackground(Color.WHITE);
        add(yes1);
        no1 = new JRadioButton("No");
        no1.setBounds(520,685,110,30);
        no1.setBackground(Color.WHITE);
        add(no1);

        ButtonGroup acc = new ButtonGroup();
        acc.add(yes1);
        acc.add(no1);

        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(720,770,80,30);
        next.addActionListener(this);
        add(next);

        //----------------------------------------------------------------------

        //Religion
        JLabel rel = new JLabel("Religion : ");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
        rel.setBounds(100,145,200,30);
        add(rel);
        //Category
        JLabel Category = new JLabel("Category : ");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100,205,200,30);
        add(Category);
        //Income
        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,265,200,30);
        add(income);
        //Educational Qualification
        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,20));
        edu.setBounds(100,325,200,30);
        add(edu);
        JLabel qual = new JLabel("Qualification :");
        qual.setFont(new Font("Raleway",Font.BOLD,20));
        qual.setBounds(100,355,200,30);
        add(qual);
        //Occupation
        JLabel occu = new JLabel("Occupation :");
        occu.setFont(new Font("Raleway",Font.BOLD,20));
        occu.setBounds(100,425,200,30);
        add(occu);
        //PAN
        JLabel pan = new JLabel("Pan Number :");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,495,200,30);
        add(pan);
        //Aadhar
        JLabel aadhar = new JLabel("Aadhar Number :");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,565,200,30);
        add(aadhar);
        //Senior Citizen
        JLabel senior = new JLabel("Senior Citizen :");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,625,200,30);
        add(senior);
        //Existing Acc
        JLabel exis = new JLabel("Existing Account :");
        exis.setFont(new Font("Raleway",Font.BOLD,20));
        exis.setBounds(100,685,250,30);
        add(exis);

        //----------------------------------------------------------------------

        //Background Img
        ImageIcon i1 = new ImageIcon("/home/harry/IdeaProjects/Bank_Management_System/src/main/resources/icons/e.jpeg");
        Image i2 = i1.getImage().getScaledInstance(900,870,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        JLabel background = new JLabel(i1);
        background.setBounds(0,0,850,870);
        add(background);


        setSize(850,870);
        setLocation(350,10);
        setTitle("SIGN UP Page : 2");

    }

    public void actionPerformed(ActionEvent ae) {
        String rel = (String) religion.getSelectedItem();
        String category = (String) cat.getSelectedItem();
        String income = (String) inc.getSelectedItem();
        String Education = (String) educ.getSelectedItem();
        String Oocupation = (String) occup.getSelectedItem();

        String pan = pann.getText();
        String adhaar = Adh.getText();
        String cit = "";
        if (yes.isSelected()) {
            cit = "Yes";
        } else if (no.isSelected()) {
            cit = "No";
        }
        String existing = "";
        if (yes1.isSelected()) {
            existing = "Yes";
        } else if (no1.isSelected()) {
            existing = "No";
        }


        try {
            if (income.equals("Null")) {
                JOptionPane.showMessageDialog(null, "Income is required");
            } else if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "Pan Number is required");
            } else if (adhaar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar Number is required");
            } else if (cit.equals("")) {
                JOptionPane.showMessageDialog(null, "Select a option in Senior Citizen");
            } else if (existing.equals("")) {
                JOptionPane.showMessageDialog(null, "Select a option in Existing Account");
            } else {
                Conn c = new Conn();
                String query = "insert into signup2 values ('" + this.formNum + "', '" + rel + "', '" + category + "', '" + income + "', '" + Education + "', '" + Oocupation + "', '" + pan + "', '" + adhaar + "', '" + cit + "', '" + existing + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpPage3(this.formNum).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
