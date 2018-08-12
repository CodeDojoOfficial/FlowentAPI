Welcome to the Flowent wiki! Here you can learn many things about the Flowent Java API and the Java Programming Language! To learn more about what Flowent is, go to the [[about|Home#About]] section.

- [[About|Home#about]]
- [[What to Expect|Home#what-to-expect]]

## About
Flowent is a [fluent interface](https://google.com/search?q=Fluent+Interface) written in the Java Programming Language, complete with JavaDoc on every method and class. Think about those libraries for PHP where you can say:

```php
<?php
new FluentInterface().

println("Testing...").
wait(1000).
println("Testing complete").
quit();
?>
```

You can't run PHP, but you can run Java, now you can do things like that with Java! Go to the [latest download page](https://github.com/CodeDojoOfficial/FlowentAPI/releases/latest) and download `flow-1.0.0.jar`! Seeing as the JavaDoc explains every thing you need to know, all you need to know now is what to do first!

```java
package flowent.helloworld;

import flowent.*; // Don't worry, there is only 2 files to add.

public class MyClass {
    
    public static void main(String[] args) {
        new Flowent().
        
        println("Hello, world!");
    }
    
}
```

Output:

```
Hello World
```

## What to Expect

When you are developing using Flowent, it seems like you only have the option to print something, wait, or exit. But there is a hidden feature that is very worth it to get excited about. You have the ability to make your own failsafe methods! Go [[here|Custom-Methods]] to find out how to use them. Given how they do tend to use up your code's readability, we still intend on adding more macros in the future.

On the other hand, if you want, you can contribute to Flowent by filing a bug report/issue, or requesting a feature [here](https://github.com/CodeDojoOfficial/FlowentAPI/issues/new/choose). Thank you!
