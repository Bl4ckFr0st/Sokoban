package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Position;

public class Parede extends AbstractSObject{
	private Position position;
	private String imageName;
	
	Parede(Position position)
	{
		this.position = position;
		imageName = "Parede";
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

}
