/* This class is object for individuals
  has all the get and set methods for tags
*/

package ssw555.project.data;
import java.util.*;


public class individual {
  
 private String identifier;
 private String name;
 private String givenName;
 private String surName;
 private char sex; 
 private Date birthDate;
 private Date deathDate;
 private char deceased;
 
 public String getIdentifier() {
  return identifier;
 }
 
 
 public void setIdentifier(String identifier) {
  this.identifier = identifier;
 }
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public String getGivenName() {
  return givenName;
 }
 public void setGivenName(String givenName) {
  this.givenName = givenName;
 }
 public String getSurName() {
  return surName;
 }
 public void setSurName(String surName) {
  this.surName = surName;
 }
 public char getSex() {
  return sex;
 }
 public void setSex(char sex) {
  this.sex = sex;
 }
 public Date getBirthDate() {
  return birthDate;
 }
 public void setBirthDate(Date birthDate) {
  this.birthDate = birthDate;
 }
 public Date getDeathDate() {
  return deathDate;
 }
 public void setDeathDate(Date deathDate) {
  this.deathDate = deathDate;
 }
 public char getDeceased() {
  return deceased;
 }
 public void setDeceased(char deceased) {
  this.deceased = deceased;
 }
}
