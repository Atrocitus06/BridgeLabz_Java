// ===== HospitalManagementDemo =====
package ObjectOrientedProgramming.EncapsulationPolymorphismInterfaceAbstractClass;
// Package declaration organizing this class in OOP demonstrations namespace.

import java.util.ArrayList;
// Importing ArrayList for dynamic storage of patient objects.

import java.util.Scanner;
// Importing Scanner class for console input operations.

public class HospitalManagementDemo {
// Public main class demonstrating hospital patient management using OOP.

    public static void main(String[] args) {
// Main method serving as program entry point.

        Scanner sc = new Scanner(System.in);
// Instantiating Scanner for reading keyboard input.

        ArrayList<Patient> patients = new ArrayList<>();
// ArrayList to hold multiple Patient objects dynamically.

        System.out.print("Enter number of patients: ");
// User prompt for total number of patients.

        int n = sc.nextInt();
// Capturing number of patients from input.

        sc.nextLine();
// Clearing input buffer newline after integer read.

        for (int i = 0; i < n; i++) {
// Iterating exactly 'n' times for each patient entry.

            System.out.println("\nPatient " + (i + 1));
// Displaying current patient sequence number.

            System.out.print("Choose Type (1-InPatient, 2-OutPatient): ");
// Prompting patient category selection.

            int type = sc.nextInt();
// Storing user type selection (1 or 2).

            sc.nextLine();
// Consuming leftover newline in buffer.

            System.out.print("Enter Patient ID: ");
// Requesting unique patient identifier.

            int id = sc.nextInt();
// Reading patient ID as integer.

            sc.nextLine();
// Buffer clear after int input.

            System.out.print("Enter Name: ");
// Prompt for patient full name.

            String name = sc.nextLine();
// Capturing name as full line input.

            System.out.print("Enter Age: ");
// Requesting patient age.

            int age = sc.nextInt();
// Storing age value.

            sc.nextLine();
// Input buffer maintenance.

            System.out.print("Enter Diagnosis: ");
// Prompt for medical diagnosis.

            String diagnosis = sc.nextLine();
// Reading diagnosis description.

            Patient p;
// Reference variable for polymorphic Patient assignment.

            if (type == 1) {
// Condition for in-patient selection.

                System.out.print("Enter Number of Days Admitted: ");
// Additional prompt specific to in-patients.

                int days = sc.nextInt();
// Reading admission days.

                p = new InPatient(id, name, age, diagnosis, days);
// Instantiating InPatient with all parameters.
            } else {
// Default case for out-patient.

                System.out.print("Enter Consultation Fee: ");
// Prompt specific to out-patient billing.

                double fee = sc.nextDouble();
// Capturing consultation fee.

                p = new OutPatient(id, name, age, diagnosis, fee);
// Creating OutPatient instance.
            }

            patients.add(p);
// Adding patient object to collection.

        }

        System.out.println("\n===== PATIENT BILL DETAILS =====");
// Header for displaying billing information.

        for (Patient p : patients) {
// Enhanced for loop iterating over all patients.

            p.getPatientDetails();
// Polymorphic call to display patient info.

            System.out.println("Total Bill: ₹" + p.calculateBill());
// Displaying calculated bill using abstract method polymorphically.

            if (p instanceof MedicalRecord) {
// Runtime type checking for interface implementation.

                MedicalRecord m = (MedicalRecord) p;
// Safe casting to interface type.

                m.addRecord();
// Calling interface method to simulate record addition.

                m.viewRecords();
// Displaying medical records via interface.
            }

            System.out.println("-------------------------------");
// Visual separator between patients.

        }

        sc.close();
// Properly closing scanner resource.

    }
}

// Abstract base class for all patient types with encapsulation.
abstract class Patient {
// Abstract class providing common patient functionality.

    // Encapsulation: private fields with controlled access.
    private int patientId;
// Unique identifier for patient record.

    private String name;
// Patient's full name.

    private int age;
// Patient's age in years.

    private String diagnosis;
// Medical diagnosis description.

    Patient(int patientId, String name, int age, String diagnosis) {
// Constructor initializing all encapsulated fields.

        this.patientId = patientId;
// Setting patient ID.

        this.name = name;
// Assigning name.

        this.age = age;
// Storing age.

        this.diagnosis = diagnosis;
// Recording diagnosis.
    }

    // Public getter methods for read access.
    public int getPatientId() {
// Accessor for patient ID.

        return patientId;
// Returning private field value.
    }

    public String getName() {
// Name accessor method.

        return name;
// Direct return of encapsulated field.
    }

    public int getAge() {
// Age getter.

        return age;
// Returning age value.
    }

    protected String getDiagnosis() {
// Protected getter for subclass access.

        return diagnosis;
// Accessible within package and subclasses.
    }

    // Concrete implementation for basic patient display.
    public void getPatientDetails() {
// Method to print core patient information.

        System.out.println("Patient ID: " + patientId);
// ID display.

        System.out.println("Name: " + name);
// Name output.

        System.out.println("Age: " + age);
// Age print.
    }

    // Abstract billing calculation method.
    public abstract double calculateBill();
// Must be implemented by concrete subclasses.

}

// Interface for medical record management.
interface MedicalRecord {
// Contract for record handling functionality.

    void addRecord();
// Method to add new medical entry.

    void viewRecords();
// Method to display existing records.
}

// In-patient subclass with medical record capability.
class InPatient extends Patient implements MedicalRecord {
// Concrete class for hospitalized patients.

    private int daysAdmitted;
// Private field for hospital stay duration.

    InPatient(int id, String name, int age, String diagnosis, int daysAdmitted) {
// Multi-parameter constructor.

        super(id, name, age, diagnosis);
// Delegating to parent constructor.

        this.daysAdmitted = daysAdmitted;
// Initializing specific field.
    }

    public double calculateBill() {
// Billing logic specific to in-patients.

        return daysAdmitted * 2000; // ₹2000 per day
// Fixed rate multiplied by days.
    }

    public void addRecord() {
// Interface implementation for record addition.

        System.out.println("Medical record added for In-Patient.");
// Simulation of record entry.
    }

    public void viewRecords() {
// Displaying in-patient specific records.

        System.out.println("Diagnosis: " + getDiagnosis());
// Using protected getter.

        System.out.println("Days Admitted: " + daysAdmitted);
// Days information.
    }
}

// Out-patient subclass implementing medical records.
class OutPatient extends Patient implements MedicalRecord {
// Concrete class for clinic visit patients.

    private double consultationFee;
// Private field for visit cost.

    OutPatient(int id, String name, int age, String diagnosis, double fee) {
// Constructor with fee parameter.

        super(id, name, age, diagnosis);
// Parent initialization.

        this.consultationFee = fee;
// Setting consultation cost.
    }

    public double calculateBill() {
// Simple out-patient billing.

        return consultationFee;
// Direct return of fee.
    }

    public void addRecord() {
// Record addition for out-patients.

        System.out.println("Medical record added for Out-Patient.");
// Console simulation.
    }

    public void viewRecords() {
// Out-patient record view.

        System.out.println("Diagnosis: " + getDiagnosis());
// Diagnosis display.

        System.out.println("Consultation Fee: ₹" + consultationFee);
// Fee information.
    }
}
