Practice 10-4: Requiring a Module Transitively

- Create a new module called `conversation`
- Create a package com.question within the conversation module
- Create a new Java Class within the com.question package.

Questions.java
``` java
package com.question;

public class Questions {
    public static String getQuestion() {
        return "How are you?";
    }
    
}
```
5. Append the returned String from callinf getQuestion() to the print statement in the main method.
Main.java
``` java
package com.greeting;

import com.question.Questions;
import com.name.Names;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello " +Names.getName() + " "
        + Questions.getQuestion());
    }
}
```
- Modify the module-info class of the conversation
module-info.java
``` java
module conversation {
    exports com.question;
}
```
- Modify the module-info class of the people require transitively
``` java
module people {
    exports com.name;
    requires transitive conversation;
}
```
output:
``` console
run:
Hello Duke! How are you?
BUILD SUCCESSFUL (total time: 0 seconds)

```
