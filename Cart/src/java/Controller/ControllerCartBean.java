/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import cart.CartBean;
import cart.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;

/**
 *
 * @author Admin
 */
public class ControllerCartBean extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            if (action.equals("Add to cart")) {
                HttpSession session = request.getSession(true);
                CartBean shop = (CartBean) session.getAttribute("SHOP");
                if (shop == null) {
                    shop = new CartBean();
                }
                String code = request.getParameter("txtCode");
                String name = request.getParameter("txtName");
                String pri = request.getParameter("txtPrice");
                float fpri = Float.parseFloat(pri);
                Product s = new Product(code, name, fpri);
                ProductDTO sp = new ProductDTO(s);
                shop.AddSanPham(sp);
                session.setAttribute("SHOP", shop);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else if (action.equals("View Cart")) {
                RequestDispatcher rd = request.getRequestDispatcher("showcart.jsp");
                rd.forward(request, response);
            } else if (action.equals("AddMore")) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);

            } else if (action.equals("Remove")) {
                String[] list = request.getParameterValues("rmv");
                if (list != null) {
                    HttpSession session = request.getSession();
                    if (session != null) {

                        CartBean shop = (CartBean) session.getAttribute("SHOP");
                        for (int i = 0; i < list.length; i++) {
                            shop.removeSanPham(list[i]);

                        }
                        session.setAttribute("SHOP", shop);

                    }
                }
            }
            String url = "ControllerCartBean?action= View Cart";
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            out.close();
        }}
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

     
         
            
            
        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    
}

