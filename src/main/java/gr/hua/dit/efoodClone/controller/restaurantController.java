package gr.hua.dit.efoodClone.controller;

import gr.hua.dit.efoodClone.dao.AddressDAO;
import gr.hua.dit.efoodClone.dao.restaurantDAO;
import gr.hua.dit.efoodClone.entity.Address;
import gr.hua.dit.efoodClone.entity.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


@RestController
@RequestMapping("/restaurants")

public class restaurantController {
	
		@Autowired
		private restaurantDAO restaurantDAO;
		
		@Autowired
		private AddressDAO addressdao;
		
		@GetMapping("")
		List<restaurant> getall(){
			return restaurantDAO.findAll();
		}
		
		@PostMapping("")
		restaurant save(@RequestBody restaurant restaurant) {
			restaurant.setId(0);
			restaurantDAO.save(restaurant);
			return restaurant;
		}
		
		@GetMapping("/{id}")
		restaurant get(@PathVariable int id) {
			restaurant restaurant = restaurantDAO.findById(id);
			return restaurant;
		}
		
		@PostMapping("/{id}/address/{Aid}")
		Address addcustomerAddress(@PathVariable int id , @PathVariable int Aid) {
			Address address = addressdao.findById(Aid);
			restaurant restaurant = restaurantDAO.findById(id);
			
			if(address == null ) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
			}
			
			restaurant.setAddress(address);
			addressdao.save(address);
			return address;
			
		}
		
		
}
