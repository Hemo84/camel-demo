package hu.camel.demo;

import hu.camel.demo.route.BasicRestRoute;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {

    public static void main(String[] args) throws Exception {
        DefaultCamelContext camelContext = new DefaultCamelContext();
        camelContext.setName("transformCamelContext");
        camelContext.addRoutes(new BasicRestRoute());
        camelContext.start();
    }

}
