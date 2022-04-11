package log4J;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/*Log levels
DEBUG 
INFO 
WARN 
ERROR 
FATAL
  */
public class LogginDemo {

	public static void main(String[] args) {
		
		Logger logger=Logger.getLogger("LogginDemo"); // need to pass class name as parameter
		PropertyConfigurator.configure("Log4j.properties");
		
		logger.setLevel(Level.DEBUG); //setting level
		
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warning message");
		logger.error("This is error message");
		logger.fatal("This is critical message");
	}

}
