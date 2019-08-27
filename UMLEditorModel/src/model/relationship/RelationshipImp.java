package model.relationship;

import model.entity.Entity;

public class RelationshipImp extends Relationship {

	protected RelationshipImp(RelationshipType relationshipType, Entity baseA,
			Entity baseB) {
		super(relationshipType, baseA, baseB);
	}

}
