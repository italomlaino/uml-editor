package diagram.figure;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import model.Model;

//TODO Implementar uma area para decoracao
public abstract class Figure extends JComponent implements Observer {

	private Model model;
	private boolean shadow = false;
	private boolean transparent = false;

	public Figure() {
	}

	public Figure(Model model) {
		this.model = model;

		if (model != null) {
			model.addObserver(this);
		}
	}

	public Model getModel() {
		return model;
	}

	public boolean isTransparent() {
		return transparent;
	}

	public void setTransparent(boolean transparent) {
		this.transparent = transparent;
	}

	public boolean isShadow() {
		return shadow;
	}

	public void setShadow(boolean shadow) {
		this.shadow = shadow;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();

		if (transparent) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					0.5f));
		}

		if (shadow) {

		}

		super.paint(g2);

		// if (selected) {
		// g2.fillRect(0, 0, SQUARE_SIZE, SQUARE_SIZE);
		// g2.fillRect((int) getSize().getWidth() - SQUARE_SIZE, 0,
		// SQUARE_SIZE, SQUARE_SIZE);
		// g2.fillRect(0, (int) getSize().getHeight() - SQUARE_SIZE,
		// SQUARE_SIZE, SQUARE_SIZE);
		// g2.fillRect((int) getSize().getWidth() - SQUARE_SIZE,
		// (int) getSize().getHeight() - SQUARE_SIZE, SQUARE_SIZE,
		// SQUARE_SIZE);
		// }
	}

	public abstract void update(Observable o, Object arg);
}
