package model.relationship;

import model.Model;
import model.entity.Entity;

public class RelationshipFactory {

	private static RelationshipFactory instance;

	protected RelationshipFactory() {
	}

	public static RelationshipFactory getInstance() {

		if (instance == null) {
			instance = new RelationshipFactory();
		}

		return instance;
	}

	public Model createRelationship(RelationshipType relationshipType,
			Entity baseA, Entity baseB) {
		return new RelationshipImp(relationshipType, baseA, baseB);
	}
}
