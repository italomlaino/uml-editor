package model.relationship;

import model.Model;
import model.entity.Entity;

/**
 * Classe pai de todos os relacionamentos.
 * 
 */
public abstract class Relationship extends Model {

	private RelationshipType relationshipType;

	private Entity baseA;
	private Entity baseB;

	/**
	 * Constroi um relacionamento.
	 * 
	 * @param baseA
	 * @param baseB
	 * @see Entity
	 */
	protected Relationship(RelationshipType relationshipType, Entity baseA,
			Entity baseB) {
		this.relationshipType = relationshipType;
		this.baseA = baseA;
		this.baseB = baseB;
	}

	/**
	 * Retorna a entidade onde comeca o relacionamento.
	 * 
	 * @return comeco
	 * @see Entity
	 */
	public Entity getBaseA() {
		return baseA;
	}

	/**
	 * Retorna a entidade onde termina o relacionamento.
	 * 
	 * @return final
	 * @see Entity
	 */
	public Entity getBaseB() {
		return baseB;
	}

	/**
	 * Seta a entidade inicial.
	 * 
	 * @param baseA
	 * @see Entity
	 */
	public void setBaseA(Entity baseA) {
		this.baseA = baseA;
		notifyChanges();
	}

	/**
	 * Seta a entidade final.
	 * 
	 * @param baseB
	 * @see Entity
	 */
	public void setBaseB(Entity baseB) {
		this.baseB = baseB;
		notifyChanges();
	}

	public RelationshipType getRelationshipType() {
		return relationshipType;
	}
}
