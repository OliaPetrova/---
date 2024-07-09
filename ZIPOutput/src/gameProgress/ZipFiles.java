package gameProgress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFiles {
public static void zipFiles(String zipFilesPath , List<String> files ) {
	try ( ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilesPath))) {
		for (String filePath:files) {
			try (FileInputStream fis = new FileInputStream(filePath)){
			ZipEntry zipEntry = new ZipEntry(filePath.substring(filePath.lastIndexOf("/")+1));
			zos.putNextEntry(zipEntry);
			byte[] buffer = new byte[1024];
			int lengh;
			while ((lengh = fis.read(buffer)) > 0) {
				zos.write(buffer,0,lengh);
			}
			zos.closeEntry();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
