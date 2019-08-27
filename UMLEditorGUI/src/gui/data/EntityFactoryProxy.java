package gui.data;

import model.Model;
import model.entity.EntityFactory;
import model.entity.EntityType;

public class EntityFactoryProxy extends EntityFactory {

	private EntityFactoryProxy() {
	}

	public static void setDefault() {
		INSTANCE = new EntityFactoryProxy();
	}

	private String lookForAName(EntityType entityType) {

		int i = 0;
		boolean found;
		String name;

		do {
			found = false;
			name = entityType.getName() + i++;

			for (int j = 0; j < Workspace.getInstance().getModels().size(); j++) {
				Model model = Workspace.getInstance().getModels().get(j);
				if (model.getName().equals(name)) {
					found = true;
					break;
				}
			}
		} while (found);

		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Model createEntity(EntityType entityType) {
		return createEntity(lookForAName(entityType), entityType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Model createEntity(String name, EntityType entityType) {
		Model model = super.createEntity(name, entityType);

		Workspace.getInstance().addModel(model);

		return model;
	}
}
