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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
 <div align="center">
 <h2 > LOGIN</h2>
 <br></br>
        <form:form action="login" method="post" modelAttribute="login"  >
            <table border="0">          
                <tr>                   
                    <td><form:input path="userid" name="uname" placeholder="User Name"  /></td>
                    <td align="left"><form:errors path="userid" /></td>
                </tr>
                <tr>                 
                    <td><form:password path="password" name="upass" placeholder="Password" /></td>
                    <td align="left"><form:errors path="password"/></td>
                </tr>                      
                     <tr>
                    <td colspan="2" align="center"><input type="submit" value="login" /></td>
                </tr>
            </table>
            <p>New here ?<a href="registration"> Sign up</a></p>
        </form:form>
    </div>
    <p><a href="viewtrains">view trains </a></p>
</body>
</html>