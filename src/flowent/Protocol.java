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

/**
 * This enum when used in the onError methods of the custom code sections is
 * used to denote where the issue occured.
 * 
 * @see flowent.Protocol#FORLOOP
 * @see flowent.Protocol#WHILELOOP
 * @see flowent.Protocol#METHOD
 * @see flowent.Protocol#getValue()
 * 
 * @since 1.0.3
 */
public enum Protocol {
	
	/**
	 * The protocol constant used to denote events in a custom for loop.
	 */
	FORLOOP("for loop"),
	
	/**
	 * The protocol constant used to denote events in a custom while loop.
	 */
	WHILELOOP("while loop"),
	
	/**
	 * The protocol constant used to denote events in a custom while loop.
	 */
	METHOD("user-defined method");
	
	/* All details below are for the ability to have user-friendly names */
	
	/**
	 * The more programmer-friendly name of the enum constant, used for the
	 * defaults in the onError methods.
	 * 
	 * @see #getValue()
	 */
	private String value;
	
	/**
	 * Creates a new enum constant with it's user friendly name.
	 * 
	 * @param value The value to be added to the constant.
	 */
	private Protocol(String value) {
		this.value = value;
	}
	
	/**
	 * Retrieves the user-friendly name of the current constant.
	 * 
	 * @return The user-friendly constant name.
	 * 
	 * @see #value
	 */
	public String getValue() {
		return value;
	}
	
}
