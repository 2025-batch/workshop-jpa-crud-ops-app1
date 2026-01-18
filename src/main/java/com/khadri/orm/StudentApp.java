package com.khadri.orm;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true){
        	
            System.out.println(" 1. Inser 2. Fin 3. Update 4. Delete 5. Exit ");

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

                    StudentCRUD.insert(s);
                    System.out.println("Inserted successfully");
                }

                case 2 -> {
                    System.out.print("Enter Id: ");
                    System.out.println(StudentCRUD.find(sc.nextInt()));

                }

                case 3 -> {
                    Student s = new Student();
                    System.out.print("Id: ");
                    s.setId(sc.nextInt());
                    System.out.print("New Name: ");
                    s.setName(sc.next());
                    System.out.print("New Course: ");
                    s.setCourse(sc.next());

                    StudentCRUD.update(s);
                    System.out.println("Updated successfully");
                }

                case 4 -> {
                    System.out.print("Enter Id: ");
                    StudentCRUD.delete(sc.nextInt());
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

