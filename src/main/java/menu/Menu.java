package menu;

import java.util.List;
import java.util.Scanner;

import DBoprations.oprations;
import model.Student;

public class Menu {
	
public static void showMenu() {
	 Scanner sc = new Scanner(System.in);
	 oprations oprations = new oprations();
     boolean runningLoop = true;

     while (runningLoop) {
         System.out.println("\n===== Student Management System =====");
         System.out.println("1. Add Student");
         System.out.println("2. View All Students");
         System.out.println("3. Search Student by ID");
         System.out.println("4. Update Student");
         System.out.println("5. Delete Student");
         System.out.println("6. Exit");
         System.out.print("Enter your choice: ");
         int choice = sc.nextInt();
         
         switch (choice) {
         case 1:
             sc.nextLine();
             System.out.print("Enter Name: ");
             String name = sc.nextLine();
             
             if (name.trim().isEmpty()) {
                 System.out.println("Name can't be empty.");
                 break;
             }

             System.out.print("Enter Course: ");
             String course = sc.nextLine();

             if (course.trim().isEmpty()) {
                 System.out.println("Course can't be empty.");
                 break;
             }

             System.out.print("Enter Marks (0-100): ");
             int marks = sc.nextInt();

             if (marks < 0 || marks > 100) {
                 System.out.println("Invalid marks. Must be between 0 and 100.");
                 break;
             }
             sc.nextLine();

             System.out.print("Enter Email: ");
             String email = sc.nextLine();

             if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                 System.out.println("Invalid email format.");
                 break;
             }

             System.out.print("Enter Phone (digits only): ");
             String phone = sc.nextLine();

             if (!phone.matches("\\d{10}")) {
                 System.out.println("Invalid phone. Must be 10 digits.");
                 break;
             }

             Student student = new Student(0, name, course, marks, email, phone);
             oprations.addStudent(student);
             break;

         case 2:
             List<Student> students = oprations.getAllStudents();

             if (students.isEmpty()) {
                 System.out.println("No students found.");
             } 
             
             else {
                 for (Student s : students) {
                     System.out.println(s);
                 }
             }

             break;

         case 3:
             System.out.print("Enter ID to search: ");
             int searchId = sc.nextInt();
             
             if (searchId <= 0) {
                 System.out.println("Invalid ID.");
                 break;
             }

             Student found = oprations.getStudentById(searchId);
             
             if (found != null) {
                 System.out.println(found);
             } 
             
             else {
                 System.out.println("Student not found.");
             }

             break;

         case 4:
             System.out.print("Enter ID to update: ");
             int updateId = sc.nextInt();
             
             if (updateId <= 0) {
                 System.out.println("ID must be positive.");
                 break;
             }
             sc.nextLine();

             System.out.print("Enter New Name: ");
             String newName = sc.nextLine();

             if (newName.trim().isEmpty()) {
                 System.out.println("Name can't be empty.");
                 break;
             }

             System.out.print("Enter New Course: ");
             String newCourse = sc.nextLine();

             if (newCourse.trim().isEmpty()) {
                 System.out.println("Course can't be empty.");
                 break;
             }

             System.out.print("Enter New Marks (0-100): ");
             int newMarks = sc.nextInt();

             if (newMarks < 0 || newMarks > 100) {
                 System.out.println("Invalid marks.");
                 break;
             }
             sc.nextLine();

             System.out.print("Enter New Email: ");
             String newEmail = sc.nextLine();
             
             if (!newEmail.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
                 System.out.println("Invalid email format.");
                 break;
             }

             System.out.print("Enter New Phone (10 digits): ");
             String newPhone = sc.nextLine();

             if (!newPhone.matches("\\d{10}")) {
                 System.out.println("Invalid phone number.");
                 break;
             }

             Student updatedStudent = new Student(updateId, newName, newCourse, newMarks, newEmail, newPhone);
             boolean updated = oprations.updateStudent(updatedStudent);

             if (updated) {
                 System.out.println("Student updated.");
             } 
             
             else {
                 System.out.println("Student not found.");
             }

             break;

         case 5:
             System.out.print("Enter ID to delete: ");
             int deleteId = sc.nextInt();
             
             if (deleteId <= 0) {
                 System.out.println("Invalid ID.");
                 break;
             }

             boolean deleted = oprations.deleteStudent(deleteId);
             
             if (deleted) {
                 System.out.println("Student deleted.");
             } 
             
             else {
                 System.out.println("Student not found.");
             }
             break;

         case 6:
             runningLoop = false;
             System.out.println("Goodbye! Exiting the application...");
             return;
         default:
             System.out.println("Invalid choice. Try again.");
		}
         
     }
}
	 
}
