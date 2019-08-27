package model.util;

/**
 * Entidade do tipo item.
 * 
 * @see Item
 * @see Operation
 * @see Attribute
 */
public class Item {

	private String name;

	/**
	 * Constroi um item.
	 * 
	 * @param name
	 */
	public Item(String name) {
		this.name = name;
	}

	/**
	 * Retorna o nome do item.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Seta o nome do item.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna uma string que representa o item.
	 * 
	 * @return string
	 */
	@Override
	public String toString() {
		return name;
	}
}
