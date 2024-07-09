package gameInstaller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstaller {

	public static void main(String[] args) {
        String baseDir = "C:\\Games";

        String[] directories = {
            baseDir + "/src",
            baseDir + "/res",
            baseDir + "/savegames",
            baseDir + "/temp",
            baseDir + "/src/main",
            baseDir + "/src/test",
            baseDir + "/res/drawables",
            baseDir + "/res/vectors",
            baseDir + "/res/icons"
        };

	
	String[]Fails= {
		baseDir + "/src/main/Main.java",
	    baseDir + "/src/main/Utils.java",
	    baseDir + "/temp/temp.txt"
	};
	
	StringBuilder log = new StringBuilder();

	for(String dir:directories) {
		File directory = new File(dir);
		if(directory.mkdir()){
			log.append("directory ").append(dir).append(" created successfully.\\n");
		} else {
			log.append("Failed to create directory ").append(dir).append(".\n");
		}
	}
	for(String filePath :Fails) {
		File file = new File(filePath);
		
		try {
			if(file.createNewFile()) {
				  log.append("File ").append(filePath).append(" created successfully.\n");
            } else {
                log.append("Failed to create file ").append(filePath).append(".\n");
            }
		} catch (IOException e) {
			 log.append("Error creating file ").append(filePath).append(": ").append(e.getMessage()).append(".\n");
		}
	}
	
	try (FileWriter writer = new FileWriter(baseDir + "\\temp\\temp.txt") ){
		writer.write(log.toString());		
	} catch (Exception e) {
		  System.out.println("Error writing to temp.txt: " + e.getMessage());
	}
	
	 System.out.println(log.toString());
	
	}
}
