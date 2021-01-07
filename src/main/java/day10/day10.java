package day10;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class day10 {
    public static final String path = "src/main/resources/input_day10";
    public static final List<Integer> input = getInput();

    public static void main(String[] args) {
        part1();
    }

    private static void part1() {
        List<Integer> count = Arrays.asList(0, 0, 0, 0);
        input.add(0);
        input.sort(Comparator.naturalOrder());
        for (int i = 0; i < input.size(); i++) {
            if (i == input.size() - 1) {
                count.set(3, count.get(3) + 1);
            } else {
                int diff = input.get(i + 1) - input.get(i);
                count.set(diff, count.get(diff) + 1);
            }
        }
        System.out.println("Answer: " + (count.get(1) * count.get(3)));
    }


    private static List<Integer> getInput() {
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
}
