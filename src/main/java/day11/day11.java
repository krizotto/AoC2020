package day11;

import utils.Input;
import utils.Solution;

import java.util.ArrayList;
import java.util.List;

public class day11 extends Solution {

    public final int colsCount = 98;
    public final int rowsCount = 93;
    public final String OCCUPIED = "#";
    public final String EMPTY = "L";
    public final List<String> input = Input.getCharInput(PATH);
    public List<String> copyOfState;

    @Override
    public Object part1() {
        boolean stateChanged;
        copyOfState = new ArrayList<>(input);
        do {
            // printTable();
            stateChanged = false;
            for (int r = 0; r < rowsCount; r++) {
                for (int c = 0; c < colsCount; c++) {
                    String s = checkInput(r, c);
                    final int occupiedSeats = countAdjacentOccupiedSeats(r, c);
                    if (s.equals(EMPTY)) {
                        if (occupiedSeats == 0) {
                            setInput(r, c, OCCUPIED);
                            stateChanged = true;
                        }
                    } else if (s.equals(OCCUPIED)) {
                        if (occupiedSeats >= 4) {
                            setInput(r, c, EMPTY);
                            stateChanged = true;
                        }
                    }
                }
            }
            input.clear();
            input.addAll(copyOfState);
        } while (stateChanged);

        return countOccupiedSeats();
    }

    @Override
    public Object part2() {
        boolean stateChanged;
        input.clear();
        input.addAll(Input.getCharInput(PATH));
        copyOfState = new ArrayList<>(input);
        do {
            // printTable();
            stateChanged = false;
            for (int r = 0; r < rowsCount; r++) {
                for (int c = 0; c < colsCount; c++) {
                    String s = checkInput(r, c);
                    final int occupiedSeats = countDimensionsOccupiedSeats(r, c);
                    if (s.equals(EMPTY)) {
                        if (occupiedSeats == 0) {
                            setInput(r, c, OCCUPIED);
                            stateChanged = true;
                        }
                    } else if (s.equals(OCCUPIED)) {
                        if (occupiedSeats >= 5) {
                            setInput(r, c, EMPTY);
                            stateChanged = true;
                        }
                    }
                }
            }
            input.clear();
            input.addAll(copyOfState);
        } while (stateChanged);

        return countOccupiedSeats();
    }


    private void printTable() {
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < colsCount; j++) {
                System.out.print(checkInput(i, j));
            }
            System.out.print("\n");
        }
        System.out.print("\n-----\n");
    }

    private void setInput(int row, int column, String state) {
        if (row >= 0 && row < rowsCount && column >= 0 && column < colsCount) {
            copyOfState.set(row * colsCount + column, state);
        }
    }

    private String checkInput(int row, int column) {
        if (row < 0 || row >= rowsCount || column < 0 || column >= colsCount) {
            return "";
        }
        return input.get(row * colsCount + column);
    }

    private int countOccupiedSeats() {
        int counter = 0;
        for (String s : input) {
            if (s.equals(OCCUPIED)) {
                counter++;
            }
        }
        return counter;
    }

    private int countDimensionsOccupiedSeats(int row, int column) {
        int count = 0;
        int LEFT = -1;
        int RIGHT = 1;
        int UP = -1;
        int MIDDLE = 0;
        int DOWN = 1;

        count += checkDimension(LEFT, UP, row, column);
        count += checkDimension(MIDDLE, UP, row, column);
        count += checkDimension(RIGHT, UP, row, column);
        count += checkDimension(LEFT, MIDDLE, row, column);
        count += checkDimension(RIGHT, MIDDLE, row, column);
        count += checkDimension(LEFT, DOWN, row, column);
        count += checkDimension(MIDDLE, DOWN, row, column);
        count += checkDimension(RIGHT, DOWN, row, column);

        return count;

    }

    private int checkDimension(int vertical, int horizontal, int row, int column) {
        int currRow = row + horizontal;
        int currCol = column + vertical;
        if (currRow < 0 || currRow >= rowsCount || currCol < 0 || currCol >= colsCount || checkInput(currRow, currCol).equals(EMPTY)) {
            return 0;
        } else if (checkInput(currRow, currCol).equals(OCCUPIED)) {
            return 1;
        } else {
            return checkDimension(vertical, horizontal, currRow, currCol);
        }

    }


    private int countAdjacentOccupiedSeats(int row, int column) {
        int count = 0;
        int currentRow = row - 1;
        int currentCol = column - 1;

        //upper row
        count += checkCurrent(currentRow, currentCol);
        currentCol += 1;

        count += checkCurrent(currentRow, currentCol);
        currentCol += 1;

        count += checkCurrent(currentRow, currentCol);
        currentCol -= 2;
        currentRow += 1;

        //current row
        count += checkCurrent(currentRow, currentCol);
        currentCol += 2;

        count += checkCurrent(currentRow, currentCol);

        currentCol -= 2;
        currentRow += 1;

        //lower row
        count += checkCurrent(currentRow, currentCol);
        currentCol += 1;

        count += checkCurrent(currentRow, currentCol);
        currentCol += 1;

        count += checkCurrent(currentRow, currentCol);

        return count;
    }

    private int checkCurrent(int currentRow, int currentCol) {
        return checkInput(currentRow, currentCol).equals(OCCUPIED) ? 1 : 0;
    }
}
