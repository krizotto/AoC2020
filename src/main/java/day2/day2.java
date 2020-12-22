package day2;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class day2 {
    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part2() {
        System.out.println("------ PART 2 ------");
        List<String> input = getInput("src/main/resources/input_day2");
        int totalCorrect = 0;

        for (int i = 2; i < input.size(); i += 3) {
            char checkedChar = input.get(i - 1).charAt(0);
            String[] split = input.get(i - 2).split("-");
            int firstPosition = Integer.parseInt(split[0]);
            int secondPosition = Integer.parseInt(split[1]);

            totalCorrect += validatePassword2(input.get(i), checkedChar, firstPosition - 1, secondPosition - 1);
        }
        System.out.println("Answer: " + totalCorrect);

    }

    private static int validatePassword2(String password, char checkedChar, int firstPosition, int secondPosition) {
        final char[] charPassword = password.toCharArray();
        boolean firstPresent = charPassword[firstPosition] == checkedChar;
        boolean secondPresent = charPassword[secondPosition] == checkedChar;
        if (firstPresent ^ secondPresent) {
            return 1;
        }
        return 0;
    }

    private static void part1() {
        System.out.println("------ PART 1 ------");
        List<String> input = getInput("src/main/resources/input_day2");
        int totalCorrect = 0;

        for (int i = 2; i < input.size(); i += 3) {
            char checkedChar = input.get(i - 1).charAt(0);
            String[] split = input.get(i - 2).split("-");
            int min = Integer.parseInt(split[0]);
            int max = Integer.parseInt(split[1]);

            totalCorrect += validatePassword1(input.get(i), checkedChar, min, max);
        }
        System.out.println("Answer: " + totalCorrect);
    }

    private static int validatePassword1(String password, char checkedChar, int min, int max) {
        final int count = StringUtils.countMatches(password, String.valueOf(checkedChar));
        if (count >= min && count <= max) {
            return 1;
        }
        return 0;
    }

    public static List<String> getInput(String path) {
        Path filePath = Paths.get(path);
        List<String> input = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(filePath);
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
