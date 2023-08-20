package listeners;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener 
{ 
	
	Connection con;
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	try
        {
        	con.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	String driver=sce.getServletContext().getInitParameter("driverclass");
        String url=sce.getServletContext().getInitParameter("jdbcurl");
        String user=sce.getServletContext().getInitParameter("user");
        String password=sce.getServletContext().getInitParameter("password");
        
        try
        {
       	 Class.forName(driver);
       	 con=DriverManager.getConnection(url,user,password);
       	 sce.getServletContext().setAttribute("jdbccon",con);
       	 System.out.println("Connection Established");
        }
        catch(Exception e)
        {
       	 e.printStackTrace();
        }
    }
	
	
}
