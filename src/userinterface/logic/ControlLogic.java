package userinterface.logic;

import java.io.IOException;
import computationLogic.GameLogic;
import application.IStorage;
import application.sudokuGame;
import constant.GameState;
import constant.Messages;
import userinterface.IUserInterfaceContract;
import userinterface.IUserInterfaceContract.EventListerner;

public class ControlLogic implements EventListerner{
	
	private IStorage storage;
	private IUserInterfaceContract.View view;

	public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
		this.storage = storage;
		this.view = view;
	}

	@Override
	public void onSudokuInput(int x, int y, int input) {
		try {
			sudokuGame gameData = storage.getGameData();
			int[][] newGridState = gameData.getCopyOfGridstate();
			newGridState[x][y] = input;
			
			gameData = new sudokuGame(GameLogic.checkForCompletion(newGridState), newGridState);
			
			storage.updateGameData(gameData);
			
			view.updateSquare(x, y, input);
			
			if(gameData.getGAMESTATE() == GameState.COMPLETE) {
				view.showDialog(Messages.GAME_COMPLETE);
			}
		} catch(IOException e) {
			e.printStackTrace();
			view.showError(Messages.ERROR);
		}
	}

	@Override
	public void onDialogClick() {
		try {
			storage.updateGameData(GameLogic.getNewGame());
			
			view.updateBoard(storage.getGameData());
		} catch(IOException e) {
			view.showError(Messages.ERROR);
		}
	}

}
