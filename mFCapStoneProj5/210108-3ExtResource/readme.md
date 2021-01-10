
Two methods to retreat resources:
* method 1 **FileSystemResource**
* method 2 **ApplicationContext** - via SpringTool, config the project with Classpath to folder

#### myApp.properties
``` console
antw@Mac-mini mFCap5 % pwd
/Users/antw/ntuc/mFCap5
antw@Mac-mini mFCap5 % ls myApp.*
myApp.properties
antw@Mac-mini mFCap5 % cat myApp.properties
empName=Samson
empAge=99
empCountry=SG

antw@Mac-mini mFCap5 % 
```

#### ExResourcesTrApplication.java
``` java
@SpringBootApplication
public class ExtResourcesTrApplication {

	public static void main(String[] args) throws Exception {

		// method 1
    Resource res = new FileSystemResource("/Users/antw/ntuc/mFCap5/myApp.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(res);
		System.out.println(" myApp.Properties == " + props);

		// method 2 thru SpringConfig and EMP
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		System.out.println( context.getBean("getEmp", Emp.class));
	}
}
```

method 2 - SpringTool
* right click on ExtResourcesTR >
* Run As >
* Run Configuration >
* Classpath > 
* User Entries > 
* Advanced 
* Add Externak Folder




#### SpringConfig.java
``` java
@Configuration 
@PropertySource("classpath:myApp.properties")
public class SpringConfig {
	
	@Value("${empName:Albert}")
	private String empName;
	
	@Value("${empAge:9}")
	private int empAge;
	
	@Value("${empCountry:MY}")
	private String empCountry;

	@Bean
	public Emp getEmp() {
		Emp e = new Emp(empName, empAge, empCountry);
		return e;
	}
}
```


#### Emp.java
+ getter, setter, constructor, toString
``` java
package com.cp5;

public class Emp {

	private String empName;
	private int empAge;
	private String empCountry;
	public String getEmpName() {
		return empName;
	}
...
...
	public Emp(String empName, int empAge, String empCountry) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.empCountry = empCountry;
	}
	@Override
	public String toString() {
		return "Emp [empName=" + empName + ", empAge=" + empAge + ", empCountry=" + empCountry + "]";
	}
}
```

#### console
``` console
 myApp.Properties == {empName=Samson, empCountry=SG, empAge=99}
17:13:20.733 [main] DEBUG org.springframework.context.annotation.AnnotationConfigApplicationContext - Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@7e0babb1
17:13:20.746 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalConfigurationAnnotationProcessor'
17:13:20.856 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerProcessor'
17:13:20.858 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.event.internalEventListenerFactory'
17:13:20.860 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalAutowiredAnnotationProcessor'
17:13:20.861 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'org.springframework.context.annotation.internalCommonAnnotationProcessor'
17:13:20.868 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'springConfig'
17:13:20.879 [main] DEBUG org.springframework.core.env.PropertySourcesPropertyResolver - Found key 'empName' in PropertySource 'class path resource [myApp.properties]' with value of type String
17:13:20.884 [main] DEBUG org.springframework.core.env.PropertySourcesPropertyResolver - Found key 'empAge' in PropertySource 'class path resource [myApp.properties]' with value of type String
17:13:20.889 [main] DEBUG org.springframework.core.env.PropertySourcesPropertyResolver - Found key 'empCountry' in PropertySource 'class path resource [myApp.properties]' with value of type String
17:13:20.889 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'getEmp'
Emp [empName=Samson, empAge=99, empCountry=SG]

```
