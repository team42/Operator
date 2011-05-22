package applet;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import applet.model.*;


/**
 * <code>ConfigurationTest</code> will test the <code>Configuration</code> class
 *
 * @see Configuration
 *
 * @author Lasse
 */
public class ConfigurationTest {

   /**
    * Test of getConfiguration method, of class Configuration.
    *
    * Call getConfiguration() to load Configuration object into result and
    * expected result.
    *
    * assertEquals the result from getConfiguration() with the expected result.
    */
   @Test
   public void testGetConfiguration() {
      Configuration expResult = Configuration.getConfiguration();
      Configuration result = Configuration.getConfiguration();
      System.out.println("testGetConfiguration result = Expected: " + result + " = " + expResult);
      assertEquals(expResult, result);
   }

   /**
    * Test of clone method, of class Configuration.
    * We want this to throw an exception so we test for that.
    * See http://junit.sourceforge.net/doc/faq/faq.htm#tests_7
    *
    * @throws Exception clone() has CloneNotSupportedException
    */
   @SuppressWarnings("unused")
   @Test(expected=CloneNotSupportedException.class)
   public void testClone() throws Exception {
      Configuration instance = Configuration.getConfiguration();
      Object o = instance.clone();
   }

   /**
    * Test of getMap() method, of class Configuration.
    * 
    * @throws IOException 
    */
   @Test
   public void testGetMap() throws IOException {
      Configuration instance = Configuration.getConfiguration();
      ArrayList<Intersection> expResult = instance.getMap(); 
      ArrayList<Intersection> result = instance.getMap();
      assertEquals(expResult, result);
      System.out.println("testGetMap result = Expected: " + result + " = " + expResult);
   }
   
   /**
    * Test of getTaxis() method, of class Configuration.
    * 
    * @throws IOException 
    */
   @Test
   public void testGetTaxis() throws IOException {
      Configuration instance = Configuration.getConfiguration();
      ArrayList<Taxi> expResult = instance.getTaxis(); 
      ArrayList<Taxi> result = expResult;
      assertEquals(expResult, result);
      System.out.println("testGetTaxis result = Expected: " + result + " = " + expResult);
   }
}
