package utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Input {

    public static final String NEW_LINE_DELIMITER = "\n";
    public static final String EVERY_CHARACTER_DELIMITER = "";

    public static List<String> getCharInput(String path) {

        Path filePath = Paths.get(path);
        List<String> input = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(filePath).useDelimiter(EVERY_CHARACTER_DELIMITER);
            while (scanner.hasNext()) {
                final String next = scanner.next();
                if (!next.equals("\n")) {
                    input.add(next);
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(input).orElse(Collections.emptyList());
    }

    public static List<Integer> getIntInput(String path) {
        Path filePath = Paths.get(path);
        List<Integer> input = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(filePath);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    input.add(scanner.nextInt());
                } else {
                    scanner.next();
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(input).orElse(Collections.emptyList());
    }

    public static List<String> getInput(String path) {
        return getInput(path, null);
    }

    public static List<String> getInput(String path, String delimiter) {
        Path filePath = Paths.get(path);
        List<String> input = new ArrayList<>();
        Scanner scanner;
        try {
            if (delimiter == null) {
                scanner = new Scanner(filePath);
            } else {
                scanner = new Scanner(filePath).useDelimiter(delimiter);
            }
            while (scanner.hasNext()) {
                input.add(scanner.next());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(input).orElse(Collections.emptyList());
    }
}
