package flowent;

/**
 * Flowent is a fluent interface API written for the Java Programming Language.
 * 
 * Flowent is a project by CodeDojo, developed by many different CodeDojo developers.
 * From a user's perspective, it looks nice and simple, while the API does all of the
 * work for you. If you need help, visit <a href="https://flowenthelp.blogspot.com"><i>Flowent
 * API Help on Blogger</i></a>.
 * 
 * @author Adrian Gjerstad
 * 
 * @version 1.0
 */
public class Flowent {
	
	/**
	 * The standard constructor for the Flowent main class.
	 */
	public Flowent() {
		
	}
	
	/**
	 * Print an object using Object.toString(), or null, depending on if the Object does not
	 * exist. This method terminates the line afterwards.
	 * 
	 * @param obj The Object to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(Object obj) {
		System.out.println((obj != null) ? obj.toString() : "null");
		return this;
	}
	
	/**
	 * Print the contents of the String object passed and terminate the line.
	 * 
	 * @param s the String object to be printed.
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(String s) {
		System.out.println(s);
		return this;
	}
	
	/**
	 * Print a data point of type short and terminate the line.
	 * 
	 * @param s The short integer to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(short s) {
		System.out.println(s);
		return this;
	}
	
	/**
	 * Prints an integer and terminates the line.
	 * 
	 * @param i The integer to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(int i) {
		System.out.println(i);
		return this;
	}
	
	/**
	 * Prints a long integer and terminates the line.
	 * 
	 * @param l The long integer to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(long l) {
		System.out.println(l);
		return this;
	}
	
	/**
	 * Prints a floating-point decimal and terminates the line.
	 * 
	 * @param f The floating-point decimal to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(float f) {
		System.out.println(f);
		return this;
	}
	
	/**
	 * Prints a doubled floating-point decimal and terminates the line.
	 * 
	 * @param d The doubled floating-point decimal to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(double d) {
		System.out.println(d);
		return this;
	}
	
	/**
	 * Prints a boolean value as true or false; not 1 or 0. This method
	 * terminates the line afterwards.
	 * 
	 * @param b The boolean value to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(boolean b) {
		System.out.println(b);
		return this;
	}
	
	/**
	 * Prints the character encoded value of the char entered and terminates
	 * the line.
	 * 
	 * @param c The character to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(char c) {
		System.out.println(c);
		return this;
	}
	
	/**
	 * Prints the 8-bit encoded version of the character entered and terminates
	 * the line.
	 * 
	 * @param b The byte to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(byte b) {
		System.out.println(new StringBuilder().append(b).toString());
		return this;
	}
	
	/**
	 * Prints the character array as if it were a string and then terminates the
	 * line.
	 * 
	 * @param c The character array to be printed as a string
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(char[] c) {
		System.out.println(new StringBuilder().append(c).toString());
		return this;
	}
	
	/**
	 * Prints the 8-bit encoded character array passed in as if it were a string and
	 * then terminates the line.
	 * 
	 * @param b The 8-bit character array to be printed as if it were a string
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println(byte[] b) {
		for(byte bt : b) {
			System.out.print(bt);
		}
		System.out.println();
		return this;
	}
	
	/**
	 * Terminates the current line and starts at the next.
	 * 
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent println() {
		System.out.println();
		return this;
	}
	
	/* NON-LINE-TERMINATING PRINT METHODS */
	
	/**
	 * Print an object using Object.toString(), or null, depending on if the Object does not
	 * exist.
	 * 
	 * @param obj The Object to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(Object obj) {
		System.out.print((obj != null) ? obj.toString() : "null");
		return this;
	}
	
	/**
	 * Print the contents of the String object passed.
	 * 
	 * @param s the String object to be printed.
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(String s) {
		System.out.print(s);
		return this;
	}
	
	/**
	 * Print a data point of type short.
	 * 
	 * @param s The short integer to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(short s) {
		System.out.print(s);
		return this;
	}
	
	/**
	 * Prints an integer.
	 * 
	 * @param i The integer to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(int i) {
		System.out.print(i);
		return this;
	}
	
	/**
	 * Prints a long integer.
	 * 
	 * @param l The long integer to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(long l) {
		System.out.print(l);
		return this;
	}
	
	/**
	 * Prints a floating-point decimal.
	 * 
	 * @param f The floating-point decimal to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(float f) {
		System.out.print(f);
		return this;
	}
	
	/**
	 * Prints a doubled floating-point decimal.
	 * 
	 * @param d The doubled floating-point decimal to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(double d) {
		System.out.print(d);
		return this;
	}
	
	/**
	 * Prints a boolean value as true or false; not 1 or 0.
	 * 
	 * @param b The boolean value to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(boolean b) {
		System.out.print(b);
		return this;
	}
	
	/**
	 * Prints the character encoded value of the char entered.
	 * 
	 * @param c The character to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(char c) {
		System.out.print(c);
		return this;
	}
	
	/**
	 * Prints the 8-bit encoded version of the character entered.
	 * 
	 * @param b The byte to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(byte b) {
		System.out.print(new StringBuilder().append(b).toString());
		return this;
	}
	
	/**
	 * Prints the character array as if it were a string.
	 * 
	 * @param c The character array to be printed as a string
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(char[] c) {
		System.out.print(c);
		return this;
	}
	
	/**
	 * Prints the 8-bit encoded character array passed in as if it were a string.
	 * 
	 * @param b The 8-bit character array to be printed as if it were a string
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(byte[] b) {
		for(byte bt : b) {
			System.out.print(bt);
		}
		return this;
	}
	
	/**
	 * Wait for a specified number of milliseconds.
	 * 
	 * @param millis The number of milliseconds to wait for
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * Wait for a specified number of nanoseconds.
	 * 
	 * @param nanos The number of nanoseconds to wait for
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent pauseNanos(int nanos) {
		try {
			Thread.sleep(0, nanos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	/**
	 * Runs the execute method in the FlowentFunction passed in.
	 * 
	 * If the method execution has any uncaught exceptions, the onError method
	 * will be called. No arguments may be passed in.
	 * 
	 * @param ff The FlowentFunction method to be run.
	 * @return This Flowent object for method chaining purposes.
	 * 
	 * @see flowent.FlowentFunction
	 * 
	 * @see flowent.FlowentFunction#execute(Flowent)
	 * @see flowent.FlowentFunction#onError(Flowent, Exception, String)
	 */
	public Flowent runMethod(FlowentFunction ff) {
		try {
			ff.execute(this);
		} catch (Exception e) {
			ff.onError(this, e, Thread.currentThread().getStackTrace()[2].toString());
		}
		return this;
	}
	
	/**
	 * Exit the program with an exit value of 0. (Normal termination)
	 */
	public void exit() {
		System.out.println();
		System.exit(0);
	}
	
	/**
	 * Exit the program and print the given message. The JVM will exit with an
	 * exit value of 0. (Normal termination)
	 * 
	 * @param message The message to be printed during program exit.
	 */
	public void exit(String message) {
		System.out.println();
		println(message + " (exit code 0)");
		System.exit(0);
	}
	
	/**
	 * Exit the program with the given exit value.
	 * 
	 * @param status The exit value to be given the the JVM on exit.
	 */
	public void exit(int status) {
		System.out.println();
		System.exit(status);
	}
	
	/**
	 * Prints the given message and exits with the value given.
	 * 
	 * @param status The exit value to be given to the JVM on exit.
	 * @param message The message to be printed along side the exit value given.
	 */
	public void exit(int status, String message) {
		System.out.println();
		println(message + " (exit code " + status + ")");
		System.exit(status);
	}
	
}
