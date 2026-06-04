public class RepairJob {

    int jobId;
    Customer customer;
    Printer printer;
    String status;
    Technician technician;

    public RepairJob(int jobId, Customer customer, Printer printer, String status) {
        this.jobId = jobId;
        this.customer = customer;
        this.printer = printer;
        this.status = status;
    }

    public void assignTechnician(Technician technician) {
        this.technician = technician;
        this.status = "Assigned to " + technician.name;
    }

    public void startRepair() {
        status = "In Progress";
    }

    public void completeRepair() {
        status = "Completed";
    }
}
