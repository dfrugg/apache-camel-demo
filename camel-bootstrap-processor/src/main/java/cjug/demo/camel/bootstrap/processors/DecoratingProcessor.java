/**
 * 
 */
package cjug.demo.camel.bootstrap.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * @author dfr2
 *
 */
@Component(DecoratingProcessor.ID)
public class DecoratingProcessor implements Processor {
	
	public static final String ID = "decoratingProcessor";

	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	public void process(Exchange exchange) throws Exception {
		String body = exchange.getIn().getBody(String.class);
		exchange.getIn().setBody("Decorating: " + body);
	}
}
