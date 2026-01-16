package Object_Oriented_Programming.DesignPrinciples;



import java.util.ArrayList;

/* ---------- SUBJECT CLASS (RENAMED FROM COURSE) ---------- */
class Subject {

    String subjectName;
    Professor professor;
    ArrayList<Student> students = new ArrayList<>();

    Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.name + " assigned to " + subjectName);
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void displaySubjectDetails() {
        System.out.println("\nSubject: " + subjectName);
        System.out.println(" Professor: " + (professor != null ? professor.name : "Not Assigned"));
        System.out.println(" Students:");
        for (Student s : students) {
            System.out.println("  " + s.name);
        }
    }
}

/* ---------- STUDENT CLASS ---------- */
class Student {

    String name;
    ArrayList<Subject> subjects = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Subject subject) {
        subjects.add(subject);
        subject.addStudent(this);
        System.out.println(name + " enrolled in " + subject.subjectName);
    }

    void viewCourses() {
        System.out.println("\nStudent: " + name);
        for (Subject s : subjects) {
            System.out.println(" Enrolled in: " + s.subjectName);
        }
    }
}

/* ---------- PROFESSOR CLASS ---------- */
class Professor {

    String name;

    Professor(String name) {
        this.name = name;
    }
}

/* ---------- MAIN CLASS ---------- */
class UniversitySystemDemo {

    public static void main(String[] args) {

        Professor p1 = new Professor("Dr. Sharma");
        Professor p2 = new Professor("Dr. Mehta");

        Subject s1 = new Subject("Data Structures");
        Subject s2 = new Subject("Operating Systems");

        s1.assignProfessor(p1);
        s2.assignProfessor(p2);

        Student st1 = new Student("Aarav");
        Student st2 = new Student("Meera");

        st1.enrollCourse(s1);
        st1.enrollCourse(s2);
        st2.enrollCourse(s1);

        st1.viewCourses();
        st2.viewCourses();

        s1.displaySubjectDetails();
        s2.displaySubjectDetails();
    }
}
