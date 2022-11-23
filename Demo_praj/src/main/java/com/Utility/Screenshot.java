package com.Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.TestBase.Testbase;

public class Screenshot extends Testbase {
	
	static String path="C:\\Users\\Prasad\\eclipse-workspace\\Project\\screenshots\\";
	public static void takeSS(String filename) throws IOException {
	
		TakesScreenshot src= (TakesScreenshot)driver;
		File ss= src.getScreenshotAs(OutputType.FILE);
		
		File failedss=new File(path+filename+".png");
		
		FileHandler.copy(ss,failedss);
		
		
		
		
	}

}