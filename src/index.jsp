<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!  
   ResultSet rs = null ; 
   ResultSetMetaData rsmd = null ; 
   int numColumns ; 
   int i;  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="db" class="beans.DAO" scope="session" />

<jsp:setProperty name="db" property="*"/> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smooth Operator</title>
</head>
<body>

<FORM METHOD=POST>
Enter coordinates: <INPUT TYPE=TEXT NAME=destination SIZE=20 VALUE="1234,5678"><BR>
<INPUT TYPE=SUBMIT>
</FORM>
<BR>
<%

   if(request.getParameter("destination") != null) {
      db.addTrip(request.getParameter("destination"));
      out.println("<H2>Added new trip with coordinates: " + request.getParameter("destination") + "</H2>");
   } else if(request.getParameter("delete") != null) {
      db.deleteTrip(request.getParameter("delete"));
      out.println("<H2>Deleted trip with id: " + request.getParameter("delete") + "</H2>");
   }
   
   rs = db.execSQL("select * from trip_offers order by id desc");
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
 
</body>
</html>
