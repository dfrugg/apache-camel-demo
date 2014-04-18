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
@Component(OverwritingProcessor.ID)
public class OverwritingProcessor implements Processor {
	
	public static final String ID = "overwritingProcessor";

	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	public void process(Exchange exchange) throws Exception {
		String body = exchange.getIn().getBody(String.class);
		exchange.getOut().setBody("Overwriting: " + body);
	}
}
