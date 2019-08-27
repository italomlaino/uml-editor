package gui.data;

import model.entity.EntityType;
import model.relationship.RelationshipType;
import diagram.figure.line.Line;
import diagram.figure.line.LineType;

public class Data {

	public static EntityType CLASS_TYPE = new EntityType("Classe", true, true,
			true);
	public static EntityType INTERFACE_TYPE = new EntityType("Interface",
			false, true, true);

	public static RelationshipType GENERALIZATION_TYPE = new RelationshipType(
			"Generaliza��o");

	public static RelationshipType REALIZATION_TYPE = new RelationshipType(
			"Realiza��o");

	public static RelationshipType ASSOCIATION_TYPE = new RelationshipType(
			"Associa��o");

	public static RelationshipType AGREGATION_TYPE = new RelationshipType(
			"Agrega��o");

	public static RelationshipType COMPOSITION_TYPE = new RelationshipType(
			"Composi��o");

	public static LineType GENERALIZATION_LINETYPE = new LineType(null,
			Line.createArrowHead(9, 18), false, null);

	public static LineType REALIZATION_LINETYPE = new LineType(null,
			Line.createArrowHead(9, 18), false, Line.getDashedStroke());

	public static LineType ASSOCIATION_LINETYPE = new LineType(null, null,
			false, null);

	public static LineType AGREGATION_LINETYPE = new LineType(null,
			Line.createComplexHead(18, 9), false, null);

	public static LineType COMPOSITION_LINETYPE = new LineType(null,
			Line.createComplexHead(18, 9), true, null);
}
