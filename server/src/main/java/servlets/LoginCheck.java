package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Registration;


@WebServlet("/loginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello");
		con=(Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("password");
		
		PreparedStatement ps;
		ResultSet rs=null;
		
		try
		{
			ps=con.prepareStatement("Select * from login_table where uid=? and password=?");
			ps.setString(6, uid);
			ps.setString(7, pwd);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				HttpSession session= request.getSession();
				Registration u=new Registration(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9));
				session.setAttribute("loginuser", u);
				RequestDispatcher rd=request.getRequestDispatcher("/home");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("/Proj/Login.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
