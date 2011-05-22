package beans;

import static org.junit.Assert.*;
import java.sql.*;
import org.junit.Test;

public class DAOTest {
   DAO instance = new DAO();
   private String lastId;
   
   @Test
   public void testDAO() {
      
      // Test addTrip()
      String expResult = instance.addTrip("1234,5678");
      this.lastId = expResult;
      String result = expResult;
      System.out.println("Result = Expected: " + result + " = " + expResult);
      assertEquals(expResult, result);
      
      // Test listTrips()
      ResultSet expResult1 = instance.listTrips();
      ResultSet result1 = expResult1;
      System.out.println("Result = Expected: " + result1 + " = " + expResult1);
      assertEquals(expResult1, result1);
      
      // Test deleteTrip()
      boolean expResult2 = true;
      boolean result2 = instance.deleteTrip(lastId);
      System.out.println("Result = Expected: " + result2 + " = " + expResult2);
      assertEquals(expResult2, result2);
   }
}
