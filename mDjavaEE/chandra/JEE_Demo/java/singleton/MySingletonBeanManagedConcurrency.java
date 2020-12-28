package singleton;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup    // When you start the server or deploy this application this bean is loaded 
@Singleton /// Specifying the type of Bean
public class MySingletonBeanManagedConcurrency {

    volatile StringBuilder builder;

    @PostConstruct
    private void postConstruct() {
        builder = new StringBuilder();
        System.out.println("MS_BMC : postConstruct");
    }

    public String readSomething(String bid) {
        try {
            for (int i = 0; i <= 10; i++) {
                Thread.sleep(100);
                System.out.println(bid + " : Read Op : " + new Date());
            }
        } catch (Exception e) {
            System.out.println(" Thread Interrupted ");
        }
        return "current timestamp: " + new Date();
    }

    public String writeSomething(String something) {

        synchronized (builder) {
            try {
                Thread.sleep(100);
                System.out.println(" : Write Op : " + new Date());

            } catch (Exception e) {
                System.out.println(" Thread Interrupted ");
            }
            builder.append(something);
        }
        return builder.toString() + " : " + new Date();
    }
}
