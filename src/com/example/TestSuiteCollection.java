package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestSuiteCollection {

@SerializedName("test_suites")
@Expose
	private List<TestSuite> testSuites = null;

	public List<TestSuite> getTestSuites() {
		return testSuites;
	}

public void setTestSuites(List<TestSuite> testSuites) {
this.testSuites = testSuites;
}

}