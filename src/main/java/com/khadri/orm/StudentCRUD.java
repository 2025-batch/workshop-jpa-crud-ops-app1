package com.khadri.orm;

import java.util.List;
import java.util.stream.Stream;

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

	public List findByName(String studentName) {
		em = this.factory.createEntityManager();
		List resultList = em.createQuery("SELECT s FROM Student s WHERE s.name=:name").setParameter("name", studentName)
				.getResultList();
		em.close();
		return resultList;
	}

	public Stream<Student> findByIdRange(int from, int to) {
		em = this.factory.createEntityManager();
		Stream<Student> resultStream = em.createQuery("SELECT s FROM Student s WHERE s.id BETWEEN ?1 AND ?2 ")
				.setParameter(1, from).setParameter(2, to).getResultStream();
		return resultStream;
	}

	public List<Student> findByStudentNameCourse(String name, String course) {
		em = this.factory.createEntityManager();
		List<Student> resultList = em
				.createQuery("SELECT s FROM Student s WHERE s.name=:name AND s.course=:course", Student.class)
				.setParameter("name", name).setParameter("course", course).getResultList();
		return resultList;
	}

	public List<Integer> findByIdStudentNames(String name) {
		em = this.factory.createEntityManager();
		List<Integer> resultList = em.createQuery("SELECT s.id FROM Student s WHERE s.name=:name", Integer.class)
				.setParameter("name", name).getResultList();
		return resultList;
	}

	public List<Object[]> findByCourseStudentNames(int id) {
		em = this.factory.createEntityManager();
		List<Object[]> listOfObjects = em
				.createQuery("SELECT s.course, s.name FROM Student s WHERE s.id=:id", Object[].class)
				.setParameter("id", id).getResultList();
		return listOfObjects;
	}

}
