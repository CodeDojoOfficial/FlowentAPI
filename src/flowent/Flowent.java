/* COPYRIGHT (c) 2018 BY CODEDOJO AND/OR IT'S INDIVIDUAL DEVELOPERS. ALL RIGHTS RESERVED.
 * 
 * The Flowent Project is protected under the MIT License.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package flowent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Flowent is a fluent interface API written for the Java Programming Language.
 * <p>
 * Flowent is a project by CodeDojo, developed by many different CodeDojo developers.
 * From a user's perspective, it looks nice and simple, while the API does all of the
 * work for you.
 * <p>
 * Starting version 1.0.1, this class is now cloneable via {@link java.lang.Object#clone() Object.clone()}.
 * Also starting version 1.0.1 is a logging feature. If you have overriden onError()
 * in one of your custom methods, for loops, while loops, or anything else, but you run
 * into an error and are not sure what is goig wrong, you can call the constructor
 * {@linkplain flowent.Flowent#Flowent(boolean) Flowent(true)} and a debugging log file
 * will be created at <code>~/.Flowent/log/flowent-log-&lt;DATE&gt;-t-&lt;TIME&gt;-&lt;ID&gt;.log</code>
 * 
 * @see java.lang.Cloneable
 * 
 * @version 1.0.2
 */
public class Flowent implements Cloneable {
	
	/* register the flowent system properties via the static initializer.
	 * 
	 * VM will execute the code below before it can say that it has
	 * completed class initialization. The System class must be loaded
	 * before this class is loaded. This also loads codedojo's information
	 * if it is not already there.
	 * 
	 * This block has been here since 1.0.2
	 */
	static {
		System.setProperty("flowent.version", "1.0.2");
		System.setProperty("flowent.vendor", "CodeDojo");
		System.setProperty("flowent.vendor.url", "https://codedojoofficial.github.io/FlowentAPI/");
		System.setProperty("flowent.log.dir", System.getProperty("user.home") + "/.Flowent/log/");
		System.setProperty("flowent.copyright", "Copyright (c) 2018 by CodeDojo and/or it's individual developers. All rights reserved.");
		
		System.setProperty("codedojo.since", "2017");
		System.setProperty("codedojo.url", "https://codedojoofficial.github.io");
	}
	
	/**
	 * This is the file output stream for the logging device.
	 * 
	 * @see flowent.Flowent#logOption
	 * 
	 * @since 1.0.1
	 */
	private PrintStream log = null;
	
	/**
	 * This shows wether or not to log errors to the output stream.
	 * 
	 * @see flowent.Flowent#log
	 * 
	 * @since 1.0.1
	 */
	private boolean logOption;
	
	/**
	 * This is what stores all variables you set using {@linkplain #setProperty(String, Object)}.
	 * 
	 * @see flowent.Flowent#setProperty(String, Object)
	 * @see flowent.Flowent#getProperty(String)
	 * @see flowent.Flowent#deleteProperty(String)
	 * 
	 * @since 1.0.2
	 */
	protected static Map<String, Object> properties = new HashMap<String, Object>();
	
	/**
	 * This is the counter for how many Flowent objects exist or did exist.
	 * It is used in creating the custom <code>id</code> for string conversion
	 * purposes.
	 * 
	 * @see flowent.Flowent#id
	 * 
	 * @since 1.0.1
	 */
	private static int nextId = 0;
	
	/**
	 * This is this Flowent object's system-assigned ID. When assigned, it is not
	 * the pointer value for this object, but rather the <code>nextId</code> value.
	 * 
	 * @see flowent.Flowent#nextId
	 * 
	 * @since 1.0.1
	 */
	private final int id;
	
	/**
	 * The standard constructor for the Flowent main class. By default, logging is off,
	 * and no file is created.
	 * 
	 * @see flowent.Flowent#Flowent(boolean)
	 */
	public Flowent() {
		logOption = false;
		
		// Used for toString conversion
		this.id = nextId;
		nextId++;
	}
	
