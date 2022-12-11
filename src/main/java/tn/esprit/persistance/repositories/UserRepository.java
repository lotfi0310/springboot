package tn.esprit.persistance.repositories;


import tn.esprit.persistance.Users;

public interface UserRepository extends  BaseRepository<Users, Integer>  {

	public Users findByUsername(String username);
	
	
	
}
