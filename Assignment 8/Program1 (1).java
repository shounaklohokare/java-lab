import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Program1 extends JFrame
{
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6,l7;

    public static void main(String args[])
    {
        JFrame frm=new JFrame("Number Conversion");
        frm.setSize(400, 200);
        frm.setLayout(new GridLayout(5,2));

        JLabel l1=new JLabel("Decimal");
        JTextField t1=new JTextField(10);
        t1.setEditable(false);

        JLabel l2=new JLabel("Binary");
        JLabel e1=new JLabel(" ");
        JLabel l3=new JLabel("Result in Binary");

        JLabel l4=new JLabel("Octal");
        JLabel e2=new JLabel(" ");
        JLabel l5=new JLabel("Result in Octal");

        JLabel l6=new JLabel("Hexadecimal");
        JLabel e3=new JLabel(" ");
        JLabel l7=new JLabel("Result in Hexadecimal");

        JButton b1=new JButton("Convert");
        JButton b2=new JButton("Exit");

        frm.add(l1);
        frm.add(t1);

        frm.add(l2);
        frm.add(e1);
        frm.add(l3);

        frm.add(l4);
        frm.add(e2);
        frm.add(l5);

        frm.add(l6);
        frm.add(e3);
        frm.add(l7);

        frm.add(b1);
        frm.add(b2);
    }
}



