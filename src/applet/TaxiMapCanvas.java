package applet;

import java.awt.Graphics;
import javax.swing.JPanel;


/**
 * Sets up the JPanel to let us draw stuff.
 * 
 * @author Nicolai, Lasse
 *
 */
@SuppressWarnings("serial")
public class TaxiMapCanvas extends JPanel {

   public TaxiMap taxiMap = new TaxiMap();

   public TaxiMapCanvas() {
      initComponents();
   }

   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      taxiMap.draw(g);
   }

   private void initComponents() {

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
      );
   }
}
