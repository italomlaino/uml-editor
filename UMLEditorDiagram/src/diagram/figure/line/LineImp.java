package diagram.figure.line;

import java.awt.Point;
import java.util.Observable;

import model.relationship.Relationship;
import diagram.figure.surface.Surface;

public class LineImp extends Line {

	protected LineImp(Relationship relationship, Surface baseA, Surface baseB,
			LineType lineType) {
		super(relationship, baseA, baseB, lineType);
	}

	protected LineImp(Surface baseA, Point p2, LineType lineType) {
		super(baseA, p2, lineType);
	}

	@Override
	public void update(Observable o, Object arg) {
	}
}
