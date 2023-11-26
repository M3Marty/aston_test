package com.m3m.aston;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConsoleDataProvider extends DataProvider {

	private InputStream in;
	
	public ConsoleDataProvider(InputStream in) {
		this.in = in;
	}
	
	public ConsoleDataProvider() {
		this(System.in);
	}

	public void getData() {
		try (var reader = new BufferedReader(new InputStreamReader(in))) {
			value = tryGetData(reader.readLine());
			clazz = value.getClass();
			
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
	
}
