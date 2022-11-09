package userinterface;

import application.sudokuGame;

public interface IUserInterfaceContract {

	interface EventListerner{
		void onSudokuInput(int x, int y, int input);
		void onDialogClick();
	}
	
	interface View{
		void setListener(IUserInterfaceContract.EventListerner listener);
		void updateSquare(int x, int y, int input);
		void updateBoard(sudokuGame game);
		void showDialog(String message);
		void showError(String error);
	}
}
