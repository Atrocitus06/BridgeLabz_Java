package Object_Oriented_Programming.Composition_Aggregation;

import java.util.ArrayList;

/* ---------- FACULTY CLASS (AGGREGATION) ---------- */
class Faculty {

    String name;
    String specialization;

    Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    void displayFaculty() {
        System.out.println(" Faculty: " + name + " | Specialization: " + specialization);
    }
}

/* ---------- UNIVERSITY CLASS (COMPOSITION OWNER) ---------- */
class University {

    String universityName;
    ArrayList<Department> departments = new ArrayList<>();
    ArrayList<Faculty> facultyMembers = new ArrayList<>(); // aggregation

    University(String universityName) {
        this.universityName = universityName;
    }

    /* ----- COMPOSITION: create & own departments ----- */
    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    /* ----- AGGREGATION: add existing faculty ----- */
    void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    void displayUniversityDetails() {
        System.out.println("\nUniversity: " + universityName);

        System.out.println("Departments:");
        for (Department d : departments) {
            d.displayDepartment();
        }

        System.out.println("Faculty Members:");
        for (Faculty f : facultyMembers) {
            f.displayFaculty();
        }
    }

    /* ----- COMPOSITION EFFECT ----- */
    void deleteUniversity() {
        departments.clear();   // deletes departments (and anything inside them)
        System.out.println("\nUniversity deleted along with all Departments");
    }

    /* ---------- INNER DEPARTMENT CLASS (COMPOSITION) ---------- */
    class Department {

        String departmentName;

        Department(String departmentName) {
            this.departmentName = departmentName;
        }

        void displayDepartment() {
            System.out.println(" Department: " + departmentName);
        }
    }
}

/* ---------- MAIN CLASS (SAME FILE) ---------- */
class UniversityCompositionAggregation {

    public static void main(String[] args) {

        // Faculty exist independently (Aggregation)
        Faculty f1 = new Faculty("Dr. Sharma", "Computer Science");
        Faculty f2 = new Faculty("Dr. Mehta", "Mathematics");

        // Create University
        University uni = new University("Global Tech University");

        // Add Departments (Composition)
        uni.addDepartment("Engineering");
        uni.addDepartment("Science");

        // Add Faculty (Aggregation)
        uni.addFaculty(f1);
        uni.addFaculty(f2);

        // Display details
        uni.displayUniversityDetails();

        // Delete University (Composition effect)
        uni.deleteUniversity();

        // Faculty still exists independently
        System.out.println("\nFaculty still exists independently:");
        f1.displayFaculty();
        f2.displayFaculty();
    }
}
