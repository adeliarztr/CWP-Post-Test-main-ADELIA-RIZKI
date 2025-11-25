package posttest2;

public class Employee extends Person {
    protected String role;

    public Employee(String id, String name, String gender, int age, String role) {
        super(id, name, gender, age);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getEmployeeInfo() {
        return getName() + " (" + getGender() + ", " + getAge() + ") | Role: " + role;
    }
}
