package applet.database;

import java.sql.*;
import java.util.ArrayList;
import applet.model.*;

/**
 * Fetches coordinates, from the database, for drawing the map and taxis
 * 
 * @author Nicolai, Lasse
 *
 */
public class MapDAO {

   Connection con = null;
   ResultSet resultSet = null;
   Statement statement = null;

   /**
    * Gets the coordinates to draw the map.
    * 
    * @return ArrayList of intersections
    */
   public ArrayList<Intersection> getMap() {
      ArrayList<Intersection> mapList = new ArrayList<Intersection>();
      int id, xCoordinate, yCoordinate, links, n1, n2, n3, n4, n5;

      try {
         con = PostgresqlConnectionFactory.createConnection();
         Statement statement = con.createStatement();

         resultSet = statement.executeQuery("SELECT * FROM coordinates ORDER BY id ASC");

         while (resultSet.next()) {
            id = resultSet.getInt(1);
            xCoordinate = resultSet.getInt(2);
            yCoordinate = resultSet.getInt(3);
            links = resultSet.getInt(4);
            n1 = resultSet.getInt(5);

            n2 = resultSet.getInt(6);
            if (resultSet.wasNull()) n2 = 9999;

            n3 = resultSet.getInt(7);
            if (resultSet.wasNull()) n3 = 9999;

            n4 = resultSet.getInt(8);
            if (resultSet.wasNull()) n4 = 9999;

            n5 = resultSet.getInt(9);
            if (resultSet.wasNull()) n5 = 9999;

            mapList.add(new Intersection(id, xCoordinate, yCoordinate, links, n1, n2, n3, n4, n5));
         }

         statement.close();
         con.close();

      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception g) {
         g.printStackTrace();
      }

      return mapList;

   }

   /**
    * Gets the list of taxis.
    * 
    * @return ArrayList of taxis
    */
   public ArrayList<Taxi> getTaxis() {
      ArrayList<Taxi> taxis = new ArrayList<Taxi>();
      String taxi_id, taxi_coordinate;

      try {
         con = PostgresqlConnectionFactory.createConnection();

         Statement statement = con.createStatement();

         resultSet = statement.executeQuery("SELECT * FROM taxi");

         while (resultSet.next()) {
            taxi_id = resultSet.getString("taxi_id");
            taxi_coordinate = resultSet.getString("taxi_coordinate");
            System.out.println("Taxi coordinate from db: " + taxi_coordinate);
            taxis.add(new Taxi(taxi_id, taxi_coordinate));
         }

         statement.close();
         con.close();

      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception g) {
         g.printStackTrace();
      }

      return taxis;
   }
}
