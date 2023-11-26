package com.m3m.aston;

public abstract class DataProvider {

	protected Class<?> clazz;
	protected Object value;
	
	protected Object tryGetData(String sValue) {
		try {
			return Integer.parseInt(sValue);
		} catch (NumberFormatException e) { }
		
		try {
			String[] numbers = sValue.split(" ");
			int[] value = new int[numbers.length];
			
			for (int i = 0; i < numbers.length; i++)
				value[i] = Integer.parseInt(numbers[i]);
			
			return value;
		}  catch (NumberFormatException e) { }
		
		return sValue;
	}
	
	public DataProvider() { }

	public DataProvider(Class<?> clazz, Object value) {
		this.clazz = clazz;
		this.value = value;
	}

	public boolean isInteger() {
		return !isEmpty() && clazz.equals(Integer.class);
	}

	public boolean isArray() {
		return !isEmpty() && clazz.equals(int[].class);
	}

	public boolean isString() {
		return !isEmpty() && clazz.equals(String.class);
	}

	public int getInt() {
		return (Integer) value;
	}

	public int[] getIntArray() {
		return (int[]) value;
	}

	public String getString() {
		return (String) value;
	}

	public boolean isEmpty() {
		return clazz == null;
	}
	
	@Override
	public String toString() {
		return getClass() + ": " + value + " of " + clazz;
	}
}
