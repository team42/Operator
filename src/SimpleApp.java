import java.awt.Graphics;

@SuppressWarnings("serial")
public class SimpleApp extends java.applet.Applet {
   // applet version of well-known application
   public void paint(Graphics g) { /* NOTE: no main */
      g.drawString("Hello World!",50,25);
   }
}
