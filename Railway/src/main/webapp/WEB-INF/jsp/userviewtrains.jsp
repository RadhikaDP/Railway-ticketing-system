<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
       <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
       <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><jsp:include page="/WEB-INF/jsp/home.jsp"></jsp:include> 
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
   <div align="center">
 <div class="container">
  <div class="row">
  <div class="panel panel-default"> 
<table >  
<tr><th class="col-xs-1">Train No</th><th class="col-xs-1">Train Name</th><th class="col-xs-1">Source</th><th class="col-xs-1">Departure</th><th class="col-xs-1">Destination</th><th class="col-xs-1">Arrival</th><th class="col-xs-1">Availability</th><th class="col-xs-1">Status</th><th class="col-xs-1">booking</th></tr>  
   <c:forEach var="train" items="${train}">   
   <tr>  
   <td class="col-xs-1">${train.trainno}</td>  
   <td class="col-xs-1">${train.trainname}</td>  
   <td class="col-xs-1">${train.source}</td>  
   <td class="col-xs-1">${train.departure}</td>
   <td class="col-xs-1">${train.destination}</td>
   <td class="col-xs-1">${train.arrival}</td>
   <td class="col-xs-1">${train.seats}</td>
   <c:set var="total" value="${train.capacity }" />
   <c:set var="seats" value="${train.seats }" />
   
   <%
   	String res="";
  	 Object ob1 = pageContext.getAttribute("total");
  	 Object ob2 = pageContext.getAttribute("seats");
    double t =(Integer)ob1;
    double s =(Integer)ob2;
  	 double x=0.95*t;
   	double c= t-x;
   	if(s<=c){
	   res="Almost 95% full";
   }
   	request.setAttribute("res",res);
   %>
   
   <td class="col-xs-1">${res}</td>
   <td><a href="booking/${train.trainno}">Book Tickets</a></td>
   </tr>  
   </c:forEach>  
   </table> 
   </div></div></div></div>
</body>
</html>