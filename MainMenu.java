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

        // TECHNICIAN LOGIN
        technicianBtn.addActionListener(e -> {

            String name = JOptionPane.showInputDialog("Enter Name");
            String password = JOptionPane.showInputDialog("Enter Password");

            for (Employee emp : ReceptionistDashboard.employees) {

                System.out.println(emp.name + " " + emp.password + " " + emp.role);

                if (emp.name.equalsIgnoreCase(name)
                        && emp.password.trim().equals(password.trim())
                        && emp.role.equalsIgnoreCase("TECHNICIAN")) {

                    Session.currentUser = emp;
                    new TechnicianDashboard();
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "Invalid login");
        });

        // ADMIN LOGIN (no login yet, just open)
        adminBtn.addActionListener(e -> {

    String password = JOptionPane.showInputDialog("Enter Admin Password");

    for (Employee emp : ReceptionistDashboard.employees) {

        if (emp.role.equalsIgnoreCase("RECEPTIONIST")
                && emp.password.equals(password)) {

            Session.currentUser = emp;
            new AdminDashboard();
            return;
        }
    }

    JOptionPane.showMessageDialog(null, "Invalid Admin Password");
});
	}
}
