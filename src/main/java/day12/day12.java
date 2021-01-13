package day12;

import utils.Input;

import java.util.List;

public class day12 {
    private static final String path = "src/main/resources/input_day12";
    private static final List<String> input = Input.getInput(path, Input.NEW_LINE_DELIMITER);

    public static void main(String[] args) {

        part1();
        part2();
    }

    private static void part1() {
        System.out.println("------ PART 1 ------");
        Ship ship = new Ship();

        input.forEach(ship::processMovement);

        System.out.println(ship.getManhattanDistance());
    }

    private static void part2() {
        System.out.println("------ PART 2 ------");
        Ship newShip = new Ship();

        for (String s : input) {
            newShip.processMovement2(s);
        }

        System.out.println(newShip.getManhattanDistance());
    }
}
