package beans;

import static org.junit.Assert.*;
import java.sql.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DAOTest {
   DAO instance;
   
   @Before
   public void setUp() throws Exception {
      instance = new DAO();
   }

   @After
   public void tearDown() throws Exception {
   }

   @Test
   public void testAddTrip() {
      boolean expResult = true;
      boolean result = instance.addTrip("1234,5678");
      System.out.println("    Result = Expected: " + result + " = " + expResult);
      assertEquals(expResult, result);
   }
   
   @Test
   public void testListTrips() {
      ResultSet expResult = instance.listTrips();
      ResultSet result = expResult;

      System.out.println("    Result = Expected: " + result + " = " + expResult);
      assertEquals(expResult, result);
   }

   @Test
   public void testExecSQL() {
      fail("Not yet implemented"); // TODO
   }

   @Test
   public void testDeleteTrip() {
      fail("Not yet implemented"); // TODO
   }

}
