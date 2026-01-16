package Object_Oriented_Programming.Inheritance;
// Package declaration that organizes this class within the Object_Oriented_Programming.Inheritance namespace.

import java.util.Scanner;
// Importing Scanner class to read user input from the console.

public class CourseTest {
// Public class declaration for CourseTest as the main demonstration class for multi-level course inheritance.

    public static void main(String[] args) {
// Main method: entry point of the program where execution begins and user inputs PaidOnlineCourse details.

        Scanner sc = new Scanner(System.in);
// Creating a Scanner object named 'sc' to read input from System.in (keyboard).

        System.out.print("Enter Course Name: ");
// Prompting the user to enter the course name.

        String courseName = sc.nextLine();
// Reading a line of input (course name) and storing in local variable.

        System.out.print("Enter Course Duration (weeks): ");
// Prompting the user to enter the course duration in weeks.

        int duration = sc.nextInt();
// Reading an integer input (duration) and storing in local variable.

        sc.nextLine();
// Consuming the newline character left in the input buffer after nextInt().

        System.out.print("Enter Platform: ");
// Prompting the user to enter the online platform.

        String platform = sc.nextLine();
// Reading a line of input (platform) and storing in local variable.

        System.out.print("Is the course recorded? (true/false): ");
// Prompting the user to indicate if course is recorded.

        boolean isRecorded = sc.nextBoolean();
// Reading boolean input (recorded status) and storing in local variable.

        System.out.print("Enter Course Fee: ");
// Prompting the user to enter the course fee.

        double fee = sc.nextDouble();
// Reading a double input (fee) and storing in local variable.

        System.out.print("Enter Discount (%): ");
// Prompting the user to enter the discount percentage.

        double discount = sc.nextDouble();
// Reading a double input (discount) and storing in local variable.

        PaidOnlineCourse course = new PaidOnlineCourse(
            courseName,
            duration,
            platform,
            isRecorded,
            fee,
            discount
        );
// Creating a PaidOnlineCourse object (deepest subclass) with all parameters.

        System.out.println("\n--- Course Details ---");
// Printing a formatted header for course information output.

        course.displayDetails();
// Calling fully overridden displayDetails() on course object; shows all levels.

        sc.close();
// Closing the Scanner to prevent resource leak (good practice).

    } // End of main method.

    class Course {
// Inner class declaration for Course as the superclass/base class for all courses.

        String courseName;
// Instance variable to store the course name.

        int duration;
// Instance variable to store course duration in weeks.

        Course(String courseName, int duration) {
// Constructor declaration that initializes basic course fields.

            this.courseName = courseName;
// Assigning parameter to instance variable (distinguished by 'this').

            this.duration = duration;
// Assigning parameter to instance variable (distinguished by 'this').

        } // End of Course constructor.

        void displayDetails() {
// Method declaration providing basic course information display.

            System.out.println("Course Name: " + courseName);
// Printing the course name with descriptive label.

            System.out.println("Duration: " + duration + " weeks");
// Printing the duration with unit suffix.

        } // End of displayDetails method in superclass.

    } // End of Course superclass.

    // Subclass
    class OnlineCourse extends Course {
// Inner class declaration for OnlineCourse subclass that inherits from Course superclass.

        String platform;
// Subclass-specific instance variable for delivery platform.

        boolean isRecorded;
// Subclass-specific instance variable for recording status.

        OnlineCourse(String courseName, int duration,
            String platform, boolean isRecorded) {
// Constructor declaration that chains to superclass and sets subclass fields.

            super(courseName, duration);
// Calling superclass Course constructor with basic parameters.

            this.platform = platform;
// Assigning parameter to subclass instance variable.

            this.isRecorded = isRecorded;
// Assigning parameter to subclass instance variable.

        } // End of OnlineCourse constructor.

        void displayDetails() {
// Overriding superclass displayDetails() to include online-specific info.

            super.displayDetails();
// Calling superclass Course's displayDetails() to print basic details first.

            System.out.println("Platform: " + platform);
// Printing the platform name.

            System.out.println("Recorded: " + isRecorded);
// Printing the recorded status (true/false).

        } // End of overridden displayDetails method in OnlineCourse.

    } // End of OnlineCourse subclass.

    // Subclass
    class PaidOnlineCourse extends OnlineCourse {
// Inner class declaration for PaidOnlineCourse subclass that inherits from OnlineCourse superclass.

        double fee;
// Subclass-specific instance variable for course fee.

        double discount;
// Subclass-specific instance variable for discount percentage.

        PaidOnlineCourse(String courseName, int duration,
            String platform, boolean isRecorded,
            double fee, double discount) {
// Constructor declaration that chains to parent OnlineCourse constructor.

            super(courseName, duration, platform, isRecorded);
// Calling superclass OnlineCourse constructor with first four parameters.

            this.fee = fee;
// Assigning parameter to subclass instance variable.

            this.discount = discount;
// Assigning parameter to subclass instance variable.

        } // End of PaidOnlineCourse constructor.

        void displayDetails() {
// Fully overriding parent displayDetails() to include payment details.

            super.displayDetails();
// Calling parent OnlineCourse's displayDetails() for prior levels' info.

            System.out.println("Fee: ₹" + fee);
// Printing the course fee with currency symbol.

            System.out.println("Discount: " + discount + "%");
// Printing the discount with percentage symbol.

        } // End of fully overridden displayDetails method in PaidOnlineCourse.

    } // End of PaidOnlineCourse subclass.

} // End of CourseTest class.
