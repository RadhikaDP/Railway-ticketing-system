<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page isELIgnored="false" %>
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/dropdownmenue.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
<%
if(session.getAttribute("userid")==null){
	response.sendRedirect("/MyShopping/login");
}
%>

</script>

</head>
<body>

<nav>
 <div align="center">
<div >
			<ul class="dropdownMenu">
               
				<li><a href="#">Notifications</a>
					<ul class="droprightMenu">
						<li><a href="/MyShopping/delay">Delay Notification</a></li>					
					</ul></li>
				<li><a href="#">Reports</a>
					<ul class="droprightMenu">
						<li><a href="/MyShopping/trainreport">Train Report</a>
						
						<ul class="droprightMenu">
						  <li><a href="/MyShopping/1">1 day</a></li>
						  </ul>
						  
						  </li>
						  
						<li><a href="#">Passenger Report </a>
						<ul class="droprightMenu">
						  <li><a href="/MyShopping/more10">10 times</a> </li>
						   
						   <li><a href="/MyShopping/seniour">senior citizens </a></li>
						 
						  </ul>
						</li>		
						<li><a href="/MyShopping/histReport">History Report </a></li>					
					</ul></li>
					<li><a href="/MyShopping/logout">Logout</a></li>
				
			</ul>
			</div>
			</div>
		</nav>

</body>
</html>