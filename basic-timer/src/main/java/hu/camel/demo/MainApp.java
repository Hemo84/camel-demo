package hu.camel.demo;

import hu.camel.demo.route.BasicTransformRoute;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {

    public static void main(String[] args) throws Exception {
        DefaultCamelContext camelContext = new DefaultCamelContext();
        camelContext.setName("transformCamelContext");
        camelContext.addRoutes(new BasicTransformRoute());
        camelContext.start();
    }

}
