import models.Database;
import models.Table;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Database db = new Database();
    public static void main(String[] args) {
        System.out.println("Hello and welcome to InMemory Database!");
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while(running) {
            displayInfo();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("----Creating table----");
                    createTable(scanner);
                    break;
                case 2:
                    System.out.println("----Deleting table----");
                    deleteTable(scanner);
                    break;
                case 3:
                    System.out.println("----Creating a record in table----");
                    createRecord(scanner);
                    break;
                case 4:
                    System.out.println("----Updating a record in table----");
                    updateRecord(scanner);
                    break;
                case 5:
                    System.out.println("----Deleting a record in a table-----");
                    deleteRecord(scanner);
                    break;
                default:
                    System.out.println("Quitting....");
                    running = false;
                    break;
            }
        }
        scanner.close();
        System.out.println("Thanks!");
    }

    private static void displayInfo() {
        System.out.println("-------Please type the option---------");
        System.out.println("1: Create a table");
        System.out.println("2: Delete a table");
        System.out.println("3: Create a record in a table");
        System.out.println("4: Update a record in a table");
        System.out.println("5: Delete a record in the table");
        System.out.println("Any other number to quit");
    }

    public static void createTable(Scanner scanner) {
        System.out.println("Enter table name: ");
        String tableName = scanner.nextLine();
        System.out.println("Enter number of columns: ");
        int cols = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter columns name and type ");
        HashMap<String, String> columns = new HashMap<>();
        while(cols > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.trim().split(" ");
            columns.put(inputArr[0], inputArr[1]);
            cols--;
        }
        System.out.println("--------------");
        System.out.println("The table is: " + db.createTable(tableName, columns));
    }

    public static void deleteTable(Scanner scanner) {
        System.out.println("Enter table name: ");
        String tableName = scanner.nextLine();
        db.deleteTable(tableName);
    }

    public static void createRecord(Scanner scanner) {
        System.out.println("Enter table name: ");
        String tableName = scanner.nextLine();
        System.out.println("Enter rowId: ");
        int rowId = scanner.nextInt();
        scanner.nextLine();
        Table table = db.getTableByName(tableName);
        int numberOfRecords = table.getNumberOfColumn();
        HashMap<String, String> map = new HashMap<>();
        System.out.println("Enter data: ");
        while(numberOfRecords > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.trim().split(" ");
            map.put(inputArr[0], inputArr[1]);
            numberOfRecords--;
        }
        table.insertRecords(rowId, map);
        System.out.println("table looks like this now: " + table);
    }

    public static void updateRecord(Scanner scanner) {
        System.out.println("Enter Table Name: ");
        String tableName = scanner.nextLine();
        System.out.println("Enter rowId: ");
        int rowId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter number of records you want to update: ");
        int numberOfRecords = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, String> map = new HashMap<>();
        System.out.println("Enter records: ");
        while(numberOfRecords > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.trim().split(" ");
            map.put(inputArr[0], inputArr[1]);
            numberOfRecords--;
        }
        Table table = db.getTableByName(tableName);
        table.updateRecords(rowId, map);
        System.out.println("table looks like this now: " + table);
    }

    public static void deleteRecord(Scanner scanner) {
        System.out.println("Enter table name: ");
        String tableName = scanner.nextLine();
        System.out.println("Enter rowId: ");
        int rowId = scanner.nextInt();
        scanner.nextLine();
        Table table = db.getTableByName(tableName);
        table.deleteRecords(rowId);
        System.out.println("Deleted!");
    }

}