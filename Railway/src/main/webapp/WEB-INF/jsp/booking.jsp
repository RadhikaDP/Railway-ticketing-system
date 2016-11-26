<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib  uri="http://www.springframework.org/tags" prefix="spring"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.io.*,java.util.*,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><jsp:include page="/WEB-INF/jsp/home.jsp"></jsp:include> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Ticket</title>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
        <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/dropdownmenue.css" />
    </head>
    <body >
 
<center>    
  <table border="1" width="30%" height="30%">
  <tr><th><font color='#D18603'>S. No.</font></th>
  <th><font color='#D18603'>Name</font></th>
  <th><font color='#D18603'>Age</font></th>
  <th><font color='#D18603'>Gender</font></th>
  <th><font color='#D18603'>Berth Preference</font></th>

  </tr><form:form action="/booking/${train.trainno}" method="post" modelAttribute="passenger"  >
  

<tr>
<td><b><font color='#663300'>1</font></b></td>
<td><b><font color='#663300'><form:input type="text" name="name1" path="Name"/></font></b></td>
<td><b><font color='#663300'><form:input type="text" name="age1" path="Age"/></font></b></td>
<td><b><font color='#663300'><form:select name="gender1"  path="gender">
<option value="select">Select</option>
<option value="male">Male</option>
<option value="female">Female</option>
</form:select></font></b></td>
<td><b><font color='#663300'><form:select name="berth1"  path="berth">
<option value="no_preference">No Preference</option>
<option value="lower">Lower</option>
<option value="middle">Middle</option>
<option value="upper">Upper</option>
<option value="side_lower">Side Lower</option>
<option value="side_upper">Side Upper</option>
</form:select></font></b></td>

<!-- 
</tr>
<tr>
<td><b><font color='#663300'>2</font></b></td>
<td><b><font color='#663300'><input type="text" name="name2" /></font></b></td>
<td><b><font color='#663300'><input type="text" name="age2" /></font></b></td>
<td><b><font color='#663300'><select name="gender2">
<option value="select">Select</option>
<option value="male">Male</option>
<option value="female">Female</option>
</select></font></b></td>
<td><b><font color='#663300'><select name="berth2">
<option value="no_preference">No Preference</option>
<option value="lower">Lower</option>
<option value="middle">Middle</option>
<option value="upper">Upper</option>
<option value="side_lower">Side Lower</option>
<option value="side_upper">Side Upper</option>
</select></font></b></td>

</tr>
<tr>
<td><b><font color='#663300'>3</font></b></td>
<td><b><font color='#663300'><input type="text" name="name3" /></font></b></td>
<td><b><font color='#663300'><input type="text" name="age3" /></font></b></td>
<td><b><font color='#663300'><select name="gender3">
<option value="select">Select</option>
<option value="male">Male</option>
<option value="female">Female</option>
</select></font></b></td>
<td><b><font color='#663300'><select name="berth3">
<option value="no_preference">No Preference</option>
<option value="lower">Lower</option>
<option value="middle">Middle</option>
<option value="upper">Upper</option>
<option value="side_lower">Side Lower</option>
<option value="side_upper">Side Upper</option>
</select></font></b></td>


</tr>
<tr>
<td><b><font color='#663300'>4</font></b></td>
<td><b><font color='#663300'><input type="text" name="name4" /></font></b></td>
<td><b><font color='#663300'><input type="text" name="age4" /></font></b></td>
<td><b><font color='#663300'><select name="gender4">
<option value="select">Select</option>
<option value="male">Male</option>
<option value="female">Female</option>
</select></font></b></td>
<td><b><font color='#663300'><select name="berth4">
<option value="no_preference">No Preference</option>
<option value="lower">Lower</option>
<option value="middle">Middle</option>
<option value="upper">Upper</option>
<option value="side_lower">Side Lower</option>
<option value="side_upper">Side Upper</option>
</select></font></b></td>


</tr>
<tr>
<td><b><font color='#663300'>5</font></b></td>
<td><b><font color='#663300'><input type="text" name="name5" /></font></b></td>
<td><b><font color='#663300'><input type="text" name="age5" /></font></b></td>
<td><b><font color='#663300'><select name="gender5">
<option value="select">Select</option>
<option value="male">Male</option>
<option value="female">Female</option>
</select></font></b></td>
<td><b><font color='#663300'><select name="berth5">
<option value="no_preference">No Preference</option>
<option value="lower">Lower</option>
<option value="middle">Middle</option>
<option value="upper">Upper</option>
<option value="side_lower">Side Lower</option>
<option value="side_upper">Side Upper</option>
</select></font></b></td>


</tr>
<tr>
<td><b><font color='#663300'>6</font></b></td>
<td><b><font color='#663300'><input type="text" name="name6" /></font></b></td>
<td><b><font color='#663300'><input type="text" name="age6" /></font></b></td>
<td><b><font color='#663300'><select name="gender6">
<option value="select">Select</option>
<option value="male">Male</option>
<option value="female">Female</option>
</select></font></b></td>
<td><b><font color='#663300'><select name="berth6">
<option value="no_preference">No Preference</option>
<option value="lower">Lower</option>
<option value="middle">Middle</option>
<option value="upper">Upper</option>
<option value="side_lower">Side Lower</option>
<option value="side_upper">Side Upper</option>
</select></font></b></td>


</tr> -->
     <tr>
                        <td colspan="10"><input type="submit" value="Submit" />  <input type="reset" value="Reset" />   </td>
                    
                    </tr>      
                  
        </form:form>
        </table>
        
        <br><br>
         </center>
    </body>
</html>