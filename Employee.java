public class Employee {

    int employeeId;
    String name;
    String role; // "TECHNICIAN" or "RECEPTIONIST"
    boolean available;

    public Employee(int employeeId, String name, String role) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.available = true;
    }

    public void setAvailable(boolean status) {
        this.available = status;
    }
}
