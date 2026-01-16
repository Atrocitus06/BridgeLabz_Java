package Object_Oriented_Programming.Association_Aggregation;

import java.util.ArrayList;

/* ---------- COURSE CLASS (Association) ---------- */
class Course {

    String courseName;
    ArrayList<Student> students = new ArrayList<>();

    Course(String courseName) {
        this.courseName = courseName;
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void displayEnrolledStudents() {
        System.out.println("\nCourse: " + courseName);
        for (Student s : students) {
            System.out.println(" Student: " + s.name);
        }
    }
}

/* ---------- STUDENT CLASS (Association) ---------- */
class Student {

    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);   // bidirectional association
    }

    void viewCourses() {
        System.out.println("\nStudent: " + name);
        for (Course c : courses) {
            System.out.println(" Enrolled in: " + c.courseName);
        }
    }
}

/* ---------- SCHOOL CLASS (Aggregation) ---------- */
class School {

    String schoolName;
    ArrayList<Student> students = new ArrayList<>();

    School(String schoolName) {
        this.schoolName = schoolName;
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void displayStudents() {
        System.out.println("\nSchool: " + schoolName);
        for (Student s : students) {
            System.out.println(" Student: " + s.name);
        }
    }
}

/* ---------- MAIN CLASS (SAME FILE) ---------- */
class SchoolAssociationAggregation {

    public static void main(String[] args) {

        // School
        School school = new School("Green Valley School");

        // Students (exist independently)
        Student s1 = new Student("Aarav");
        Student s2 = new Student("Meera");

        // Courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");

        // Aggregation: School has students
        school.addStudent(s1);
        school.addStudent(s2);

        // Association: Students enroll in courses (many-to-many)
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);

        s2.enrollCourse(c2);

        // Display details
        school.displayStudents();
        s1.viewCourses();
        s2.viewCourses();

        c1.displayEnrolledStudents();
        c2.displayEnrolledStudents();
    }
}
