package org.flys.business.persons;

public class Employee extends Person {

    protected EmployeeType employeeType;

    public Employee(String name, String surname, int age, String email, String phoneNumber, EmployeeType employeeType) {
        super(name, surname, age, email, phoneNumber);
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
