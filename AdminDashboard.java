import javax.swing.*;

public class AdminDashboard {

    JFrame frame;

    public AdminDashboard() {

        frame = new JFrame("Admin Dashboard");

        JButton viewJobs = new JButton("View Jobs");
        JButton addEmployee = new JButton("Add Employee");

        viewJobs.setBounds(50, 50, 200, 40);
        addEmployee.setBounds(50, 110, 200, 40);

        frame.add(viewJobs);
        frame.add(addEmployee);

        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        // VIEW JOBS
        viewJobs.addActionListener(e -> {

            StringBuilder sb = new StringBuilder();

            for (RepairJob job : ReceptionistDashboard.jobs) {

                sb.append("Job ID: ").append(job.jobId)
                        .append("\nStatus: ").append(job.status)
                        .append("\nCustomer: ").append(job.customer.name)
                        .append("\nPrinter: ").append(job.printer.model)
                        .append("\n\n");
            }

            JOptionPane.showMessageDialog(frame, sb.toString());
        });

        // ADD EMPLOYEE
        addEmployee.addActionListener(e -> {

            String name = JOptionPane.showInputDialog("Enter Employee Name:");
            String role = JOptionPane.showInputDialog("Enter Role (TECHNICIAN / RECEPTIONIST):");

            int id = ReceptionistDashboard.employees.size() + 1;

            ReceptionistDashboard.employees.add(
                    new Employee(id, name, role.toUpperCase())
            );

            JOptionPane.showMessageDialog(frame,
                    "Employee Added:\n" + name + " (" + role + ")");
        });
    }
}
