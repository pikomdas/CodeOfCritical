/*
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * PDFfileReadingAndValidation.java belongs to AssetVantage 
 * Do not COPY or PASTE code to WEB from TemenosT24
 * Creation date-time : 23-Apr-2019 4:30:58 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */
package com.codeOfCritical.commonUtils;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * @author partha.das
 *
 */
public class PDFfileReadingAndValidation
{
	private PDDocument doc;

	public PDFfileReadingAndValidation(String fileLocation)
	{
		try
		{
			this.doc = PDDocument.load(new File(fileLocation));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void readPDF() {
		String text;
		try
		{
			text = new PDFTextStripper().getText(doc);
			System.out.println("Text in PDF\n---------------------------------");
			System.out.println(text);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}
