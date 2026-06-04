import javax.swing.*;

public class TechnicianDashboard {

    JFrame frame;

    public TechnicianDashboard() {

        frame = new JFrame("Technician Dashboard");

        JButton viewJobsBtn = new JButton("View My Jobs");
        JButton acceptBtn = new JButton("Accept First Job");
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
                if (job.status.contains("Assigned") || job.status.equals("In Progress")) {
                    sb.append("Job ID: ").append(job.jobId)
                            .append("\nStatus: ").append(job.status)
                            .append("\n\n");
                }
            }

            JOptionPane.showMessageDialog(frame, sb.toString());
        });

        // ACCEPT JOB
        acceptBtn.addActionListener(e -> {
            for (RepairJob job : ReceptionistDashboard.jobs) {
                if (job.status.contains("Assigned")) {
                    job.startRepair();
                    break;
                }
            }
        });

        // COMPLETE JOB
        completeBtn.addActionListener(e -> {
            for (RepairJob job : ReceptionistDashboard.jobs) {
                if (job.status.equals("In Progress")) {
                    job.completeRepair();
                    break;
                }
            }
        });
    }
}
