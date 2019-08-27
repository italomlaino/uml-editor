package diagram.figure.surface;

public class SurfaceFactory {

	private static SurfaceFactory instance;

	private SurfaceFactory() {
	}

	public static SurfaceFactory getInstance() {
		if (instance == null) {
			instance = new SurfaceFactory();
		}
		return instance;
	}

	public Surface createSurface() {
		return null;
	}
}
