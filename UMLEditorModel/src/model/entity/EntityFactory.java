package model.entity;

import model.Model;

public class EntityFactory {

	protected static EntityFactory INSTANCE;

	protected EntityFactory() {
	}

	public static final EntityFactory getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new EntityFactory();
		}

		return INSTANCE;
	}

	public Model createEntity(EntityType entityType) {
		return createEntity(entityType.getName(), entityType);
	}

	public Model createEntity(String name, EntityType entityType) {
		return new EntityImp(name, entityType);
	}
}
