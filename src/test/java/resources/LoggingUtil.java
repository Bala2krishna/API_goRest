package resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import io.restassured.filter.Filter;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class LoggingUtil {
	
	
	
	
	private static final String LOGGING_LEVEL="HIGH";
	
	public static List<Filter> getLoggingFilters() throws IOException{
		
		
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		
		List<Filter> restAssuredFilters =new ArrayList();
		
		if(LOGGING_LEVEL==null || LOGGING_LEVEL=="LOW") {
			
			restAssuredFilters.add(new ErrorLoggingFilter());
			
		}else {
			
			restAssuredFilters.add(new RequestLoggingFilter().logRequestTo(log));
			restAssuredFilters.add(new ResponseLoggingFilter().logResponseTo(log));
			
		}
		
		return restAssuredFilters;
		
	}

}
