package hollowmen.model;

/**
 * This interface represents any bullet, it can return his owner
 * @author pigio
 *
 */
public interface Bullet extends Actor{

	/**
	 * 
	 * @return {@link Actor} who throws this {@code Bullet}
	 */
	public Actor getOwner();
}
