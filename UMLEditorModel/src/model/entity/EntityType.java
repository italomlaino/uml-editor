package model.entity;

public class EntityType {

	private String name;
	private boolean hasAttributes;
	private boolean hasOperations;
	private boolean hasRelationships;

	public EntityType(String name, boolean hasAttributes,
			boolean hasOperations, boolean hasRelationships) {
		this.name = name;
		this.hasAttributes = hasAttributes;
		this.hasOperations = hasOperations;
		this.hasRelationships = hasRelationships;
	}

	public String getName() {
		return name;
	}

	public boolean hasAttributes() {
		return hasAttributes;
	}

	public boolean hasOperations() {
		return hasOperations;
	}

	public boolean hasRelationships() {
		return hasRelationships;
	}
}
