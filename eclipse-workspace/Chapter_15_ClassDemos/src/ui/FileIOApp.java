package ui;

import java.io.IOException;
import java.nio.file.*;

public class FileIOApp {

	public static void main(String[] args) throws IOException {
		// pg 463 create directory
		String dirString = "c:/temp/sub1/sub2";
		Path dirPath = Paths.get(dirString);
		if (Files.notExists(dirPath)) {
			Files.createDirectories(dirPath);
		}
		else {
			System.out.println("Directory already exits");
		}
		// p 463 create file
		String fileString = "temp.txt";
		Path filePath = Paths.get(dirString, fileString);
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
		else {
			System.out.println("File already exists,");
		}
		
		System.out.println(filePath.getNameCount());
		System.out.println(filePath.toString());
		System.out.println(filePath.toAbsolutePath());
		System.out.println(Files.isWritable(filePath));
		System.out.println(Files.isHidden(filePath));
		for (int i=0; i < filePath.getNameCount(); i++){
			System.out.println(filePath.getName(i));
		}
		
		//p, 463 display files in a directory
		
		System.out.println("Directory:  "+dirPath.toAbsolutePath());
		System.out.println("Files:");
		DirectoryStream<Path> dirStream = Files.newDirectoryStream(dirPath);
		for (Path p: dirStream) {
			if (Files.isRegularFile(p)) {
				System.out.println(""+p.getFileName());
			}
		}
		
	}

}
