/*This main class which calls others functions */


import java.io.*;

import ssw555.project.input_store;

public class gedcom_main {
 public static void main(String args[]) {
  try {
  input_store gedcomr = new input_store();
   gedcomr.readFile("C:/QingliaoWu.ged");
   System.out.println("Individuals:");
   gedcomr.print_individual();
   System.out.println("Families:");
   gedcomr.print_family();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
}
