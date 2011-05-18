<%--

  - Author(s): Lasse
  - Date: 10. May 2011
  - Description:
   Frontend interface for taxi company operators.
   
   This is a proof-of-concept to illustrate the ease of implementing 
   such a interface with JSP and JavaBeans.
   
   The operator is able to enter a new coordinate set which is the 
   position of the customer. This position is then added to the trip_offers
   table in the database and listed on the web page under "Listing trips".
   Periodically the taxi company peer will poll this table for new trips and 
   handle them accordingly.
   
   It is also possible to remove individual trips by clicking the "remove" 
   button besides every trip.  

--%>

<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" import="java.sql.*" %>

<%!  
   
   // Instanciate vars.
   ResultSet rs = null ; 
   ResultSetMetaData rsmd = null ; 
   int numColumns ; 
   int i;  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- Load the bean class as "db" keyword and let it be accessable within a session --%>
<jsp:useBean id="db" class="beans.DAO" scope="session" />
<jsp:setProperty name="db" property="*"/> 

<%-- Start of HTML --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smooth Operator</title>
</head>
<body>

<table border="0">
<tr>
<td>
<%-- Start applet --%>
<APPLET CODE="DbTest.class" WIDTH=700 HEIGHT=700></APPLET>
<%-- End applet --%>
</td>
<td>
<%-- Main form to submit new customer coordinates --%>
<p>
<FORM METHOD=POST>
Enter coordinates: <INPUT TYPE=TEXT NAME=destination SIZE=20 VALUE="1234,5678">
<INPUT TYPE=SUBMIT>
</FORM>
</p>
<BR>
<%

   /* 
    * If customer coordinates or a deletion of trip have been submitted, 
    * send them to the bean for handling.
    * 
    */ 
   if(request.getParameter("destination") != null) {
      db.addTrip(request.getParameter("destination"));
      out.println("<H2>Added new trip with coordinates: " + request.getParameter("destination") + "</H2>");
   } else if(request.getParameter("delete") != null) {
      db.deleteTrip(request.getParameter("delete"));
      out.println("<H2>Deleted trip with id: " + request.getParameter("delete") + "</H2>");
   }
   
   // Fetch trips from database.
   rs = db.execSQL("select * from trip_offers order by id desc");
   //rs = db.listTrips();
%>

<H4>Listing trips</H4>
<%         
      while(rs.next()) {  
%>      
<%= rs.getString("destination") %>
<%= rs.getString("time_ordered") %>
<FORM METHOD POST>
<INPUT TYPE="HIDDEN" NAME="delete" VALUE="<%= rs.getString("id") %>">
<INPUT TYPE="SUBMIT" VALUE="remove">
<BR>
<% 
                }  
%>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
</td>
</tr>
</table> 
</body>
</html>
<%-- End HTML --%>
