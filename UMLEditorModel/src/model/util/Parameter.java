package model.util;

/**
 * Parametro.
 * 
 */
public final class Parameter {

	private String name;
	private Type type;

	/**
	 * Retorna o nome.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retorna o tipo.
	 * 
	 * @return type
	 * @see Type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Seta o nome.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Seta o tipo.
	 * 
	 * @param type
	 * @see Type
	 */
	public void setType(Type type) {
		this.type = type;
	}
}
