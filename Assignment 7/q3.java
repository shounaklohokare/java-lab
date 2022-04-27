import java.applet.*;
import java.awt.*;

public class q3 extends Applet {

    public void paint(Graphics g) {

        String s = " ";
        String f[];

        int a = 20;

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        f = ge.getAvailableFontFamilyNames();

        for (int i = 0; i < f.length; i++) {
            g.drawString(f[i], 10, a);
            a += 20;
        }

    }

}
