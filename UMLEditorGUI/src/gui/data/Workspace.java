package gui.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.Model;
import diagram.Diagram;

public final class Workspace extends Observable implements Observer {

	private static String DEFAULT_NAME = "Sem Nome";
	private static Workspace instance;

	private String name;

	private List<Diagram> diagrams = new ArrayList<Diagram>();
	private List<Model> models = new ArrayList<Model>();

	private Workspace() {
		name = DEFAULT_NAME;
	}

	public static Workspace getInstance() {

		if (instance == null) {
			instance = new Workspace();
		}

		return instance;
	}

	public void addDiagram(Diagram diagram) {
		diagrams.add(diagram);
		notifyChanges();
	}

	public void addModel(Model model) {
		models.add(model);
		model.addObserver(this);
		notifyChanges();
	}

	public List<Diagram> getDiagrams() {
		return Collections.unmodifiableList(diagrams);
	}

	public List<Model> getModels() {
		return Collections.unmodifiableList(models);
	}

	public String getName() {
		return name;
	}

	public void remove(Diagram diagram) {
		diagrams.remove(diagram);
		notifyChanges();
	}

	public void remove(Model model) {
		models.remove(model);
		model.deleteObserver(this);
		notifyChanges();
	}

	public void setName(String name) {
		this.name = name;
		notifyChanges();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void update(Observable o, Object arg) {
		notifyChanges();
	}

	protected void notifyChanges() {
		setChanged();
		notifyObservers();
	}
}
