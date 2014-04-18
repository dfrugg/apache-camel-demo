/**
 * 
 */
package cjug.demo.camel.services;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.stereotype.Service;

/**
 * @author dfr2
 *
 */
@Service("myService")
public class DefaultMyService implements MyService{

	/*
	 * (non-Javadoc)
	 * @see cjug.demo.camel.services.MyService#getTime()
	 */
	public String getTime(){
		return new StringBuilder("The current time is ")
			.append(DateTimeFormat.fullTime().print(new DateTime())).toString();
	}
}
