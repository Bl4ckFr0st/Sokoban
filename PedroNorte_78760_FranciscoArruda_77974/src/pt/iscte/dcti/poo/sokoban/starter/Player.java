package pt.iscte.dcti.poo.sokoban.starter;

import java.util.Random;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Position;

public class Player extends AbstractSObject implements ActiveObject{

	private Position position;
	private String imageName;
	private int bateriaDisponivel;

	private SokobanGame game;
	
	public int getBateriaDisponivel() {
		return bateriaDisponivel;
	}

	public void setBateriaDisponivel(int bateriaDisponivel) {
		this.bateriaDisponivel = bateriaDisponivel;
	}

	public Player(Position initialPosition, SokobanGame game){
		position = initialPosition;
		setImageName("Empilhadora_U");
		this.game = game;
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
		return 2;
	}

	public void randomMove() {
		// Generate a random vector for movement
		Direction[] possibleDirections = Direction.values();
		
		Random randomizer = new Random();
		int randomNumber = randomizer.nextInt(possibleDirections.length);
		
		Direction randomDirection = possibleDirections[randomNumber];

		Position newPosition = position.plus(randomDirection.asVector());
		if (newPosition.getX()>=0 && newPosition.getX()<10 && newPosition.getY()>=0 && newPosition.getY()<10 ){
			position = newPosition;
		}
		
		ImageMatrixGUI.getInstance().update();
	}
	
	public void move(Direction novaDireccao)
	{
		Position newPosition = position.plus(novaDireccao.asVector());
		for(AbstractSObject objecto : game.getObjectos())
		{
			if(objecto.getPosition().equals(newPosition))
			{
				if(objecto instanceof Caixote)
				{
					System.out.println("Encontrei caixote!");
					((Caixote)objecto).move(novaDireccao);
				}
				if(objecto.isTransposable())
				{
					position = newPosition;
					
				}
			}
		}
		ImageMatrixGUI.getInstance().update();
	}
}
