package core_programming.Methods.Level3;
/*
Create a program to find the bonus of 10 employees based on their years of
service as well as the total bonus amount the 10-year-old company Zara has to pay
as a bonus, along with the old and new salary.
Hint =>
Zara decides to give a bonus of 5% to employees whose year of service is more than
5 years or 2% if less than 5 years
Create a Method to determine the Salary and years of service and return the same.
Use the Math.random() method to determine the 5-digit salary for each employee and
also use the random method to determine the years of service. Define 2D Array to save
the salary and years of service.
Write a Method to calculate the new salary and bonus based on the logic defined above
and return the new 2D Array of the latest salary and bonus amount
Write a Method to Calculate the sum of the Old Salary, the Sum of the New Salary,
and the Total Bonus Amount and display it in a Tabular Format
*/

public class EmployeeBonusCalculator {

    public static double[][] generateEmployeeData(int employees) {

        double[][] data = new double[employees][2];

        for (int i = 0; i < employees; i++) {

            data[i][0] = (int) (Math.random() * 90000) + 10000;

            data[i][1] = (int) (Math.random() * 10) + 1;
        }
        return data;
    }

    public static double[][] calculateBonus(double[][] data) {

        double[][] result = new double[data.length][2];

        for (int i = 0; i < data.length; i++) {

            double salary = data[i][0];
            double years = data[i][1];
            double bonus;

            if (years > 5) {
                bonus = salary * 0.05; // 5% bonus
            } else {
                bonus = salary * 0.02; // 2% bonus
            }

            result[i][0] = salary + bonus; // New Salary
            result[i][1] = bonus;
        }

        return result;
    }

    public static void displayReport(double[][] oldData, double[][] newData) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("Emp\tOldSalary\tYears\tBonus\t\tNewSalary");

        for (int i = 0; i < oldData.length; i++) {

            double oldSalary = oldData[i][0];
            double years = oldData[i][1];
            double bonus = newData[i][1];
            double newSalary = newData[i][0];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%d\t%.0f\t\t%.0f\t%.2f\t\t%.2f\n",
                    (i + 1), oldSalary, years, bonus, newSalary);
        }

        System.out.println("----------------------------------------------------------");
        System.out.printf("TOTAL\t%.0f\t\t\t%.2f\t\t%.2f\n",
                totalOldSalary, totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {

        int employees = 10;

        double[][] employeeData = generateEmployeeData(employees);

        double[][] updatedData = calculateBonus(employeeData);

        displayReport(employeeData, updatedData);
    }
}
