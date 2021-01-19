package com.krizotto.day03;

import com.krizotto.utils.Input;
import com.krizotto.utils.Solution;

import java.util.List;

public class day03 extends Solution {

    private static final int xMax = 31;
    private static final int yMax = 323;
    private final char[][] map = getMapFromInput();

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
        List<String> input = Input.getInput(path);

        char[][] tempMap = new char[xMax][yMax];

        int currentX;
        int currentY = 0;

        for (String s : input) {
            currentX = 0;
            final char[] line = s.toCharArray();
            for (char c : line) {
                tempMap[currentX][currentY] = c;
                currentX++;
            }
            currentY++;
        }
        return tempMap;
    }

    private int countTrees(int xSlope, int ySlope) {
        int currentX = 0;
        int currentY = 0;
        int countTrees = 0;

        while (currentY < yMax - ySlope) {
            currentX += xSlope;
            currentY += ySlope;
            if (currentX >= xMax) {
                currentX -= xMax;
            }
            if (map[currentX][currentY] == '#') {
                countTrees++;
            }
        }
        return countTrees;
    }

}
