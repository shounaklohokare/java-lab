import java.awt.*;
import javax.swing.*;

class Program2 extends JFrame {
    JLabel Font, FontStyle, Size;
    JComboBox<String> fontfam;
    JRadioButton bld, itl;
    ButtonGroup radioButton;
    Box verticalBox;
    DefaultListModel<String> listModel;
    JList<String> list;
    JScrollPane scroll;
    JTextField fontotp;
    String fonts[];
    JButton aply, ext;

    Program2() {
        Font = new JLabel("Font");
        FontStyle = new JLabel("Font Style");
        Size = new JLabel("Size");

        aply = new JButton("Apply");
        ext = new JButton("Exit");

        fontotp = new JTextField("Hello Everyone");
        fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontfam = new JComboBox<String>(fonts);

        bld = new JRadioButton("Bold");
        itl = new JRadioButton("Italic");

        radioButton = new ButtonGroup();
        radioButton.add(bld);
        radioButton.add(itl);

        listModel = new DefaultListModel<String>();
        String fontsize[] = new String[50];

        for (int i = 0; i <= 50; i++) {
            listModel.addElement(String.valueOf(i + 1));
        }

        list = new JList<String>(listModel);
        scroll = new JScrollPane(list);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        verticalBox = Box.createVerticalBox();
        verticalBox.add(bld);
        verticalBox.add(itl);

        setSize(550, 450);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        add(Font);
        add(FontStyle);
        add(Size);

        add(fontfam);
        add(verticalBox);
        add(scroll);

        add(fontotp);
        add(aply);
        add(ext);
    }

    class Program2Main {
        public static void main(String args[]) {
            new Program2();
        }
    }
}
