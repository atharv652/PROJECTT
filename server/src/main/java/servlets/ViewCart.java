package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/viewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		con=(Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		List<Integer>sps=(List<Integer>)session.getAttribute("cart");
		
		if(sps==null)
		{
			out.print("No Products In The Cart!!!");
		}
		else
		{
			out.print("<table border=1>");
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			try
			{
				ps=con.prepareStatement("select * from stock where sid=?");
				int cnt=0;
				float tprice=0;
				for(int n : sps)
				{
					ps.setInt(1,n);
					rs=ps.executeQuery();
					if(rs.next())
					{
						out.print("<tr>");
						out.print("<td>"+(++cnt)+"</td>");
						out.print("<td>"+rs.getString(2)+"</td>");
						out.print("<td>"+rs.getString(4)+"</td>");
						out.print("<td> <a href='deleteItem?pid="+rs.getInt(1)+"'>Delete</a> </td>");
						out.print("</tr>");
						tprice+=Float.parseFloat(rs.getString(4));
					}
				}
				session.setAttribute("tprice", tprice);
				out.print("<table border=1>");
				out.print("<tr>");
				out.print("<td colspan='2'>TOTAL PRICE</td>");
				out.print("<td>"+tprice+"</td>");
				out.print("<tr>");
				out.print("</table>");
				out.print("</br><a href='confirmCart'>Confirm Cart</a>");
				out.print("<br/><a href='home'> Home </a>");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
