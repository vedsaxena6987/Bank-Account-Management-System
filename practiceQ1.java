
import java.util.Scanner;


class InvalidEmployeeIDException extends Exception {
    public InvalidEmployeeIDException(String message) {
        super(message);
    }
}

class InvalidEmployeeNameException extends Exception {
    public InvalidEmployeeNameException(String message) {
        super(message);
    }
}

class InvalidDepartmentIDException extends Exception {
    public InvalidDepartmentIDException(String message) {
        super(message);
    }
}

public class practiceQ1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter Employee Details:");
            System.out.print("Enter Employee ID (2001-5001): ");
            int empId = scanner.nextInt();
            if (empId < 2001 || empId > 5001) {
                throw new InvalidEmployeeIDException("Employee ID must be between 2001 and 5001.");
            }

            scanner.nextLine(); 

            System.out.print("Enter Employee Name (First letter capital): ");
            String empName = scanner.nextLine();
            if (!Character.isUpperCase(empName.charAt(0))) {
                throw new InvalidEmployeeNameException("Employee name must start with a capital letter.");
            }

            System.out.print("Enter Department ID (1-5): ");
            int deptId = scanner.nextInt();
            if (deptId < 1 || deptId > 5) {
                throw new InvalidDepartmentIDException("Department ID must be between 1 and 5.");
            }

            System.out.println("\nEmployee Details:");
            System.out.println("Employee ID: " + empId);
            System.out.println("Employee Name: " + empName);
            System.out.println("Department ID: " + deptId);

        } catch (InvalidEmployeeIDException | InvalidEmployeeNameException | InvalidDepartmentIDException e) {
            System.out.println("Input Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
