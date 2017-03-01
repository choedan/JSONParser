package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		Gson gson = new Gson();
		BufferedReader reader = null;
		final String pass = "pass";
		final String fail = "fail";
		final String block = "blocked";
		ArrayList<TestCases> passed;
		ArrayList<TestCases> failed;
		ArrayList<TestCases> blocked;
		ArrayList<TestCases> greaterThanTenSeconds;
	

		try {
			reader = new BufferedReader(new FileReader("sample.json"));
			TestSuiteCollection result = gson.fromJson(reader, TestSuiteCollection.class);

			if (result != null) {
				for (TestSuite t : result.getTestSuites()) {
					System.out.println("Test suite name: " + t.getSuiteName());
					passed = new ArrayList<TestCases>();
					failed = new ArrayList<TestCases>();
					blocked = new ArrayList<TestCases>();
					greaterThanTenSeconds = new ArrayList<TestCases>();
					for (TestCases testresult : t.getResults()) {
						if (testresult.getStatus().equals(pass)) {
							passed.add(testresult);
							if (Double.parseDouble(testresult.getTime()) > 10) {
								greaterThanTenSeconds.add(testresult);
							}
						} else if (testresult.getStatus().equals(fail)) {
							failed.add(testresult);
							if (Double.parseDouble(testresult.getTime()) > 10) {
								greaterThanTenSeconds.add(testresult);
							}

						} else if (testresult.getStatus().equals(block)) {
							blocked.add(testresult);
						}

					}
										
					output("Passed tests", passed);
					output("Failed tests", failed);
					output("Blocked tests", blocked);
					output("Tests that took longer than 10 seconds to run", greaterThanTenSeconds);

				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void output(String status, ArrayList<TestCases> testCaseSet) {
		clean(testCaseSet);
		Collections.sort(testCaseSet);
		System.out.println(status + " (" + testCaseSet.size() + ")");
		for (int i = 0; i < testCaseSet.size(); i++) {
			System.out.println(
					"Test name: " + testCaseSet.get(i).getTestName() + ", test time: " + testCaseSet.get(i).getTime());
		}
	}
	public static void clean(ArrayList<TestCases> testCaseSet){
		for (int i=0; i<testCaseSet.size(); i++){
			TestCases testcase = testCaseSet.get(i);
			testcase.setTestName(testCaseSet.get(i).getTestName().replaceAll("\\s+",""));
			testcase.setStatus(testCaseSet.get(i).getStatus().replaceAll("\\s+",""));
			testcase.setTime(testCaseSet.get(i).getTime().replaceAll("\\s+",""));
		}
	}
}
