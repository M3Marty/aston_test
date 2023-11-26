package com.m3m.aston;

public class ArgsDataProvider extends DataProvider {
	
	public ArgsDataProvider(String[] args) {
		if (args.length == 0)
			return;
		
		if (args.length == 1) {
			value = tryGetData(args[0]);
			clazz = value.getClass();
			return;
		}
		
		if (args.length > 1) {
			try {
				int[] nums = new int[args.length];
				
				for (int i = 0; i < nums.length; i++)
					nums[i] = Integer.parseInt(args[i]);
				
				value = nums;
				clazz = nums.getClass();
			}  catch (NumberFormatException e) { }
		}
	}
}
