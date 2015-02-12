package ssw555.project;

//import files
import ssw555.project.data.family;
import ssw555.project.data.individual;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class input_store{

 private static String[] VALID_TAGS = { "INDI", "NAME", "SEX", "BIRT",
   "DEAT", "FAMC", "FAMS", "FAM", "MARR", "HUSB", "WIFE", "CHIL",
   "DIV", "DATE", "TRLR", "NOTE" };
 
 private List<individual> individuals = new ArrayList<individual>();
 private List<family> families = new ArrayList<family>();
 
 private String retrieveArguments(String[] parseLine){
  String arguments = "";
  for(int i=2; i < parseLine.length; i++){
   arguments = arguments + " " + parseLine[i];
  }
  return arguments.trim();
 }
 
 private String retrieveXrefId(String xrefId){
  return xrefId.replace("@", "");
 }

 public void readFile(String file) throws IOException {

  FileInputStream fis = null;
  BufferedReader br = null;

  try {

   fis = new FileInputStream(file);
   br = new BufferedReader(new InputStreamReader(fis));
   System.out.println();

   String line = null;
   individual ind = null;
   family fam = null;
   boolean isIndOrFam = false;
   
   while ((line = br.readLine()) != null) {
    String[] parseLine = (line.split("\\s+"));
    int level = Integer.valueOf(parseLine[0]);
    String tag = parseLine[1];
    String arguments = (parseLine.length > 2) ? retrieveArguments(parseLine) : null;
    
    
    if(level == 0) {
     if("INDI".equals(arguments)){
      ind = new individual();
      if(ind != null){
       individuals.add(ind);
       ind.setIdentifier(retrieveXrefId(tag));
       isIndOrFam = true;
      }
     }
     else if("FAM".equals(arguments)){
      fam = new family();
      if(fam != null){
       families.add(fam);
       fam.setIdentifier(retrieveXrefId(tag));
       isIndOrFam = true;
      }
     } else {
      isIndOrFam = false;
     }
    }
    
    if(isIndOrFam){
     if("NAME".equals(tag)){
      ind.setName(arguments);
     } else if("HUSB".equals(tag)){
      fam.setHusband(retrieveXrefId(arguments));
     } else if("WIFE".equals(tag)){
      fam.setWife(retrieveXrefId(arguments));
     } 
     else if("SEX".equals(tag)){
      ind.setSex(arguments.charAt(0));
     } 
     else if("DEAT".equals(tag)){  
      ind.setDeceased(arguments.charAt(0));
     }
    }    
   }

  } catch (FileNotFoundException ex) {
   Logger.getLogger(input_store.class.getName()).log(Level.SEVERE, null, ex);
  } catch (IOException ex) {
   Logger.getLogger(input_store.class.getName()).log(Level.SEVERE, null, ex);

  } finally {
   try {
    br.close();
    fis.close();
   } catch (IOException ex) {
    Logger.getLogger(input_store.class.getName()).log(Level.SEVERE, null, ex);
   }
  }
 }
 
 public String getIndividual(String xRefId){
  if(individuals != null && !individuals.isEmpty()){
   for(int i=0; i < individuals.size(); i++){
    individual indObj = individuals.get(i);
    if(indObj.getIdentifier().equals(xRefId)){
     return indObj.getName();
    }
   }   
  }
  return "No Individual Error!";
 }

 
 public void print_individual(){


  if(individuals == null || individuals.isEmpty()){
   System.out.println("No individuals!");
  } else {
   for(int i=0; i < individuals.size(); i++){
    individual indObj = individuals.get(i);
    System.out.println("  ID: @" + indObj.getIdentifier()+"@");
    System.out.println("NAME: " + indObj.getName());
    System.out.println();
   } 
  }
 }

 public void print_family(){
  
  if(families == null || families.isEmpty()){
   System.out.println("No families!");
  } else {
   for(int i=0; i < families.size(); i++){
    family famObj = families.get(i);
    System.out.println("     ID:@" + famObj.getIdentifier()+"@");
    System.out.println("HUSBAND: " + getIndividual(famObj.getHusband()));
    System.out.println("   WIFE: " + getIndividual(famObj.getWife()));
    System.out.println();
   }   
  }
 }

}
