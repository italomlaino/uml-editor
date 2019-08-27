package model.entity;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.util.Attribute;

/**
 * Interface que implica na implementacao do gerenciamento de atributos.
 * 
 * @see Attribute
 */
public abstract class AttributeMod extends Observable {

	/**
	 * Adiciona um atributo.
	 * 
	 * @param attribute
	 */
	public abstract void addAttribute(Attribute attribute);

	/**
	 * Retorna uma lista de atributos.
	 * 
	 * @return atributos
	 */
	public abstract List<Attribute> getAttributes();

	/**
	 * Seta os atributos.
	 * 
	 * @param attributes
	 */
	public abstract void setAttributes(List<Attribute> attributes);

	/**
	 * Remove um atributo.
	 * 
	 * @param attribute
	 */
	public abstract void removeAttribute(Attribute attribute);

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
