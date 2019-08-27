package model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.util.Operation;

public class OperationModImp extends OperationMod {

	private List<Operation> operations = new ArrayList<Operation>();

	/**
	 * {@inheritDoc}
	 */
	protected OperationModImp() {

	}

	/**
	 * {@inheritDoc}
	 */
	public void addOperation(Operation operation) {
		operations.add(operation);
		notifyChanges();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Operation> getOperations() {
		return Collections.unmodifiableList(operations);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
		notifyChanges();
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeOperation(Operation operation) {
		operations.remove(operation);
		notifyChanges();
	}

}
