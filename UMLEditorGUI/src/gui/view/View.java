package gui.view;

import javax.swing.JPanel;

public abstract class View extends JPanel {

	private String text;

	public View(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return getText();
	}
}
