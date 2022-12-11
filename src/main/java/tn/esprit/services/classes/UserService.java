package tn.esprit.services.classes;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.persistance.UserRole;
import tn.esprit.persistance.Users;
import tn.esprit.persistance.repositories.RoleRepository;
import tn.esprit.persistance.repositories.UserRepository;
import tn.esprit.services.Interfaces.UserServiceInterface;

@Service
public class UserService extends BaseServiceImp<Users,Integer> implements UserServiceInterface {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	
	
	@Override
	public Users register(Users user, Set<UserRole> userRoles) throws Exception {
		
		Users local = this.userRepo.findByUsername(user.getUsername());
		
		if(local!=null) {
			//System.out.println("user exist");
			throw new Exception("Utilisateur deja exit");
		}else {
			
			for(UserRole ur : userRoles) {
				roleRepo.save(ur.getRole());
			}
			
			user.getUserRole().addAll(userRoles);
			local = this.userRepo.save(user);
			
			
			
			
			
			
		}
		
		
		return local;
	}



	@Override
	public Users getUserByUsername(String username) {
		return this.userRepo.findByUsername(username);

	}

}
