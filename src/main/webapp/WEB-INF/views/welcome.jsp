<%-- 
    Document   : welcome
    Created on : May 17, 2017, 11:49:38 AM
    Author     : Saiteja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>BOOK LIST</h1>

        <table>
            <tr>
                <th>ID</th><th>TITLE</th><th>PRICE</th>
            </tr>
            <c:forEach var="i" begin="0" end="${booklist.size()}">
                <tr>
                    <td>
                        <c:out value="${booklist[i].bookId}"></c:out>
                        </td>
                        <td>
                        <c:out value="${booklist[i].title}"></c:out>
                        </td>
                        <td>
                        <c:out value="${booklist[i].price}"></c:out>
                        </td>
                    </tr>
            </c:forEach>
        </table>
    </body>
</html>
