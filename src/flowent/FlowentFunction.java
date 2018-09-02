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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FlowentFunction is a way of expressing a completely safe method, executable in the
 * Flowent method chain using {@link Flowent#runMethod(FlowentFunction)}.
 * <p>
 * Think of FlowentFunction as a More Blocks option in a block coding interface. You can build
 * your own methods and pass them into the Flowent method chain to be executed. This is also a
 * convenient way to store methods AND their failsafes in just one variable. Develop the method
 * as a FlowentFunction variable, such as:
 * 
 * <blockquote>
 * <code>private FlowentFunction helloWorld = new FlowentFunction() {</code><br>
 * <br>
 * <code>&nbsp; &nbsp; &#64;Override</code><br>
 * <code>&nbsp; &nbsp; public void execute(Flowent f) {</code><br>
 * <code>&nbsp; &nbsp; &nbsp; &nbsp; f.println("Hello, world!");</code><br>
 * <code>&nbsp; &nbsp; }</code><br>
 * <br>
 * <code>};</code>
 * </blockquote>
 * 
 * Note: After the brackets used for defining, you still have to remember that you are in a variable
 * declaration, so you have to add a semicolon on the end.
 * <p>
 * The failsafe method, onError(Flowent, Exception, String), is called when something wrong has happened.
 * By default, this method is filled with error messages letting you know something went wrong. You
 * can override this, however, and change it however you'd like. You can even leave it blank! For
 * debugging purposes, though, it's probably not the best idea.
 * 
 * @author Adrian Gjerstad
 * 
 * @since 1.0
 * 
 * @see flowent.Flowent#runMethod(FlowentFunction)
 * @see flowent.FlowentFunction#execute(Flowent)
 * @see flowent.FlowentFunction#onError(Flowent, Exception, Protocol)
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
	 * @see flowent.FlowentFunction#onError(Flowent, Exception, Protocol)
	 * @see flowent.Flowent
	 * @see flowent.FlowentFunction
	 */
	public abstract void execute(Flowent f) throws Exception;
	
	/**
	 * This is the FlowentFunction's failsafe in case something goes wrong during execution of the execute(Flowent) method.
	 * <p>
	 * If you try to call this object's execute method, and an exception is thrown, it is up to you to catch it. This is why the
	 * {@link Flowent#runMethod(FlowentFunction)} method is easier. It already has the try catch in it.
	 * <p>
	 * By default, the onError method is set to print the exception's message and revive the thread,
	 * but you can override it very easily.
	 * 
	 * @param f The Flowent object that called the method in the first place.
	 * @param e The exception that caused the error.
	 * @param p The protocol for denoting when the error happened. (user-defined function in this case)
	 * 
	 * @see flowent.Flowent#runMethod(FlowentFunction)
	 * @see flowent.FlowentFunction#execute(Flowent)
	 * @see flowent.Flowent
	 * @see flowent.FlowentFunction
	 */
	public default void onError(Flowent f, Exception e, Protocol p) {
		System.err.println("Exception in thread \"" + Thread.currentThread().getName() + "\" " + e.getClass().getName() + ((e.getMessage() != null) ? ": " + e.getMessage() : ""));
		for(StackTraceElement stackTrace : e.getStackTrace()) {
			System.err.println("\tat " + stackTrace.toString());
		}
		
		System.err.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Occured during a " + p.getValue() + " protocol.");
		System.err.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Reviving thread \"" + Thread.currentThread().getName() + "\"...");
	}
	
}
