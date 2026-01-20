package com.khadri.orm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import jakarta.persistence.Persistence;

public class StudentApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentCRUD stdCurd = new StudentCRUD(Persistence.createEntityManagerFactory("PERSISTENCE_UNIT"));

		while (true) {

			System.out.println(
					" 1. Insert 2. Find 3. Update 4. Delete 5.Find by Name 6.Find by id range 7.Find By name and Course 8.Find By Student Id 9.Find By course for names 10. Exit ");

			int choice = sc.nextInt();

			switch (choice) {

			case 1 -> {
				Student s = new Student();
				System.out.print("Id: ");
				s.setId(sc.nextInt());
				System.out.print("Name: ");
				s.setName(sc.next());
				System.out.print("Course: ");
				s.setCourse(sc.next());

				stdCurd.insert(s);
				System.out.println("Inserted successfully");
			}

			case 2 -> {
				System.out.print("Enter Id: ");
				System.out.println(stdCurd.find(sc.nextInt()));

			}

			case 3 -> {
				Student s = new Student();
				System.out.print("Id: ");
				s.setId(sc.nextInt());
				System.out.print("New Name: ");
				s.setName(sc.next());
				System.out.print("New Course: ");
				s.setCourse(sc.next());

				stdCurd.update(s);
				System.out.println("Updated successfully");
			}

			case 4 -> {
				System.out.print("Enter Id: ");
				stdCurd.delete(sc.nextInt());
				System.out.println("Deleted successfully");
			}

			case 5 -> {
				System.out.print("Enter Name: ");
				List list = stdCurd.findByName(sc.next());
				list.stream().forEach(eachStudent -> {
					System.out.println(eachStudent);
				});
			}
			case 6 -> {
				System.out.print("Enter id from: ");
				int from = sc.nextInt();
				System.out.print("Enter id to: ");
				int to = sc.nextInt();

				stdCurd.findByIdRange(from, to).forEach(eachStudent -> {
					System.out.println(eachStudent);
				});
				;

			}
			case 7 -> {
				System.out.print("Enter name : ");
				String name = sc.next();
				System.out.print("Enter course: ");
				String course = sc.next();

				stdCurd.findByStudentNameCourse(name, course).forEach(eachStudent -> {
					System.out.println(eachStudent);
				});
				;

			}
			case 8 -> {
				System.out.print("Enter name : ");
				String name = sc.next();
				stdCurd.findByIdStudentNames(name).forEach(eachId -> {
					System.out.println(eachId);
				});

			}
			case 9 -> {
				System.out.print("Enter id : ");
				int id = sc.nextInt();
				List<Object[]> arrayOfNameCourse = stdCurd.findByCourseStudentNames(id);
				
				arrayOfNameCourse.stream().forEach(eachObjectArray ->{
					System.out.println("Course: "+eachObjectArray[0]+", Name :"+eachObjectArray[1]);
				});
			  
	 
			}
			case 10 -> {
				sc.close();
				System.exit(0);
			}
			}
		}
	}
}
