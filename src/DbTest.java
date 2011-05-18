import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class DbTest extends JApplet implements ActionListener {

   private static Connection link;
   private static Statement statement;
   private static ResultSet result;
   private JLabel dbInfo;
   private JButton checkButton;
   private JPanel lowPanel;

   @Override
   public void init() {
      dbInfo = new JLabel("Hello..");

      checkButton = new JButton("Push Me");
      checkButton.addActionListener(this);

      lowPanel = new JPanel();
      lowPanel.add(dbInfo);
      lowPanel.add(checkButton);

      add(lowPanel, BorderLayout.NORTH);
   }

   public void getData() throws SQLException, ClassNotFoundException {
      final String URL = "jdbc:postgresql://192.168.1.10/nicolai3sf11";
      final String USERNAME = "nicolai3sf11";
      final String PASSWORD = "ihk100050eit";

      Class.forName("org.postgresql.Driver");
      link = DriverManager.getConnection(URL, USERNAME, PASSWORD);

      statement = link.createStatement();

      String select = "SELECT * FROM trips";

      result = statement.executeQuery(select);

      String infoText = "hej";

      if(result.next()) {
         infoText = "ID: " + result.getInt("id") +
         " Trip ID: " + result.getString("trip_id");
      } else {
         infoText = "nononono";
      }
      dbInfo.setText(infoText);

   }

   public void actionPerformed(ActionEvent e) {
      try {
         getData();
      } catch (SQLException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      } catch (ClassNotFoundException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
   }
}