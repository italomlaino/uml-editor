package gui.frame;

import gui.bar.MenuBar;
import gui.bar.StatusBar;
import gui.bar.ToolBar;
import gui.data.Workspace;
import gui.view.DiagramView;
import gui.view.ExplorerView;
import gui.view.View;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import diagram.Diagram;
import diagram.DiagramFactory;

public final class MainGUI extends JFrame {

	private static MainGUI instance;

	private static int DIV_MAIOR = 0;
	private static int DIV_CIMA = 1;
	private static int DIV_BAIXO = 2;

	private static final int PADRAO_WIDTH = 600;
	private static final int PADRAO_HEIGHT = 400;
	private static final double PADRAO_PORCENTAGEM_DIV_HOR = 0.2;
	private static final double PADRAO_PORCENTAGEM_DIV_VER = 0.5;

	private JTabbedPane divMaior;
	private JTabbedPane divCima;
	private JTabbedPane divBaixo;

	private Diagram diagrama;

	private MainGUI() {
		initComponents();
		test();
	}

	public static MainGUI getInstance() {

		if (instance == null) {
			instance = new MainGUI();
		}

		return instance;
	}

	private void initComponents() {
		setTitle("UMLEditor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(PADRAO_WIDTH, PADRAO_HEIGHT));
		setMinimumSize(new Dimension(PADRAO_WIDTH, PADRAO_HEIGHT));
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);

		setJMenuBar(new MenuBar());

		divMaior = new JTabbedPane();
		divCima = new JTabbedPane();
		divBaixo = new JTabbedPane();

		Container container = getContentPane();

		container.add(new ToolBar(), BorderLayout.NORTH);

		JSplitPane splitpV = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitpV.setDividerLocation(PADRAO_PORCENTAGEM_DIV_VER);
		splitpV.setResizeWeight(PADRAO_PORCENTAGEM_DIV_VER);
		splitpV.setOneTouchExpandable(true);
		splitpV.setLeftComponent(divCima);
		splitpV.setRightComponent(divBaixo);

		JSplitPane splitpH = new JSplitPane();
		splitpH.setDividerLocation(PADRAO_PORCENTAGEM_DIV_HOR);
		splitpH.setResizeWeight(PADRAO_PORCENTAGEM_DIV_HOR);
		splitpH.setOneTouchExpandable(true);
		splitpH.setLeftComponent(splitpV);
		splitpH.setRightComponent(divMaior);

		container.add(splitpH, BorderLayout.CENTER);
		container.add(new StatusBar(), BorderLayout.SOUTH);

		addView(new ExplorerView(Workspace.getInstance()), DIV_CIMA);
	}

	private void addView(View view, int div) {

		if (div == DIV_MAIOR) {
			divMaior.addTab(view.getText(), view);
		} else if (div == DIV_BAIXO) {
			divBaixo.addTab(view.getText(), view);
		} else if (div == DIV_CIMA) {
			divCima.addTab(view.getText(), view);
		}
	}

	private void test() {
		diagrama = DiagramFactory.getInstance().createClassDiagram(
				"DiagramaDeClasses0");
		Workspace.getInstance().addDiagram(diagrama);
		addView(new DiagramView(diagrama), DIV_MAIOR);
	}
}
