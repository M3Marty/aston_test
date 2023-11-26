package com.m3m.aston;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileDataProvider extends ConsoleDataProvider {

	public FileDataProvider(String fileName) throws FileNotFoundException {
		super(new FileInputStream(fileName));
		getData();
	}

	public static boolean isFileName(String string) {
		return new File(string).exists();
	}

}
