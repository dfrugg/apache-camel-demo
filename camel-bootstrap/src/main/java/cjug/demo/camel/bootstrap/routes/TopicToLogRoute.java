/**
 * 
 */
package cjug.demo.camel.bootstrap.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A bootstrapped route to move messages from the topic to a log.
 * 
 * @author dfr2
 */
@Component("bootstrappedTopicToLogRoute")
public class TopicToLogRoute extends RouteBuilder {

	/* (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {
		from("activemq:topic:t.my.topic")
			.to("log:cjug.demo.camel.routes?showExchangeId=true&showHeaders=true");
	}
}
