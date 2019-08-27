package gui.bar;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	public MenuBar() {
		initComponents();
	}

	private void initComponents() {
		JMenu mnArquivo = new JMenu("Arquivo");
		JMenu mnAjuda = new JMenu("Ajuda");

		JMenuItem mniArquivoNovo = new JMenuItem("Novo");
		JMenuItem mniArquivoAbrir = new JMenuItem("Abrir");
		JMenuItem mniArquivoSalvar = new JMenuItem("Salvar");
		JMenuItem mniArquivoSalvarComo = new JMenuItem("Salvar Como...");
		JMenuItem mniArquivoExportar = new JMenuItem("Exportar...");
		JMenuItem mniArquivoSair = new JMenuItem("Sair");

		JMenuItem mniAjudaSobre = new JMenuItem("Sobre");

		mnArquivo.add(mniArquivoNovo);
		mnArquivo.addSeparator();
		mnArquivo.add(mniArquivoAbrir);
		mnArquivo.add(mniArquivoSalvar);
		mnArquivo.add(mniArquivoSalvarComo);
		mnArquivo.addSeparator();
		mnArquivo.add(mniArquivoExportar);
		mnArquivo.addSeparator();
		mnArquivo.add(mniArquivoSair);

		mnAjuda.add(mniAjudaSobre);

		add(mnArquivo);
		add(mnAjuda);
	}
}
