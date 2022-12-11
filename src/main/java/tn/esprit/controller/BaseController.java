package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import tn.esprit.services.Interfaces.BaseServiceInterface;


public class BaseController<T, id> {

	
	@Autowired
	BaseServiceInterface<T, id> baseService;
	
	 @GetMapping()
	    public List<T> getAll(){

	        return baseService.retrieveAll();

	    }


	    @PostMapping("/add")
	    public ResponseEntity<T> add(@RequestBody T e){
			System.out.println(e);
	        return ResponseEntity.ok(this.baseService.add(e));


	    }


	   // @PutMapping(path ="{id}")

	   @PutMapping("/update")
	    public ResponseEntity<T>update(@RequestBody T e){

	        return ResponseEntity.ok(this.baseService.update(e));


	    }



	    @GetMapping("/{id}")
	    public T retrieveById(@PathVariable("id") id id) {

	        return this.baseService.retrieve(id);

	    }


	    @DeleteMapping("/delete/{id}")
	    public void remove(@PathVariable("id") id id) {

	        this.baseService.remove(id);

	    }
	
}
