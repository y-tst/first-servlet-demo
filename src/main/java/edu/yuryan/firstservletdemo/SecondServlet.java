package edu.yuryan.firstservletdemo;

import edu.yuryan.firstservletdemo.logic.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "secondServlet", value = "/second-servlet")
public class SecondServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Second Servlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String surName = request.getParameter("surName");

        Integer count = (Integer) session.getAttribute("count");
        Cart cart = (Cart) session.getAttribute("cart");

        String product = request.getParameter("product");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (cart == null) {
            cart = new Cart();
            cart.setProduct(product);
            cart.setQuantity(quantity);
        }

        session.setAttribute("cart", cart);

        if (count == null) {
            session.setAttribute("count", 0);
            count = 1;
        } else {
            session.setAttribute("count", count + 1);
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h3>" + "Hello " + name + " " + surName +  "</h3>");

        out.println("</br>" + "Your count is: " + count + "<h2>");
        out.println("</body></html>");

//        response.sendRedirect("https://www.speedtest.net");

        getServletContext().getRequestDispatcher("/showCart.jsp").forward(request, response);
    }

    public void destroy() {
    }
}