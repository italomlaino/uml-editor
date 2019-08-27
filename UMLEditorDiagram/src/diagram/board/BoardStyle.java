package diagram.board;

import java.awt.Color;
import java.awt.Dimension;

public class BoardStyle {

	private static Color DEFAULT_COLOR = Color.white;
	private static Dimension DEFAULT_DIMENSION = new Dimension(5000, 5000);

	private Color color;
	private Dimension dimension;

	public BoardStyle() {
		color = DEFAULT_COLOR;
		dimension = DEFAULT_DIMENSION;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
}
