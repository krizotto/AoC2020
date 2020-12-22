package day1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class day1 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part2() {
        System.out.println("------ PART 2 ------");
        List<Integer> input = getInput();
        int answer = -1;

        for (Integer first : input) {
            for (Integer second : input) {
                Integer third = 2020 - first - second;
                if (input.contains(third)) {
                    answer = first * second * third;
                }
            }
        }
        System.out.println("Answer: " + answer);

    }

    private static void part1() {
        System.out.println("------ PART 1 ------");
        int lowerAnswer = -1;
        int higherAnswer = -1;
        List<Integer> input = getInput();
        Collections.sort(input);

        int bottom = 0;
        int top = input.size() - 1;

        while (bottom < input.size() && top > 0) {
            int lower = input.get(bottom);
            int higher = input.get(top);
            int sum = lower + higher;

            if (sum == 2020) {
                lowerAnswer = lower;
                higherAnswer = higher;
                break;
            } else if (sum > 2020) {
                top--;
            } else {
                bottom++;
            }
        }
        if (lowerAnswer < 0 || higherAnswer < 0) {
            System.out.println("NO ANSWER!");
        } else {
            System.out.println("Answer: " + lowerAnswer * higherAnswer);
        }

    }

    private static List<Integer> getInput() {
        Path filePath = Paths.get("src/main/resources/input_day1");
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
