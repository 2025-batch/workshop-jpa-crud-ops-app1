package com.khadri.orm;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {

	
	public static void main(String[] args) {
		
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE_UINT");
		 
		 EntityManager em = entityManagerFactory.createEntityManager();
 
	}
}
