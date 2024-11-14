package dev.bikas;

import java.io.IOException;
import java.nio.file.Path;

public class Application {
    public static void main(String[] args) throws IOException {
        DataSingleton dataSingleton = DataSingleton.getInstance();

        // Populate data from a CSV file
        dataSingleton.populate(Path.of("src/main/resources/data.csv"));

        // Print all data
        dataSingleton.print();

        // Get a specific data member's value
        System.out.printf("Value of key: %s, is %s\n",
                "2070", dataSingleton.getDataMemberValue("2070").toString());

        // Set a new value for a data member
        dataSingleton.setDataMemberValue("2070", new User("grey07", "John", "Grey"));

        // Print the updated data
        dataSingleton.print();

        // Clear all data
        dataSingleton.clear();

        // Print data after clearing
        dataSingleton.print();
    }
}