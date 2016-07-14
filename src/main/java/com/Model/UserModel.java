package com.Model;
import org.springframework.data.annotation.Id;

public class UserModel {
 
 @Id
 public int id;
 public String name;
 public String pass;
 
 public UserModel(){}
 
public UserModel(int id, String name, String pass){
	 this.id=id;
	 this.name=name;
	 this.pass=pass;
 }

 /**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the name
 */

public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the pass
 */
public String getPass() {
	return pass;
}
/**
 * @param pass the pass to set
 */
public void setPass(String pass) {
	this.pass = pass;
} 
}
