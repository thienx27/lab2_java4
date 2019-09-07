/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchAccount extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>SearchAccount<title><head>");
            out.println("<body><h1>ket qua tr dien thaoi theo yeu cau:<h1>");
            out.println("<table border=1 cellPadding=1 cellSpacing=1>");
            String tenthưbao = request.getParameter("txtthuebao");

            String newSQL = "select *from CUSTOMER";
            if (tenthưbao != null && tenthưbao.length() != 0) {
                newSQL = newSQL + "where  TenThueBao like '&" + tenthưbao + "&'";
            }
            String constr = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QLDienThoai ";
            java.sql.Statement stmt = null;
            ResultSet rs = null;
            try {
                Connection con = null;
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(constr, "sa", "123");
                stmt = con.createStatement();
                rs = stmt.executeQuery(newSQL);
                out.println("<br><th>sothutu</th><th>tenthuebao</th><th>sodienthoai</th><th>diachi</th</tr>\n");
                if (rs != null) {
                    for (int i = 1; rs.next();) {
                        out.println("<tr>" + "<td>" + i + "</td>"
                                + "<td>" + rs.getString(2) + "</td>"
                                + "<td>" + rs.getString(3) + "</td>"
                                + "<td>" + rs.getString(4) + "</td></tr\n");

                    }
                }
                out.println("</table>");
                rs.close();
                stmt.close();

            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error:" + e);

            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
