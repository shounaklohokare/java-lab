import java.applet.*;
import java.awt.*;

/*
<applet code="q2" width=400 heigth=200>
</applet>
*/

public class q2 extends Applet {

    public void paint(Graphics g) {

        int[] x = { 300, 400, 190 };
        int[] y = { 30, 220, 220 };

        int no = 3;

        Color c = new Color(255, 0, 0); // red color
        g.setColor(c);

        g.fillPolygon(x, y, no); // draw triangle of red color with three points

        c = new Color(255, 255, 0); // yellow
        g.setColor(c);

        g.fillRect(190, 220, 210, 220); // fills the yello rectangle

        c = new Color(255, 255, 255); // white color
        g.setColor(c);

        g.fillRect(255, 320, 80, 120); // fills the small white rectangle

    }

}