package src.main.java.rnd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class fileOperation {

	static void readFile1(String fileName) throws IOException {
		File file = new File(fileName);

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int count = 0;
		while (br.readLine() != null) {
			System.out.println(br.readLine());
			count++;
		}
		System.out.println("Total lines are read: " + count);
		fr.close();
	}

	static void readFile2(String fileName) throws IOException {
		File file = new File(fileName);
		Scanner sr = new Scanner(file);
		int count = 0;
		while (sr.hasNextLine()) {
			System.out.println(sr.nextLine());
			count++;
		}
		System.out.println("Total lines are read: " + count);
		sr.close();
	}

	// Java Program to illustrate reading from text file
	// as string in Java
	static void readFile3(String fileName) throws Exception {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		System.out.println(data);
	}

	public static void main(String[] args) throws Exception {
		readFile3("/home/amit/git/CodeOfCritical/u/src/main/java/rnd/jj.java");
	}
}
