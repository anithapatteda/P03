/*This main class which calls others functions */


import java.io.*;

import ssw555.project.input_store;

public class gedcom_main {
 public static void main(String args[]) {
  try {
  input_store gedcomr = new input_store(); // creates object for gedcom file 
   gedcomr.readFile("C:/QingliaoWu.ged"); // Read file
   System.out.println("Individuals:"); // Prints individual names
   gedcomr.print_individual();
   System.out.println("Families:"); // Prints family
   gedcomr.print_family();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
}
