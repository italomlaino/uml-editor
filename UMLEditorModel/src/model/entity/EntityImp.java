package model.entity;

public class EntityImp extends Entity {

	protected EntityImp(String name, EntityType entityType) {
		super(name, entityType,
				entityType.hasAttributes() ? new AttributeModImp() : null,
				entityType.hasOperations() ? new OperationModImp() : null,
				entityType.hasRelationships() ? new RelationshipModImp() : null);
	}
}
