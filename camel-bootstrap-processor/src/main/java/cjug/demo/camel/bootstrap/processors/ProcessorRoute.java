/**
 * 
 */
package cjug.demo.camel.bootstrap.processors;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A bootstrapped route to move messages from the topic to a log.
 * 
 * @author dfr2
 */
@Component()
public class ProcessorRoute extends RouteBuilder {

	/* (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {
		final String header = "myHeader";
		final String headerValue = "true";
		
		from("activemq:topic:t.my.topic")
			.setHeader(header).simple(headerValue)
			//.processRef(DecoratingProcessor.ID)
			.processRef(OverwritingProcessor.ID)
			.choice()
				.when(header(header).isEqualTo(headerValue))
					.to("log:cjug.demo.camel.routes?showExchangeId=true&showHeaders=true")
			.end();
	}
}
