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
	   // HashMap<String, String> TagValue = new HashMap<String, String>(); 
	       for (int i = 0; i < listOfFiles.length; i++) {
	    	  // System.out.println(listOfFiles[i]);

	      	   files = listOfFiles[i].getName();
	      	   
	    	   if (files.endsWith(".txt") || files.endsWith(".TXT")){
	    		   String filename = files.toUpperCase();
	    		   System.out.println("START OF FILE :"+filename);
	    		   try{
	    		   BufferedReader br = new BufferedReader(new FileReader(listOfFiles[i]));
	    		   HashMap NameId = new HashMap();
	    		   String name = null;
    			   String id = null;
	    		   while ((line = br.readLine()) != null ) {
	    			  
	    			   //System.out.println("Line = "+line);
	    			   String[] lineVariables = line.split(" "); 
	    			   if(lineVariables.length == 3){
	    				  if(lineVariables[1].startsWith("@") && lineVariables[2].equals("INDI") ){
	    					  id=lineVariables[1];
	    				  }else if(lineVariables[1].equals("SUBM")){
	    					  id=lineVariables[2];
	    				  }
	    				  
	    				  if(lineVariables[1].equals("GIVN")){
	    					  name = lineVariables[2];
	    				  }
	    				 // System.out.println(name+id);
	    				  if(id!=null && name!=null){
	    				    NameId.put(id,name);
	    				   // System.out.println(NameId);
	    				  }
	    				  if(lineVariables[2].equals("FAM")){
	    					  System.out.println("-------------------");
	    					  System.out.println(" Family ID :"+lineVariables[1]);
	    				  }
	    				  if(lineVariables[1].equals("HUSB")){
	    					 String husband = (String) NameId.get(lineVariables[2]);
	    					 System.out.println("Unique Id :"+lineVariables[2]+" "+" Husband Name :"+husband);
	    				  }
	    				  if(lineVariables[1].equals("WIFE")){
		    					 String wife = (String) NameId.get(lineVariables[2]);
		    					 System.out.println("Unique Id :"+lineVariables[2]+" "+" Wife Name :"+wife);
		    					 
		    			  }
	    				  if(lineVariables[1].equals("CHIL")){
	    					  String child = (String) NameId.get(lineVariables[2]);
		    					System.out.println("Unique Id :"+lineVariables[2]+" "+" Child Name :"+child);
		    					
	    				  }
	    				 
	    			   }
	    		   }
	    		   }catch(Exception e){
	    			   
	    		   }
	    		   System.out.println("END OF FAMILY : "+filename);
	    		   System.out.println("             ");
	    	   }
	               
	           
	      }
	}

}
