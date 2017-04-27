package pt.iscte.dcti.poo.sokoban.starter;

import java.io.FileNotFoundException;

import pt.iul.ista.poo.gui.ImageMatrixGUI;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		SokobanGame newSokobanGame = new SokobanGame();
		ImageMatrixGUI.getInstance().addObserver(newSokobanGame);
		ImageMatrixGUI.getInstance().go();
	}
}
