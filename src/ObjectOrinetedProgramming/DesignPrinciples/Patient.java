package Object_Oriented_Programming.Association;

import java.util.ArrayList;

/* ---------- PATIENT CLASS ---------- */
class Patient {

    String name;

    Patient(String name) {
        this.name = name;
    }
}

/* ---------- DOCTOR CLASS ---------- */
class Doctor {

    String name;
    ArrayList<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    // Association + Communication
    void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Doctor " + name + " is consulting Patient " + patient.name);
    }
}

/* ---------- HOSPITAL CLASS ---------- */
class Hospital {

    String hospitalName;
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();

    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    void addPatient(Patient patient) {
        patients.add(patient);
    }

    void displayHospitalDetails() {
        System.out.println("\nHospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println(" Doctor: " + d.name);
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println(" Patient: " + p.name);
        }
    }
}

/* ---------- MAIN CLASS (SAME FILE) ---------- */
class HospitalAssociation {

    public static void main(String[] args) {

        // Hospital
        Hospital hospital = new Hospital("City Care Hospital");

        // Doctors
        Doctor d1 = new Doctor("Dr. Rao");
        Doctor d2 = new Doctor("Dr. Sen");

        // Patients
        Patient p1 = new Patient("Amit");
        Patient p2 = new Patient("Riya");

        // Add to hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        hospital.addPatient(p1);
        hospital.addPatient(p2);

        // Association + Communication
        d1.consult(p1);
        d1.consult(p2);

        d2.consult(p2);

        // Display hospital info
        hospital.displayHospitalDetails();
    }
}
