

import java.sql.*;
import java.util.ArrayList;

public class MapDAO {

	Connection con = null;
	ResultSet resultSet = null;
	Statement statement = null;
	
	final String URL = "jdbc:postgresql://192.168.1.10/nicolai3sf11";
    final String USERNAME = "nicolai3sf11";
    final String PASSWORD = "ihk100050eit";

	ArrayList<Intersection> mapList = new ArrayList<Intersection>();
	int id, xCoordinate, yCoordinate, links, n1, n2, n3, n4, n5;

	public ArrayList<Intersection> getMap() {
		try {
			Class.forName("org.postgresql.Driver");
		    con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
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

}
