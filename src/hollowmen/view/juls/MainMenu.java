package hollowmen.view.juls;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hollowmen.controller.ViewObserver;
import hollowmen.view.SingletonFrame;
import hollowmen.view.juls.buttons.PaintedButton;
import hollowmen.view.juls.dialog.CreditsMenu;
import hollowmen.view.juls.dialog.ExitDialog;
import hollowmen.view.juls.dialog.HelpMenu;
import hollowmen.view.juls.dialog.NewGameDialog;
import hollowmen.view.juls.dialog.PauseMenu;

/**
 * The {@code MainMenu} class it's a visual representation
 * of the Main Menu of the app. From here, the user can start using
 * the software.
 * 
 * @author Juls
 * @version 2.2
 * @since 11/05
 * 
 * Last Update: 24/05 21:40
 */
public class MainMenu extends JFrame {

	private static final long serialVersionUID = 3001623152687149057L;
	private static final int TITLE_X = 30;
	private static final int TITLE_Y = 50;
	private static final int TITLE_WIDTH = 270;
	private static final int TITLE_HEIGHT = 190;
	
	private JPanel buttonsContainer = new JPanel(); // will contain the buttons (no surprise)

	private PaintedButton newGame = new PaintedButton("NEW GAME");
	private PaintedButton loadGame = new PaintedButton("LOAD GAME");
	private PaintedButton help = new PaintedButton("HELP");
	private PaintedButton credits = new PaintedButton("CREDITS");
	private PaintedButton exit = new PaintedButton("EXIT");

	private final JLabel label = new JLabel();
	private final JLabel title = new JLabel();
	
	private ViewObserver observer; //needed to tell Controller what happens
	

	public MainMenu() {
		
		// obtaining a reference to the only instance of the SingletonFrame class
		SingletonFrame frame = SingletonFrame.getInstance();
		
		// loading of the images (background and title)
		try {
			label.setIcon(new ImageIcon(ImageIO.read(new File("res/images/castle.jpg"))));
			title.setIcon(new ImageIcon(ImageIO.read(new File("res/images/title.png"))));			
		} catch (IOException e) {
			e.printStackTrace();
		}
		// setting "label" as background image
		frame.setContentPane(label);
		
		title.setBounds(TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT);
		
		buttonsContainer.setOpaque(false);	// lets see the background under the component
		buttonsContainer.setLayout(new GridLayout(5,1,8,0)); // GridLayout it's great for a menu
		buttonsContainer.add(newGame);
		buttonsContainer.add(loadGame);
		buttonsContainer.add(help);
		buttonsContainer.add(credits);
		buttonsContainer.add(exit);
		buttonsContainer.setBounds(90, 240, 150, 300);
		
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewGameDialog(frame);
			}
		});
		
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PauseMenu(frame);
			}
		});
		
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HelpMenu(frame);
			}
		});
		
		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreditsMenu(frame);
			}
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExitDialog(frame);
			}
		});
		
		frame.add(title);
		frame.add(buttonsContainer);
		frame.setVisible(true);
		
	}

	/* This main is here just for me, will be deleted once everything works... */
	public static void main(String args[]) {
		SingletonFrame.setWidth(800);
		SingletonFrame.setHeight(600);
		new MainMenu();
	}

}
