package applet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Create connection to the database.
 * 
 * @author Lasse
 *
 */
public class PostgresqlConnectionFactory {
   private static final String URL = "jdbc:postgresql://localhost:5432/nicolai3sf11";
   private static final String USERNAME = "nicolai3sf11";
   private static final String PASSWORD = "ihk100050eit";

   /**
    * Returns a connection defined by URL, Username and Password
    * 
    * @return a connection to the URL
    * @throws SQLException
    */
   public static Connection createConnection() throws SQLException {
      try {
         Class.forName("org.postgresql.Driver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      return DriverManager.getConnection(URL, USERNAME, PASSWORD);
   }

}
