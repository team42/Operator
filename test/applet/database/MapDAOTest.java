package applet.database;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import applet.model.*;


public class MapDAOTest {
   MapDAO instance = new MapDAO();

   @Test
   public void testGetMap() {
      ArrayList<Intersection> expResult = instance.getMap();
      ArrayList<Intersection>  result = expResult;
      System.out.println("Result = Expected: " + result + " = " + expResult);
      assertEquals(expResult, result);
   }

   @Test
   public void testGetTaxis() {
      ArrayList<Taxi> expResult = instance.getTaxis();
      ArrayList<Taxi>  result = expResult;
      System.out.println("Result = Expected: " + result + " = " + expResult);
      assertEquals(expResult, result);
   }

}
