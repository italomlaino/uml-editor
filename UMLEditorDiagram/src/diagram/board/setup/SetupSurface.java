package diagram.board.setup;

import java.awt.event.MouseEvent;

import model.entity.Entity;
import model.entity.EntityFactory;
import model.entity.EntityType;
import diagram.board.Board;
import diagram.figure.surface.ClassEntitySpc;
import diagram.figure.surface.Surface;

public class SetupSurface extends Setup {

	private EntityType type;

	private Board board;

	public SetupSurface(Board board, EntityType type) {
		this.type = type;
		this.board = board;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Surface surface = new ClassEntitySpc(e.getPoint(),
				(Entity) EntityFactory.getInstance().createEntity(type));

		board.addFigure(surface);

		board.activateSetupSelect();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void dispose() {
	}
}
