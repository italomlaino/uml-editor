package diagram.board.setup;

import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import model.relationship.RelationshipType;
import diagram.board.Board;
import diagram.figure.line.Line;
import diagram.figure.line.LineFactory;
import diagram.figure.line.LineType;
import diagram.figure.surface.Surface;

public class SetupLine extends Setup {

	private Board board;
	private Surface baseA;
	private Surface baseB;
	private Line shadowLine;

	private LineType lineType;
	private RelationshipType type;

	private boolean adding = false;

	public SetupLine(Board board, RelationshipType type, LineType lineType) {
		this.board = board;
		this.type = type;
		this.lineType = lineType;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Component c;

		if (!SwingUtilities.isLeftMouseButton(e)) {
			return;
		}

		if (adding) {
			return;
		}

		c = board.getComponentAt(e.getPoint());

		if (c instanceof Surface) {
			baseA = (Surface) c;
			adding = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Component c;

		if (!SwingUtilities.isLeftMouseButton(e)) {
			return;
		}

		if (!adding) {
			return;
		}

		c = board.getComponentAt(e.getPoint());

		if (c instanceof Surface) {
			baseB = (Surface) c;

			Line line = LineFactory.getInstance().createLine(type, baseA,
					baseB, lineType);

			board.add(line);

			line.revalidate();
			line.repaint();
		}

		adding = false;
		removeShadow();

		board.activateSetupSelect();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (e.getPoint() == null) {
			return;
		}

		if (!adding) {
			return;
		}

		removeShadow();

		shadowLine = LineFactory.getInstance().createLine(baseA, e.getPoint(),
				lineType);
		board.add(shadowLine);

		shadowLine.revalidate();
		shadowLine.repaint();
	}

	private void removeShadow() {
		if (shadowLine != null) {
			board.remove(shadowLine);
			board.repaint(shadowLine.getBounds());
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void dispose() {
	}
}
