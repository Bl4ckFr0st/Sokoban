package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Position;

public class Bateria extends AbstractSObject{
	
	private Position position;
	private String imageName;
	
	public Bateria(Position position)
	{
		this.position = position;
		imageName = "Bateria";
	}
	
	public boolean isTransposable()
	{
		return true;
	}
	
	@Override
	public String getName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public int getLevel() {
		return 1;
	}
}
