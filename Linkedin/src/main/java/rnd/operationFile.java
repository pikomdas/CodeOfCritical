package rnd;

import java.io.File;

public class operationFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("/home/amit/Downloads");
        String[] fileList = file.list();
        File[] files = file.listFiles();
        for(String name:fileList){
            System.out.println(name);
        }
        for(File f: files) {
        	System.out.println("Files are :"+ f);
        }
	
	}

}
