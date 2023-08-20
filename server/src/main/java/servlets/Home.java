package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/home")
public class Home extends HttpServlet {
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
			
			Statement st=null;
			ResultSet rs=null;
			
			try
			{
				st=con.createStatement();
				rs=st.executeQuery("select * from stock");
				
				while(rs.next())
				{
					out.println("<a href='getProducts?sid="+rs.getInt(1)+"'>"+rs.getString(2)+"</a><br/>");
				}
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
					st.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}

}
