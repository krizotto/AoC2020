package org.krizotto.day12;

import org.krizotto.utils.Input;
import org.krizotto.utils.Solution;

import java.util.List;

public class day12 extends Solution {
    private static final List<String> input = Input.getInput(path, Input.NEW_LINE_DELIMITER);

    @Override
    public Object part1() {
        Ship ship = new Ship();

        input.forEach(ship::processMovement);

        return ship.getManhattanDistance();
    }

    @Override
    public Object part2() {
        Ship newShip = new Ship();

        input.forEach(newShip::processMovement2);

        return newShip.getManhattanDistance();
    }
}
