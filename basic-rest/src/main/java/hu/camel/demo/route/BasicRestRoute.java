package hu.camel.demo.route;

import hu.camel.demo.handler.RestHandler;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;

public class BasicRestRoute extends RouteBuilder {

    /**
     * http://localhost:8900/rest/api
     * http://localhost:8900/doc/api
     *
     * */

    @Override
    public void configure()  {
        restConfiguration()
                .component("undertow").componentProperty("minThreads", "25").componentProperty("maxThreads","30")
                .bindingMode(RestBindingMode.auto)
                .port(8900)
                .contextPath("/rest/api")
                .enableCORS(true)
                .apiContextPath("/doc/api");

        rest("/orders").consumes("text/plain").produces("application/json")
                .description("Ez a leirasa az egesz resourcenak")
                .get("/{id}").outType(String.class).description("A get muvelet leirasa")
                .param().name("id").description("A get muvelet id parameterenek leirasa")
                .type(RestParamType.path)
                .endParam()
                .to("direct:handleGetOrders");

        
        from("direct:handleGetOrders")
                .log("Retrieving order total for order with id ${header.id}")//${header} *-* ${body} *-* ${id}
                .bean(RestHandler.class, "handleGetOrderList(${header.id})");
        
    }
}
