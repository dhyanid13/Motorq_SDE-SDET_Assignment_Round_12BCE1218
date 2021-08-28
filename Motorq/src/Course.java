import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Course implements java.io.Serializable {
    String courseName;
    //unique id to identify course efficiently
    String courseID;
    //capacity of the class
    int maxStudents;
    //seats allotted
    int currentStudents;
    //Object of student which can store student details (currently having student firstname and lastname)
    ArrayList<Student> studentList;
    static ArrayList<Course> courseList = new ArrayList<Course>();

    Course() {
       //empty constructor
    }

    Course(String courseName, String courseID, int maxStudents, int currentStudents) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.maxStudents = maxStudents;
        this.currentStudents = currentStudents;
        this.studentList = new ArrayList<Student>();

    }

    public String print() {
        String names = "";

        if (studentList != null) {
            for (int i = 0; i < studentList.size(); i++) {
                String addFirst = studentList.get(i).getFirstName();
                String addLast = studentList.get(i).getLastName();
                names = names + addFirst + " " + addLast + ", ";
            }
            System.out.println("Course: " + courseName + "\n" + "Course ID: " + courseID + "\n"
                    + "Maximum # of Students: " + maxStudents + "\n" + "Current # of Students: " + currentStudents
                    + "\n" + "Registered Students: " + names + "\n" );
            System.out.println("==========");
            String text1 = "Course: " + courseName + "\n" + "Course ID: " + courseID + "\n" + "Maximum # of Students: "
                    + maxStudents + "\n" + "Current # of Students: " + currentStudents + "\n" + "Registered Students: "
                    + names + "\n" ;
            return (text1);
        } else {
            System.out.println("Course: " + courseName + "\n" + "Course ID: " + courseID + "\n"
                    + "Maximum # of Students: " + maxStudents + "\n" + "Current # of Students: " + currentStudents
                    + "\n" + "Registered Students: " + studentList + "\n" );
            System.out.println("==========");
            String text2 = "Course: " + courseName + "\n" + "Course ID: " + courseID + "\n" + "Maximum # of Students: "
                    + maxStudents + "\n" + "Current # of Students: " + currentStudents + "\n" + "Registered Students: "
                    + studentList + "\n" + "Instructor: " ;
            return (text2);
        }
    }

    public String studentPrint() {
        System.out.println("Course: " + courseName + "\n" + "Course ID: " + courseID + "\n" + "Maximum # of Students: "
                + maxStudents + "\n" + "Current # of Students: " + currentStudents + "\n" + "Registered Students: "
                + "\n" );
        System.out.println("==========");
        String text = "Course: " + courseName + "\n" + "Course ID: " + courseID + "\n" + "Maximum # of Students: "
                + maxStudents + "\n" + "Current # of Students: " + currentStudents + "\n" + "Registered Students: "
                + "\n" ;
        return (text);
    }

    //Getters and Setters


    public String getCourseName() {
        return courseName;
    }


    public String getCourseID() {
        return courseID;
    }



    public int getMaxStudents() {
        return maxStudents;
    }



    public int getCurrentStudents() {
        return currentStudents;
    }



    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }


    public static void deSerialization() {
        try {
            FileInputStream fis = new FileInputStream("CRSData.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            courseList = (ArrayList<Course>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Deserialization complete");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    public static void serialization() {
        try {
            FileOutputStream fos = new FileOutputStream("CRSData.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(courseList);
            oos.close();
            fos.close();
            System.out.println("Serialization complete");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File fileName = new File("CRSData.ser");
        if (!fileName.exists()) {
            fileName = new File("C:/Users/Lenovo/IdeaProjects/Motorq/src/MyUniversityCourses.csv");

            // References one line at a time
            String line = null;

            try {

                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);


                bufferedReader.close();
            }

            catch (FileNotFoundException ex) {
                System.out.println("Unable to open file '" + fileName + "'");

                ex.printStackTrace();
            }

            catch (IOException ex) {
                System.out.println("Error reading file '" + fileName + "'");
                ex.printStackTrace();
            }

            // STEP 2: TOKENIZE CSV FILE

            String input = new Scanner(fileName).useDelimiter("\\A").next();


            StringTokenizer strTokens = new StringTokenizer(input, ",\n");

            int count = 0;

            while (strTokens.hasMoreTokens()) {
                if (count > 7) {
                    String courseName = strTokens.nextToken();
                    String courseID = strTokens.nextToken();
                    String test = strTokens.nextToken();
                    String trimmedTest = test.replace(" ", "");
                    int maxStudents = Integer.parseInt(trimmedTest);
                    String test1 = strTokens.nextToken();
                    String trimmedTest1 = test1.replace(" ", "");
                    int currentStudents = Integer.parseInt(trimmedTest1);
                    strTokens.nextToken();

                    String test2 = strTokens.nextToken();
                    String trimmedTest2 = test2.replace(" ", "");


                    // creates a course list from the elements found
                    Course c = new Course(courseName, courseID, maxStudents, currentStudents);
                    courseList.add(c);
                    count++;
                } else {
                    strTokens.nextToken();
                    count++;
                }
            }
        } else {
            deSerialization();

            String fileName2 = "newtext.txt";
            // References one line at a time
            String line = null;
            try {

                FileReader fileReader = new FileReader(fileName2);


                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    //System.out.println(line);
                    String[] animalsArray = line.split(",");
                    String firstName = animalsArray[0];
                    String lastName = animalsArray[1];
                    //Student student = new Student(firstName, lastName);


                }

                   bufferedReader.close();
            }
            // The catch block performs a specific action depending on the exception
            catch (FileNotFoundException ex) {
                System.out.println("Unable to open file '" + fileName2 + "'");
                // the printStackTrace method will print out an error output stream ("What went
                // wrong?" report);

                ex.printStackTrace();
            }

            catch (IOException ex) {
                System.out.println("Error reading file '" + fileName2 + "'");
                ex.printStackTrace();
            }

        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome!");
        System.out.println("Enter '2' to start Course registration ");
        System.out.println("Enter '3' to Exit");
        String option = in.readLine();

        // error message
        while (!option.contentEquals("2") && !option.contentEquals("3")) {
            System.out.println("Enter '2' to start Course registration ");
            System.out.println("Enter '3' to Exit");
            option = in.readLine();
        }


        if (option.contentEquals("2")) {

            System.out.println("Please enter your first name:");
            String firstName = in.readLine();
            System.out.println("Please enter your last name:");
            String lastName = in.readLine();



            Student student = new Student(firstName, lastName);
            System.out.println("Congrats! You have been successfully logged in as " + firstName + " " + lastName + "!");
            System.out.println("What would you like to do today?");
            System.out.println("Enter '1' to View All Courses");
            System.out.println("Enter '2' to View All Available Courses");
            System.out.println("Enter '3' to Register to a Course");
            System.out.println("Enter '4' to Withdraw from a Course");
            System.out.println("Enter '5' to View All Registered Courses");
            System.out.println("Enter '6' to Exit");
            String option3 = in.readLine();

            if (option3.contentEquals("1")) {
                student.studentViewAllCourses();
            } else if (option3.contentEquals("2")) {
                student.viewAvailableCourses();
            } else if (option3.contentEquals("3")) {
                student.registerToCourse();
            } else if (option3.contentEquals("4")) {
              student.withdrawFromCourse();
            } else if (option3.contentEquals("5")) {
                student.addtowaitlist();
            } else {
                System.out.println("Thank you & come again! :D");

            }

        }
        else {
            System.out.println("Thank you & come again! :D");

        }

    }

}