package hu.camel.demo.handler;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmptyValueProcessor implements Processor {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmptyValueProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.info("EmptyValueProcessor BEGIN");
        Message inputExchange = exchange.getIn();
        inputExchange.getHeaders().entrySet().stream().forEach(e-> LOGGER.info("Key: {} - Value: {}", e.getKey(), e.getValue() ));

        Object body = inputExchange.getBody();

        LOGGER.info("BODY: " + body);

        LOGGER.info("EmptyValueProcessor END");
    }
}
