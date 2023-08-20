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


@WebServlet("/getProducts")
public class GetProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
		
		public void init(ServletConfig config) throws ServletException {
			con=(Connection)config.getServletContext().getAttribute("jdbccon");
		}

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();
			int sid=Integer.parseInt(request.getParameter("sid"));
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			try
			{
				ps=con.prepareStatement("Select * from stock where sid=?");
				ps.setInt(1, sid);
				rs=ps.executeQuery();
				out.print("<form action='addtocart' method='get'>");
				out.print("select Blood :");
				out.print("<select name=SelectedProducts>");
				out.print("<option> Select Blood </option>");
				while(rs.next())
				{
					out.print("<option value='"+rs.getInt(2)+"'>"+rs.getString(6)+" "+rs.getFloat(8)+"</option>");
				}
				out.print("</select>");
				out.print("</br>");
				out.print("<input type='submit' value='Add To Cart'/>");
				out.print("</form>");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					rs.close();
					ps.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doGet(request, response);
		}

}
