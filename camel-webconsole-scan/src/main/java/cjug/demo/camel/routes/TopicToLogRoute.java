/**
 * 
 */
package cjug.demo.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Creates a route that recieved messages sent to direct:toTopic and pushes them to the t.my.topic topic in ActiveMQ.
 * @author dfr2
 */
@Component
public class TopicToLogRoute extends RouteBuilder {
	

	/* (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {
		from("activemq:topic:t.my.topic")
			.to("log:cjug.demo.camel.routes");
	}
}
