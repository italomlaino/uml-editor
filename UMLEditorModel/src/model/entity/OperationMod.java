package model.entity;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.util.Operation;

/**
 * Interface que implica na implementacao do gerenciamento de operacoes.
 * 
 * @see Operation
 */
public abstract class OperationMod extends Observable {

	/**
	 * Adiciona uma operacao.
	 */
	public abstract void addOperation(Operation operation);

	/**
	 * Retorna uma lista de operacoes.
	 * 
	 * @return operacoes
	 */
	public abstract List<Operation> getOperations();

	public abstract void setOperations(List<Operation> operations);

	/**
	 * Remove uma operacao.
	 * 
	 * @param operation
	 */
	public abstract void removeOperation(Operation operation);

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
