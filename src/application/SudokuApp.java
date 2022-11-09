package application;
	
import java.io.IOException;

import buildLogic.SudokuBuildLogic;
import javafx.application.Application;
import javafx.stage.Stage;
import userinterface.IUserInterfaceContract;
import userinterface.UserInterfaceImpl;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class SudokuApp extends Application {
	
	private IUserInterfaceContract.View uiImpl;
	@Override
	public void start(Stage primaryStage) throws IOException {
		uiImpl = new UserInterfaceImpl(primaryStage);
		try {
			SudokuBuildLogic.build(uiImpl);
		} catch(IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
