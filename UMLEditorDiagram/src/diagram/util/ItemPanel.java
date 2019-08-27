package diagram.util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComponent;

import model.entity.AttributeMod;
import model.entity.Entity;
import model.entity.OperationMod;
import model.util.Attribute;
import model.util.Operation;

public class ItemPanel extends JComponent {

	private Entity entity;
	private AttributeMod attributeMod;
	private OperationMod operationMod;

	public ItemPanel(OperationMod operationMod) {
		this.operationMod = operationMod;
		initComponents();
	}

	public ItemPanel(AttributeMod attributeMod) {
		this.attributeMod = attributeMod;
		initComponents();
	}

	public ItemPanel(Entity entity) {
		this.entity = entity;
		initComponents();
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		update();
	}

	public void update() {
		fill();
		resize();
	}

	private void fill() {
		ItemLabel itemLabel;

		removeAll();

		if (entity != null) {
			itemLabel = new ItemLabel(entity);
			itemLabel.setAlignmentX(CENTER_ALIGNMENT);
			add(itemLabel);
		} else if (attributeMod != null) {
			for (int i = 0; i < attributeMod.getAttributes().size(); i++) {
				Attribute att = attributeMod.getAttributes().get(i);
				itemLabel = new ItemLabel(att);
				itemLabel.setAlignmentX(CENTER_ALIGNMENT);
				add(itemLabel);
			}
		} else if (operationMod != null) {
			for (int i = 0; i < operationMod.getOperations().size(); i++) {
				Operation opp = operationMod.getOperations().get(i);
				itemLabel = new ItemLabel(opp);
				itemLabel.setAlignmentX(CENTER_ALIGNMENT);
				add(itemLabel);
			}
		}
	}

	private void resize() {
		int sizeX;
		int sizeY;
		ItemLabel itemLabel;

		sizeX = 0;
		sizeY = 0;
		for (Component component : getComponents()) {
			if (component instanceof ItemLabel) {
				itemLabel = (ItemLabel) component;

				if (itemLabel.getPreferredSize().getWidth() > sizeX) {
					sizeX = (int) itemLabel.getPreferredSize().getWidth();
				}

				sizeY += (int) itemLabel.getPreferredSize().getHeight();
			}
		}

		setPreferredSize(new Dimension(sizeX, sizeY));
		setSize(new Dimension(sizeX, sizeY));
		setMinimumSize(new Dimension(sizeX, sizeY));
	}
}