	/**
	 * This constructor gives you the option to log everything. (<i>See {@link flowent.Flowent Flowent} for details</i>)
	 * 
	 * @param logOption The option of wether or not you want to use logs for debugging purposes.
	 * 
	 * @see flowent.Flowent#Flowent()
	 * 
	 * @since 1.0.1
	 */
	public Flowent(boolean logOption) {
		this.logOption = logOption;
		if(logOption) {
			File dir = new File(System.getProperty("user.home") + "/.Flowent/log/");
			dir.mkdirs();
			File errorLog = new File(System.getProperty("user.home") + "/.Flowent/log/flowent-log-" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "-t-" + new SimpleDateFormat("HH-mm-ss").format(new Date()) + "-" + nextId + ".log");
			try {
				log = new PrintStream(errorLog);
			} catch (FileNotFoundException e) {
				log = null;
				e.printStackTrace();
			}
			
			log.printf("Log file generated by Flowent Java API on %s.\n", System.getProperty("os.name") + " " + System.getProperty("os.architecture"));
			log.printf("Program executed using JRE %s\n", System.getProperty("java.version"));
			log.println("Copyright (c) 2018 by CodeDojo and/or it's individual developers. All rights reserved.");
			log.println("This file must not be edited if intent is to publicize this document. Thank you.\n");
			log.printf("Log start: %s at %s\n\n", new SimpleDateFormat("MM/dd/yyyy").format(new Date()), new SimpleDateFormat("hh:mm:ss aa").format(new Date()));
			
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

				@Override
				public void run() {
					log.printf("Log end: %s at %s\n\n", new SimpleDateFormat("MM/dd/yyyy").format(new Date()), new SimpleDateFormat("hh:mm:ss aa").format(new Date()));
					log.printf("Generated in account: %s", System.getProperty("user.name"));
					log.close();
				}
				
			}));
		} else {
			log = null;
		}
		
		// Used for toString conversion
		this.id = nextId;
		nextId++;
	}
	
	/**
	 * Sets a property in the flowent system to an assigned value. This method acts just like the
	 * native line:
	 * <blockquote>
	 * <pre>
	 * properties.put(key, value);
	 * </pre></blockquote>
	 * Note that you would have to extend Flowent as a parent class to do this.
	 * 
	 * @param key The "variable name" to assign the object in the system.
	 * @param value The object to be entered for the assignment
	 * @return This Flowent object for method chaining purposes.
	 * 
	 * @see flowent.Flowent#getProperty(String)
	 * @see flowent.Flowent#deleteProperty(String)
	 * @see flowent.Flowent#properties
	 * 
	 * @since 1.0.2
	 */
	public Flowent setProperty(String key, Object value) {
		properties.put(key, value);
		
		if(logOption) {
			log.println(">>> setProperty(\"" + key + "\", " + ((value instanceof String) ? ("\"" + value + "\"") : ("Object: " + value)) + ")\n");
		}
		
		return this;
	}
	
	/**
	 * Gets a property in the flowent system. This method acts just like the
	 * native line:
	 * <blockquote>
	 * <pre>
	 * properties.get(key);
	 * </pre></blockquote>
	 * Note that you would have to extend Flowent as a parent class to do this.
	 * 
	 * @param key The "variable name" to use to get the object in the system.
	 * @return The object contained in the variable.
	 * 
	 * @see flowent.Flowent#setProperty(String, Object)
	 * @see flowent.Flowent#deleteProperty(String)
	 * @see flowent.Flowent#properties
	 * 
	 * @since 1.0.2
	 */
	public static Object getProperty(String key) {
		return properties.get(key);
	}
	
	/**
	 * Removes a property from the flowent system. This method acts just like the
	 * native line:
	 * <blockquote>
	 * <pre>
	 * properties.remove(key);
	 * </pre></blockquote>
	 * Note that you would have to extend Flowent as a parent class to do this.
	 * 
	 * @param key The "variable name" to use to get the object in the system.
	 * @return This Flowent object for method chaining purposes.
	 * 
	 * @see flowent.Flowent#setProperty(String, Object)
	 * @see flowent.Flowent#getProperty(String)
	 * @see flowent.Flowent#properties
	 * 
	 * @since 1.0.2
	 */
	public Flowent deleteProperty(String key) {
		properties.remove(key);
		
		if(logOption) {
			log.println(">>> deleteProperty(\"" + key + "\")\n");
		}
		
		return this;
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
		
		if(logOption) {
			log.printf(">>> println(%s)\n\n", ((obj instanceof String) ? ("\"" + obj + "\"") : ("Object: " + obj)));
		}
		
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
		
		if(logOption) {
			log.printf(">>> println(\"%s\")\n\n", s);
		}
		
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
		
		if(logOption) {
			log.printf(">>> println(%s)\n\n", s);
		}
		
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
		
		if(logOption) {
			log.printf(">>> println(%d)\n\n", i);
		}
		
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
		
		if(logOption) {
			log.printf(">>> println(%d)\n\n", l);
		}
		
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
		
		if(logOption) {
			log.printf(">>> println(%s)\n\n", f);
		}
		
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
		
		if(logOption) {
			log.printf(">>> println(%s)\n\n", d);
		}
		
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
		
		if(logOption) {
			log.printf(">>> println(%b)\n\n", b);
		}
		
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
		
		if(logOption) {
			log.printf(">>> println(%c)\n\n", c);
		}
		
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
		System.out.println(new StringBuilder().append((char) b).toString());
		
		if(logOption) {
			log.printf(">>> println(%b)\n\n", new StringBuilder().append((char) b).toString());
		}
		
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
		
		if(logOption) {
			log.printf(">>> println(%s)\n\n", new StringBuilder().append(c).toString());
		}
		
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
		StringBuilder str = new StringBuilder();
		for(byte ch : b) {
			str.appendCodePoint((int) ch);
			System.out.print(new StringBuilder().appendCodePoint((int)ch).toString());
		}
		
		if(logOption) {
			log.printf(">>> println(%s)\n\n", str.toString());
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
		
		if(logOption) {
			log.printf(">>> println()\n\n");
		}
		
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
		
		if(logOption) {
			log.printf(">>> print(%s)\n\n", ((obj instanceof String) ? ("\"" + obj + "\"") : ("Object: " + obj)));
		}
		
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
		
		if(logOption) {
			log.printf(">>> print(\"%s\")\n\n", s);
		}
		
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
		
		if(logOption) {
			log.printf(">>> print(%s)\n\n", s);
		}
		
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
		
		if(logOption) {
			log.printf(">>> print(%d)\n\n", i);
		}
		
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
		
		if(logOption) {
			log.printf(">>> print(%d)\n\n", l);
		}
		
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
		
		if(logOption) {
			log.printf(">>> print(%s)\n\n", f);
		}
		
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
		
		if(logOption) {
			log.printf(">>> print(%s)\n\n", d);
		}
		
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
		
		if(logOption) {
			log.printf(">>> print(%b)\n\n", b);
		}
		
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
		
		if(logOption) {
			log.printf(">>> print(%c)\n\n", c);
		}
		
		return this;
	}
	
	/**
	 * Prints the 8-bit encoded version of the character entered.
	 * 
	 * @param b The byte to be printed
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(byte b) {
		System.out.print(new StringBuilder().append((char) b).toString());
		
		if(logOption) {
			log.printf(">>> print(%b)\n\n", new StringBuilder().append((char) b).toString());
		}
		
		return this;
	}
	
	/**
	 * Prints the character array as if it were a string.
	 * 
	 * @param c The character array to be printed as a string
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(char[] c) {
		System.out.print(new StringBuilder().append(c).toString());
		
		if(logOption) {
			log.printf(">>> print(%s)\n\n", new StringBuilder().append(c).toString());
		}
		
		return this;
	}
	
	/**
	 * Prints the 8-bit encoded character array passed in as if it were a string.
	 * 
	 * @param b The 8-bit character array to be printed as if it were a string
	 * @return This Flowent object for method chaining purposes.
	 */
	public Flowent print(byte[] b) {
		StringBuilder str = new StringBuilder();
		for(byte ch : b) {
			str.appendCodePoint((int) ch);
			System.out.print(new StringBuilder().appendCodePoint((int)ch).toString());
		}
		
		if(logOption) {
			log.printf(">>> print(%s)\n\n", str.toString());
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
		
		if(logOption) {
			log.println(">>> pause(" + millis + ")\n");
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
		
		if(logOption) {
			log.println(">>> pauseNanos(" + nanos + ")\n");
		}
		
		return this;
	}
	
	/**
	 * Runs the execute method in the FlowentFunction passed in.
	 * <p>
	 * If the method execution has any uncaught exceptions, the onError method
	 * will be called. No arguments may be passed in.
	 * <p>
	 * If an error occurs, and the logging option is set to true, the standard
	 * error will be added to the log file.
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
			String location = Thread.currentThread().getStackTrace()[2].toString();
			ff.onError(this, e, location);
			if(logOption) {
				log.println("Uncaught exception in thread \"" + Thread.currentThread().getName() + "\" " + e.getClass().getName() + ((e.getLocalizedMessage() != null) ? ": " + e.getLocalizedMessage() : ""));
				log.println("\tat " + location  + "\n");
			}
		}
		
		if(logOption) {
			log.println(">>> runMethod(Object: " + ff.toString() + ")\n");
		}
		
		return this;
	}
	
	/**
	 * This method takes a <code>FlowentForLoop</code> object and executes it's iterate method over <code>iterations</code>
	 * times. The first iteration is passed in to <code>iterate</code> as iteration 0. If an error occurs during the <code>iterate</code>
	 * method, onError picks up.
	 * <p>
	 * If the logging option for this object is set to true, and an error is thrown, it is logged in the output file.
	 * 
	 * @param loop The loop to run in a for loop
	 * @param iterations The number of iterations to run through
	 * @return This Flowent object for method chaining purposes
	 * 
	 * @see flowent.FlowentForLoop#iterate(Flowent, int)
	 * @see flowent.FlowentForLoop#onError(Flowent, Exception, String)
	 * @see flowent.FlowentForLoop
	 * @see flowent.FlowentWhileLoop
	 * 
	 * @since 1.0.1
	 */
	public Flowent runForLoop(FlowentForLoop loop, int iterations) {
		// elapsed time
		double firstTime = 0;
		double passedTime = 0;
		
		// Auto-break counters
		int unauthI = 0;
		int consErrors = 0;
		
		if(logOption) {
			log.println(">>> runForLoop(Object: " + loop.toString() + ", " + iterations + ")\n");
		}
		
		for(int i = 0; i < ((iterations < 0) ? Math.abs(iterations) : iterations); i++) {
			firstTime = System.nanoTime() / 1000000000.0;
			if(iterations == 0) {
				break;
			}
			try {
				synchronized(loop) {
					loop.iterate(this, i);
				}
				
				consErrors = 0;
			} catch (Exception e) {
				consErrors++;
				String location = Thread.currentThread().getStackTrace()[2].toString();
				loop.onError(this, e, location);
				if(logOption) {
					log.println("Uncaught exception in thread \"" + Thread.currentThread().getName() + "\" " + e.getClass().getName() + ((e.getLocalizedMessage() != null) ? ": " + e.getLocalizedMessage() : ""));
					log.println("\tat " + location  + "\n");
				}
			}
			
			passedTime = System.nanoTime() / 1000000000.0 - firstTime;
			
			if(passedTime < 0.01) {
				unauthI++;
				if(unauthI == 500) {
					println("For loop broken due to fast execution.");
					break;
				}
			} else {
				unauthI = 0;
			}
			
			if(consErrors == 50) {
				println("For loop broken due to a multitude of errors.");
				break;
			}
		}
		
		return this;
	}
	
	/**
	 * This method runs a given <code>FlowentWhileLoop</code>'s <code>iterate</code> method until it returns true.
	 * <p>
	 * There are two cases in which during the loop will stop automatically, before the JVM crashes due to stack overflow.
	 * <p>
	 * The first way it will stop is if the loop is executing to fast. It can sustain 60 FPS at a maximum recommendation.
	 * If it runs faster than the JVM can handle for 100 consecutive iterations, it is stopped. Do not confuse this
	 * with stopping the program.
	 * <p>
	 * The second way is if the iterate method runs into at least one error for 50 consecutive iterations. After that, the
	 * while loop will be broken.
	 * 
	 * @param loop The while loop to be run
	 * @return This Flowent object for method chaining purposes
	 * 
	 * @see flowent.FlowentWhileLoop#iterate(Flowent, int)
	 * @see flowent.FlowentWhileLoop#onError(Flowent, Exception, String)
	 * @see flowent.FlowentWhileLoop
	 * @see flowent.FlowentForLoop
	 * 
	 * @since 1.0.1
	 * 
	 * @author Adrian Gjerstad
	 */
	public Flowent runWhileLoop(FlowentWhileLoop loop) {
		// Iteration counter
		int i = 0;
		
		// elapsed time
		double firstTime = 0;
		double passedTime = 0;
		
		// Auto-break counters
		int unauthI = 0;
		int consErrors = 0;
		
		if(logOption) {
			log.println(">>> runWhileLoop(Object: " + loop.toString() + ")\n");
		}
		
		while(true) {
			firstTime = System.nanoTime() / 1000000000.0;
			try {
				if(loop.iterate(this, i)) {
					break;
				}
				
				consErrors = 0;
			} catch(Exception e) {
				consErrors++;
				String location = Thread.currentThread().getStackTrace()[2].toString();
				loop.onError(this, e, location);
				if(logOption) {
					log.println("Uncaught exception in thread \"" + Thread.currentThread().getName() + "\" " + e.getClass().getName() + ((e.getLocalizedMessage() != null) ? ": " + e.getLocalizedMessage() : ""));
					log.println("\tat " + location  + "\n");
				}
			}
			i++;
			passedTime = System.nanoTime() / 1000000000.0 - firstTime;
			
			if(passedTime < 0.01) {
				unauthI++;
				if(unauthI == 100) {
					println("While loop broken due to fast execution.");
					break;
				}
			} else {
				unauthI = 0;
			}
			
			if(consErrors == 50) {
				println("While loop broken due to a multitude of errors.");
				break;
			}
		}
		
		return this;
	}
	
	/**
	 * Exit the program with an exit value of 0. (Normal termination)
	 * 
	 * @see #exit(int)
	 * @see #exit(String)
	 * @see #exit(int, String)
	 */
	public void exit() {
		System.out.println();
		
		if(logOption) {
			log.println(">>> exit()\n");
		}
		
		System.exit(0);
	}
	
	/**
	 * Exit the program and print the given message. The JVM will exit with an
	 * exit value of 0. (Normal termination)
	 * 
	 * @param message The message to be printed during program exit.
	 * 
	 * @see #exit()
	 * @see #exit(int)
	 * @see #exit(int, String)
	 */
	public void exit(String message) {
		System.out.println();
		System.out.println(message + " (exit code 0)");
		
		if(logOption) {
			log.println(">>> exit(\"" + message + "\")\n");
		}
		
		System.exit(0);
	}
	
	/**
	 * Exit the program with the given exit value.
	 * 
	 * @param status The exit value to be given the the JVM on exit.
	 * 
	 * @see #exit()
	 * @see #exit(String)
	 * @see #exit(int, String)
	 */
	public void exit(int status) {
		System.out.println();
		
		if(logOption) {
			log.println(">>> exit(" + status + ")\n");
		}
		
		System.exit(status);
	}
	
	/**
	 * Prints the given message and exits with the value given.
	 * 
	 * @param status The exit value to be given to the JVM on exit.
	 * @param message The message to be printed along side the exit value given.
	 * 
	 * @see #exit()
	 * @see #exit(int)
	 * @see #exit(String)
	 */
	public void exit(int status, String message) {
		System.out.println();
		System.out.println(message + " (exit code " + status + ")");
		
		if(logOption) {
			log.println(">>> exit(" + status + ", \"" + message + "\")\n");
		}
		
		System.exit(status);
	}
	
	/**
	 * This method converts this <code>Flowent</code> object into a string format.
	 * It returns a String object in the format:
	 * <blockquote>
	 * <pre>
	 * "flowent" + id + "@" + Integer.toHexString(hashCode())
	 * </pre>
	 * </blockquote>
	 * 
	 * @see flowent.Flowent#id
	 * @see java.lang.Object#toString()
	 * 
	 * @return This <code>Flowent</code> object's id, along with other information.
	 */
	@Override
	public String toString() {
		return "flowent" + id + "@" + Integer.toHexString(hashCode());
	}
	
}
