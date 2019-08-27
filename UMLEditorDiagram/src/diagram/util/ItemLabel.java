package diagram.util;

import javax.swing.JLabel;

public class ItemLabel extends JLabel {

	private boolean customText = false;
	private Object object;

	public ItemLabel(Object object) {
		this.object = object;

		customText = false;
		if (object != null) {
			this.setText(object.toString());
		}
	}

	public ItemLabel(Object object, String text) {
		this.object = object;
		this.setText(text);
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;

		if (object == null) {
			return;
		}

		if (!customText) {
			setText(object.toString());
			customText = false;
		}
	}

	@Override
	public void setText(String text) {
		super.setText(text);
		customText = true;
	}

	@Override
	public String toString() {
		return getText();
	}
}
