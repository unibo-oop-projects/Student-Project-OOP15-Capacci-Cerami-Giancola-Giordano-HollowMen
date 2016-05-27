package hollowmen.view.juls.dialog;

import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import hollowmen.view.juls.buttons.PaintedButton;
import hollowmen.view.juls.panel.PanelBuilder;

/**
 * The {@code GridDialog} abstract class will be extended from
 * those classes that need to create panels with
 * grid-organized buttons.
 * @author Juls
 *
 */
public abstract class GridDialog extends MenuDialog {

	private static final long serialVersionUID = -7697502946815508802L;
	protected JLabel portrait = new JLabel();
	protected JScrollBar scroll = new JScrollBar();
	protected JPanel gridPanel = PanelBuilder.getBuilder()
								.layout(20, 3, 3, 2)
								.bound(50, 70, 165, 160)
								.addTo(scroll)
								.build();
	protected PaintedButton close = new PaintedButton("CLOSE");
	protected JPanel buttonC = PanelBuilder.getBuilder()
								.layout(1, 0, 0, 0)
								.bound(300, 480, 150, 58)
								.addTo(close)
								.build();
	
	
	public GridDialog(Frame frame) {
		super(frame);
		this.add(gridPanel);
		this.add(buttonC);
	}
	
	/**
	 * The {@code addPortrait} method draws something on screen,
	 * for instance a bigger image of an Item or Mob.
	 * @param image - the image to draw
	 */
	protected void addPortrait(JLabel image) {
		this.portrait = image;
		JPanel p = PanelBuilder.getBuilder()
				.layout(1, 0, 0, 0)
				.bound(430, 50, 120, 120)
				.addTo(portrait)
				.build();
		//addInfoBox();
	}
	
	/**
	 * The {@code addInfoBox} method adds information about 
	 * what has been clicked before.
	 */
	protected void addInfoBox(/* ci andr� qualcosa*/) {
		//da implementare
	}
	

}