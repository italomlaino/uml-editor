package gui.view;

import gui.data.Workspace;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Model;
import model.entity.Entity;
import model.util.Attribute;
import model.util.Operation;
import diagram.Diagram;

public final class ExplorerView extends View implements Observer {

	private static String text = "Explorer";

	private JTree tree;

	private Workspace workspace;

	public ExplorerView(Workspace workspace) {
		super(text);
		this.workspace = workspace;
		initComponents();
	}

	private void initComponents() {
		workspace.addObserver(this);
		tree = new JTree(getNodes());
		JScrollPane scrollPane = new JScrollPane(tree);
		add(scrollPane);
		setLayout(new GridLayout());
	}

	private DefaultMutableTreeNode getNodes() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(workspace);

		DefaultMutableTreeNode leaf;
		for (int i = 0; i < workspace.getDiagrams().size(); i++) {
			Diagram diagram = workspace.getDiagrams().get(i);
			leaf = new DefaultMutableTreeNode(diagram);
			root.add(leaf);
		}

		DefaultMutableTreeNode subRoot;

		for (int i = 0; i < workspace.getModels().size(); i++) {
			Model model = workspace.getModels().get(i);
			subRoot = new DefaultMutableTreeNode(model);
			if (model instanceof Entity) {
				Entity entity = (Entity) model;
				if (entity.hasAttributes()) {
					for (int j = 0; j < entity.getAttributeMod()
							.getAttributes().size(); j++) {
						Attribute at = entity.getAttributeMod().getAttributes()
								.get(j);
						subRoot.add(new DefaultMutableTreeNode(at));
					}
				}

				if (entity.hasOperations()) {

					for (int j = 0; j < entity.getOperationMod()
							.getOperations().size(); j++) {
						Operation op = entity.getOperationMod().getOperations()
								.get(j);
						subRoot.add(new DefaultMutableTreeNode(op));
					}
				}
			}

			root.add(subRoot);
		}

		return root;
	}

	@Override
	public void update(Observable o, Object arg) {
		tree.setModel(new DefaultTreeModel(getNodes()));
	}
}
