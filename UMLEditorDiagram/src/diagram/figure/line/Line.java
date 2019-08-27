package diagram.figure.line;

import static java.awt.geom.AffineTransform.getRotateInstance;
import static java.awt.geom.AffineTransform.getTranslateInstance;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import model.relationship.Relationship;
import diagram.figure.Figure;
import diagram.figure.surface.Surface;

//TODO Implementar Conector
//TODO Ao invez de refazer component melhor destroir e fazer denovo
public abstract class Line extends Figure {

	private static int LINE_SIZE = 2;

	private Point p1;
	private Point p2;
	private Surface baseA;
	private Surface baseB;
	private LineType lineType;
	private Line2D.Double line;
	private Relationship relationship;

	protected Line(Relationship relationship, Surface baseA, Surface baseB,
			LineType lineType) {
		super(relationship);

		this.relationship = relationship;
		this.baseA = baseA;
		this.baseB = baseB;
		this.lineType = lineType;
		this.line = new Line2D.Double();

		this.setDoubleBuffered(true);

		baseA.addLine(this);
		baseB.addLine(this);
		getP1();
		getP2();
		setLocation(getPosition());
		setSize(getDimension());
	}

	protected Line(Surface baseA, Point p2, LineType lineType) {
		this.baseA = baseA;
		this.lineType = lineType;
		this.line = new Line2D.Double();

		this.setTransparent(true);
		this.setDoubleBuffered(true);

		this.p2 = p2;

		getP1();

		setLocation(getPosition());
		setSize(getDimension());
	}

	@Override
	protected void paintComponent(Graphics g) {
		getP1();
		getP2();
		setLocation(getPosition());
		setSize(getDimension());

		drawToRelativePos(g, lineType.getBaseB());
		// Graphics2D g2d = (Graphics2D) g;
		// g2d.drawRect(0, 0, getWidth() - SIZE_LINE, getHeight() - SIZE_LINE);
	}

	@Override
	public boolean contains(int x, int y) {

		if (line != null) {
			if (line.ptLineDist(x, y) < 5) {
				// JOptionPane.showMessageDialog(null, "True");
				return true;
			}
		}

		if (lineType.getBaseB() != null) {
			if (lineType.getBaseB().intersects(x, y, 1, 1)) {
				// JOptionPane.showMessageDialog(null, "True");
				return true;
			}
		}

		return false;
	}

	public void drawToRelativePos(Graphics g, Polygon polygon) {
		int x1;
		int y1;
		int x2;
		int y2;
		int dx = (int) Math.abs(p1.getX() - p2.getX());
		int dy = (int) Math.abs(p1.getY() - p2.getY());
		int dif;

		if (p1.getX() > p2.getX()) {
			// P1 esta a direita de P2
			if (p1.getY() > p2.getY()) {
				// P1 esta no Quarto Quadrante
				// P2 esta no Segundo Quadrante
				x1 = dx;
				y1 = dy;
				x2 = 0;
				y2 = 0;
			} else {
				// P1 esta no Primeiro Quadrante
				// P2 esta no Terceiro Quadrante
				x1 = dx;
				y1 = 0;
				x2 = 0;
				y2 = dy;
			}
		} else {
			// P1 esta a esquerda de P2
			if (p1.getY() > p2.getY()) {
				// P1 esta no Terceiro Quadrante
				// P2 esta no Primeiro Quadrante
				x1 = 0;
				y1 = dy;
				x2 = dx;
				y2 = 0;
			} else {
				// P1 esta no Segundo Quadrante
				// P2 esta no Quarto Quadrante
				x1 = 0;
				y1 = 0;
				x2 = dx;
				y2 = dy;
			}
		}

		if (polygon != null) {
			dif = getMaxSide(polygon) / 2;
			x1 += dif;
			y1 += dif;
			x2 += dif;
			y2 += dif;
		}
		drawArrow(g, x1, y1, x2, y2, line, polygon, lineType.isFill(),
				lineType.getStroke());
	}

