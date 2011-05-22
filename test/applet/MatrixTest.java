package applet;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *  <code>Matrixtest</code> will test the <code>Matrix</code> class
 *
 * @see Matrix
 * @author lasse
 *
 */
public class MatrixTest {
   Matrix instance;

   @Before
   public void setUp() throws Exception {
      instance = new Matrix(100, 200, 300, 400);
   }

   @After
   public void tearDown() throws Exception {
      instance = null;
   }

   @Test
   public void testMultiplyVector() {
      Vector v = new Vector(2,2);
      Vector expResult = new Vector(600,1400);
      Vector result = instance.multiply(v);
      System.out.println("testAdd result = Expected: " + result.x + "," + result.y + " = " + expResult.x + "," + expResult.y);
      assertEquals(expResult.x, result.x, 0);
      assertEquals(expResult.y, result.y, 0);
   }

   @Test
   public void testMultiplyMatrix() {
      Matrix m = new Matrix(100,200,300,400);
      Matrix expResult = new Matrix(70000, 100000,10,90);
      Matrix result = instance.multiply(m);
      System.out.println("testAdd result = Expected: " + result.a + "," + result.b + " = " + expResult.a + "," + expResult.b);
      assertEquals(expResult.a, result.a, 0);
      assertEquals(expResult.b, result.b, 0);
   }

}
