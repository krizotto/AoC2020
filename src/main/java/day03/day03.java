package day03;

import utils.Input;
import utils.Solution;

import java.util.List;

public class day03 extends Solution {

    public final int X_MAX = 31;
    public final int Y_MAX = 323;
    public final char[][] map = getMapFromInput();

    @Override
    public Object part1() {
        return countTrees(3, 1);
    }

    @Override
    public Object part2() {
        return countTrees(1, 1)
                * countTrees(3, 1)
                * countTrees(5, 1)
                * countTrees(7, 1)
                * countTrees(1, 2);
    }


    private char[][] getMapFromInput() {
        List<String> input = Input.getInput(PATH);

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

    private int countTrees(int xSlope, int ySlope) {
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

}
