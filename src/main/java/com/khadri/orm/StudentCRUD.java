package com.khadri.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class StudentCRUD {

	private EntityManagerFactory factory;
	private EntityManager em;

	public StudentCRUD(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public void insert(Student student) {
		em = this.factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();
	}

	public Student find(int id) {
		em = this.factory.createEntityManager();
		Student student = em.find(Student.class, id);
		em.close();
		return student;
	}

	public Student update(Student newStudent) {
		em = this.factory.createEntityManager();
		em.getTransaction().begin();
		Student mergedStudent = em.merge(newStudent);
		em.getTransaction().commit();
		em.close();
		return mergedStudent;
	}

	public void delete(int id) {
		em = this.factory.createEntityManager();
		Student deleteStudent = em.find(Student.class, id);
		em.getTransaction().begin();
		em.remove(deleteStudent);
		em.getTransaction().commit();
		em.close();
	}
}
