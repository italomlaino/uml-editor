package diagram.figure.surface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import model.entity.Entity;
import diagram.util.ItemPanel;

public class ClassEntitySpc extends Surface {

	private static int gapX = 50;
	private static int gapY = 50;
	private static Color DEFAULT_BACKGROUNDCOLOR = Color
			.getHSBColor(80, 20, 20); // 80, 20, 20

	// TODO Remover esse count
	private int count = 0;
	private ItemPanel namePanel;
	private ItemPanel attributePanel;
	private ItemPanel operationPanel;
	private Entity entity;
	private GridBagLayout layout;

	public ClassEntitySpc(Point p, Entity entity) {
		super(p, entity);
		this.entity = entity;
		initComponents();
	}

	private void initComponents() {
		setBorder(BorderFactory.createLineBorder(Color.black, 2));
		setBackground(DEFAULT_BACKGROUNDCOLOR);

		layout = new GridBagLayout();
		setLayout(layout);

		List<Object> topList = new ArrayList<Object>();
		topList.add(entity);

		namePanel = new ItemPanel(entity);
		namePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0,
				Color.black));
		addPanel(namePanel, 0.3);

		if (entity.hasAttributes()) {
			attributePanel = new ItemPanel(entity.getAttributeMod());
			attributePanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0,
					0, Color.black));
			addPanel(attributePanel, 2);
		}

		if (entity.hasOperations()) {
			operationPanel = new ItemPanel(entity.getOperationMod());
			operationPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0,
					0, Color.black));
			addPanel(operationPanel, 2);
		}

		resize();
		revalidate();
	}

	private void addPanel(JComponent panel, double weighty) {
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = weighty;
		c.gridx = 0;
		c.gridy = count++;
		c.anchor = GridBagConstraints.SOUTH;
		layout.setConstraints(panel, c);
		add(panel);
	}

	private void resize() {
		int sizeX;
		int sizeY;

		sizeX = 0;
		sizeY = 0;
		for (Component component : getComponents()) {
			if (sizeX < component.getWidth()) {
				sizeX = component.getWidth();
			}

			sizeY += component.getHeight();
		}

		setPreferredSize(new Dimension(sizeX + gapX, sizeY + gapY));
		setSize(new Dimension(sizeX + gapX, sizeY + gapY));
		setMinimumSize(new Dimension(sizeX + gapX, sizeY + gapY));
	}

	@Override
	public final void update(final Observable o, final Object arg) {
		if (namePanel != null) {
			namePanel.update();
		}

		if (attributePanel != null) {
			attributePanel.update();
		}

		if (operationPanel != null) {
			operationPanel.update();
		}

		resize();

		revalidate();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.drawRect(0, 0, (int) getSize().getWidth(), (int) getSize()
				.getHeight());
		g.setColor(getBackground());
		g.fillRect(0, 0, (int) getSize().getWidth(), (int) getSize()
				.getHeight());
		super.paint(g);
	}
}
