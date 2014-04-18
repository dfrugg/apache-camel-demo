/**
 * 
 */
package cjug.demo.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Creates a route that recieved messages sent to direct:toTopic and pushes them to the t.my.topic topic in activemq.
 * @author dfr2
 */
@Component
public class TimedTimeToDirectRoute extends RouteBuilder {
	

	/* (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {
		from("quartz://myTimer?trigger.repeatInterval=5000&trigger.repeatCount=9")
			.to("bean:myService?method=getTime")
			.to("seda:toTopic?multipleConsumers=true")
			.log("Sent message to direct:myTopic");
	}
}
