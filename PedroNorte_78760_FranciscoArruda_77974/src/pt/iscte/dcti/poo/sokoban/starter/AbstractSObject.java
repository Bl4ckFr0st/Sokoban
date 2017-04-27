package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Position;

public abstract class AbstractSObject implements ImageTile{
	private Position position;
	
	public boolean isTransposable()
	{
		return true;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return 0;
	}
}
