package Object_Oriented_Programming.Composition;

import java.util.ArrayList;

/* ---------- COMPANY CLASS (OWNER) ---------- */
class Company {

    String companyName;
    ArrayList<Department> departments = new ArrayList<>();

    Company(String companyName) {
        this.companyName = companyName;
    }

    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    void displayCompanyDetails() {
        System.out.println("\nCompany: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartmentDetails();
        }
    }

    // Composition: deleting company deletes everything inside
    void deleteCompany() {
        departments.clear();   // removes all departments & employees
        System.out.println("\nCompany deleted along with all Departments and Employees");
    }

    /* ---------- INNER DEPARTMENT CLASS ---------- */
    class Department {

        String departmentName;
        ArrayList<Employee> employees = new ArrayList<>();

        Department(String departmentName) {
            this.departmentName = departmentName;
        }

        void addEmployee(String empName) {
            employees.add(new Employee(empName));
        }

        void displayDepartmentDetails() {
            System.out.println(" Department: " + departmentName);
            for (Employee emp : employees) {
                emp.displayEmployeeDetails();
            }
        }

        /* ---------- INNER EMPLOYEE CLASS ---------- */
        class Employee {

            String employeeName;

            Employee(String employeeName) {
                this.employeeName = employeeName;
            }

            void displayEmployeeDetails() {
                System.out.println("  Employee: " + employeeName);
            }
        }
    }
}

/* ---------- MAIN CLASS (SAME FILE) ---------- */
class CompanyComposition {

    public static void main(String[] args) {

        // Create company
        Company company = new Company("TechNova Pvt Ltd");

        // Add departments
        company.addDepartment("Development");
        company.addDepartment("HR");

        // Add employees (composition)
        Company.Department devDept = company.departments.get(0);
        devDept.addEmployee("Amit");
        devDept.addEmployee("Riya");

        Company.Department hrDept = company.departments.get(1);
        hrDept.addEmployee("Neha");

        // Display company structure
        company.displayCompanyDetails();

        // Delete company (composition effect)
        company.deleteCompany();
    }
}
