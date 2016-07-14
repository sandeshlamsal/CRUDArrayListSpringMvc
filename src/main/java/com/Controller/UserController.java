package com.Controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Model.UserModel;

@RestController
public class UserController {
	
	     //GET request to /api/user/ returns a list of users
		//GET request to /api/user/1 returns the user with ID 1
		
		//POST request to /api/user/ with a user object as JSON creates a new user
		
		//PUT request to /api/user/3 with a user object as JSON updates the user with ID 3
		
		//DELETE request to /api/user/4 deletes the user with ID 4
		//DELETE request to /api/user/ deletes all the users
		
		//1.enable logger
		//2.filtlers
	private ArrayList<UserModel> listUsers;
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	public UserController() {
		
		UserModel obj1=new UserModel(1,"Sandesh","Password");
		UserModel obj2=new UserModel(2,"Milan","Password");
		UserModel obj3=new UserModel(3,"Manoj","Password");
		
		listUsers=new ArrayList<>();
		listUsers.add(obj1);
		listUsers.add(obj2);
		listUsers.add(obj3);
		
	}
	
	@RequestMapping( value="/users",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<UserModel> getUserList(){
		return listUsers;
	}
	
	@RequestMapping( value="/users/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public UserModel findUser(@PathVariable("id") int id){
	
		UserModel userModel=new UserModel();
		userModel.setId(id);
		
		for(UserModel user:listUsers) {
			if(user.getId() == id){
				return user;
			}
		}
		return userModel;
	}
	
	@RequestMapping( value="/users/add", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addUser(@RequestBody UserModel usermodel) {
		listUsers.add(usermodel);
		log.info(" user added", usermodel.getId());
		return "{msg: user added}";
	}
	
	@RequestMapping( value="/users/update", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateUser(@RequestBody UserModel usermodel) {
		int id = usermodel.getId();
	
		
		for(UserModel user:listUsers){
			if(user.getId() == id) {
				user.setName(usermodel.getName());
				user.setPass(usermodel.getPass());
				return "{msg: user updated}";
			}
		}
		return "{msg: user not found}";
	}
	
	@RequestMapping( value="/users/delete/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public  String deleteUser(@PathVariable("id") int id){

		UserModel userModel=new UserModel();
		//userModel.setId(id);
		
		for(UserModel user:listUsers) {
			if(user.getId() == id){
				listUsers.remove(user);
				return "{msg:deleted}";
			}
		}
		return "{msg:user not found}";
	}
	
	

}
