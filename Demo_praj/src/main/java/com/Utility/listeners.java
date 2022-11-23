package com.Utility;

import java.io.IOException; 

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestBase.Testbase;

public class listeners extends Testbase implements ITestListener  {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println("Test case execution completed");
		logger.info("Execution completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case execution failed");
		try {
			Screenshot.takeSS(result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		/*
		 * try { Screenshot_pushpa.sspushpa(result.getName()); } catch (IOException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case execution skipped");
	}

}
