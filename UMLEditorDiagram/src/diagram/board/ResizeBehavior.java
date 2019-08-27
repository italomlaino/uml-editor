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

public class ResizeBehavior implements MouseListener, MouseMotionListener {

	private static int PADDING = 10;

	private boolean resizing = false;

	private boolean resizeX;
	private boolean resizeY;

	private Board board;
	private Point cornerPoint;

	private Figure selected;
	private JComponent rectangle;

	public ResizeBehavior(Board board) {
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
		Point p1;

		if (!SwingUtilities.isLeftMouseButton(e)) {
			return;
		}

		if (resizing) {
			return;
		}

		c = e.getComponent();

		if (!(c instanceof Figure)) {
			return;
		}

		selected = (Figure) c;
		p1 = e.getPoint();

		cornerPoint = getCornerPoint(selected, p1);

		if (cornerPoint != null) {
			// Shadow resizing
			rectangle = new JPanel();

			rectangle.setSize(selected.getSize());
			rectangle.setMinimumSize(selected.getMinimumSize());
			rectangle.setMaximumSize(selected.getMaximumSize());
			rectangle.setBorder(BorderFactory.createLineBorder(Color.black));
			rectangle.setLocation(selected.getLocation());
			rectangle.setOpaque(false);

			board.add(rectangle);
			board.setComponentZOrder(rectangle, 0);

			rectangle.revalidate();
			rectangle.repaint();

			selected.setTransparent(true);
			resizing = true;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int newX;
		int newY;
		int newSizeX;
		int newSizeY;
		Point p1;

		if (resizing) {
			p1 = e.getPoint();
			newX = (int) rectangle.getLocation().getX();
			newY = (int) rectangle.getLocation().getY();

			if (resizeX) {
				newX = (int) p1.getX();
				newSizeX = (int) Math.abs(rectangle.getLocation().getX()
						+ rectangle.getWidth() - p1.getX());
			} else {
				newSizeX = (int) Math.abs(rectangle.getLocation().getX()
						- p1.getX());
			}

			if (resizeY) {
				newY = (int) p1.getY();
				newSizeY = (int) Math.abs(rectangle.getLocation().getY()
						+ rectangle.getHeight() - p1.getY());
			} else {
				newSizeY = (int) Math.abs(rectangle.getLocation().getY()
						- p1.getY());
			}

			if (newSizeX <= rectangle.getMinimumSize().getWidth()) {
				newX = (int) rectangle.getLocation().getX();
				newSizeX = (int) rectangle.getMinimumSize().getWidth();
			}

			if (newSizeY <= rectangle.getMinimumSize().getHeight()) {
				newY = (int) rectangle.getLocation().getY();
				newSizeY = (int) rectangle.getMinimumSize().getHeight();
			}

			rectangle.setLocation(newX, newY);
			rectangle.setSize(newSizeX, newSizeY);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (resizing) {
			selected.setLocation(rectangle.getLocation());
			selected.setSize(rectangle.getSize());
			selected.revalidate();
			selected.repaint();
			((Surface) selected).paintLines();
			selected.setTransparent(false);
			selected = null;

			board.remove(rectangle);
			rectangle = null;

			resizing = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	private Point getCornerPoint(Component component, Point p) {

		Point p1 = component.getLocation();
		Point p2 = ((Point) component.getLocation().clone());
		p2.translate(component.getWidth(), 0);

		Point p3 = ((Point) component.getLocation().clone());
		p3.translate(0, component.getHeight());

		Point p4 = ((Point) component.getLocation().clone());
		p4.translate(component.getWidth(), component.getHeight());

		if (p1.distance(p) < PADDING) {
			resizeX = true;
			resizeY = true;
			return p1;
		}

		if (p2.distance(p) < PADDING) {
			resizeX = false;
			resizeY = true;
			return p2;
		}

		if (p3.distance(p) < PADDING) {
			resizeX = true;
			resizeY = false;
			return p3;
		}

		if (p4.distance(p) < PADDING) {
			resizeX = false;
			resizeY = false;
			return p4;
		}

		resizeX = false;
		resizeY = false;

		return null;
	}
}
