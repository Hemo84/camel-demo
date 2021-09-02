package hu.camel.demo.route;

import hu.camel.demo.handler.EmptyValueProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class BasicChoiceRoute extends RouteBuilder {

    /*More information: https://camel.apache.org/components/3.4.x/eips/choice-eip.html*/
    /*use .filter is also possible for one condition*/

    private final static String ORDER_ID = "OrderId";

    @Override
    public void configure() throws Exception {
        from("file:from?include=transaction.*xml&noop=true&delete=false")
            .choice()
                .when(xpath("/transaction/transactionValue > 500"))
                    .setHeader(ORDER_ID, xpath("/transaction/id/text()",String.class))
                    .log("Forwarded to high priority transactions. Body: ${body} Header: ${headers}")
                    .to("file:to/urgent")
                .when(xpath("/transaction/transactionValue <= 500"))
                    .setHeader(ORDER_ID, xpath("/transaction/id/text()",String.class))
                    .log("Forwarded to low priority transactions. Body: ${body} Header: ${headers}")
                    .to("file:to/not_urgent")
                .otherwise()
                    .log(LoggingLevel.ERROR, "Transaction has no value, further investigation needed. Body: ${body} Header: ${headers}")
                    .process(new EmptyValueProcessor())
                    .to("file:to/")
            .endChoice();
    }
}
