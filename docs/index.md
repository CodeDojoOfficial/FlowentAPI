<h1 align="center">
  <a href="https://github.com/CodeDojoOfficial/FlowentAPI/edit/master/README.md"><img src="https://codedojoofficial.github.io/image/flowent-logo.png" alt="Flowent - Fluent Interface API" width="200"></a>
  <br>
  Flowent Java API
  <br>
  <br>
</h1>

<p align="center">
  <a href="https://en.wikipedia.org/wiki/Fluent_interface"><img src="https://img.shields.io/badge/fluent-interface-yellow.svg"/></a>
  <a href="https://www.oracle.com/java/"><img src="https://img.shields.io/badge/language-java-blue.svg"/></a>
  <a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html"><img src="https://img.shields.io/badge/jdk-1.8.0-orange.svg"/></a>
  <!-- Semi-dynamic badge comes directly from Travis-CI's badge generator for builds -->
  <a href="https://travis-ci.org/CodeDojoOfficial/FlowentAPI"><img src="https://api.travis-ci.org/CodeDojoOfficial/FlowentAPI.svg?branch=master"/></a>
</p>

## Java Fluent Interface API

This library gives you the chance to create programs in a method chain style! Look at the abilities!

- Print anything to the console
- Wait for however long you want
- Exit with a custom message and exit code
- **Featured:** Create custom commands and call them from within your method chain!

You won't be limited to what you can do, just like normal programming!

install with:

```
github:~ $ git clone https://github.com/CodeDojoOfficial/FlowentAPI.git
github:~ $ cd FlowentAPI/releases/
github:releases $ mv flow-1.0.0.jar ~/workspace/flow.jar
```

## Table of Contents

