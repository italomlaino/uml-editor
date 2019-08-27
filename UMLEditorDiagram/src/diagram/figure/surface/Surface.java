package diagram.figure.surface;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import model.entity.Entity;
import diagram.figure.Figure;
import diagram.figure.line.Line;

public class Surface extends Figure {

	private Entity entity;
	private List<Line> lines = new ArrayList<Line>();

	public Surface(Point p, Entity entity) {
		super(entity);
		this.entity = entity;
		super.setLocation(p);
	}

	public Point getNearestPortTo(Point to) {
		int x;
		int y;

		if (to.getX() > getX()) {
			if (to.getX() > getX() + getWidth()) {
				x = getX() + getWidth();
			} else {
				x = (int) to.getX();
			}
		} else {
			x = getX();
		}

		if (to.getY() > getY()) {
			if (to.getY() > getY() + getHeight()) {
				y = getY() + getHeight();
			} else {
				y = (int) to.getY();
			}
		} else {
			y = getY();
		}

		return new Point(x, y);
	}

	public void paintLines() {
		for (int i = 0; i < lines.size(); i++) {
			Line line = lines.get(i);
			line.repaint();
		}
	}

	public void addLine(Line line) {
		lines.add(line);
	}

	public Entity getEntity() {
		return entity;
	}

	@Override
	public void update(Observable o, Object arg) {
	}
}
