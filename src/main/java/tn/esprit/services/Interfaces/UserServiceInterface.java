package tn.esprit.services.Interfaces;


import tn.esprit.persistance.UserRole;
import tn.esprit.persistance.Users;

import java.util.Set;

public interface UserServiceInterface extends BaseServiceInterface<Users, Integer>{
	
	
	public Users register(Users user, Set<UserRole> userRole) throws Exception;


	//Get users by username
	public Users getUserByUsername(String username);




}
