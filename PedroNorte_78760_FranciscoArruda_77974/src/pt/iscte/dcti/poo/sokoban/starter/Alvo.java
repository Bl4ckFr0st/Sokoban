package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Position;

public class Alvo extends AbstractSObject {
	private Position position;
	private String imageName;
	
	Alvo(Position position) {
		this.position = position;
		imageName = "Alvo";
	}
	
	public boolean isTransposable()
	{
		return true;
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
