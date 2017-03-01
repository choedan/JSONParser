package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestSuite {

	@SerializedName("suite_name")
	@Expose
	private String suiteName;
	@SerializedName("results")
	@Expose
	private List<TestCases> results = null;

	public String getSuiteName() {
		return suiteName;
	}

	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	public List<TestCases> getResults() {
		return results;
	}

	public void setResults(List<TestCases> results) {
		this.results = results;
	}

}
