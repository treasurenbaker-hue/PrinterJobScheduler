import javax.swing.*;

public class MainMenu {

    JFrame frame;

    public MainMenu() {

        frame = new JFrame("Printer Repair System - Login");

        JButton receptionistBtn = new JButton("Receptionist");
        JButton technicianBtn = new JButton("Technician");
        JButton adminBtn = new JButton("Admin");

        receptionistBtn.setBounds(80, 50, 200, 40);
        technicianBtn.setBounds(80, 110, 200, 40);
        adminBtn.setBounds(80, 170, 200, 40);

        frame.add(receptionistBtn);
        frame.add(technicianBtn);
        frame.add(adminBtn);

        frame.setSize(380, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Open dashboards
        receptionistBtn.addActionListener(e -> new ReceptionistDashboard());
        technicianBtn.addActionListener(e -> new TechnicianDashboard());
        adminBtn.addActionListener(e -> new AdminDashboard());
    }
}
