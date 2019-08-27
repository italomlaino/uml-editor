package model.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Tipo de dados.
 * 
 */
public final class Type {

	private String name;
	private static List<Type> types = new ArrayList<Type>();

	/**
	 * Constroi um tipo.
	 * 
	 * @param name
	 */
	private Type(String name) {
		this.name = name;
	}

	/**
	 * Cria ou retorna um tipo com um especifico nome. Se o tipo ja existir ira
	 * so retorna-lo.
	 * 
	 * @param name
	 * @return type
	 */
	public static Type getType(String name) {
		for (Type type : types) {
			if (type.getName().equals(name)) {
				return type;
			}
		}

		return new Type(name);
	}

	/**
	 * Retorna o nome do tipo.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Seta o nome do tipo.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
