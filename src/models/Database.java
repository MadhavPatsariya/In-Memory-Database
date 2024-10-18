package models;

import java.util.HashMap;

public class Database {
    private HashMap<String, Table> tableRecords;
    private String databaseName;

    public Database() {
        this.tableRecords = new HashMap<>();
        this.databaseName = "Database";
    }

    public String getDatabaseName() {
        return this.databaseName;
    }

    public void setDatabaseName() {
        this.databaseName = databaseName;
    }

    public HashMap<String, Table> getTableRecords() {
        return tableRecords;
    }

    public void setTableRecords(HashMap<String, Table> tableRecords) {
        this.tableRecords = tableRecords;
    }

    public String createTable(String name, HashMap<String, String> columns) {
        tableRecords.put(name, new Table(name, columns));
        return tableRecords.get(name).toString();
    }

    public Table getTableByName(String name) {
        return tableRecords.get(name);
    }

    public boolean deleteTable(String name) {
        tableRecords.remove(name);
        return true;
    }
}
