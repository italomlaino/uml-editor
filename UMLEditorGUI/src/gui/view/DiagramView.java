package gui.view;

import gui.bar.ClassDiagramToolBar;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;

import diagram.Diagram;

public class DiagramView extends View {

	private Diagram diagram;

	public DiagramView(Diagram diagrama) {
		super(diagrama.getName());
		this.diagram = diagrama;
		initComponents();
	}

	private void initComponents() {
		setLayout(new BorderLayout());
		add(new ClassDiagramToolBar(diagram), BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(diagram.getBoard());
		add(scrollPane, BorderLayout.CENTER);
	}
}
