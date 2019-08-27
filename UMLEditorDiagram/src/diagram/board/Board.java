package diagram.board;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import model.entity.EntityType;
import model.relationship.RelationshipType;
import diagram.board.setup.Setup;
import diagram.board.setup.SetupLine;
import diagram.board.setup.SetupSelect;
import diagram.board.setup.SetupSurface;
import diagram.figure.Figure;
import diagram.figure.line.LineType;

public final class Board extends JComponent {

	private Setup setup;

	private BoardStyle style;

	public Board() {
		initComponents();
	}

	private void initComponents() {
		setDoubleBuffered(true);
		setLayout(null);

		style = new BoardStyle();
		setBackground(style.getColor());
		setPreferredSize(style.getDimension());
		setSize(style.getDimension());
	}

	public void activateSetupSelect() {
		clearSetup();

		setup = new SetupSelect(this);
		addSetup(setup);
	}

	public void activateSetupSurface(final EntityType type) {
		clearSetup();

		setup = new SetupSurface(this, type);
		addSetup(setup);
	}

	public void activateSetupRelationship(final RelationshipType type,
			final LineType lineType) {
		clearSetup();

		setup = new SetupLine(this, type, lineType);
		addSetup(setup);
	}

	private void addSetup(Setup setup) {
		addMouseListener(setup);
		addMouseMotionListener(setup);
	}

	private void clearSetup() {
		if (setup == null) {
			return;
		}

		setup.dispose();

		removeMouseListener(setup);
		removeMouseMotionListener(setup);

		setup = null;
	}

	public void addFigure(final Figure figure) {
		super.add(figure);

		figure.revalidate();
		figure.repaint();
	}

	public void removeFigure(final Figure figure) {
		super.remove(figure);

		figure.revalidate();
		figure.repaint();
	}

	@Override
	public void paint(final Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getSize().width, getSize().height);

		super.paint(g);
	}

	@Override
	protected void paintComponent(final Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints renderHints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		renderHints.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(renderHints);

		super.paintComponent(g2d);
	}
}
