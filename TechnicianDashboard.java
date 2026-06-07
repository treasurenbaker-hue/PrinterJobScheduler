import javax.swing.*;

public class TechnicianDashboard {

    JFrame frame;

    public TechnicianDashboard() {

        frame = new JFrame("Technician Dashboard");

        JButton viewJobsBtn = new JButton("View Jobs");
        JButton acceptBtn = new JButton("Accept Job");
        JButton completeBtn = new JButton("Complete Job");

        viewJobsBtn.setBounds(50, 50, 200, 40);
        acceptBtn.setBounds(50, 110, 200, 40);
        completeBtn.setBounds(50, 170, 200, 40);

        frame.add(viewJobsBtn);
        frame.add(acceptBtn);
        frame.add(completeBtn);

        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        // VIEW JOBS
        viewJobsBtn.addActionListener(e -> {

            StringBuilder sb = new StringBuilder();

            for (RepairJob job : ReceptionistDashboard.jobs) {

                sb.append("Job ID: ").append(job.jobId)
                        .append("\nCustomer: ").append(job.customer.name)
                        .append("\nPrinter: ").append(job.printer.model)
                        .append("\nStatus: ").append(job.status)
                        .append("\n\n");
            }

            JOptionPane.showMessageDialog(frame, sb.toString());
        });

        // ACCEPT JOB
   acceptBtn.addActionListener(e -> {

    String idStr = JOptionPane.showInputDialog("Enter Job ID to Accept");
    if (idStr == null) return;

    int jobId = Integer.parseInt(idStr);

    for (RepairJob job : ReceptionistDashboard.jobs) {

        if (job.jobId == jobId && job.status.equals("Available")) {

            Employee tech = Session.currentUser;

            job.assignTechnician(
                    new Technician(
                            tech.employeeId,
                            tech.name,
                            true
                    )
            );

            tech.setAvailable(false);

            JOptionPane.showMessageDialog(frame, "Job Accepted");

            return;
        }
    }

    JOptionPane.showMessageDialog(frame, "Job not found");
});

        // COMPLETE JOB
        completeBtn.addActionListener(e -> {

            String idStr =
                    JOptionPane.showInputDialog(
                            "Enter Job ID to Complete");

            if (idStr == null) return;

            int jobId = Integer.parseInt(idStr);

            for (RepairJob job : ReceptionistDashboard.jobs) {

                if (job.jobId == jobId)
 {

                  String techName =
        JOptionPane.showInputDialog(
                "Enter Technician Name");
Employee tech = Session.currentUser;

job.status = "Completed by " + techName;
tech.setAvailable(true);

                    JOptionPane.showMessageDialog(
                            frame,
                            "Job Completed!"
                    );

                    return;
                }
            }

            JOptionPane.showMessageDialog(
                    frame,
                    "Job not found."
            );
        });
    }
}
