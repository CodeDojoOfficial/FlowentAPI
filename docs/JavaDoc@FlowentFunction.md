## JavaDoc Tree for Interface FlowentFunction

- [[FlowentFunction|JavaDoc@FlowentFunction#public-interface-flowentfunction]]
- [[void execute(Flowent f) throws java.lang.Exception|JavaDoc@FlowentFunction#void-executeflowent-f-throws-javalangexception]]
- [[default void onError(Flowent f, java.lang.Exception e, java.lang.String location)|JavaDoc@FlowentFunction#default-void-onerrorflowent-f-javalangexception-e-javalangstring-location]]

## public interface FlowentFunction

FlowentFunction is a way of expressing a completely safe method, executable in the Flowent method chain using Flowent.runMethod(FlowentFunction).
Think of FlowentFunction as a More Blocks option in a block coding interface. You can build your own methods and pass them into the Flowent method chain to be executed. This is also a convenient way to store methods AND their failsafes in just one variable. Develop the method as a FlowentFunction variable, such as:

```java
private FlowentFunction helloWorld = new FlowentFunction() {

    @Override
    public void execute(Flowent f) {
        f.println("Hello, world!");
    }

};
```

Note: After the brackets used for defining, you still have to remember that you are in a variable declaration, so you have to add a semicolon on the end.

The failsafe method, onError(Flowent, Exception, String), is called when something wrong has happened. By default, this method is filled with error messages letting you know something went wrong. You can override this, however, and change it however you'd like. You can even leave it blank! For debugging purposes, though, it's probably not the best idea.

Since:

&emsp;1.0

Author:

&emsp;Adrian Gjerstad

See Also:

&emsp;Flowent.runMethod(FlowentFunction), execute(Flowent), onError(Flowent, Exception, String), Flowent, Exception

&nbsp;

## void execute(Flowent f) throws java.lang.Exception

This method stores the functionality to be executed when called using Flowent.runMethod(FlowentFunction)

Parameters:

&emsp;f - The Flowent object that called the method in the first place.

Throws:

&emsp;java.lang.Exception - if something goes wrong during execution, then onError can pick up.

See Also:

&emsp;Flowent.runMethod(FlowentFunction), onError(Flowent, Exception, String), Flowent, FlowentFunction

&nbsp;

## default void onError(Flowent f, java.lang.Exception e, java.lang.String location)

This is the FlowentFunction's failsafe in case something goes wrong during execution of the execute(Flowent) method.
If you try to call this object's execute method, and an exception is thrown, it is up to you to catch it. This is why the Flowent.runMethod(FlowentFunction) method is easier. It already has the try catch in it.

By default, the onError method is set to print the exception's localized message and revive the thread, but you can override it very easily.

Parameters:

&emsp;f - The Flowent object that called the method in the first place.

&emsp;e - The exception that caused the error.

&emsp;location - The location of the line that caused the issue

See Also:

&emsp;Flowent.runMethod(FlowentFunction), execute(Flowent), Flowent, FlowentFunction

&nbsp;

> Generated JavaDoc using Standard Doclet version 1.8.0_112.