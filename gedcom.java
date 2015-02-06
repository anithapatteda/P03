/** 
 * This class Contains map with gedcom keys
 * displays the key values and level number and details
 */

package Agile;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.HashMap;
//import java.nio.file.Paths;


public class gedcom {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ReadGedcom();

	}
	
	/*
	 * This methods imports the AnithaFamily.txt from agile folder and reads the file from line
	 * by line intrepreting the tags of the line.
	 * Displays level number
	 * Gedcom line
	 * Meaning of each Gedcom line
	 */
	public static void ReadGedcom()  {
		
		String folderPath = "C:/eclipse/Programmes/Agile";
		Path path = Paths.get(folderPath, "AnithaFamily.txt"); 
		Charset charset = Charset.forName("UTF-8");

		try (BufferedReader reader = Files.newBufferedReader(path , charset)) {
		  String line;
		  String bmdate = new String();
		  while ((line = reader.readLine()) != null ) {
			System.out.println(" GEDCOM Line  = "+line);
		    //separate all Strings fields into string array
		    String[] lineVariables = line.split(" "); 
		       for(int i=0;i<lineVariables.length;i++){
		    	  // HashMap<String, String> Details = new HashMap();
		    	  if(i==0){
		    	     System.out.println("Level number = "+lineVariables[i]);
		    	  }else{
		    		   
		    		  String TagValue = ReadTag(lineVariables[1]);
		    	      
		    	      if(lineVariables[1].equals("BIRT"))
		    	        bmdate = TagValue;
		    	      else if(lineVariables[1].equals("MARR"))
		    	    	  bmdate = TagValue;
		    	       
		    		  if(lineVariables.length==3){
		    			  if(lineVariables[2].equals("INDI")){
		    				  TagValue = "UniqueID";
		    				  lineVariables[2] = lineVariables[1];
		    			  }else if(lineVariables[2].equals("FAM")){
		    				  TagValue = "Family";
		    				  lineVariables[2] = lineVariables[1];
		    			  }else if(lineVariables[1].equals("DATE")){
		    				  TagValue = bmdate;
		    			  }
		    		   System.out.println(TagValue+" : "+lineVariables[2]);
		    		   System.out.println(" ---------- ");
		    		 
		    		  		    		   break;
		    		  }
		    	  }
		    	 
		    	 
		  } // end of for
		} // end of while 
	   }catch (IOException e) {
		    System.err.println(e);
		}
	}
	
	/* Storing all the valid tags and meaning into the hashmap 
	 * and checks tag for value and returns the value of tag
	 */
	public static String ReadTag(String tag){
		HashMap<String, String> TagMap = new HashMap<String, String>();
		TagMap.put("INDI", "UniqueID");
		TagMap.put("NAME", "NameofPerson");
		TagMap.put("GIVN", "Given Name");
		TagMap.put("SURN", "Last Name");
		TagMap.put("MARNM", "Married To");
		TagMap.put("SEX", "M/F");
		TagMap.put("BIRT", "Birth date");
		TagMap.put("PLAC", "Place");
		TagMap.put("OCCU", "Occupation");
		TagMap.put("FAMS", "Spouse Of Family");
		TagMap.put("FAMC", "Child Of Family");
		TagMap.put("BIRT", "Date of Birth");
		TagMap.put("CHIL", "CHILD");
		TagMap.put("HUSB", "Husband");
		TagMap.put("WIFE", "Wife");
		TagMap.put("FAM", "Family");
		TagMap.put("MARR", "Marriage Date");
		TagMap.put("TRLR", "** END OF FILE **");
		String value = new String();
		if(TagMap.containsKey(tag)){
			value =  TagMap.get(tag).toString();
		}else{
			value = "Invalid Tag";
		}
		return value;
		
	}
}
