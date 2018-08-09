package flowent;

/**
 * FlowentFunction is a way of expressing a completely safe method, executable in the
 * Flowent method chain using {@link Flowent.runMethod(FlowentFunction)}.
 * </p>
 * Think of FlowentFunction as a More Blocks option in a block coding interface. You can build
 * your own methods and pass them into the Flowent method chain to be executed. This is also a
 * convenient way to store methods AND their failsafes in just one variable. Develop the method
 * as a FlowentFunction variable, such as:
 * 
 * <blockquote>
 * <code>private FlowentFunction helloWorld = new FlowentFunction() {</code><br/>
 * <br/>
 * <code>&nbsp; &nbsp; &#64;Override</code><br/>
 * <code>&nbsp; &nbsp; public void execute(Flowent f) {</code><br/>
 * <code>&nbsp; &nbsp; &nbsp; &nbsp; f.println("Hello, world!");</code><br/>
 * <code>&nbsp; &nbsp; }</code><br/>
 * <br/>
 * <code>};</code>
 * </blockquote>
 * 
 * Note: After the brackets used for defining, you still have to remember that you are in a variable
 * declaration, so you have to add a semicolon on the end.
 * </p>
 * The failsafe method, onError(Flowent, Exception), is called when something wrong has happened.
 * By default, this method is filled with error messages letting you know something went wrong. You
 * can override this, however, and change it however you'd like. You can even leave it blank! For
 * debugging purposes, though, it's probably not the best idea. At the very least, have <code>e.printStackTrace()</code>
 * in the function so that way the thread can revive itself safely.
 * </p>
 * 
 * @author Adrian Gjerstad
 * 
 * @since 1.0
 * 
 * @see flowent.Flowent#runMethod(FlowentFunction)
 * @see flowent.FlowentFunction#execute(Flowent)
 * @see flowent.FlowentFunction#onError(Flowent, Exception)
 * @see flowent.Flowent
 * @see java.lang.Exception
 */
public interface FlowentFunction {
	
	/**
	 * This method stores the functionality to be executed when called using Flowent.runMethod(FlowentFunction)
	 * 
	 * @param f The Flowent object that called the method in the first place.
	 * @throws Exception if something goes wrong during execution, then onError can pick up.
	 * 
	 * @see flowent.Flowent#runMethod(FlowentFunction)
	 * @see flowent.FlowentFunction#onError(Flowent, Exception, String)
	 * @see flowent.Flowent
	 * @see flowent.FlowentFunction
	 */
	public abstract void execute(Flowent f) throws Exception;
	
	/**
	 * This is the FlowentFunction's failsafe in case something goes wrong during execution of the execute(Flowent) method.
	 * </p>
	 * If you try to call this object's execute method, and an exception is thrown, it is up to you to catch it. This is why the
	 * {@link Flowent#runMethod(FlowentFunction)} method is easier. It already has the try catch in it.
	 * </p>
	 * By default, the onError method is set to print the exception's localized message and revive the thread,
	 * but you can override it very easily.
	 * </p>
	 * 
	 * @param f The Flowent object that called the method in the first place.
	 * @param e The exception that caused the error.
	 * @param location The location of the line that caused the issue
	 * 
	 * @see flowent.Flowent#runMethod(FlowentFunction)
	 * @see flowent.FlowentFunction#execute(Flowent)
	 * @see flowent.Flowent
	 * @see flowent.FlowentFunction
	 */
	public default void onError(Flowent f, Exception e, String location) {
		f.
		println("Uncaught exception in thread \"" + Thread.currentThread().getName() + "\" " + e.getClass().getName() + ": " + e.getLocalizedMessage()).
		println("\tat: " + location).
		println("Reviving thread...");
	}
	
}
