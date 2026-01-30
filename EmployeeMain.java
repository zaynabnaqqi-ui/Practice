class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String first, String last, double salary) {
        firstName = first;
        lastName = last;

        if (salary > 0)
            monthlySalary = salary;
    }
    public void setFirstName(String first) { firstName = first; }
    public void setLastName(String last) { lastName = last; }

    public void setMonthlySalary(double salary) {
        if (salary > 0)
            monthlySalary = salary; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public double getMonthlySalary() { return monthlySalary; }
    public double yearlySalary() { return monthlySalary * 12; }
}
public class EmployeeMain {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Zaynab", "Naqqi", 25000);
        Employee emp2 = new Employee("Maham", "Nauman", 499.0);

        System.out.println("Yearly Salary of " + emp1.getFirstName() + " " + emp1.getLastName() + " is " + emp1.yearlySalary());
        System.out.println("Yearly Salary of " + emp2.getFirstName() + " " +  emp2.getLastName() +" is " + emp2.yearlySalary());

        emp1.setMonthlySalary(emp1.getMonthlySalary() * 1.10);   // 10% raise
        emp2.setMonthlySalary(emp2.getMonthlySalary() * 1.10);

        System.out.println("After 10% Raise:");    // display salary 
        System.out.println("Yearly Salary of " + emp1.getFirstName() + " " +emp1.getLastName() + " is  " + emp1.yearlySalary());
        System.out.println("Yearly Salary of " + emp2.getFirstName() + " " + emp2.getLastName() +" is " + emp2.yearlySalary());
    }
}
