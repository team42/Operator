package applet;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 * Displays map of intersections.
 * 
 * @author Nicolai, Lasse
 *
 */
@SuppressWarnings("serial")
public class DrawMap extends JApplet {

   private TaxiMapCanvas taxiMap;

   @Override
   public void init() {

      this.setSize(701, 701);

      taxiMap = new TaxiMapCanvas();

      add(taxiMap, BorderLayout.CENTER);
   }
}