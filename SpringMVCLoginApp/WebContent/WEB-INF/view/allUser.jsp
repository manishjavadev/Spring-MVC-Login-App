<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td>ID</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td>CONTACT</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td>MAIL</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td>NAME</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td>PASSWORD</td></tr>
<c:forEach var="listVar" items="${allUserData}">
<tr>
   <td> <c:out value="${listVar.id}"/></td>
   <td> <c:out value="${listVar.contact}"/></td>
    <td><c:out value="${listVar.mail}"/></td>
    <td><c:out value="${listVar.name}"/></td>
    <td><c:out value="${listVar.password}"/></td>
    <td><form action="deleteRecord" method="Post">
    <input type="text" value="${listVar.mail}" name="mail">
    <input type="submit" value="Delete Record">
    </form></td>
    </tr>
   
</c:forEach>
 </table>
</body>
</html>