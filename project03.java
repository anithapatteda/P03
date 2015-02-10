package Agile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

public class project03 {
	public static void main(String args[]){
		ReadFiles();
	}
	
	public static void ReadFiles(){
		String files;
	    File folder = new File("C:/eclipse/Programmes/Agile");
	    File[] listOfFiles = folder.listFiles(); 
	    
	   // Charset charset = Charset.forName("UTF-8");
	    String line;
	    HashMap<String, String> TagValue = new HashMap<String, String>(); 
	       for (int i = 0; i < listOfFiles.length; i++) {
	    	  // System.out.println(listOfFiles[i]);

	      	   files = listOfFiles[i].getName();
	      	   
	    	   if (files.endsWith(".txt") || files.endsWith(".TXT")){
	    		   System.out.println(files);
	    		   try{
	    		   BufferedReader br = new BufferedReader(new FileReader(listOfFiles[i]));
	    		   while ((line = br.readLine()) != null ) {
	    			   String[] lineVariables = line.split(" "); 
	    			   if(lineVariables.length == 3){
	    				   TagValue.put(lineVariables[1], lineVariables[2]);
	    				   System.out.println(TagValue);
	    			   }
	    		   }
	    		   }catch(Exception e){
	    			   
	    		   }
	    	   }
	               
	           
	      }
	}

}
