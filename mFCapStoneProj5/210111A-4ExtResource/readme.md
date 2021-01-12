
messages_en_US.properties
``` yaml
msg1 = Hello World !!
msg2 = Welcome to Spring !!
Login.user.prompt = Enter your Username here ....
Login.user.prompt = Enter your Password here ....
```

SpringConfig.java
``` java
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource ();
		messageSource.setBasenames("/messages");
		return messageSource;
	}
```
ExtResourcesTrApplication.java
``` java
		// method 3 thru main/resources
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		String hwMsg = ctx.getMessage("msg1", null, Locale.US);
		String welMsg = ctx.getMessage("msg2", null, Locale.US);

		System.out.println("\t msg1 : " + hwMsg + "\n\t msg2 : " + welMsg);

		hwMsg = ctx.getMessage("msg1", null, Locale.FRANCE);
		welMsg = ctx.getMessage("msg2", null, Locale.FRANCE);

		System.out.println("\t msg1 : " + hwMsg + "\n\t msg2 : " + welMsg);

		hwMsg = ctx.getMessage("msg1", null, Locale.CHINA);
		welMsg = ctx.getMessage("msg2", null, Locale.CHINA);

		System.out.println("\t msg1 : " + hwMsg + "\n\t msg2 : " + welMsg);

	}
```

console
``` console
14:21:09.020 [main] DEBUG org.springframework.context.support.ReloadableResourceBundleMessageSource - Loading properties [messages_en_US.properties]
	 msg1 : Hello World !!
	 msg2 : Welcome to Spring !!
14:21:09.021 [main] DEBUG org.springframework.context.support.ReloadableResourceBundleMessageSource - No properties file found for [/messages_fr] - neither plain properties nor XML
14:21:09.021 [main] DEBUG org.springframework.context.support.ReloadableResourceBundleMessageSource - Loading properties [messages_fr_FR.properties]
	 msg1 : Hola mundo !!
	 msg2 : Bienvenue au printemps !!
14:21:09.022 [main] DEBUG org.springframework.context.support.ReloadableResourceBundleMessageSource - No properties file found for [/messages_zh] - neither plain properties nor XML
14:21:09.022 [main] DEBUG org.springframework.context.support.ReloadableResourceBundleMessageSource - Loading properties [messages_zh_CN.properties]
	 msg1 : 你好
	 msg2 : 欢迎来到 Spring !!

```
