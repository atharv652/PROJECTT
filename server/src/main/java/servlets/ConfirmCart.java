package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Registration;


@WebServlet("/confirmCart")
public class ConfirmCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		con=(Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		Registration u=(Registration)session.getAttribute("loginuser");
		
		String uid=u.getUid();
		out.print(uid+"</br>");
		java.sql.Timestamp ts= new java.sql.Timestamp(new java.util.Date().getTime());
		out.print("</br>"+ts);
		float tprice=(Float)session.getAttribute("tprice");
		out.print(tprice);
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try
		{
			ps=con.prepareStatement("insert into shopping(user_id, shoppingDate, totalprice) values(?,?,?");
			
			ps.setString(1, uid);
			ps.setTimestamp(2, ts);
			ps.setFloat(3, tprice);
			
			out.print("<p> Order Is Confirmed </p>");
			out.print("<p>You will recieve message on "+u.getContact()+"before order delivery"+"</p>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}
}
