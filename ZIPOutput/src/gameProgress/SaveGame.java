package gameProgress;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveGame {
public static void saveGame (String failPath , GameProgress gameProgress) {
	try (FileOutputStream fos = new FileOutputStream(failPath)){
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(gameProgress);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
