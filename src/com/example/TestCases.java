package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestCases implements Comparable<TestCases>{

	@SerializedName("test_name")
	@Expose
	private String testName;
	@SerializedName("time")
	@Expose
	private String time;
	@SerializedName("status")
	@Expose
	private String status;

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int compareTo(TestCases other) {
		//decided to sort ascending by name since names may have tags or other identifiers that group similar tests together. 
		return testName.compareTo(other.testName);
	}

}