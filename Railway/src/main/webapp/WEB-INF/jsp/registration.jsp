<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body >
  <div >
 <div align="center">
 <h2 > REGISTRATION</h2>
 <br></br>
        <form:form action="registration" method="post" modelAttribute="registration">
            <table border="0">
             
                <tr>
                   
                    <td><form:input path="userid" placeholder="User Id" /></td>
                     <td align="left"><form:errors path="userid" cssClass="error"/></td>
                </tr>
                
                    <tr>
                    
                    <td><form:password path="password"  placeholder="Password" /></td>
                     <td align="left"><form:errors path="password" cssClass="error"/></td>
                </tr>
                
                <tr>
                    
                    <td><form:input path="firstname"  placeholder="First Name" /></td>
                     <td align="left"><form:errors path="firstname" cssClass="error"/></td>
                </tr>
                
                    <tr>
                    
                    <td><form:input path="lastname"  placeholder="Last Name" /></td>
                     <td align="left"><form:errors path="lastname" cssClass="error"/></td>
                </tr>
                
                <tr>                  
                    <td><form:input path="email"  placeholder="E-mail" /></td>
                     <td align="left"><form:errors path="email" cssClass="error"/></td>
                </tr>
                <tr>
                    
                    <td><form:input path="phone" placeholder="Phone Number"/></td>
                     <td align="left"><form:errors path="phone" cssClass="error"/></td>
                </tr>
                <tr>
                	
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
            <p>Allready Registered ?<a href="login"> Sign In</a></p>
        </form:form>
    </div>
    </div>
</body>
</html>