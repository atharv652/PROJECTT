package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/addtocart")
public class AddToCart extends HttpServlet {
private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int sp=Integer.parseInt(request.getParameter("SelectedProducts"));
		
		HttpSession session=request.getSession();
		List<Integer>products=(List<Integer>)session.getAttribute("cart");
		
		if(products==null)
		{
			products=new ArrayList<>();
		}
		products.add(sp);
		session.setAttribute("cart", products);
		
		out.print("Selected products "+sp+" are added to cart");
		out.print("</br>'There are "+products.size()+" items in your cart'");
		
		out.print("</br><a href='viewcart'>View Cart </a>");
		out.print("<br/><a href='home'> Home </a>");
	}

}
