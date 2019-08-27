package gui;

import gui.data.EntityFactoryProxy;
import gui.frame.MainGUI;

import javax.swing.SwingUtilities;

public final class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				EntityFactoryProxy.setDefault();
				MainGUI.getInstance().setVisible(true);
			}
		});
	}
}
