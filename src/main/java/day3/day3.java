package day3;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class day3 {

    public static final int X_MAX = 31;
    public static final int Y_MAX = 323;

    public static void main(String[] args) {
        char[][] map = getMapFromInput("src/main/resources/input_day3");

        part1(map);
        part2(map);
    }

    private static void part1(char[][] map) {
        System.out.println("------ PART 1 ------");
        int countTrees = getCountTrees(3, 1, map);
        System.out.println("Answer: " + countTrees);
    }

    private static void part2(char[][] map) {
        System.out.println("------ PART 2 ------");
        int countTrees = getCountTrees(1, 1, map) * getCountTrees(3, 1, map) * getCountTrees(5, 1, map) * getCountTrees(7, 1, map) * getCountTrees(1, 2, map);
        System.out.println("Answer: " + countTrees);
    }


    private static char[][] getMapFromInput(String path) {
        List<String> input = getInput(path);

        int xMax = input.get(0).length();
        int yMax = input.size();

        char[][] map = new char[xMax][yMax];

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

    private static int getCountTrees(int xSlope, int ySlope, char[][] map) {
        int currentX;
        int currentY;
        currentX = 0;
        currentY = 0;
        int countTrees = 0;
        while (currentY < Y_MAX - ySlope) {
            currentX += xSlope;
            currentY += ySlope;
            if (currentX >= X_MAX) {
                currentX -= X_MAX;
            }
            if (map[currentX][currentY] == '#') {
                countTrees += 1;
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
