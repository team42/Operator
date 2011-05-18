package beans;

import java.sql.*;

/**
 * This bean handles the SQL strings/commands for the Postgresql database.
 *
 * This code was originally written by hbe and has been modified to fit the 
 * goal of this project.
 *
 * @author Lasse
 */
public class DAO {
   private Connection con;
   private PreparedStatement preparedStatement;
   private ResultSet resultSet;

   /**
    * List all rows in table trip_offers.
    * 
    * @return resultSet containing found values in table
    */
   public ResultSet listTrips() {
      con = null;
      resultSet = null;

      String query = "SELECT * FROM trip_offers ORDER BY id DESC";

      try {
         con = PostgresqlConnectionFactory.createConnection();
         preparedStatement = con.prepareStatement(query);
         resultSet = preparedStatement.executeQuery();
      } catch(SQLException e) {
         e.printStackTrace();
      }
      return resultSet;
   }

   /**
    * Add a new trip to the database.
    * 
    * @param destination
    * @return true if success, otherwise false
    */
   public boolean addTrip(String destination) {
      String cardsQuery = "INSERT INTO trip_offers (destination, time_ordered) VALUES (?, ?)";

      int rowCount = 0;
      con = null;

      try {
         con = PostgresqlConnectionFactory.createConnection();
         preparedStatement = con.prepareStatement(cardsQuery);
         preparedStatement.setString(1, destination);

         java.util.Date date = new java.util.Date(System.currentTimeMillis()); 
         java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime()); 
         preparedStatement.setTimestamp(2, timestamp);

         rowCount = preparedStatement.executeUpdate();
         preparedStatement.close();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if (con != null) {
            try { con.close(); }
            catch (SQLException e1) { System.out.println("Failed Closing of Database!"); }
         }
      }
      // We want to return false if INSERT was unsuccesfull, else return true
      if (rowCount == 0) { return false; }
      else { return true; }

   }

   /**
    * Execute SQL statement in query.
    * 
    */
   public ResultSet execSQL(String query) {
      con = null;
      resultSet = null;

      try {
         con = PostgresqlConnectionFactory.createConnection();
         preparedStatement = con.prepareStatement(query);
         resultSet = preparedStatement.executeQuery();

         return resultSet;
      } catch(SQLException e) {
         e.printStackTrace();
      }
      return resultSet;
   }

   /**
    * Delete row from database that matches id.
    * @param id Row id to delete
    * @return true if successfull, else false
    */
   public boolean deleteTrip(String id) {
      int newid = Integer.parseInt(id);
      String query = "DELETE FROM trip_offers WHERE id  = ?";

      int rowCount = 0;
      con = null;

      try {
         con = PostgresqlConnectionFactory.createConnection();
         preparedStatement = con.prepareStatement(query);
         preparedStatement.setInt(1, newid);
         rowCount = preparedStatement.executeUpdate();
         preparedStatement.close();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if (con != null) {
            try { con.close(); }
            catch (SQLException e1) { System.out.println("Failed Closing of Database!"); }
         }
      }
      // We want to return false if INSERT was unsuccesfull, else return true
      if (rowCount == 0) { return false; }
      else { return true; }
   }
}