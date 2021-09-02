package hu.camel.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class ShowTime {

    private final static Logger LOGGER = LoggerFactory.getLogger(ShowTime.class);

    public void showMeTheTime() {
        LOGGER.info("Current time is: " + LocalDateTime.now());
    }


}
