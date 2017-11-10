package com.pack.common.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.annotations.Factory;

import com.pack.common.packageObjects.TestRunner;

public class TestSuite {

	@Factory
	public Object[] testSuite(ITestContext ngContext) throws IOException{
		TestRunner runner  = new TestRunner(ngContext);
		runner.addTCFromXL();
		return runner.getTCList();  //Add TestCases from TestData
		
	}
}
