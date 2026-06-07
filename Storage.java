import java.io.*;
import java.util.*;

public class Storage {

    public static void saveEmployees(ArrayList<Employee> list) {
        try (PrintWriter pw = new PrintWriter("employees.txt")) {
            for (Employee e : list) {
                pw.println(e.employeeId + "," + e.name + "," + e.role + "," + e.password + "," + e.available);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> loadEmployees() {
        ArrayList<Employee> list = new ArrayList<>();

        try (Scanner sc = new Scanner(new File("employees.txt"))) {

            while (sc.hasNextLine()) {
                String[] p = sc.nextLine().split(",");

                Employee e = new Employee(
                        Integer.parseInt(p[0]),
                        p[1],
                        p[2],
                        p[3]
                );

                e.available = Boolean.parseBoolean(p[4]);
                list.add(e);
            }

        } catch (Exception e) {
            // file might not exist yet
        }

        return list;
    }
}
