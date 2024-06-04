package com.example.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;
@Service
public class UserService {
	@Autowired
	private UserRepository userrep;
	@Autowired
	private VehicleRepository vehiclerepp;

	public List<User> getAllUsers(){
		return userrep.findAll();
	}
	public Optional<User>getUserById(int id){
		return userrep.findById(id);
	}
	public User createuser(User user) {
		return userrep.save(user);
	}
	public User updateuser(int id,User userdetails) throws Exception {
		User user=userrep.findById(id).orElseThrow(()->new Exception("user not found"));
		user.setName(userdetails.getName());
		return userrep.save(user);
	}
	public void deleteuser(int id) throws Exception {
		User user=userrep.findById(id).orElseThrow(()->new Exception("user not found"));
	}
}
