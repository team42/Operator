package applet;

import java.awt.*;
import java.util.*;
import applet.model.*;

/**
 * 
 * @author Nicolai, Lasse
 *
 */
public class TaxiMap {

   double scale = 0.35;

   Configuration config = Configuration.getConfiguration();

   ArrayList<Intersection> mapList = config.getMap();
   ArrayList<Integer> route = new ArrayList<Integer>();
   ArrayList<Taxi> taxis = config.getTaxis();

   public TaxiMap() {
      mapList = config.getMap();
   }

   /**
    * Draws a map of intersections with vectors.
    * 
    * @param g
    */
   public void draw(Graphics g) {
      CoordinateSystem S2 = new CoordinateSystem(scale, scale, 0, scale * 2000);

      int xLength = 2000;
      int yLength = 2000;

      S2.drawLine(g, new Vector(0, 0), new Vector(0, yLength));
      S2.drawLine(g, new Vector(0, yLength), new Vector(xLength, yLength));
      S2.drawLine(g, new Vector(xLength, yLength), new Vector(xLength, 0));
      S2.drawLine(g, new Vector(xLength, 0), new Vector(0, 0));

      g.setColor(Color.BLACK);

      for (int t = 0; t < mapList.size(); t++) {
         for (int i = mapList.get(t).getLinks(); i > 0; i--) {
            int ax = mapList.get(t).getXCoord();
            int ay = mapList.get(t).getYCoord();

            int neighbor = mapList.get(t).getNn(i);

            int bx = mapList.get(neighbor).getXCoord();
            int by = mapList.get(neighbor).getYCoord();

            S2.drawStationLine(g, ax, ay, bx, by, false);
         }
      }

      for (int i = 0; i < mapList.size(); i++) {
         S2.drawStation(g, mapList.get(i).getXCoord(), mapList.get(i).getYCoord());
      }
      
          
      for(int k=0;k<taxis.size();k++) {
         S2.drawTaxi(g, new Vector((double) taxis.get(k).getXcoord(), (double) taxis.get(k).getYcoord()), Color.RED);
      }

//      int start = config.getTaxiPosition();
//      int tempId;
//
//      int ownX = Integer.parseInt(config.getTaxiCoord().substring(0, 4));
//      int ownY = Integer.parseInt(config.getTaxiCoord().substring(5, 9));
//
//      S2.drawPoint(g, new Vector(ownX, ownY), 20);
//
//      for(int i=0; i<tripList.size(); i++) {
//         route = algorithm.Route(start, tripList.get(i).getCoords());
//         int j=0;
//         while (j < route.size() - 1) {
//            tempId = route.get(j);
//            int Ax = mapList.get(tempId).getXCoord();
//            int Ay = mapList.get(tempId).getYCoord();
//            j++;
//            tempId = route.get(j);
//            int Bx = mapList.get(tempId).getXCoord();
//            int By = mapList.get(tempId).getYCoord();
//
//            S2.drawRouteLine(g, Ax, Ay, Bx, By);
//         }
//      }
   }
}