	public static Polygon createArrowHead(int width, int height) {
		Polygon polygon = new Polygon(new int[] { 0, -width, -width, 0 },
				new int[] { 0, -height / 2, height / 2, 0 }, 4);

		return polygon;
	}

	public static Polygon createComplexHead(int width, int height) {
		Polygon polygon = new Polygon(new int[] { 0, -width / 2, -width,
				-width / 2 }, new int[] { 0, height / 2, 0, -height / 2 }, 4);

		return polygon;
	}

	private void drawArrow(Graphics g, int x1, int y1, int x2, int y2,
			Line2D.Double line, Polygon polygon, boolean fill, Stroke stroke) {
		double angle = Math.atan2(y2 - y1, x2 - x1);
		int len = (int) Point.distance(x1, y1, x2, y2);
		Polygon copy;
		Stroke backup;

		Graphics2D g2d = (Graphics2D) g.create();

		backup = g2d.getStroke();

		AffineTransform at = getTranslateInstance(x1, y1);
		at.concatenate(getRotateInstance(angle));

		// Nao usar setTransform
		g2d.transform(at);

		if (polygon != null) {
			copy = new Polygon(polygon.xpoints, polygon.ypoints,
					polygon.npoints);
			copy.translate(len, 0);

			if (line != null) {
				if (len > copy.getBounds().width) {
					if (stroke != null) {
						g2d.setStroke(stroke);
					}
					// line = new Line2D.Double(0, 0, (int) len
					// - polygon.getBounds().width, 0);
					line.setLine(0, 0, (int) len - copy.getBounds().width, 0);
					g2d.draw(line);

					g2d.setStroke(backup);
				}
			}
			g2d.draw(copy);

			if (fill) {
				g2d.fill(copy);
			}
		} else {
			if (line != null) {
				if (stroke != null) {
					g2d.setStroke(stroke);
				}
				line = new Line2D.Double(0, 0, (int) len, 0);
				g2d.draw(line);
				g2d.setStroke(backup);
			}
		}
	}

	private Point getPosition() {
		int x;
		int y;
		int dif;

		if (p1.getX() > p2.getX()) {
			x = (int) p2.getX();
		} else {
			x = (int) p1.getX();
		}

		if (p1.getY() > p2.getY()) {
			y = (int) p2.getY();
		} else {
			y = (int) p1.getY();
		}

		if (lineType.getBaseB() != null) {
			dif = getMaxSide(lineType.getBaseB()) / 2;
			x -= dif;
			y -= dif;
		}

		return new Point(x, y);
	}

	private Dimension getDimension() {
		int dx;
		int dy;
		int dif;

		dx = (int) Math.abs(p1.getX() - p2.getX());
		dy = (int) Math.abs(p1.getY() - p2.getY());

		if (lineType.getBaseB() != null) {
			dif = getMaxSide(lineType.getBaseB());
		} else {
			dif = LINE_SIZE;
		}

		dx += dif;
		dy += dif;

		return new Dimension(dx, dy);
	}

	private int getMaxSide(Polygon polygon) {
		if (polygon.getBounds().width > polygon.getBounds().height) {
			return polygon.getBounds().width;
		} else {
			return polygon.getBounds().height;
		}
	}

	public Point getP1() {
		if (baseA != null) {
			if (baseB != null) {
				p1 = baseA.getNearestPortTo(baseB.getLocation());
			} else {
				p1 = baseA.getNearestPortTo(p2);
			}
		}
		return p1;
	}

	public Point getP2() {
		if (baseB != null) {
			p2 = baseB.getNearestPortTo(baseA.getLocation());
		}
		return p2;
	}

	public static Stroke getDashedStroke() {
		final float[] dash1 = { 10.0f };
		final BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);

		return dashed;
	}

	public Surface getBaseA() {
		return baseA;
	}

	public Surface getBaseB() {
		return baseB;
	}

	public Relationship getRelationship() {
		return relationship;
	}
}
