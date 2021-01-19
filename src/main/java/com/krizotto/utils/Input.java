package com.krizotto.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Input {

    public static final String NEW_LINE_DELIMITER = "\n";
    public static final String EVERY_CHARACTER_DELIMITER = "";

    private Input() {

    }

    public static List<String> getCharInput(String path) {

        Path filePath = Paths.get(path);
        List<String> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(filePath).useDelimiter(EVERY_CHARACTER_DELIMITER)) {
            while (scanner.hasNext()) {
                final String next = scanner.next();
                if (!next.equals("\n")) {
                    input.add(next);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(input).orElse(Collections.emptyList());
    }

    public static List<Integer> getIntInput(String path, String delimiter) {
        Path filePath = Paths.get(path);
        List<Integer> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(filePath)) {
            if (delimiter != null) {
                scanner.useDelimiter(delimiter);
            }
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    input.add(scanner.nextInt());
                } else {
                    scanner.next();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(input).orElse(Collections.emptyList());
    }

    public static List<Integer> getIntInput(String path) {
        return getIntInput(path, null);
    }

    public static List<String> getLineInput(String path) { return getInput(path, NEW_LINE_DELIMITER);}

    public static List<String> getInput(String path) {
        return getInput(path, null);
    }

    public static List<String> getInput(String path, String delimiter) {
        Path filePath = Paths.get(path);
        List<String> input = new ArrayList<>();
        try (Scanner scanner = new Scanner(filePath)) {
            if (delimiter != null) {
                scanner.useDelimiter(delimiter);
            }
            while (scanner.hasNext()) {
                input.add(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(input).orElse(Collections.emptyList());
    }
}
