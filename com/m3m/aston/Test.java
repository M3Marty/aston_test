package com.m3m.aston;

import java.io.FileNotFoundException;

public class Test {
	
	private static final int INT_LIMIT = 7;
	private static final String ALLOWED_NAME = "Вячеслав";
	
	private static final String WRONG_NAME = "Нет такого имени";
	private static final String HELLO = "Привет";
	
	public static void main(String[] args) {
		try {
			DataProvider dp = new ArgsDataProvider(args);
			if (dp.isString() && FileDataProvider.isFileName(dp.getString()))
				dp = new FileDataProvider(dp.getString());

			if (dp.isEmpty())
				dp = new ConsoleDataProvider() {{ getData(); }};
			
			if (dp.isInteger() && dp.getInt() > INT_LIMIT)
				System.out.println(HELLO);
			
			if (dp.isString()) {
				if (dp.getString().equals(ALLOWED_NAME))
					System.out.println(new StringBuilder(HELLO).append(", ").append(dp.getString()));
				else
					System.out.println(WRONG_NAME);
			}
			
			if (dp.isArray()) {
				for (int i = 0; i < dp.getIntArray().length; i++)
					if (dp.getIntArray()[i] % 3 == 0)
						System.out.print(dp.getIntArray()[i] + " ");
				
				System.out.println();
			}
			
		} catch (NullPointerException e) {
			System.err.println("Incorrect input");
			throw e;
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			throw new IllegalArgumentException(e);
		}
	}
}
