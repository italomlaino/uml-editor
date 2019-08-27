package model.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Item do tipo operacao.
 * 
 * @see Item
 * @see Operation
 */
public class Operation extends Item {

	private List<Parameter> parameters = new ArrayList<Parameter>();
	private Type returnType;
	private Visibility visibility = Visibility.Public;

	/**
	 * Constroi uma operacao.
	 * 
	 * @param name
	 */
	public Operation(String name) {
		super(name);
	}

	/**
	 * Constroi uma operacao.
	 * 
	 * @param name
	 * @param returnType
	 */
	public Operation(String name, Type returnType) {
		super(name);
		this.returnType = returnType;
	}

	/**
	 * Adiciona um parametro.
	 * 
	 * @param parameter
	 * @see Parameter
	 */
	public void addParameter(Parameter parameter) {
		parameters.add(parameter);
	}

	/**
	 * Retorna todos os parametros.
	 * 
	 * @return parametros
	 * @see Parameter
	 */
	public List<Parameter> getParameters() {
		return Collections.unmodifiableList(parameters);
	}

	/**
	 * Retorna o tipo do retorno.
	 * 
	 * @return tipo do retorno
	 * @see Type
	 */
	public Type getReturnType() {
		return returnType;
	}

	/**
	 * Remove um parametro.
	 * 
	 * @param parameter
	 * @see Parameter
	 */
	public void removeParameter(Parameter parameter) {
		parameters.remove(parameter);
	}

	/**
	 * Seta o tipo do retorno.
	 * 
	 * @param returnType
	 * @see Type
	 */
	public void setReturnType(Type returnType) {
		this.returnType = returnType;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	/**
	 * Retorna uma string que representa a operacao.
	 * 
	 * @return string
	 */
	@Override
	public String toString() {
		String s;

		s = getName() + "()";
		if (returnType != null) {
			s += ":" + returnType.getName();
		}
		return s;
	}
}
