package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Position;

public class Caixote extends AbstractSObject implements ActiveObject{
	private Position position;
	private String imageName;
	private SokobanGame game;

	public Caixote(Position position, SokobanGame game) {
		this.position = position;
		imageName = "Caixote";
		this.game = game;
	}

	@Override
	public boolean isTransposable()
	{
		return false;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return imageName;
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public void move(Direction novaDireccao) {
		Position newPosition = position.plus(novaDireccao.asVector());
		for(AbstractSObject objecto : game.getObjectos())
			if(objecto.getPosition().equals(newPosition))
			{
				if(objecto.isTransposable())
				{
					position = newPosition;
				}
			}
		ImageMatrixGUI.getInstance().update();
	}
}
