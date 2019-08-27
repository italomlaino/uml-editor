package diagram;

public class DiagramFactory {

	private static DiagramFactory instance;

	private DiagramFactory() {
	}

	public static DiagramFactory getInstance() {

		if (instance == null) {
			instance = new DiagramFactory();
		}

		return instance;
	}

	public ClassDiagram createClassDiagram(String name) {
		return new ClassDiagram(name);
	}
}
