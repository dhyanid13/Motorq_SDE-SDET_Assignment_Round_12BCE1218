import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


class Student extends Course implements StudentApp, java.io.Serializable {

    String firstName;
    String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    //shows all the courses available at the university irrespective of the class being full or slot clashing
    public void studentViewAllCourses() {
        for (int i = 0; i < courseList.size(); i++) {
            // prints out the courses within the course list
            courseList.get(i).studentPrint();
        }
    }

    @Override
    //Shows only those classes to the student that he can apply i.e classes still having seats to register
    public void viewAvailableCourses() {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCurrentStudents() != courseList.get(i).getMaxStudents()) {
                courseList.get(i).studentPrint();
            }
        }
    }

    @Override
    // In this case the student must enter the course name, section, and student
    // full name, the name will be added to the appropriate course.
    public void registerToCourse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the course name: ");
        String courseName = in.readLine();
        System.out.println("Enter the course  ID: ");
        String courseID = in.readLine();
        System.out.println("Enter your first name: ");
        String firstName = in.readLine();
        System.out.println("Enter your last name: ");
        String lastName = in.readLine();

        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName() == courseName && courseList.get(i).getCourseID() == courseID) {
                Student student = new Student(firstName, lastName);
                courseList.get(i).studentList.add(student);
                System.out.println("You have been successfully added to the course!");
            }
        }
    }

    @Override
    // In this case the student will be asked to enter name and the course name,
    // then the name of student will be taken off from given course's list.
    public void withdrawFromCourse() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the course name: ");
        String courseName = in.readLine();
        System.out.println("Enter your first name: ");
        String firstName = in.readLine();
        System.out.println("Enter your last name: ");
        String lastName = in.readLine();

        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseName() == courseName) {
                Student student = new Student(firstName, lastName);
                courseList.get(i).studentList.remove(student);
                System.out.println("You have been successfully removed from the course!");
            }
        }
    }

    @Override
    public void addtowaitlist() {


    }
}