- [Quick start](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#quick-start)
  - [Installation](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#installation)
  - [The HelloWorld Program](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#the-helloworld-program)
  - [Method Chaining](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#method-chaining)
  - [Introduction to Custom Methods](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#introduction-to-custom-methods)
  - [Creating a Counting Method](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#creating-a-counting-method)
- [FAQ](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#faq)
  - [If you have custom functions, what's the point of the built-in ones?](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#if-you-have-custom-functions-whats-the-point-of-the-built-in-ones)

## Quick Start

Let's start your first few test programs. In this section, you will build the hello world program, chain methods together, have an introduction to custom methods, and a counting method! Let's install Flowent first.

## Installation

To install using git, run the following command:

```
github:~ $ git clone https://github.com/CodeDojoOfficial/FlowentAPI.git
```

The next few instructions are IDE specific. If you are using something like Vim or Nano, or any other IDE that doesn't only support java, you will have to just use javac and java.

### Eclipse IDE

1. Open Eclipse and right-click on the project name in the Package Explorer.
2. Select Properties.
3. Double-click Java Build Path.
4. Click Add Library.
5. User Library > Next
6. If the Flowent Library is here, select it and click finish. Your done.
7. Click User Libraries...
8. Click New and Enter the Name, "Flowent".
9. Click Done and Select the new Library.
10. Click "Add External JARs...".
11. Select ~/FlowentAPI/releases/flow-1.0.0.jar or the latest version.
12. Click done.

### NetBeans IDE

1. Open NetBeans and right-click on the project name in the Projects tab.
2. Select Properties.
3. Select Libraries.
4. Click the Add Jar/Folder button.
5. Select ~/FlowentAPI/releases/flow-1.0.0.jar or the latest version.
6. Click Ok.

Great! Your done! If you want to expiriment on your own, feel free to do so. The next section covers your first program.

## The HelloWorld Program

So you want to get started with Flowent. It's easy! Let's start from basics. This tutorial assumes you have an IDE.

Create a new project, and name it HelloWorld. New package, your choice of name. New class. Name it HelloWorld. We will need the main method and the constructor. Also, import `flowent.Flowent` when you are done creating the class. Let's start!

In your main method, enter `new HelloWorld()`.  This will call the constructor. (*See the [Introduction to Custom Methods](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#introduction-to-custom-methods) section to see why.*)

Now for the magic to happen! Go into your constructor and type the following: (*It will be explained.*)

```java
new Flowent().
println("Hello, world!");
```

This code creates a new Flowent object and calls the println(String) method from within it. You may have 2 questions right now. Why did you put the newline after the dot? And what does this have to do with method chaining? Both questions will be answered in the [Challenges](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#the-helloworld-program-challenges) section of this tutorial.

This is a pretty simple program. But in the next tutorial, you will learn how to chain methods together!

### The HelloWorld Program Challenges

Using the `println()`, `wait()`, and `exit()` methods, complete these tasks.

1. Build a program that prints 3 things. A String, an int, and a float.
2. Build a program that prints "Exiting" and exits with an exit code of 2.
3. Build a program that prints the numbers 1 to 5 without terminating the line.

## Method Chaining

You may have learned how to call a method from the new instance of the Flowent class, but did you know that every single method, except exit, returns the Flowent instance back? Yup. You can call a method on a method. So now you can write programs like this:

```java
new Flowent().

println("Wow!").
wait(1000).
println("It really works!").

exit("Program finished.");
```

Note that you don't try to add another method after exit because exit doesn't actually return anything. But go ahead and run this, and you get:

```
Wow!
It really works!

Program finished. (exit code 0)
```

Wow! The program continued even after the first method was called!

## Introduction to Custom Methods

> Forwarning: The methods that were referred to before are now called macros.

> Look at the wiki page [here](https://github.com/CodeDojoOfficial/FlowentAPI/wiki/Custom-Methods)

If macros didn't cut it for you in terms of functionality, then FlowentFunction is just the thing for you!

Let's back up a step. FlowentFunction is an interface included in the JAR file you downloaded. It has to methods, an abstract one, and a default one. In other words, one is required for you to use, and the other is not. Let's look at an example of a custom method here:

```java
new FlowentFunction() {
  
  @Override
  public void execute(Flowent f) throws Exception {
    f.println("The custom method was called!");
  }
  
}
```

This custom method defines an overridden method `execute(Flowent)` that throws Exception. (*See [here](https://github.com/CodeDojoOfficial/FlowentAPI/blob/master/README.md#error-handling) to find out what the exception part is for.*) The Flowent object that is passed in is the very same one that called it in the first place.

This method prints a line of text to the console. That much is obvious. But how do we run it? Like this:

```java
new Flowent().
runMethod(myFunction);
```

So this runs the method and we get our line of text! Hooray!

### Error Handling

What happens if an Exception is thrown within the execute method? This is where that other method comes into play. It is called `onError(Flowent f, Exception e, String location)`. If Flowent finds an error in the execute method, it immediately calls this method. (*See JavaDoc for default actions.*) Even though it is a default method, you can still override it. So if we do this in the execute method without overriding it:

```java
throw new RuntimeException("A test error.");
```

You get:

```
Uncaught exception in thread "main" java.lang.RuntimeException: A test error.
        at: com.example.project.CustomMethods.<init>(CustomMethods.java:20)
Reviving thread...
```

And there you go! But wait. It exited with an exit code 0!? Yup. Because of the fact that those errors are caught, no early termination occurs. (*Unless something really bad happened.*)

## Creating a Counting Method

In the last tutorial, you learned how to write a custom method. But did you notice that you created a custom class in the process? So now you can make variables as well! And, Flowent does not have any reserved variables! Let's make a counting method!

```java
new FlowentFunction() {
  
  private int count = 1;
  
  @Override
  public void execute(Flowent f) throws Exception {
    f.println("This method has been called " + count + " times.");
    
    count++;
  }
  
}
```

And we run it, something like this will appear! (*Enter the code in to run it first*) (*Note: Do not enter it in directly. Flowent does not cache methods.*)

```
This method has been called 1 times.
This method has been called 2 times.
This method has been called 3 times.

Program finished (exit code 0)
```

There you go! A counting machine!

## FAQ

We know you have many questions about Flowent, and we are happy to answer them. The next few headers answer the most commonly asked questions.

## If you have custom functions, what's the point of the built-in ones?

Yes, there is the ability to create custom functions. But first of all, methods are called from macros. So if there were no macros, Flowent would have no point in existing. Second of all, if you have many custom methods, your code can start to get a little messy. Leave the messiness to us. Give yourself a clean slate to work with so that you can use less space.

> If you're still reading this, just... just wow.
