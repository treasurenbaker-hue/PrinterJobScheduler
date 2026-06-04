import javax.swing.*;
import java.util.ArrayList;

public class ReceptionistDashboard {

    JFrame frame;

    static ArrayList<RepairJob> jobs = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();

    public ReceptionistDashboard() {

        // sample employees
        if (employees.isEmpty()) {
            employees.add(new Employee(1, "Brian", "TECHNICIAN"));
            employees.add(new Employee(2, "Sarah", "TECHNICIAN"));
            employees.add(new Employee(3, "Alice", "RECEPTIONIST"));
        }

        frame = new JFrame("Receptionist Dashboard");

        JButton addJobBtn = new JButton("Add Repair Job");
        JButton viewJobsBtn = new JButton("View Assigned Jobs");

        addJobBtn.setBounds(50, 50, 200, 40);
        viewJobsBtn.setBounds(50, 110, 200, 40);

        frame.add(addJobBtn);
        frame.add(viewJobsBtn);

        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        // ADD JOB
        addJobBtn.addActionListener(event -> {

            String customerName = JOptionPane.showInputDialog("Customer Name:");
            String phone = JOptionPane.showInputDialog("Customer Phone:");
            String printerModel = JOptionPane.showInputDialog("Printer Model:");
            String fault = JOptionPane.showInputDialog("Fault Description:");

            Customer customer = new Customer(jobs.size() + 1, customerName, phone);
            Printer printer = new Printer(jobs.size() + 100, printerModel, fault);

            RepairJob job = new RepairJob(
                    jobs.size() + 1001,
                    customer,
                    printer,
                    "Created"
            );

            jobs.add(job);

            // auto-assign technician
            for (Employee emp : employees) {
                if (emp.role.equals("TECHNICIAN") && emp.available) {

                    job.assignTechnician(
                            new Technician(emp.employeeId, emp.name, true)
                    );

                    job.startRepair();
                    emp.setAvailable(false);

                    break;
                }
            }

            JOptionPane.showMessageDialog(frame,
                    "Job Created Successfully!\nJob ID: " + job.jobId);
        });

        // VIEW JOBS
        viewJobsBtn.addActionListener(event -> {

            StringBuilder sb = new StringBuilder();

            for (RepairJob job : jobs) {

                sb.append("Job ID: ").append(job.jobId)
                        .append("\nCustomer: ").append(job.customer.name)
                        .append("\nPrinter: ").append(job.printer.model)
                        .append("\nFault: ").append(job.printer.faultDescription)
                        .append("\nStatus: ").append(job.status)
                        .append("\nTechnician: ")
                        .append(job.technician != null ? job.technician.name : "None")
                        .append("\n--------------------\n");
            }

            JOptionPane.showMessageDialog(frame, sb.toString());
        });
    }
}
