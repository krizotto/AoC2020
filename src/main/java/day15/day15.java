package day15;

import utils.Input;
import utils.Solution;

import java.util.HashMap;
import java.util.List;

public class day15 extends Solution {
    private final List<Integer> input = Input.getIntInput(PATH, ",");

    @Override
    public Object part1() {
        return calculate(input, 2020);
    }

    @Override
    public Object part2() {
        return calculate(input, 30000000);
    }

    private static Integer calculate(List<Integer> numbers, int target) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (; i < numbers.size() - 1; i++) {
            map.put(numbers.get( i), i);
        }

        int n = numbers.get(i);
        for (; i < target - 1; i++) {
            final Integer prev = map.get(n);
            map.put(n, i);
            n = prev == null ? 0 : i - prev;
        }

        return n;
    }
}
