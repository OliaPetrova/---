package gameProgress;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		 GameProgress game1 = new GameProgress(100, 2, 1, 50.0);
	     GameProgress game2 = new GameProgress(90, 3, 2, 120.5);
	     GameProgress game3 = new GameProgress(75, 4, 3, 200.0);

	     SaveGame.saveGame("savegames/save1.dat", game1);
	     SaveGame.saveGame("savegames/save2.dat", game2);
	     SaveGame.saveGame("savegames/save3.dat", game3);
	     
	     List<String> filesToZip = Stream.of("savegames/save1.dat","savegames/save1.dat","savegames/save3.dat").collect(Collectors.toList());
	     
	     ZipFiles.zipFiles("savegames/zip.zip", filesToZip);
	     FileUtils.deleteFils(filesToZip);
	}

}
