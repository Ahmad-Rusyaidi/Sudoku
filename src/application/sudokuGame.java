package application;

import java.io.Serializable;

import computationLogic.SudokuUtilities;
import constant.GameState;

public class sudokuGame implements Serializable{
	
	private final GameState GAMESTATE;
	private final int[][] GRIDSTATE;
	public static final int GRID_BOUNDARY = 9;
	
	
	
	public sudokuGame(GameState gAMESTATE, int[][] gRIDSTATE) {
		super();
		this.GAMESTATE = gAMESTATE;
		this.GRIDSTATE = gRIDSTATE;
	}
	public GameState getGAMESTATE() {
		return GAMESTATE;
	}
	public int[][] getCopyOfGridstate() {
		return SudokuUtilities.copyToNewArray(GRIDSTATE);
	}
	public static int getGridBoundary() {
		return GRID_BOUNDARY;
	}
}
