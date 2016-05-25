package hollowmen.controller;

import hollowmen.enumerators.ClassType;
import hollowmen.enumerators.InputCommand;
import hollowmen.enumerators.InputMenu;

/**
 * Interface used to notify controller about input
 * 
 * @author Giordo
 *
 */
public interface ViewObserver {
	
	/**
	 * The method {@code addInput} notify a simple input
	 * related to the hero or to an item
	 * 
	 * @param input
	 */
	public void addInput(InputCommand input);
	
	/**
	 * The method {@code addInput} notify a simple input
	 * related to a menu
	 * 
	 * @param menu
	 */
	public void addInput(InputMenu menu);
	
	/**
	 * The method {@code addInput} notify an input and the 
	 * {@link Information} on which the input is used
	 * 
	 * @param input
	 * @param info
	 */
	public void addInput(InputCommand input, ImmutableItem item);
	
	/**
	 * The method {@code addInput} notify which class player choose
	 * 
	 * @param classType
	 */
	public void addInput(ClassType classType);
}
