<%-- 
    Document   : index
    Created on : Jul 15, 2019, 5:13:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Products</h1>
        <table border="1">
            <tr>
                <td>Ma SP</td>
                <td>Tên SP</td>
                <td>Gia</td>
            </tr>
           
        </table>
        <form action="ControllerCartBean">
            <input type="submit" value="View Cart" name="action"/>
        </form>
    </body>
</html>
