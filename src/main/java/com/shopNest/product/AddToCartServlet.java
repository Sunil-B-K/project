package com.shopNest.product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import com.shopNest.dbHandler.DataFetcher;
@WebServlet("/add-to-cart")

public class AddToCartServlet extends HttpServlet{
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = DataFetcher.getProductById(productId);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        cart.addItem(product);
        response.sendRedirect("cart.jsp");
    }

}
