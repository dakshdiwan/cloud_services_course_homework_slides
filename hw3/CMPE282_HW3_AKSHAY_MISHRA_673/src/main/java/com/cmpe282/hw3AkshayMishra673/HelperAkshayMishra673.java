package com.cmpe282.hw3AkshayMishra673;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class HelperAkshayMishra673 {
	/*
	public static void printOutput(File folder) throws IOException {
		
	    for (final File fileEntry : folder.listFiles(	 	    		
	    		new FileFilter() {	    			
	    		    public boolean accept(File file) {	    		    	
	    		        return !file.isHidden() && file.getName().startsWith("part") ;
	    		    }
	    		}
	    	)) {
	        if (fileEntry.isDirectory()) {
	        	printOutput(fileEntry);
	        } else {
	            System.out.println("\nFilename: " + fileEntry.getName() + "\n");
	            
	            FileInputStream fis = new FileInputStream(fileEntry);

	    		int oneByte;
	    		while ((oneByte = fis.read()) != -1) {
	    			System.out.write(oneByte);
	    		}
	    		fis.close();
	    		System.out.flush();	            	            
	        }
	    }
	}
	*/
}
