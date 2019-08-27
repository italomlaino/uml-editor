package model.entity;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.relationship.Relationship;

public abstract class RelationshipMod extends Observable {

	/**
	 * Adiciona um relacionamento da entidade.
	 * 
	 * @param relationship
	 */
	public abstract void addRelationship(Relationship relationship);

	/**
	 * Retorna todos os relacionamentos da entidade.
	 * 
	 * @return
	 */
	public abstract List<Relationship> getRelationships();

	/**
	 * Remove um relacionamento da entidade.
	 * 
	 * @param relation
	 */
	public abstract void removeRelationship(Relationship relation);

	public abstract void setRelationships(List<Relationship> relationships);

	/**
	 * Verifica se a relacao e valida para a classe.
	 * 
	 * @param relation
	 * @return
	 */
	public abstract boolean isValid(Relationship relation);

	/**
	 * Notifica mudanças para os observadores.
	 * 
	 * @see Observable
	 * @see Observer
	 */
	protected void notifyChanges() {
		setChanged();
		notifyObservers();
	}
}
