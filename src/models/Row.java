package models;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Row {
    private int id;
    private HashMap<String, String> records;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Row() {
        this.records = new HashMap<>();
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    public HashMap<String, String> getRecords() {
        return this.records;
    }

    public void setRecords(HashMap<String, String> records) {
        this.records = records;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Row: " + this.id + "having records: " + this.records.toString();
    }
}
