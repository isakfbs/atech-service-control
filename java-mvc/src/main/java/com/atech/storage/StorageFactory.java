package main.java.com.atech.storage;

public class StorageFactory {
    public static CustomerStorage getStorage(String type) {
        switch (type.toLowerCase()){
            case "database":
                return new DatabaseStorage();
            case "json":
                return new JsonFileStorage("customers.json");
            default:
                throw new IllegalArgumentException("Invalid storage type: " + type);
        }

    }}
