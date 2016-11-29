<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
       <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><jsp:include page="/WEB-INF/jsp/adminhome.jsp"></jsp:include> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/dropdownmenue.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style type="text/css">
th, td {
    padding: 15px;
    text-align: left;
}
th, td {
    border-bottom: 1px solid #ddd;
}
tr:hover {background-color: #f5f5f5}
</style>
</head>
<body>
<p>All trains travelling between two stations on particular 1 day in a week</p>
   <div align="center">
 <div class="container">
  <div class="panel panel-default"> 
<table >  
<tr><th class="col-xs-1">Train Number</th><th class="col-xs-1">Train Name</th><th class="col-xs-1">Source</th><th class="col-xs-1">Destination</th><th class="col-xs-1">Departure</th><th class="col-xs-1">Arrival</th></tr>  
   <c:forEach var="trns" items="${trns}">   
   <tr>  
   <td class="col-xs-1">${trns.trainno}</td>  
   <td class="col-xs-1">${trns.trainname}</td>  
   <td class="col-xs-1">${trns.source}</td>  
   <td class="col-xs-1">${trns.destination}</td>  
   <td class="col-xs-1">${trns.departure}</td>  
   <td class="col-xs-1">${trns.arrival}</td>  
   </tr>  
   </c:forEach>  
   </table> </div></div></div>
</body>
</html>