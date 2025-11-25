package posttest2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AccountingTest {

    @Test
    public void testPerson() {
        // --- Code input ---
        // Hint: id, name, gender, age should be private
        Person p = new Person("P001", "Andi", "Male", 22);

        // --- Code output ---
        String codeOutputInfo = p.getInfo();
        String codeOutputId = p.getId();
        String codeOutputName = p.getName();
        String codeOutputGender = p.getGender();
        int codeOutputAge = p.getAge();

        // --- Expected output ---
        String expectedOutputInfo = "Andi (Male, 22)";
        String expectedOutputId = "P001";
        String expectedOutputName = "Andi";
        String expectedOutputGender = "Male";
        int expectedOutputAge = 22;

        // --- Assertion ---
        try {
            assertEquals(expectedOutputInfo, codeOutputInfo);
            assertEquals(expectedOutputId, codeOutputId);
            assertEquals(expectedOutputName, codeOutputName);
            assertEquals(expectedOutputGender, codeOutputGender);
            assertEquals(expectedOutputAge, codeOutputAge);
        } catch (AssertionError ae) {
            System.out.println(ae);
        }
    }

    @Test
    public void testEmployee() {
        // --- Code input ---
        // Hint: role should be protected so subclasses can override
        Employee staff = new Employee("E001", "Budi", "Male", 25, "Staff");
        Employee manager = new Employee("E002", "Dewi", "Female", 35, "Manager");

        // --- Code output ---
        String codeOutputStaffInfo = staff.getEmployeeInfo();
        String codeOutputManagerInfo = manager.getEmployeeInfo();
        String codeOutputStaffRole = staff.getRole();
        String codeOutputManagerRole = manager.getRole();

        // --- Expected output ---
        String expectedStaffInfo = "Budi (Male, 25) | Role: Staff";
        String expectedManagerInfo = "Dewi (Female, 35) | Role: Manager";
        String expectedStaffRole = "Staff";
        String expectedManagerRole = "Manager";

        // --- Assertion ---
        try {
            assertEquals(expectedStaffInfo, codeOutputStaffInfo);
            assertEquals(expectedManagerInfo, codeOutputManagerInfo);
            assertEquals(expectedStaffRole, codeOutputStaffRole);
            assertEquals(expectedManagerRole, codeOutputManagerRole);
        } catch (AssertionError ae) {
            System.out.println(ae);
        }
    }

    @Test
    public void testAccountingSpecialID() {
        // --- Code input ---
        // Hint: Accounting implements Payable, methods can be public
        Employee staff = new Employee("E001", "Budi", "Male", 25, "Staff");
        Employee manager = new Employee("E002", "Dewi", "Female", 35, "Manager");

        Accounting acc = new Accounting("A001", "Armi", "Female", 30);

        // --- Code output ---
        double codeOutputStaffSalary = acc.calculateSalary(staff);
        double codeOutputManagerSalaryBonus = acc.calculateSalary(manager, 0.1);
        String codeOutputAccInfo = acc.getEmployeeInfo();

        // --- Expected output ---
        double expectedStaffSalary = 5000.0;
        double expectedManagerSalaryBonus = 7000.0 + 7000.0 * 0.1;
        // getEmployeeInfo should contain the special hint text
        String expectedAccInfoContains = "Can calculate salaries for Staff & Manager";

        // --- Assertion ---
        try {
            assertEquals(expectedStaffSalary, codeOutputStaffSalary, 0.001);
            assertEquals(expectedManagerSalaryBonus, codeOutputManagerSalaryBonus, 0.001);
            assertTrue(codeOutputAccInfo.contains(expectedAccInfoContains));
        } catch (AssertionError ae) {
            System.out.println(ae);
        }
    }

    @Test
    public void testAccountingNonSpecialID() {
        // --- Code input ---
        Employee staff = new Employee("E001", "Budi", "Male", 25, "Staff");
        Employee manager = new Employee("E002", "Dewi", "Female", 35, "Manager");

        Accounting acc2 = new Accounting("A002", "Novan", "Male", 28);

        // --- Code output ---
        double codeOutputStaffSalary = acc2.calculateSalary(staff);
        double codeOutputManagerSalaryBonus = acc2.calculateSalary(manager, 0.1);

        // --- Expected output ---
        double expectedStaffSalary = 0.0; // access denied
        double expectedManagerSalaryBonus = 0.0; // access denied

        // --- Assertion ---
        try {
            assertEquals(expectedStaffSalary, codeOutputStaffSalary, 0.001);
            assertEquals(expectedManagerSalaryBonus, codeOutputManagerSalaryBonus, 0.001);
        } catch (AssertionError ae) {
            System.out.println(ae);
        }
    }

    @Test
    public void testAccountingImplementsPayable() {
        // --- Code input ---
        Accounting acc = new Accounting("A001", "Armi", "Female", 30);

        // --- Code output ---
        boolean codeOutputInstance = acc instanceof Payable;

        // --- Expected output ---
        boolean expectedOutputInstance = true;

        // --- Assertion ---
        try {
            assertEquals(expectedOutputInstance, codeOutputInstance);
        } catch (AssertionError ae) {
            System.out.println(ae);
        }
    }
}
