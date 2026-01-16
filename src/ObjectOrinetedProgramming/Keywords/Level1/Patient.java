package Object_Oriented_Programming.Keywords.Level1];
// Package declaration that places the Patient class under the Keywords.Level1 package.

import java.util.Scanner;
// Importing the Scanner class to enable reading input from the console.

public class Patient {
    // Public class representing a patient with hospital-related static and instance data.

    /* ---------- STATIC ---------- */

    static String hospitalName = "City Care Hospital";
    // Static variable storing the hospital name shared by all Patient objects.

    static int totalPatients = 0;
    // Static counter to track how many Patient objects have been created (admitted).

    static void getTotalPatients() {
        // Static method to display the total number of admitted patients.

        System.out.println("Total Patients Admitted: " + totalPatients);
        // Printing the total number of patients admitted so far.
    }

    /* ---------- INSTANCE VARIABLES ---------- */

    String name;
    // Instance variable to store the patient's name.

    int age;
    // Instance variable to store the patient's age.

    String ailment;
    // Instance variable to store the patient's ailment description.

    final int patientID;
    // Final instance variable for the unique patient ID which cannot be changed after initialization.

    /* ---------- CONSTRUCTOR (THIS) ---------- */

    Patient(String name, int age, String ailment, int patientID) {
        // Constructor used to initialize a Patient with name, age, ailment, and patientID.

        this.name = name;
        // Using 'this' to assign the constructor parameter to the instance variable 'name'.

        this.age = age;
        // Using 'this' to assign the constructor parameter to the instance variable 'age'.

        this.ailment = ailment;
        // Using 'this' to assign the constructor parameter to the instance variable 'ailment'.

        this.patientID = patientID;
        // Using 'this' to assign the constructor parameter to the final instance variable 'patientID'.

        totalPatients++;
        // Incrementing the static patient counter whenever a new Patient object is created.
    }

    /* ---------- METHOD WITH INSTANCEOF ---------- */

    void displayPatientDetails(Object obj) {
        // Instance method to display patient details if the passed object is a Patient.

        if (obj instanceof Patient) {
            // Checking whether the given object is actually an instance of Patient.

            System.out.println("\n--- Patient Details ---");
            // Printing a header to indicate the beginning of patient details.

            System.out.println("Hospital Name : " + hospitalName);
            // Printing the static hospital name shared by all Patient objects.

            System.out.println("Patient ID : " + patientID);
            // Printing this patient's unique ID.

            System.out.println("Name : " + name);
            // Printing this patient's name.

            System.out.println("Age : " + age);
            // Printing this patient's age.

            System.out.println("Ailment : " + ailment);
            // Printing this patient's ailment.

        } else {
            // Executed if the given object is not an instance of Patient.

            System.out.println("Object is not a Patient");
            // Informing that the provided object is not of type Patient.
        }
        // End of instanceof check and display logic.
    }
    // End of displayPatientDetails method.

    /* ---------- MAIN METHOD (SAME FILE) ---------- */

    public static void main(String[] args) {
        // Main method where the program begins execution.

        Scanner sc = new Scanner(System.in);
        // Creating a Scanner object for reading user input.

        System.out.print("Enter Patient Name: ");
        // Asking the user to input the patient's name.

        String name = sc.nextLine();
        // Reading the full line as the patient's name.

        System.out.print("Enter Age: ");
        // Asking the user to input the patient's age.

        int age = sc.nextInt();
        // Reading the patient's age as an integer.

        sc.nextLine();
        // Consuming the leftover newline character from the input buffer after nextInt().

        System.out.print("Enter Ailment: ");
        // Asking the user to input the patient's ailment.

        String ailment = sc.nextLine();
        // Reading the full line as the ailment description.

        System.out.print("Enter Patient ID: ");
        // Asking the user to input the patient's unique ID.

        int id = sc.nextInt();
        // Reading the patient ID as an integer.

        // Create Patient object
        Patient patient = new Patient(name, age, ailment, id);
        // Creating a new Patient object using the data collected from the user.

        // Validate using instanceof and display details
        patient.displayPatientDetails(patient);
        // Passing the same Patient object to displayPatientDetails for instanceof check and printing details.

        // Display total patients (static)
        Patient.getTotalPatients();
        // Calling the static method to display how many patients have been admitted in total.

        sc.close();
        // Closing the Scanner to release associated system resources.
    }
    // End of main method.
}
// End of Patient class.
