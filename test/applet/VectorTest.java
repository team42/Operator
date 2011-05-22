package applet;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *  <code>VectorTest</code> will test the <code>Vector</code> class
 *
 * @see Vector
 * @author lasse
 *
 */
public class VectorTest {
   Vector instance;

   @Before
   public void setUp() throws Exception {
      instance = new Vector(5, 2);
   }

   @After
   public void tearDown() throws Exception {
      instance = null;
   }

   @Test
   public void testAdd() {
      Vector expResult = new Vector(10, 4);
      Vector result = instance.add(instance);
      System.out.println("testAdd result = Expected: " + result + " = " + expResult);
      assertEquals(expResult.x, result.x,0);
      assertEquals(expResult.y, result.y,0);
   }

}
