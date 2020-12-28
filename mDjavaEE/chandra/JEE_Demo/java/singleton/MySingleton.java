/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class MySingleton {

    StringBuilder builder;

    @PostConstruct
    private void postConstruct() {
        System.out.println("MS_CMC postConstruct");
        builder = new StringBuilder();
    }

    @Lock(LockType.READ)
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

    @Lock(LockType.WRITE)
    public String writeSomething(String something) {
        builder.append(something);
        try {
            Thread.sleep(100);
               System.out.println(" : Write  Op : " + new Date());
        } catch (Exception e) {
            System.out.println(" Thread Interrupted ");
        }

        return builder.toString() + " : " + new Date();
    }
}
