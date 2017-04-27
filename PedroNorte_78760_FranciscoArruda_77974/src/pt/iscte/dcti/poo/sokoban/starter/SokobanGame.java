package pt.iscte.dcti.poo.sokoban.starter;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.utils.Direction;
import pt.iul.ista.poo.utils.Position;

public class SokobanGame implements Observer {
 	
	private Player player;
	//private Bateria bateria;
	private ArrayList <AbstractSObject> objectos = new ArrayList <AbstractSObject>();

	public SokobanGame() throws FileNotFoundException{
		
		buildSampleLevel();
		ArrayList<ImageTile> tiles = new ArrayList<ImageTile>();
		for(AbstractSObject cadaObjecto : objectos)
		{
			tiles.add(cadaObjecto);	
		}
		ImageMatrixGUI.getInstance().addImages(tiles);
	}

	public ArrayList<AbstractSObject> getObjectos() {
		return objectos;
	}
	
	private void buildSampleLevel() throws FileNotFoundException{
		
		ArrayList<ImageTile> sampleLevelTiles = new ArrayList<ImageTile>();
		
		Scanner sc = new Scanner(new File("levels/level0.txt"));
		String linha = "";
		String[] vecLinha;
		int y = 0;
		while(sc.hasNextLine())
		{
			linha = sc.nextLine();
			vecLinha = linha.split("");
			for(int x = 0; x != 10; x++){
			switch(vecLinha[x]) 
			{
				case "#":
					Parede novaParede = new Parede(new Position(x,y));
					sampleLevelTiles.add(novaParede);
					objectos.add(novaParede);
					break;
				case "E":
					Chao empilhadoraOrigem = new Chao(new Position(x,y));
					sampleLevelTiles.add(empilhadoraOrigem);
					objectos.add(empilhadoraOrigem);
					Player novoPlayer = new Player(new Position(x,y), this);
					sampleLevelTiles.add(novoPlayer);
					objectos.add(novoPlayer);
					setPlayer(novoPlayer);
					break;
				case "b":
					Bateria novaBateria = new Bateria(new Position(x,y));
					sampleLevelTiles.add(novaBateria);
					objectos.add(novaBateria);
					break;
				case "O":
					Buraco novoBuraco = new Buraco(new Position(x,y));
					sampleLevelTiles.add(novoBuraco);
					objectos.add(novoBuraco);
					break;
				case "C":
					Chao caixoteOrigem = new Chao(new Position(x,y));
					sampleLevelTiles.add(caixoteOrigem);
					Caixote novoCaixote = new Caixote(new Position(x,y), this);
					sampleLevelTiles.add(novoCaixote);
					objectos.add(novoCaixote);
					objectos.add(caixoteOrigem);
					break;
				case "X":
					Alvo novoAlvo = new Alvo(new Position(x,y));
					sampleLevelTiles.add(novoAlvo);
					objectos.add(novoAlvo);
					break;
				case " ":
					Chao novoChao = new Chao(new Position(x,y));
					sampleLevelTiles.add(novoChao);
					objectos.add(novoChao);
				}
			}
			y = y + 1;
		}
		sc.close();
		//return sampleLevelTiles;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		int lastKeyPressed = (Integer) arg1;
		Direction novaDireccao = Direction.directionFor(lastKeyPressed);
		System.out.println("Key pressed " + lastKeyPressed);
		// VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT
		if (lastKeyPressed == KeyEvent.VK_LEFT || lastKeyPressed == KeyEvent.VK_UP ||
				lastKeyPressed == KeyEvent.VK_RIGHT || lastKeyPressed == KeyEvent.VK_DOWN) {
			if (player != null)
				switch(lastKeyPressed)
				{
				case KeyEvent.VK_LEFT:
					player.setImageName("Empilhadora_L");
					break;
				case KeyEvent.VK_UP:
					player.setImageName("Empilhadora_U");
					break;
				case KeyEvent.VK_RIGHT:
					player.setImageName("Empilhadora_R");
					break;
				case KeyEvent.VK_DOWN:
					player.setImageName("Empilhadora_D");
					break;
				}
				player.move(novaDireccao);
				/*if(player.getPosition().equals(bateria.getPosition()))
				{
					objectos.remove(bateria);
				}*/
		}
	}
}
