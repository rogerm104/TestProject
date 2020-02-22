/**
 * 
 */
package com.roger.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;

/**
 * @File ServiceLocator.java
 * @author msusanta
 * @description This class is loaded when Tomcat starts
 * It registers the Connection pool so that the connections are available 
 * to the application.Uses the proxool API.
 *
 */
public class ServiceLocator 
{
	//Log4j
	private final Logger LOG;
	//ServiceLocator instance
	private static ServiceLocator serviceLocator; 
	
	//private constructor to create the connection pool
	private ServiceLocator()
	{
		//Initialize the logger.
		LOG = Logger.getLogger(this.getClass());
	}
	
	/**
	 * Since the ServiceLocator follows the Singleton pattern, it has a public
	 * method which returns the instance of this class, thereby encapsulating
	 * the instance creation mechanism.
	 * 
	 * @return ServiceLocator the singleton instance
	 */
	public static synchronized ServiceLocator getInstance() 
	{
		if (null == serviceLocator) {
			serviceLocator = new ServiceLocator(); //create a new object of serviceLocator
		}
		return serviceLocator;
	}
	
	/**
	 * Creates the connection pooling through the Proxool API
	 */
	public void createPool()
	{
		try 
		{
			//calling the xml file with the XML configurator 
			//The false means non-validating 
			JAXPConfigurator.configure(ApplicationConstants.APP_DIRPATH+"//WEB-INF//"+ApplicationConstants.PROXOOL_XML_FILE, false);
		} catch (Exception e) 
		{
			LOG.error("Error configuring the proxool xml file",e.getCause());
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * @description Gets the connection object from the proxool API
	 * @return the connection
	 */
	public Connection getConnection()
	{
		Connection connection = null;
		try 
		{
			//picking the connection using proxool API
			connection = DriverManager.getConnection(ApplicationConstants.PROXOOL_XML_URL);
		} 
		catch (SQLException e) 
		{	
			LOG.error("Error getting connection",e.getCause());
			e.printStackTrace();
		}
		//return the connection
		return connection;
	}
	
	/**
	 * @description closes the connection
	 */
	public void closeConnection(Connection connection)
	{
		try 
		{
			//Check to see we actually got a connection before we close it
			if(null!=connection)
				connection.close();
		}
		catch (SQLException e) 
		{
			LOG.error("Problem closing connection", e);
		}
	}
}
