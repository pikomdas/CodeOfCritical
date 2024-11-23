/*
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * FileOperations.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from TemenosT24
 * Creation date-time : 16-Jul-2019 2:35:50 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */
package com.codeOfCritical.commonUtils;


import com.codeOfCritical.CucumberExtentReport.Reporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author partha.das
 *
 */
public class FileOperations
{

	private static Logger log = LogManager.getLogger(FileOperations.class.getName());

	/**
	 * This method will check for latest downloaded file from Server by sorting the
	 * file with last modified
	 * 
	 * @param locationOfDownloadDirectory
	 * @return null
	 */

	private String check_for_latest_file(String locationOfDownloadDirectory) {
		File uploadDirectory = new File(locationOfDownloadDirectory);
		File[] downloadedFiles = uploadDirectory.listFiles();

		Arrays.sort(downloadedFiles, new Comparator<File>()
		{
			@Override
			public int compare(File fileOne, File fileTwo) {
				return Long.valueOf(fileOne.lastModified()).compareTo(fileTwo.lastModified());
			}
		});

		return (downloadedFiles[downloadedFiles.length - 1].getName().toString());
	}

	/**
	 * @param expectedFilePath
	 * @param actuaalFilePath
	 * @throws Throwable
	 */

	private void check_whether_fileSize_areSame(String expectedFilePath, String actuaalFilePath) throws Throwable {
		File file1 = new File(expectedFilePath);
		File file2 = new File(actuaalFilePath);
		int sizeOfFile1 = (int) (file1.length() / 1024);
		int sizeOfFile2 = (int) (file2.length() / 1024);
		/*
		 * if file1 and file 2 comparison fails then it will throw an Exception
		 */
		if (sizeOfFile1 != sizeOfFile2)
		{
			Reporter.addStepLog(file1.getName() + " are NOT same with " + file2.getName());
			throw new Exception(file1.getName() + " are NOT same with " + file2.getName());
		}
		else
		{
			log.info(file1.getName() + " are SAME with " + file2.getName());
		}
	}

	/**
	 * @param locationOfDownloadDirectory
	 * @param pathOfExpectedData
	 * @throws Throwable
	 */

	public void check_two_excelfiles_for_deviation(String locationOfDownloadDirectory, String pathOfExpectedData)
			throws Throwable {

		String latestEditedFileName = check_for_latest_file(locationOfDownloadDirectory);

		// Checking whether file size is same or not
		check_whether_fileSize_areSame(System.getProperty("user.dir") + File.separator + "externalFiles"
				+ File.separator + "downloadFiles" + File.separator + latestEditedFileName, pathOfExpectedData);
		ExcelFileReadingAndValidation ev = new ExcelFileReadingAndValidation();
		// Verifying two excel files
		log.info("Checking both files");
		ev.verify2Excels(System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator
				+ "downloadFiles" + File.separator + latestEditedFileName, pathOfExpectedData);

	}
}
