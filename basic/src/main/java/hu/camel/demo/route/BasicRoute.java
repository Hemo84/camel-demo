package hu.camel.demo.route;

import org.apache.camel.builder.RouteBuilder;

public class BasicRoute extends RouteBuilder {

    /*More information: https://camel.apache.org/components/latest/file-component.html*/

    @Override
    public void configure() throws Exception {
        from("file:basic/from?include=.*test&noop=true").to("file:basic/to");
    }
}
