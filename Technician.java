public class Technician {

    int techId;
    String name;
    boolean available;

    public Technician(int techId, String name, boolean available) {
        this.techId = techId;
        this.name = name;
        this.available = available;
    }

    public void acceptJob(RepairJob job) {
        if (available) {
            job.assignTechnician(this);
            job.startRepair();
            available = false;
        }
    }
}
