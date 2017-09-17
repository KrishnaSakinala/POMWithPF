package com.automationtesting.util;

public class DataUtil {

	public static boolean isTestExecutable(ExcelApiTest xls, String testCaseName) {
		int rows = xls.getRowCount("TestCases");
		for (int rNum = 1; rNum <= rows; rNum++) {
			String tcid = xls.getCellData("TestCases", "TestCaseName", rNum);
			if (tcid.equals(testCaseName)) {
				String runmode = xls.getCellData("TestCases", "RunMode", rNum);
				if (runmode.equals("Y"))
					return true;
				else
					return false;

			}
		}
		return false;
	}
}
