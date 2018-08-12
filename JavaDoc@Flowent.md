## JavaDoc Tree for Class Flowent

- [[Flowent|JavaDoc@Flowent#public-class-flowent]]
- [[public Flowent()|JavaDoc@Flowent#public-flowent]]
- [[public Flowent println(java.lang.Object obj)|JavaDoc@Flowent#public-flowent-printlnjavalangobject-obj]]
- [[public Flowent println(java.lang.String s)|JavaDoc@Flowent#public-flowent-printlnjavalangstring-s]]
- [[public Flowent println(short s)|JavaDoc@Flowent#public-flowent-printlnshort-s]]
- [[public Flowent println(int i)|JavaDoc@Flowent#public-flowent-printlnint-i]]
- [[public Flowent println(long l)|JavaDoc@Flowent#public-flowent-printlnlong-l]]
- [[public Flowent println(float f)|JavaDoc@Flowent#public-flowent-printlnfloat-f]]
- [[public Flowent println(double d)|JavaDoc@Flowent#public-flowent-printlndouble-d]]
- [[public Flowent println(boolean b)|JavaDoc@Flowent#public-flowent-printlnboolean-b]]
- [[public Flowent println(char c)|JavaDoc@Flowent#public-flowent-printlnchar-c]]
- [[public Flowent println(byte b)|JavaDoc@Flowent#public-flowent-printlnbyte-b]]
- [[public Flowent println(char[] c)|JavaDoc@Flowent#public-flowent-printlnchar-c-1]]
- [[public Flowent println(byte[] b)|JavaDoc@Flowent#public-flowent-printlnbyte-b-1]]
- [[public Flowent print(java.lang.Object obj)|JavaDoc@Flowent#public-flowent-printjavalangobject-obj]]
- [[public Flowent print(java.lang.String s)|JavaDoc@Flowent#public-flowent-printjavalangstring-s]]
- [[public Flowent print(short s)|JavaDoc@Flowent#public-flowent-printshort-s]]
- [[public Flowent print(int i)|JavaDoc@Flowent#public-flowent-printint-i]]
- [[public Flowent print(long l)|JavaDoc@Flowent#public-flowent-printlong-l]]
- [[public Flowent print(float f)|JavaDoc@Flowent#public-flowent-printfloat-f]]
- [[public Flowent print(double d)|JavaDoc@Flowent#public-flowent-printdouble-d]]
- [[public Flowent print(boolean b)|JavaDoc@Flowent#public-flowent-printboolean-b]]
- [[public Flowent print(char c)|JavaDoc@Flowent#public-flowent-printchar-c]]
- [[public Flowent print(byte b)|JavaDoc@Flowent#public-flowent-printbyte-b]]
- [[public Flowent print(char[] c)|JavaDoc@Flowent#public-flowent-printchar-c-1]]
- [[public Flowent print(byte[] b)|JavaDoc@Flowent#public-flowent-printbyte-b-1]]
- [[public Flowent pause(long millis)|JavaDoc@Flowent#public-flowent-pauselong-millis]]
- [[public Flowent pauseNanos(int nanos)|JavaDoc@Flowent#public-flowent-pausenanosint-nanos]]
- [[public Flowent runMethod(FlowentFunction ff)|JavaDoc@Flowent#public-flowent-runmethodflowentfunction-ff]]
- [[public void exit()|JavaDoc@Flowent#public-void-exit]]
- [[public void exit(java.lang.String message)|JavaDoc@Flowent#public-void-exitjavalangstring-message]]
- [[public void exit(int status)|JavaDoc@Flowent#public-void-exitint-status]]
- [[public void exit(int status, java.lang.String message)|JavaDoc@Flowent#public-void-exitint-status-javalangstring-message]]

## public class Flowent

Flowent is a fluent interface API written for the Java Programming Language. Flowent is a project by CodeDojo, developed by many different CodeDojo developers. From a user's perspective, it looks nice and simple, while the API does all of the work for you.

Version:

&emsp;1.0

Author:

&emsp;Adrian Gjerstad

&nbsp;

## public Flowent()

The standard constructor for the Flowent main class.

&nbsp;

## public Flowent println(java.lang.Object obj)

Print an object using Object.toString(), or null, depending on if the Object does not exist. This method terminates the line afterwards.

Parameters:

&emsp;obj - The Object to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(java.lang.String s)

Print the contents of the String object passed and terminate the line.

Parameters:

&emsp;s - the String object to be printed.

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(short s)

Print a data point of type short and terminate the line.

Parameters:

&emsp;s - The short integer to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(int i)

Prints an integer and terminates the line.

Parameters:

&emsp;i - The integer to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(long l)

Prints a long integer and terminates the line.

Parameters:

&emsp;l - The long integer to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(float f)

Prints a floating-point decimal and terminates the line.

Parameters:

&emsp;f - The floating-point decimal to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(double d)

Prints a doubled floating-point decimal and terminates the line.

Parameters:

&emsp;d - The doubled floating-point decimal to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(boolean b)

Prints a boolean value as true or false; not 1 or 0. This method terminates the line afterwards.

Parameters:

&emsp;b - The boolean value to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(char c)

Prints the character encoded value of the char entered and terminates the line.

Parameters:

&emsp;c - The character to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(byte b)

Prints the 8-bit encoded version of the character entered and terminates the line.

Parameters:

&emsp;b - The byte to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(char[] c)

Prints the character array as if it were a string and then terminates the line.

Parameters:

&emsp;c - The character array to be printed as a string

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println(byte[] b)

Prints the 8-bit encoded character array passed in as if it were a string and then terminates the line.

Parameters:

&emsp;b - The 8-bit character array to be printed as if it were a string

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent println()

Terminates the current line and starts at the next.

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(java.lang.Object obj)

Print an object using Object.toString(), or null, depending on if the Object does not exist.

Parameters:

&emsp;obj - The Object to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(java.lang.String s)

Print the contents of the String object passed.

Parameters:

&emsp;s - the String object to be printed.

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(short s)

Print a data point of type short.

Parameters:

&emsp;s - The short integer to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(int i)

Prints an integer.

Parameters:

&emsp;i - The integer to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(long l)

Prints a long integer.

Parameters:

&emsp;l - The long integer to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(float f)

Prints a floating-point decimal.

Parameters:

&emsp;f - The floating-point decimal to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(double d)

Prints a doubled floating-point decimal.

Parameters:

&emsp;d - The doubled floating-point decimal to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(boolean b)

Prints a boolean value as true or false; not 1 or 0.

Parameters:

&emsp;b - The boolean value to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(char c)

Prints the character encoded value of the char entered.

Parameters:

&emsp;c - The character to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(byte b)

Prints the 8-bit encoded version of the character entered.

Parameters:

&emsp;b - The byte to be printed

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(char[] c)

Prints the character array as if it were a string.

Parameters:

&emsp;c - The character array to be printed as a string

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent print(byte[] b)

Prints the 8-bit encoded character array passed in as if it were a string.

Parameters:

&emsp;b - The 8-bit character array to be printed as if it were a string

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent pause(long millis)

Wait for a specified number of milliseconds.

Parameters:

&emsp;millis - The number of milliseconds to wait for

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent pauseNanos(int nanos)

Wait for a specified number of nanoseconds.

Parameters:

&emsp;nanos - The number of nanoseconds to wait for

Returns:

&emsp;This Flowent object for method chaining purposes.

&nbsp;

## public Flowent runMethod(FlowentFunction ff)

Runs the execute method in the FlowentFunction passed in. If the method execution has any uncaught exceptions, the onError method will be called. No arguments may be passed in.

Parameters:

&emsp;ff - The FlowentFunction method to be run.

Returns:

&emsp;This Flowent object for method chaining purposes.

See Also:

&emsp;FlowentFunction, FlowentFunction.execute(Flowent), FlowentFunction.onError(Flowent, Exception, String)

&nbsp;

## public void exit()

Exit the program with an exit value of 0. (Normal termination)

&nbsp;

## public void exit(java.lang.String message)

Exit the program and print the given message. The JVM will exit with an exit value of 0. (Normal termination)

Parameters:

&emsp;message - The message to be printed during program exit.

&nbsp;

## public void exit(int status)

Exit the program with the given exit value.

Parameters:

&emsp;status - The exit value to be given the the JVM on exit.

&nbsp;

## public void exit(int status, java.lang.String message)

Prints the given message and exits with the value given.

Parameters:

&emsp;status - The exit value to be given to the JVM on exit.

&emsp;message - The message to be printed along side the exit value given.

&nbsp;

> Generated JavaDoc using Standard Doclet version 1.8.0_112.