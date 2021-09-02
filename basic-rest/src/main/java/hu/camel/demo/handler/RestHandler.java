package hu.camel.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class RestHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(RestHandler.class);

    public String handleGetOrderList(final String id ) {
        LOGGER.info("BEGIN handleGetOrderList with id: {}", id);


        LOGGER.info("END handleGetOrderList");

        return "order list for id: " + id;
    }


}
