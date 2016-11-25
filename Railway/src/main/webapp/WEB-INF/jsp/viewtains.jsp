<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
       <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table >  
<tr><th class="col-xs-2">Train No</th><th class="col-xs-2">Train Name</th><th class="col-xs-2">Source</th><th class="col-xs-2">Departure</th><th class="col-xs-2">Destination</th><th class="col-xs-2">Arrival</th></tr>  
   <c:forEach var="cust" items="${train}">   
   <tr>  
   <td class="col-xs-2">${train.trainno}</td>  
   <td class="col-xs-2">${train.trainname}</td>  
   <td class="col-xs-2">${train.source}</td>  
   <td class="col-xs-2">${train.departure}</td>
   <td class="col-xs-2">${train.destination}</td>
   </tr>  
   </c:forEach>  
   </table> 
</body>
</html>