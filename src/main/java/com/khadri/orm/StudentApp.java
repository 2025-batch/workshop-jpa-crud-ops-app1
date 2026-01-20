package com.khadri.orm;

import java.util.Scanner;

import jakarta.persistence.Persistence;

public class StudentApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentCRUD stdCurd = new StudentCRUD(Persistence.createEntityManagerFactory("PERSISTENCE_UNIT"));

		while (true) {

			System.out.println(" 1. Insert 2. Find 3. Update 4. Delete 5. Exit ");

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
				sc.close();
				System.exit(0);
			}
			}
		}
	}
}
