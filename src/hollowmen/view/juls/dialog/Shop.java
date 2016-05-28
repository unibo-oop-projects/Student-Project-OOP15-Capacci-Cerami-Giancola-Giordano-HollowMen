package hollowmen.view.juls.dialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import hollowmen.model.facade.InformationDealer;
import hollowmen.view.juls.buttons.IconButton;
import hollowmen.view.juls.buttons.PaintedButton;
import hollowmen.view.juls.panel.PanelBuilder;

public class Shop extends TabbedDialog {

	private static final long serialVersionUID = -1975340404777455747L;
	private PaintedButton buy = new PaintedButton("BUY");
	private PaintedButton sell = new PaintedButton("SELL");
	private JPanel buttonC = PanelBuilder.getBuilder()
							.layout(1, 3, 30, 0)
							.bound(90, 450, 150, 58)
							.addTo(buy)
							.addTo(sell)
							.addTo(close)
							.build();

	public Shop(Frame frame, Collection<InformationDealer> collection) {
		super(frame);
		this.loadImages();
		super.addTitle(title);
		this.add(buttonC);
		statsBox.setBounds(420, 280, 130, 140);
		this.setButtonState(false, false);
		super.addMouseListener(dialogL);
		
		buy.addActionListener(listener);
		sell.addActionListener(listener);
		close.addActionListener(listener);

		this.populateTab(collection, "inventory", inventoryP);
		this.populateTab(collection, "shop", shopP);
		
		this.setVisible(true);
	}
	
	ActionListener listener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			name = ((PaintedButton) e.getSource()).getText();
			if(name.equals("BUY")) {
				//addInput(BUY, getLastItem());
				getButton().setEnabled(false);
			} else if (name.equals("SELL")) {
				//addInput(SELL, getLastItem());
				getButton().setEnabled(false);
			} else {
				dispose();
			}
		}
	};

	@Override
	protected void populateTab(Collection<InformationDealer> c, String tab, JPanel panel) {
		c.stream()	
		.filter(x -> x.getStat().equals("unequiped"))//TODO change getStat with getState()
		.forEach(x -> {
			stats = x.getStat();
			nameF = x.getName();
			icon = view.getStorage().get(nameF);
			button = new IconButton(icon);
			button.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
						setButtonState(false, true);
						setButton(button);
						setLastItem(x);
						showImage((ImageIcon) icon);
						statsBox.setText(showStats(stats));
						add(statsBox);	
				}
			});
			panel.add(button);
		});
		tabbedPane.addTab(tab, panel);
	}

	protected void populateShopTab(Collection<InformationDealer> c, String tab, JPanel panel) {
		c.stream()	
		.filter(x -> x.getStat().equals("buyable"))//TODO change getStat with getState()
		.forEach(x -> {
			stats = x.getStat();
			nameF = x.getName();
			icon = view.getStorage().get(nameF);
			button = new IconButton(icon);
			button.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
						setButtonState(true, false);
						setButton(button);
						setLastItem(x);
						showImage((ImageIcon) icon);
						statsBox.setText(showStats(stats));
						add(statsBox);	
				}
			});
			panel.add(button);
		});
		tabbedPane.addTab(tab, panel);
	}

	@Override
	protected void setButtonState(boolean b, boolean s) {
		buy.setEnabled(b);
		sell.setEnabled(s);	
	}
	
	private void loadImages() {
		try {
			title.setIcon(new ImageIcon(ImageIO.read(new File("res/images/titles/shop.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}