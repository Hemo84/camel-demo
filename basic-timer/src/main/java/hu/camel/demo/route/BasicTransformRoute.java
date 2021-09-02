package hu.camel.demo.route;

import hu.camel.demo.handler.ShowTime;
import org.apache.camel.Predicate;
import org.apache.camel.builder.PredicateBuilder;
import org.apache.camel.builder.RouteBuilder;

import java.time.LocalDateTime;

public class BasicTransformRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        Predicate testComplexPredicate = PredicateBuilder.or(header("firedTime").isNotNull(), simple(" ${header.firedTime != ''}"));

        from("timer:fiveSecondTimer?period=5s")
            .transform().constant("Actual time: " + LocalDateTime.now())
            .log("Actual time: " + LocalDateTime.now())
                .bean(ShowTime.class, "showMeTheTime")
        .to("mock:end");



    }
}
