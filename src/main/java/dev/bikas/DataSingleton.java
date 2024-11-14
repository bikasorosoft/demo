package dev.bikas;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DataSingleton {

    private static class LazyHolder {
        private static final DataSingleton INSTANCE = new DataSingleton();
    }

    public static DataSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private final Map<String, User> employees = new ConcurrentHashMap<>();

    private DataSingleton() {}

    public void populate(Path path) throws IOException {
        final CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();
        try (Reader reader = Files.newBufferedReader(path)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build()) {
                List<String[]> data = csvReader.readAll();
                this.employees.putAll(toUser(data));
            } catch (CsvException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public User getDataMemberValue(String key) {
        return employees.get(key);
    }

    public void setDataMemberValue(String key, User value) {
        employees.put(key, value);
    }

    public void clear() {
        employees.clear();
    }

    public void print() {
        System.out.println("-------------------------start-------------------------");
        if (this.employees.isEmpty()) {
            System.out.println("I am empty");
        }
        for(Map.Entry<String, User> user : this.employees.entrySet()) {
            System.out.printf("Id: %s\t" +
                    "User: %s\n", user.getKey(), user.getValue().toString());
        }
        System.out.println("-------------------------end-------------------------");
    }

    private User toUser(String[] values) {
        return new User(values[0], values[2], values[3]);
    }

    private Map<String, User> toUser(List<String[]> data) {
        return data.stream().filter(item -> item.length>3)
                .collect(Collectors.toMap(item-> item[1], this::toUser));
    }
}

