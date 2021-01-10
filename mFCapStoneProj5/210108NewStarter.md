### starter

CoC - Convention over Configuration 

### start new project >>>
* New > 
* Spring Starter Project

    * Build + Compile + Tool = Maven
    * JDK 8
    * Package - jar
    * Language - java

    * Spring Boot DeveTools
    * Finish

FirstProjectApplication.java >
remove the line in the main()

https://start.spring.io/starter.zip

#### FirstProjectApplication.java
``` java
package com.cp5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
//		SpringApplication.run(FirstProjectApplication.class, args);

			SeqGenerator sq = new SeqGenerator(); // Initialize the Object 1) Constructor
			sq.setPrefix("4477 0090 9089 "); // 2) Set Methods 
			for(int i =0; i<= 10; i++)
				System.out.println(sq.getSequence());
		}

}
```

  * New > 
  * Class File > SeqGenerator


#### SeqGenerator.java
``` java
package com.cp5;

import java.util.concurrent.atomic.AtomicInteger;

public class SeqGenerator {

	private String prefix;
	private final AtomicInteger counter = new AtomicInteger();
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getSequence() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(prefix)
		.append(counter.getAndIncrement());
		return sb.toString();
	}
	
	public SeqGenerator() {} // Zero-Arg Constructor 
	
}

```


#### SpringConfig.java
``` java
@Configuration
public class SpringConfig {
	
	@Bean
	public SeqGenerator seqGenerator() {
		SeqGenerator sq = new SeqGenerator(); // Initialize the Object 1) Constructor
		sq.setPrefix("4477 0090 9089 "); // 2) Set Methods 
		return sq;
	}

}
```
####  revised FirstProjectApplication.java
``` java
@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
//		SpringApplication.run(FirstProjectApplication.class, args);

		// Is the Spring FRAMEWORK
		ApplicationContext context =  new AnnotationConfigApplicationContext(SpringConfig.class);
		
		SeqGenerator sq = context.getBean(SeqGenerator.class);
		SeqGenerator sq1 = context.getBean(SeqGenerator.class);
		
//		for(int i =0; i<= 10; i++)
//				System.out.println(sq.getSequence());
		for(int i =0; i<= 10; i++)
			System.out.println("SQ  : " + sq.getSequence() + "\nSQ1 : " + sq1.getSequence());
		}

}
```
#### console
``` console
...
... - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
... - Creating shared instance of singleton bean 'springConfig'
... - Creating shared instance of singleton bean 'seqGenerator'
SQ  : 4477 0090 9089 0
SQ1 : 4477 0090 9089 1
SQ  : 4477 0090 9089 2
SQ1 : 4477 0090 9089 3
```

### my understanding
Require annotation to work need
*  `@Configuation` and `@Bean` as in SpringConfig.java
*  `ApplicationContext` with `AnnotationConfigApplicationContext(SpringConfig.class)`

---
