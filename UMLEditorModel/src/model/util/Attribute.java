package model.util;

/**
 * Item do tipo Atributo.
 * 
 * @see Item
 * @see Operation
 */
public class Attribute extends Item {

	private String initialValue;
	private Type type;
	private Visibility visibility = Visibility.Private;

	/**
	 * Constroi um atributo.
	 * 
	 * @param name
	 */
	public Attribute(String name) {
		super(name);
	}

	/**
	 * Constroi um atributo.
	 * 
	 * @param name
	 * @param type
	 * @see Type
	 */
	public Attribute(String name, Type type) {
		super(name);
		this.type = type;
	}

	/**
	 * Retorna o valor inicial do atributo.
	 * 
	 * @return valor inicial
	 */
	public String getInitialValue() {
		return initialValue;
	}

	/**
	 * Retorna o tipo do atributo.
	 * 
	 * @return tipo
	 * @see Type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Seta o valor inicial do atributo.
	 * 
	 * @param value
	 */
	public void setInitialValue(String value) {
		this.initialValue = value;
	}

	/**
	 * Seta o tipo do atributo.
	 * 
	 * @param type
	 * @see Type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	/**
	 * Retorna uma string que representa o atributo.
	 * 
	 * @return string
	 */
	@Override
	public String toString() {
		String s;

		s = getName();
		if (type != null) {
			s += ":" + type.getName();
		}
		return s;
	}
}
