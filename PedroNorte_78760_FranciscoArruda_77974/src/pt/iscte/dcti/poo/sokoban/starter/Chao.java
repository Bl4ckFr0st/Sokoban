package pt.iscte.dcti.poo.sokoban.starter;

import pt.iul.ista.poo.utils.Position;

public class Chao extends AbstractSObject{
	
	private Position position;
	
	public Chao(Position position){
		this.position = position;
	}
	
	@Override
	public String getName() {
		return "Chao";
	}

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public int getLevel() {
		return 0;
	}

}
