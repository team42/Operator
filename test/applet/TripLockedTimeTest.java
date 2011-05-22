package applet;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TripLockedTimeTest {
   TripLockedTime instance;

   @Before
   public void setUp() throws Exception {
      instance = new TripLockedTime("42", 0, "42", "1234,5678");
   }

   @After
   public void tearDown() throws Exception {
      instance = null;
   }

   @Test
   public void testGetTripID() {
      String expResult = "42";
      String result = instance.getTripID();
      assertEquals(expResult, result);
   }

   @Test
   public void testGetAccepted() {
      int expResult = 0;
      int result = instance.getAccepted();
      assertEquals(expResult, result);
   }

   @Test
   public void testGetCoords() {
      String expResult = "1234,5678";
      String result = instance.getCoords();
      assertEquals(expResult, result);
   }

   @Test
   public void testGetTime() {
      String expResult = "42";
      String result = instance.getTime();
      assertEquals(expResult, result);
   }

}
