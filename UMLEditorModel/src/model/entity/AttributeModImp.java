package model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.util.Attribute;

public class AttributeModImp extends AttributeMod {

	private List<Attribute> attributes = new ArrayList<Attribute>();

	/**
	 * {@inheritDoc}
	 */
	protected AttributeModImp() {

	}

	/**
	 * {@inheritDoc}
	 */
	public void addAttribute(Attribute attribute) {
		attributes.add(attribute);
		notifyChanges();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Attribute> getAttributes() {
		return Collections.unmodifiableList(attributes);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeAttribute(Attribute attribute) {
		attributes.remove(attribute);
		notifyChanges();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
		notifyChanges();
	}
}
