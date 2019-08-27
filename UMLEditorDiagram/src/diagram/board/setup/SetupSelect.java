package diagram.board.setup;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import model.entity.Entity;
import diagram.board.Board;
import diagram.board.MoveBehavior;
import diagram.board.ResizeBehavior;
import diagram.figure.Figure;
import diagram.util.QuickEditor;

public class SetupSelect extends Setup {

	private Board board;

	private MoveBehavior moveBehavior;
	private ResizeBehavior resizeBehavior;

	private List<Figure> selecteds;

	public SetupSelect(Board board) {
		this.board = board;
		moveBehavior = new MoveBehavior(board);
		resizeBehavior = new ResizeBehavior(board);
		selecteds = new ArrayList<Figure>();
	}

	private void select(Figure figure) {
		clearSelects();
		board.setComponentZOrder(figure, 0);
		addSelect(figure);
	}

	private void addSelect(Figure figure) {
		register(figure);
		selecteds.add(figure);
	}

	private void removeSelect(Figure figure) {
		deregister(figure);
		selecteds.remove(figure);
	}

	private void clearSelects() {
		for (int i = 0; i < selecteds.size(); i++) {
			Figure figure = selecteds.get(i);
			removeSelect(figure);
		}
	}

	private void register(Figure figure) {
		moveBehavior.register(figure);
		resizeBehavior.register(figure);
	}

	private void deregister(Figure figure) {
		moveBehavior.deregister(figure);
		resizeBehavior.deregister(figure);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point p;
		Component c;
		Figure selected;

		if (!selecteds.isEmpty()) {
			clearSelects();
		}

		p = e.getPoint();

		c = board.getComponentAt(p);

		if (c == null) {
			return;
		}

		if (!(c instanceof Figure)) {
			return;
		}

		selected = (Figure) c;

		if (SwingUtilities.isRightMouseButton(e)) {
			if (selected.getModel() instanceof Entity) {
				QuickEditor quickEditor = new QuickEditor(
						(Entity) selected.getModel());
				quickEditor.setVisible(true);
			}

			return;
		} else {
			select(selected);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void dispose() {
		clearSelects();
	}
}
