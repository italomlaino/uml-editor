package model.entity;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import model.util.Visibility;

/**
 * Classe pai de todos os modelos tipo entidade.
 * 
 */
public abstract class Entity extends Model implements Observer {

	private EntityType entityType;
	private AttributeMod attributeMod;
	private OperationMod operationMod;
	private RelationshipMod relationshipMod;
	private Visibility visibility = Visibility.Public;

	protected Entity(String name, EntityType entityType,
			AttributeMod attributeMod, OperationMod operationMod,
			RelationshipMod relationshipMod) {
		super.setName(name);
		this.entityType = entityType;
		this.attributeMod = attributeMod;
		this.operationMod = operationMod;
		this.relationshipMod = relationshipMod;

		if (attributeMod != null) {
			attributeMod.addObserver(this);
		}

		if (operationMod != null) {
			operationMod.addObserver(this);
		}

		if (relationshipMod != null) {
			relationshipMod.addObserver(this);
		}
	}

	public boolean hasAttributes() {
		if (attributeMod != null) {
			return true;
		}

		return false;
	}

	public boolean hasOperations() {
		if (operationMod != null) {
			return true;
		}

		return false;
	}

	public boolean hasRelationships() {
		if (relationshipMod != null) {
			return true;
		}

		return false;
	}

	public AttributeMod getAttributeMod() {
		return attributeMod;
	}

	public OperationMod getOperationMod() {
		return operationMod;
	}

	public RelationshipMod getRelationshipMod() {
		return relationshipMod;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	@Override
	public void update(Observable o, Object arg) {
		notifyChanges();
	}
}
