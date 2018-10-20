package com.Naukri.BDDFrameworkTest;
import com.Naukri.FileReaderManager.ConfigFileReader;
public class testRnD {

	public static void main(String[] args) {
		ConfigFileReader c=new ConfigFileReader();
		System.out.println(c.getApplicationUrl().toString());		
	}

}
