package posttest2;

public class Accounting extends Employee implements Payable {

    public Accounting(String id, String name, String gender, int age) {
        super(id, name, gender, age, "Accounting");
    }

    @Override
    public double calculateSalary(Employee emp) {
        // hanya boleh jika ID = A001
        if (!getId().equals("A001")) return 0.0;

        if (emp.getRole().equalsIgnoreCase("Staff")) {
            return 5000.0;
        } else if (emp.getRole().equalsIgnoreCase("Manager")) {
            return 7000.0;
        }

        return 0.0;
    }

    @Override
    public double calculateSalary(Employee emp, double bonusRate) {
        // jika bukan A001 → gaji diblokir
        if (!getId().equals("A001")) return 0.0;

        double base = calculateSalary(emp);
        return base + base * bonusRate;
    }

    @Override
    public String getEmployeeInfo() {
        return super.getEmployeeInfo()
                + " | Can calculate salaries for Staff & Manager";
    }
}

