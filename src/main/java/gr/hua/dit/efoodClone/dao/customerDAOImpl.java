package gr.hua.dit.efoodClone.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.efoodClone.entity.customer;


@Repository
public class customerDAOImpl implements customerDAO {
	
	@Autowired
	private EntityManager entityManager;
	

	@Override
	@Transactional
	public List<customer> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from customer", customer.class);
		List<customer> customers = query.getResultList();
		return customers;
	}
	

	@Override
	@Transactional
	public void save(customer customer) {
		customer a_customer = entityManager.merge(customer);
	}

	@Override
	@Transactional
	public customer findById(int id) {
		return entityManager.find(customer.class, id);
				
	}

}
