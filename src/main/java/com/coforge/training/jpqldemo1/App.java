package com.coforge.training.jpqldemo1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class App {

	public static void main(String[] args) {
		
		System.out.println("JPQLDEMO");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager entityManager = emf.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			String qlQuery = "SELECT c FROM City c";
			Query query = entityManager.createQuery(qlQuery);
			List<City> cities = query.getResultList();
			cities.stream().forEach((x) -> System.out.println(x));
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
