package gameProgress;

import java.io.File;
import java.util.List;

public class FileUtils {
	public static void deleteFils(List<String> fils) {
		for (String filePath : fils) {
			File fl = new File(filePath);
			if (fl.exists()) {
				fl.delete();
			}
		}

	}

}
