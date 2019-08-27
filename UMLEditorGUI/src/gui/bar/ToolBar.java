package gui.bar;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	public ToolBar() {
		initComponents();
	}

	private void initComponents() {
		JButton tbNovo = new JButton("Novo");
		JButton tbAbrir = new JButton("Abrir");
		JButton tbSalvar = new JButton("Salvar");
		JButton tbSalvarComo = new JButton("Salvar Como...");
		JButton tbExportar = new JButton("Exportar...");

		add(tbNovo);
		add(tbAbrir);
		add(tbSalvar);
		add(tbSalvarComo);
		add(tbExportar);
	}
}
