package models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Column {
    private String name;
    private Class<?> type;

    public Column(String name, String type) throws ClassNotFoundException {
        this.name = name;
        this.type = getTypeFromString(type);
    }

    public String getType() throws ClassNotFoundException {
        return getStringFromType(type);
    }

    public void setType(String type) throws ClassNotFoundException {
        this.type = getTypeFromString(type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getTypeFromString(String type) throws ClassNotFoundException {
        return switch (type) {
            case "int" -> Integer.class;
            case "long" -> Long.class;
            case "string" -> String.class;
            case "boolean" -> Boolean.class;
            case "date" -> LocalDateTime.class;
            default -> throw new ClassNotFoundException("The class is not supported");
        };
    }

    public String getStringFromType(Class<?> type) throws ClassNotFoundException {
        return switch (type.getSimpleName()) {
            case "Integer" -> "int";
            case "Long" -> "long";
            case "String" -> "string";
            case "Boolean" -> "boolean";
            case "LocalDateTime" -> "date";
            default -> throw new ClassNotFoundException("The class is not supported");
        };
    }

    @Override
    public String toString() {
        try {
            return this.name + " " + this.getStringFromType(this.type);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object c1) {
        if(this == c1) {
            return true;
        }
        if(c1 == null || c1.getClass() != getClass()) {
            return false;
        }
        return c1.toString().equals(this.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
