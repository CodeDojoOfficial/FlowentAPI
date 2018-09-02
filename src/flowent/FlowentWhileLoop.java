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
 * FlowentWhileLoop is an interface that can be utilized to create loops from within the method chain. More
 * specifically, while loops. You can run a FlowentWhileLoop within the method chain by using
 * {@link Flowent#runWhileLoop(FlowentWhileLoop) Flowent.runWhileLoop}.
 * <p>
 * The {@linkplain FlowentWhileLoop#iterate(Flowent, int) iterate} method is executed in the native while loop
 * within the runWhileLoop method.
 * 
 * @see flowent.Flowent#runWhileLoop(FlowentWhileLoop)
 * @see flowent.FlowentWhileLoop
 * 
 * @since 1.0.1
 */
public interface FlowentWhileLoop {
	
	/**
	 * This is the method called by the Flowent object within a for loop.
	 * 
	 * @param f The Flowent object that called this method
	 * @param iteration The number of times before this call the method has been called
	 * @return True if the loop should be broken, false if it should continue
	 * 
	 * @throws Exception If something goes wrong, onError can pick up.
	 * 
	 * @see flowent.Flowent#runWhileLoop(FlowentWhileLoop)
	 * @see flowent.FlowentWhileLoop#onError(Flowent, Exception, Protocol)
	 * @see flowent.Flowent
	 * @see flowent.FlowentWhileLoop
	 * 
	 * @since 1.0.1
	 */
	public boolean iterate(Flowent f, int iteration) throws Exception;
	
	/**
	 * This is the FlowentWhileLoop's failsafe in case something goes wrong during execution of the {@link FlowentWhileLoop#iterate(Flowent, int)} method.
	 * <p>
	 * If you try to call this object's execute method, and an exception is thrown, it is up to you to catch it. This is why the
	 * {@link Flowent#runWhileLoop(FlowentWhileLoop)} method is easier. It already has the try catch in it.
	 * <p>
	 * By default, the onError method is set to print the exception's message and revive the thread,
	 * but you can override it very easily.
	 * 
	 * @param f The Flowent object that called the method in the first place.
	 * @param e The exception that caused the error.
	 * @param p The protocol for denoting when the error happened. (while loop in this case)
	 * 
	 * @see flowent.Flowent#runWhileLoop(FlowentWhileLoop)
	 * @see flowent.FlowentWhileLoop#iterate(Flowent, int)
	 * @see flowent.Flowent
	 * @see flowent.FlowentWhileLoop
	 * 
	 * @since 1.0.1
	 */
	public default void onError(Flowent f, Exception e, Protocol p) {
		// Code taken from FlowntFunction.onError():
		
		System.err.println("Exception in thread \"" + Thread.currentThread().getName() + "\" " + e.getClass().getName() + ((e.getMessage() != null) ? ": " + e.getMessage() : ""));
		for(StackTraceElement stackTrace : e.getStackTrace()) {
			System.err.println("\tat " + stackTrace.toString());
		}
		
		System.err.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Occured during a " + p.getValue() + " protocol.");
		System.err.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Reviving thread \"" + Thread.currentThread().getName() + "\"...");
	}
	
}
