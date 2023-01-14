package gr.hua.dit.efoodClone.entity;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;



@Entity
@Table(name = "restaurantOwners")
public class restaurantOwners implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
	
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id")
   // @JsonBackReference
    private customer customer;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public customer getCustomer() {
		return customer;
	}

	public void setCustomer(customer customer) {
		this.customer = customer;
	}

	public List<restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "res_owners_id")
    private List<restaurant> restaurants;
    
    
    
	
	
	
	

}
