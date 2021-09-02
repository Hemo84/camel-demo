package hu.camel.demo;

import hu.camel.demo.route.BasicChoiceRoute;
import org.apache.camel.impl.DefaultCamelContext;

public class MainApp {

    public static void main(String[] args) throws Exception {
        DefaultCamelContext camelContext = new DefaultCamelContext();
        camelContext.setName("choiceCamelContext");
        camelContext.addRoutes(new BasicChoiceRoute());
        camelContext.start();
    }

}
