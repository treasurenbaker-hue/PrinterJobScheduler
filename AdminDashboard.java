import javax.swing.*;
import java.util.*;

public class AdminDashboard {

    JFrame frame;

    public AdminDashboard() {

        frame = new JFrame("Admin Dashboard");

        JButton viewJobs = new JButton("View Jobs");
        JButton addEmployee = new JButton("Add Employee");
	JButton viewEmployees = new JButton("View Employees");

        viewJobs.setBounds(50, 50, 200, 40);
        addEmployee.setBounds(50, 110, 200, 40);
	viewEmployees.setBounds(50, 170, 200, 40);

        frame.add(viewJobs);
        frame.add(addEmployee);
	frame.add(viewEmployees);

        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        // VIEW JOBS
             

        // ADD EMPLOYEE
        addEmployee.addActionListener(e -> {

    String name = JOptionPane.showInputDialog("Enter Name");
    String role = JOptionPane.showInputDialog("Enter Role");
    String password = JOptionPane.showInputDialog("Enter Password");

    int id = ReceptionistDashboard.employees.size() + 1;

    ReceptionistDashboard.employees.add(
            new Employee(id, name, role.toUpperCase(), password)
    );
Storage.saveEmployees(ReceptionistDashboard.employees);

    JOptionPane.showMessageDialog(frame, "Employee Added");
});
    }
}
