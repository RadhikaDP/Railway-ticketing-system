<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.io.*,java.util.*,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login </title>
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/dropdownmenue.css" />
            <link rel="stylesheet" href="css/clndr.css" type="text/css" />
                                <script src="js/underscore-min.js" type="text/javascript"></script>
                    <script src= "js/moment-2.2.1.js" type="text/javascript"></script>
                    <script src="js/clndr.js" type="text/javascript"></script>
                    <script src="js/site.js" type="text/javascript"></script>     
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<p>All trains travelling between two stations on particular 1 day in a week</p>
<form:form action="2" method="post" modelAttribute="days"  >
            <table border="0">          
                <tr>                                    
        <td>  Source
          <form:select path="src" name="source" id="source" items="${source}"  >        
          </form:select></td>
          </tr>
               <tr>    
          <td>  Destination
          <form:select path="dest" name="destination" id="destination" items="${destination}"  >
          
          </form:select></td>
          </tr>     
                <form:select name="day" path="day1" >
				<option value="MON">Mon</option>
				<option value="Tue">Tue</option>
				<option value="Wed">Wed</option>
				<option value="Thu">Thu</option>
				<option value="Fri">Fri</option>
				<option value="Sat">Sat</option>
</form:select>

           <form:select name="day" path="day2" >
				<option value="MON">Mon</option>
				<option value="Tue">Tue</option>
				<option value="Wed">Wed</option>
				<option value="Thu">Thu</option>
				<option value="Fri">Fri</option>
				<option value="Sat">Sat</option>
</form:select>
   			   <tr>
                    <td colspan="2" align="center"><input type="submit" value="Get Details" /></td>
                </tr>
                
            </table>
        </form:form>
</body>
</html>