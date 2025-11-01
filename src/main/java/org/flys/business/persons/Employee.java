package org.flys.business.persons;

public class Employee extends Person {
    private EmployeeType employeeType;

    public Employee(String name, String surname, String email, String phoneNumber, int age, EmployeeType employeeType) {
        super(name, surname, email, phoneNumber, age);
        this.employeeType = employeeType;
    }

    public Employee(){
        super();
        this.employeeType = EmployeeType.ATTENDANT;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }
    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
