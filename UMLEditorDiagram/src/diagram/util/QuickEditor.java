package diagram.util;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.entity.Entity;

public class QuickEditor extends JDialog {

	// TODO Remover esse count
	private int count = 0;
	private Entity entity;

	private JTextField txtName;
	private JTextArea txtAttributes;
	private JTextArea txtOperations;
	private GridBagLayout layout;

	public QuickEditor(Entity entity) {
		this.entity = entity;
		initComponents();
	}

	private void initComponents() {
		setTitle("Edição Rápida");
		setSize(new Dimension(500, 500));
		setResizable(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		layout = new GridBagLayout();
		setLayout(layout);

		GridBagConstraints c = new GridBagConstraints();

		JPanel pnName = createNamePanel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 0;
		c.gridy = count++;
		c.gridwidth = 3;
		c.weightx = 2;
		c.weighty = 0;
		c.anchor = GridBagConstraints.CENTER;
		layout.setConstraints(pnName, c);
		add(pnName);

		if (entity.hasAttributes()) {
			JPanel pnAttributes = createAttributePanel();
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = count++;
			c.gridwidth = 3;
			c.weightx = 2;
			c.weighty = 2;
			c.anchor = GridBagConstraints.CENTER;
			layout.setConstraints(pnAttributes, c);
			add(pnAttributes);
		}

		if (entity.hasOperations()) {
			JPanel pnOperations = createOperationPanel();
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = count++;
			c.gridwidth = 3;
			c.weightx = 2;
			c.weighty = 2;
			c.anchor = GridBagConstraints.CENTER;
			layout.setConstraints(pnOperations, c);
			add(pnOperations);
		}

		JPanel pnButtons = createButtonPanel();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = count++;
		c.gridwidth = 1;
		c.weightx = 0;
		c.weighty = 0;
		c.anchor = GridBagConstraints.EAST;
		layout.setConstraints(pnButtons, c);
		add(pnButtons);
	}

	private JPanel createNamePanel() {
		txtName = new JTextField();
		txtName.setText(entity.getName());

		JPanel pnName = new JPanel();
		pnName.setBorder(BorderFactory.createTitledBorder("Nome:"));
		pnName.setLayout(new BorderLayout());
		pnName.add(txtName, BorderLayout.CENTER);

		return pnName;
	}

	private JPanel createAttributePanel() {
		txtAttributes = new JTextArea();
		txtAttributes.setText(ClassParser.attributesToString(entity
				.getAttributeMod().getAttributes()));
		JScrollPane spAttributes = new JScrollPane(txtAttributes);

		JPanel pnAttributes = new JPanel();
		pnAttributes.setBorder(BorderFactory.createTitledBorder("Atributos:"));
		pnAttributes.setLayout(new BorderLayout());
		pnAttributes.add(spAttributes, BorderLayout.CENTER);

		return pnAttributes;
	}

	private JPanel createOperationPanel() {
		txtOperations = new JTextArea();
		txtOperations.setText(ClassParser.operationsToString(entity
				.getOperationMod().getOperations()));
		JScrollPane spOperations = new JScrollPane(txtOperations);

		JPanel pnOperations = new JPanel();
		pnOperations.setBorder(BorderFactory.createTitledBorder("Operações:"));
		pnOperations.setLayout(new BorderLayout());
		pnOperations.add(spOperations, BorderLayout.CENTER);

		return pnOperations;
	}

	private JPanel createButtonPanel() {
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					save();
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString());
				}
			}

		});

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString());
				}
			}

		});

		JPanel pnButtons = new JPanel();
		pnButtons.setLayout(new GridLayout());
		pnButtons.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		pnButtons.add(btnCancel);
		pnButtons.add(btnOk);

		return pnButtons;
	}

	private void save() throws Exception {
		String name = txtName.getText().trim();
		entity.setName(name);

		if (entity.hasAttributes()) {
			String attributes = txtAttributes.getText().trim();
			if (!attributes.isEmpty()) {
				entity.getAttributeMod().setAttributes(
						ClassParser.parseAttributes(attributes));
			}
		}
		if (entity.hasOperations()) {
			String operations = txtOperations.getText().trim();
			if (!operations.isEmpty()) {
				entity.getOperationMod().setOperations(
						ClassParser.parseOperations(operations));
			}
		}
	}
}
