<%-- 
    Document   : index.jsp
    Created on : Jul 15, 2019, 1:58:33 PM
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
        <h1>Danh bạ điện thoai!</h1>
        <form action="SearchAccount">
            Nhập tên thuê bao:<input type="text"name="txtThuebao" value=""><br></br>
            Nhập số điện thoai:<input type="text" name="txtSoDt" value=""><br></br>
            địa chỉ: <input type="text" name="txtDiachi" value=""><br><br>
            <input type="submit" name="Submit" value="Tra cuu">
        </form>
    </body>
</html>
