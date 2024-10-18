package models;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Table {
    private final HashMap<Integer, Row> records;
    private final HashSet<String> columns;
    private String tableName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Table(String tableName, HashMap<String, String> columns) {
        this.tableName = tableName;
        this.records = new HashMap<>();
        this.columns = new HashSet<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        columns.forEach((name, _) -> {
            this.columns.add(name);
        });
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public HashMap<Integer, Row> getRecords() {
        return records;
    }

    public int getNumberOfColumn() {
        return this.columns.size();
    }

    public void insertRecords(int rowId, HashMap<String, String> newRecords) {
        boolean columnExists = true;
        for (Map.Entry<String, String> entry : newRecords.entrySet()) {
            String columnName = entry.getKey();
            if (!columns.contains(columnName)) {
                columnExists = false;
                break;
            }
        }
        if(columnExists) {
            Row currentRow = new Row();
            currentRow.setRecords(newRecords);
            this.records.put(rowId, currentRow);
        }
   }

   public void updateRecords(int rowId, HashMap<String, String> updatedRecord) {
       boolean columnExists = true;
       Row row = this.records.get(rowId);
       for (Map.Entry<String, String> entry : updatedRecord.entrySet()) {
           String columnName = entry.getKey();
           if (!columns.contains(columnName)) {
               columnExists = false;
               break;
           }
       }
       if(columnExists) {
           HashMap<String, String> mixed = row.getRecords();
           mixed.putAll(updatedRecord);
           row.setRecords(mixed);
           this.records.put(rowId, row);
       }
       this.records.get(rowId).toString();
   }

   public void deleteRecords(int rowId) {
        this.records.remove(rowId);
   }

   @Override
    public String toString() {
        return "Table: " + this.tableName + "\nColumns: " + this.columns + "\nRecords: " + this.records.toString();
   }
}
