package tn.esprit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Helpers.UserNotFoundException;
import tn.esprit.config.JwtUtils;
import tn.esprit.persistance.JwtRequest;
import tn.esprit.persistance.JwtResponse;
import tn.esprit.persistance.Users;
import tn.esprit.services.classes.UserDetailsServiceImp;


@RestController
@CrossOrigin("*")
public class AuthenticateController {

	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsServiceImp userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	
	

	@PostMapping("/generate-token")
	public ResponseEntity<?>generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		
		try {
			
			
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		}catch(UserNotFoundException e) {
			
			e.printStackTrace();
			throw new Exception("User not found");
			
		}
		
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token  = this.jwtUtils.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	
	
	
	
	
	
	
	private void authenticate(String username, String password) throws Exception {
		
		
		try {
		
		authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		
		}catch(DisabledException e){
			
			
			throw new Exception ("User Disabled" + e.getMessage());
			
		}catch(BadCredentialsException e) {
			
			throw new Exception("Invalid Credential" + e.getMessage());
			
		}
	}
	
	@GetMapping("/current-user")
	public Users getCurrentUser(Principal principal) {

		
		return ((Users)this.userDetailsService.loadUserByUsername(principal.getName()));

		
	}
	
	
	
	
}
