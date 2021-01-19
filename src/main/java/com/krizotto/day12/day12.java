package com.krizotto.day12;

import com.krizotto.utils.Input;
import com.krizotto.utils.Solution;

import java.util.List;

public class day12 extends Solution {
    private static final List<String> input = Input.getLineInput(path);

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
