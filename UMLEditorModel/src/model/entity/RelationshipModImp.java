package model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.relationship.Relationship;

public class RelationshipModImp extends RelationshipMod {

	private List<Relationship> relationships = new ArrayList<Relationship>();

	/**
	 * {@inheritDoc}
	 */
	protected RelationshipModImp() {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addRelationship(Relationship relationship) {
		relationships.add(relationship);
		notifyChanges();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Relationship> getRelationships() {
		return Collections.unmodifiableList(relationships);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRelationships(List<Relationship> relationships) {
		this.relationships = relationships;
		notifyChanges();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeRelationship(Relationship relation) {
		relationships.add(relation);
		notifyChanges();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid(Relationship relation) {
		return false;
	}

}
