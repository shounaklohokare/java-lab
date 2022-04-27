import java.awt.*;
import javax.swing.*;

class Program1
{
    public static void main(String args[])
    {
        JFrame frm=new JFrame("Number Conversion");
        frm.setSize(600, 600);
        frm.setLayout(new GridLayout(5,2));

        JLabel l1=new JLabel("Decimal");
        JTextField t1=new JTextField(10);
        t1.setEditable(false);

        JLabel l2=new JLabel("Binary");
        JLabel l3=new JLabel("Result in Binary");

        JLabel l4=new JLabel("Octal");
        JLabel l5=new JLabel("Result in Octal");

        JLabel l6=new JLabel("Hexadecimal");
        JLabel l7=new JLabel("Result in Hexadecimal");

        JButton b1=new JButton("Convert");
        JButton b2=new JButton("Exit");

        frm.add(l1);
        frm.add(t1);

        frm.add(l2);
        frm.add(l3);

        frm.add(l4);
        frm.add(l5);

        frm.add(l6);
        frm.add(l7);

        frm.add(b1);
        frm.add(b2);

        frm.setVisible(true);
    }
}



