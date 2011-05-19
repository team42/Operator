package applet;

import java.util.ArrayList;
import applet.model.*;
import applet.database.*;

/**
 * <code>Configuration</code> is a singleton design pattern class (no direct 
 * instantiation) used for holding configuration information.
 *
 * Code for this found here:<br />
 * <li>http://www.javacoffeebreak.com/articles/designpatterns/index.html</li>
 * <li>http://www.javabeginner.com/learn-java/java-singleton-design-pattern</li>
 *
 *
 * @author Lasse
 */
public class Configuration {

   private ArrayList<Intersection> mapList;
   private MapDAO mapDAO = new MapDAO();
   private ArrayList<Taxi> taxis;

   private static Configuration configurationObject;

   /** 
    * Make default constructor private to make sure no other class can 
    * instantiate.
    */
   private Configuration() {
      mapList = mapDAO.getMap();
   }

   /**
    * When first called, the <code>getConfiguration</code>method creates a
    * singleton instance, assigns it to a member variable, and returns the
    * singleton.
    * Subsequent calls will return the same singleton, and all is well with
    * the world.
    *
    * Method is declared synchronized to prevent two threads from calling the
    * <code>getConfiguration</code> method at the same time.
    *
    * @return configurationObject holds static instance of Configuration object.
    */
   public static synchronized Configuration getConfiguration() {
      if (configurationObject == null) {
         configurationObject = new Configuration();
      }
      return configurationObject;
   }

   /**
    * We override the inherited superclass implementation of clone() to
    * prevent cloning of the singleton.
    * 
    * For now the only superclass is Object, in which clone() is protected,
    * but later on we might inherit from another class that implements clone()
    *
    * @return nothing, throws exception
    * @throws CloneNotSupportedException
    */
   @Override
   public Object clone() throws CloneNotSupportedException {
      throw new CloneNotSupportedException();
   }

   /**
    * Get the value of mapList
    *
    * @return value of mapList
    */
   public ArrayList<Intersection> getMap() {
      return mapList;
   }
   
   /**
    * Get the value of taxis
    * 
    * @return value of taxis
    */
   public ArrayList<Taxi> getTaxis() {
      taxis = mapDAO.getTaxis();
      return taxis;
   }

}