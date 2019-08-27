package diagram.figure.line;

import java.awt.Polygon;
import java.awt.Stroke;

public class LineType {

	private boolean fill;
	private Polygon baseA;
	private Polygon baseB;
	private Stroke stroke;

	public LineType(Polygon baseA, Polygon baseB, boolean fill, Stroke stroke) {
		this.baseA = baseA;
		this.baseB = baseB;
		this.fill = fill;
		this.stroke = stroke;
	}

	public boolean isFill() {
		return fill;
	}

	public Polygon getBaseA() {
		return baseA;
	}

	public Polygon getBaseB() {
		return baseB;
	}

	public Stroke getStroke() {
		return stroke;
	}
}
