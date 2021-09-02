package hu.camel.demo;

import hu.camel.demo.route.BasicRoute;
import org.apache.camel.main.Main;

public class MainApp {

    public static void main(String[] args) throws Exception {
        Main camelMain = new Main();
        camelMain.configure().addRoutesBuilder(new BasicRoute());
        camelMain.run(args);
        camelMain.shutdown();
    }

}
