import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Add Fees");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    DB_connection.addStudent(id, name, age, course);
                    break;

                case 2:
                    DB_connection.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();

                    DB_connection.searchStudent(searchId);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();

                    DB_connection.deleteStudent(deleteId);
                        break;

                case 5:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    DB_connection.updateStudent(updateId, newName, newAge, newCourse);
                    break;

                case 6:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();

                    System.out.print("Enter Total Fees: ");
                    double total = sc.nextDouble();

                    System.out.print("Enter Paid Amount: ");
                    double paid = sc.nextDouble();

                    DB_connection.addFees(sid, total, paid);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}