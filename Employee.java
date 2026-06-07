public class Employee {

    int employeeId;
    String name;
    String role;
    String password;   // NEW
    boolean available;

    public Employee(int employeeId, String name, String role, String password) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.password = password;
        this.available = true;
    }

    public void setAvailable(boolean status) {
        this.available = status;
    }
}
