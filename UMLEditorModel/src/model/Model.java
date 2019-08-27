package model;

import java.util.Observable;
import java.util.Observer;

/**
 * Classe pai de todos os modelos.
 * 
 */
public abstract class Model extends Observable {

	private String name;

	/**
	 * Retorna o nome do modelo.
	 * 
	 * @return nome
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Seta o nome do modelo.
	 * 
	 * @param name
	 */
	public final void setName(final String name) {
		this.name = name;
		notifyChanges();
	}

	/**
	 * Retorna uma string que representa o modelo.
	 * 
	 * @return string
	 */
	@Override
	public final String toString() {
		return name;
	}

	/**
	 * Notifica mudanças para os observadores.
	 * 
	 * @see Observable
	 * @see Observer
	 */
	protected final void notifyChanges() {
		setChanged();
		notifyObservers();
	}
}
