### Practice for Lesson 13: Concurrency
in these practices, you will use the java.util.concurrent package and sub-packages of the Java programming language

###Practice 13-1: Summary Level: Using the java.util.concurrent Package

CountRunnable.java
``` java
package com.example;

public class CountRunnable implements Runnable{

    /*** NetBeans shortcut: Add the field first, then right-click and select Insert Code ***/
    final int count;
    final String threadName;

    // Setup Constructor to initialize variables
    public CountRunnable(int count, String threadName) {
        this.count = count;
        this.threadName = threadName;
    }

    public void run() {
        // Count with for loop
        for (int i = 1; i   <= count ; i++) {
            System.out.println("Thread " + threadName
                    + ": " + i);
        }
    }
}
```

Main.java
``` java
package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) {
    // Setup Executor
    ExecutorService es = Executors.newCachedThreadPool();
    
    // Submit Runnable
    es.submit(new CountRunnable(20,"A"));
    es.submit(new CountRunnable(20,"B"));
    es.submit(new CountRunnable(20,"C"));
    
    // Showndown ExectuorService
    es.shutdown();
  }
}
```

### Practice 13-2: Summary Level: Creating a Network Client using the java,util.concurrent Package
#### before change
Project: ExecutorService13-02Prac
``` console
antw@Mac-mini ExecutorService13-02Prac % ls -R
build		manifest.mf	src
build.xml	nbproject	test

./build:
classes

./build/classes:
com

./build/classes/com:
example

./build/classes/com/example:
client	server

./build/classes/com/example/client:
NetworkClientMain.class	RequestResponse.class

./build/classes/com/example/server:
NetworkServerMain.class	PriceRangeServer.class

./nbproject:
build-impl.xml		private			project.xml
genfiles.properties	project.properties

./nbproject/private:
private.properties

./src:
com

./src/com:
example

./src/com/example:
client	server

./src/com/example/client:
NetworkClientMain.java	RequestResponse.java

./src/com/example/server:
NetworkServerMain.java	PriceRangeServer.java

./test:
antw@Mac-mini ExecutorService13-02Prac % 
```
com.example.client/NetworkClientMain.js
``` java
package com.example.client;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NetworkClientMain {

    public static void main(String[] args) {
        String host = "localhost";
        for (int port = 10000; port < 10010; port++) {
            RequestResponse lookup = new RequestResponse(host, port);
            try (Socket sock = new Socket(lookup.host, lookup.port);
                    Scanner scanner = new Scanner(sock.getInputStream());) {
                lookup.response = scanner.next();
                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
            } catch (NoSuchElementException | IOException ex) {
                System.out.println("Error talking to " + host + ":" + port);
            }
        }
    }
}

```
com.example.client/RequestResponse.js
``` java
package com.example.client;

import java.util.Objects;

public class RequestResponse {

    public String host; //request
    public int port; //request
    public String response; //response

    public RequestResponse(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RequestResponse) {
            RequestResponse lookup = (RequestResponse) obj;
            if (host.equals(lookup.host) && port == lookup.port) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.host);
        hash = 97 * hash + this.port;
        return hash;
    }
}
```
com.example.server/NetworkServerMain.js
``` java
package com.example.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkServerMain {

    public static void main(String[] args) {
        ExecutorService exSrv = Executors.newCachedThreadPool();
        List<Runnable> runners = new ArrayList<>();
        for (int port = 10000; port < 10010; port++) {
            Runnable r;
            try {
                r = new PriceRangeServer(port, 20, 110);
                runners.add(r);
            } catch (IOException ex) {
                System.out.println("Port " + port + " already in use");
            }
        }
        for (Runnable r : runners) {
            exSrv.execute(r);
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        System.out.println("Press enter to quit...");
        try {
            System.in.read();
        } catch (IOException ex) {
        }
        System.out.println("Quiting...");
        exSrv.shutdownNow();
    }

}

```
com.example.server/PriceRangeServer.js
``` java

package com.example.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class PriceRangeServer implements Runnable {
    
    private String price;
    private ServerSocket ss;

    //low inclusive
    //high exclusive
    public PriceRangeServer(int port, int low, int high) throws IOException {
        ss = new ServerSocket(port);
        ss.setSoTimeout(250);
        double d = Math.random() * (high - low) + low;
        price = String.format("%.2f", d);
    }

    public void accept() throws IOException {
        System.out.println("Accepting connections on port " + ss.getLocalPort());
        while (!Thread.interrupted()) {
            try (Socket sock = ss.accept();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    return;
                }
                bw.write(price);
            } catch (SocketTimeoutException ste) {
                //timeout every .25 seconds to see if interrupted
            }
        }
        System.out.println("Done accepting");
    }

    @Override
    public void run() {
        try {
            accept();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}

```
