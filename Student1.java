/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.student1;

/**
 *
 * @author zuwa
 */
import java.util.ArrayList;
import java.util.Scanner;

     
class Student {
    private String studentNumber;
    private int age;
    private String name;
    private String email;
    private String course;

    public Student(String studentNumber, int age, String name ,String email, String course) {
        this.studentNumber = studentNumber;
        this.age = age;
        this.name = name;
        this.course = course;
        this.email = email;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
    
     public String getEmail() {
        return email;
    }
     
      public String getCourse() {
        return course;
    }
      
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}

public class Student1 {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("******************************");
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Print student report");
            System.out.println("5. Exit Application");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(studentList, scanner);
                    break;
                case 2:
                    searchforStudent(studentList, scanner);
                    break; 
                case 3:
                    deleteStudent(studentList, scanner);
                    break;
                case 4:
                    studentReport(studentList, scanner);
                    break;
                case 5:
                    ExitStudentApplication ();
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 3);
    }

    private static void addStudent(ArrayList<Student> studentList, Scanner scanner) {
        boolean cage = false;
       
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("*********************");
        System.out.print("Enter student id: ");
        System.out.println("");
        String studentNumber = scanner.next();
        System.out.print("Enter name: ");
        String name = scanner.next();       
        System.out.println("");
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.println("");
        while(!cage){
            if(age>16){
                cage=true;
            }else{
                System.out.print("Enter age: ");
                age = scanner.nextInt();
                System.out.println("");
            }
        }
        System.out.print("Enter student email: ");
        String email = scanner.next();
        System.out.println("");
        System.out.print("Enter student course: ");
        String course = scanner.next();
        System.out.println("");

        Student student = new Student(studentNumber, age, name,email, course);
        studentList.add(student);

        System.out.println("Student profile added successfully.");
    }
    
    private static void searchforStudent(ArrayList<Student> studentList, Scanner scanner){
        System.out.print("Enter the student id to search : ");
        String studentNumber = scanner.next();
        
         boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentNumber().equals(studentNumber)) {
                found = true;
                System.out.println("--------------------------------");
                System.out.println("Student ID: " +studentList.get(i).getStudentNumber());
                System.out.println("Student NAME: "+studentList.get(i).getName());
                System.out.println("Student AGE: "+studentList.get(i).getAge());
                System.out.println("Student EMAIL: "+studentList.get(i).getEmail());
                System.out.println("Student COURSE: "+studentList.get(i).getCourse());
                System.out.println("--------------------------------");
                break;
            }
        }
        
    }

    private static void studentReport(ArrayList<Student> studentList, Scanner scanner){
        
        for (int i = 0; i < studentList.size(); i++) {
                System.out.println("STUDENT "+(i+1));
                System.out.println("--------------------------------");
                System.out.println("Student ID: " +studentList.get(i).getStudentNumber());
                System.out.println("Student NAME: "+studentList.get(i).getName());
                System.out.println("Student AGE: "+studentList.get(i).getAge());
                System.out.println("Student EMAIL: "+studentList.get(i).getEmail());
                System.out.println("Student COURSE: "+studentList.get(i).getCourse());
                System.out.println("--------------------------------");
        }
    }
    
    private static void deleteStudent(ArrayList<Student> studentList, Scanner scanner) {
        System.out.print("Enter student number to delete: ");
        String studentNumber = scanner.next();

        boolean found = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentNumber().equals(studentNumber)) {
                studentList.remove(i);
                found = true;
                System.out.println("Student profile deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student profile not found.");
        }
    }
    
    private static void ExitStudentApplication(){
        System.exit(0);
    }
}


      
  
