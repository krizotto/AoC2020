package day3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class day3 {

    public static final int X_MAX = 31;
    public static final int Y_MAX = 323;
    public static final String path = "src/main/resources/input_day3";
    public static final char[][] map = getMapFromInput();

    public static void main(String[] args) {
        part1(map);
        part2(map);
    }

    private static void part1(char[][] map) {
        System.out.println("------ PART 1 ------");
        int countTrees = countTrees(3, 1);
        System.out.println("Answer: " + countTrees);
    }

    private static void part2(char[][] map) {
        System.out.println("------ PART 2 ------");
        int countTrees = countTrees(1, 1)
                * countTrees(3, 1)
                * countTrees(5, 1)
                * countTrees(7, 1)
                * countTrees(1, 2);
        System.out.println("Answer: " + countTrees);
    }


    private static char[][] getMapFromInput() {
        List<String> input = getInput(path);

        char[][] map = new char[X_MAX][Y_MAX];

        int currentX;
        int currentY = 0;

        for (String s : input) {
            currentX = 0;
            final char[] line = s.toCharArray();
            for (char c : line) {
                map[currentX][currentY] = c;
                currentX++;
            }
            currentY++;
        }
        return map;
    }

    private static int countTrees(int xSlope, int ySlope) {
        int currentX = 0;
        int currentY = 0;
        int countTrees = 0;

        while (currentY < Y_MAX - ySlope) {
            currentX += xSlope;
            currentY += ySlope;
            if (currentX >= X_MAX) {
                currentX -= X_MAX;
            }
            if (map[currentX][currentY] == '#') {
                countTrees++;
            }
        }
        return countTrees;
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
