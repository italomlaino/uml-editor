package diagram;

import diagram.board.Board;

public abstract class Diagram {

	private Board board;

	private String name;

	/**
	 * Cria um diagrama com um nome especificado.
	 * 
	 * @param name
	 */
	protected Diagram(final String name) {
		this.name = name;

		initComponents();
	}

	/**
	 * Inicia os componentes.
	 */
	private void initComponents() {
		board = new Board();
	}

	/**
	 * Retorna o nome.
	 * 
	 * @return nome
	 */
	public String getName() {
		return name;
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
	 * Retorna o Board.
	 * 
	 * @return
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return name;
	}
}