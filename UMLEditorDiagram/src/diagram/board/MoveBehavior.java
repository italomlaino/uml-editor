package diagram.board;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import diagram.figure.Figure;
import diagram.figure.surface.Surface;

public class MoveBehavior implements MouseListener, MouseMotionListener {

	private Board board;

	private boolean moving;

	private boolean stopped = false;

	private int width;
	private int height;

	private Figure selected;
	private JComponent rectangle;

	public MoveBehavior(Board board) {
		this.board = board;
	}

	public void register(Figure figure) {
		figure.addMouseListener(this);
		figure.addMouseMotionListener(this);
	}

	public void deregister(Figure figure) {
		figure.removeMouseListener(this);
		figure.removeMouseMotionListener(this);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Component c;

		if (!SwingUtilities.isLeftMouseButton(e)) {
			return;
		}

		if (stopped) {
			return;
		}

		c = e.getComponent();

		if (!(c instanceof Figure)) {
			return;
		}

		selected = (Figure) c;

		if (!moving) {
			width = (int) (e.getPoint().getX() - selected.getLocation().getX());
			height = (int) (e.getPoint().getY() - selected.getLocation().getY());

			// Shadow moving
			rectangle = new JPanel();
			rectangle.setBounds(selected.getBounds());
			rectangle.setBorder(BorderFactory.createLineBorder(Color.black));
			rectangle.setLocation(selected.getLocation());
			rectangle.setOpaque(false);
			board.add(rectangle);
			board.setComponentZOrder(rectangle, 0);

			rectangle.revalidate();
			rectangle.repaint();

			((Surface) selected).setTransparent(true);
			//

			moving = true;
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int newLocationX;
		int newLocationY;
		Point p1 = e.getPoint();

		if (moving) {
			newLocationX = (int) p1.getX() - width;
			newLocationY = (int) p1.getY() - height;

			if (newLocationX < 0) {
				newLocationX = 0;
			} else if (newLocationX > board.getSize().getWidth()
					- selected.getWidth()) {
				newLocationX = (int) board.getSize().getWidth()
						- selected.getWidth();
			}

			if (newLocationY < 0) {
				newLocationY = 0;
			} else if (newLocationY > board.getSize().getHeight()
					- selected.getHeight()) {
				newLocationY = (int) board.getSize().getHeight()
						- selected.getHeight();
			}

			// selected.setLocation(newLocationX, newLocationY);
			rectangle.setLocation(newLocationX, newLocationY);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (moving) {
			selected.setLocation(rectangle.getLocation());
			selected.revalidate();
			selected.repaint();
			((Surface) selected).paintLines();
			((Surface) selected).setTransparent(false);
			selected = null;

			board.remove(rectangle);
			rectangle = null;

			moving = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
