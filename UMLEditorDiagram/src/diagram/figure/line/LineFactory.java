package diagram.figure.line;

import java.awt.Point;

import model.relationship.Relationship;
import model.relationship.RelationshipFactory;
import model.relationship.RelationshipType;
import diagram.figure.surface.Surface;

public class LineFactory {

	private static LineFactory instance;

	private LineFactory() {
	}

	public static LineFactory getInstance() {
		if (instance == null) {
			instance = new LineFactory();
		}

		return instance;
	}

	public Line createLine(RelationshipType type, Surface baseA, Surface baseB,
			LineType lineType) {
		Relationship relationship = (Relationship) RelationshipFactory
				.getInstance().createRelationship(type, baseA.getEntity(),
						baseB.getEntity());
		return new LineImp(relationship, baseA, baseB, lineType);
	}

	public Line createLine(Surface baseA, Point p2, LineType lineType) {
		return new LineImp(baseA, p2, lineType);
	}
}
