
package others;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Others {

    public static int i = 10;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(" Before Sleep ::: " + i + " ::: " + name);
                i++;
                TimeUnit.SECONDS.sleep(1);
                i++;
                System.out.println(" After Sleep :::  " + i + " ::: " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread.start();
        thread1.start();
        thread2.start();
    }

}
