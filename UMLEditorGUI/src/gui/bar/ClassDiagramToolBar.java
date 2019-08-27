package gui.bar;

import gui.data.Data;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import diagram.Diagram;

public class ClassDiagramToolBar extends JToolBar {

	private ButtonGroup group;

	private Diagram diagram;

	public ClassDiagramToolBar(Diagram diagram) {
		this.diagram = diagram;
		initComponents();
	}

	private void initComponents() {
		final JToggleButton tbSelect = new JToggleButton("Selecionar");
		final JToggleButton tbClass = new JToggleButton("Classe");
		final JToggleButton tbInterface = new JToggleButton("Interface");
		final JToggleButton tbGeneralization = new JToggleButton(
				"Generalização");
		final JToggleButton tbRealization = new JToggleButton("Realização");
		final JToggleButton tbAssociation = new JToggleButton("Associação");
		final JToggleButton tbAgregation = new JToggleButton("Agregação");
		final JToggleButton tbComposition = new JToggleButton("Composição");

		group = new ButtonGroup();

		group.add(tbSelect);
		group.add(tbClass);
		group.add(tbInterface);
		group.add(tbGeneralization);
		group.add(tbRealization);
		group.add(tbAssociation);
		group.add(tbAgregation);
		group.add(tbComposition);

		add(tbSelect);
		add(tbClass);
		add(tbInterface);
		add(tbGeneralization);
		add(tbRealization);
		add(tbAssociation);
		add(tbAgregation);
		add(tbComposition);

		tbSelect.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				diagram.getBoard().activateSetupSelect();
			}
		});

		tbClass.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				diagram.getBoard().activateSetupSurface(Data.CLASS_TYPE);
			}
		});

		tbInterface.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				diagram.getBoard().activateSetupSurface(Data.INTERFACE_TYPE);

			}

		});

		tbGeneralization.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				diagram.getBoard().activateSetupRelationship(
						Data.GENERALIZATION_TYPE, Data.GENERALIZATION_LINETYPE);

			}

		});

		tbRealization.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				diagram.getBoard().activateSetupRelationship(
						Data.REALIZATION_TYPE, Data.REALIZATION_LINETYPE);

			}

		});

		tbAssociation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				diagram.getBoard().activateSetupRelationship(
						Data.ASSOCIATION_TYPE, Data.ASSOCIATION_LINETYPE);
			}

		});

		tbAgregation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				diagram.getBoard().activateSetupRelationship(
						Data.AGREGATION_TYPE, Data.AGREGATION_LINETYPE);
			}

		});

		tbComposition.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				diagram.getBoard().activateSetupRelationship(
						Data.COMPOSITION_TYPE, Data.COMPOSITION_LINETYPE);
			}

		});

		diagram.getBoard().addContainerListener(new ContainerListener() {

			@Override
			public void componentAdded(ContainerEvent e) {
				tbSelect.setSelected(true);
				tbSelect.requestFocus();
			}

			@Override
			public void componentRemoved(ContainerEvent e) {
			}
		});
	}
}
