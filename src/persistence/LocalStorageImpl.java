package persistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import application.IStorage;
import application.sudokuGame;

public class LocalStorageImpl implements IStorage{

	private static File GAME_DATA = new File(System.getProperty("user.home"), "gamedata1.txt");
	
	@Override
	public void updateGameData(sudokuGame game) throws IOException {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(GAME_DATA);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(game);
			objectOutputStream.close();
		} catch (IOException e) {
			throw new IOException("Unable to access Game Data");
		}
	}

	@Override
	public sudokuGame getGameData() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(GAME_DATA);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			sudokuGame gameState = (sudokuGame) objectInputStream.readObject();
			objectInputStream.close();
			return gameState;
		} catch(ClassNotFoundException e) {
			throw new IOException("File not FOund!");
		}
	}
}
