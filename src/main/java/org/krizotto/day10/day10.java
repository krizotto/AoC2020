package org.krizotto.day10;

import org.krizotto.utils.Input;
import org.krizotto.utils.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class day10 extends Solution {

    private static final List<Integer> input = Input.getIntInput(path);

    @Override
    public Object part1() {
        List<Integer> count = Arrays.asList(0, 0, 0, 0);
        input.add(0);
        input.sort(Comparator.naturalOrder());
        for (int i = 0; i < input.size(); i++) {
            if (i == input.size() - 1) {
                count.set(3, count.get(3) + 1);
            } else {
                int diff = input.get(i + 1) - input.get(i);
                count.set(diff, count.get(diff) + 1);
            }
        }
        return count.get(1) * count.get(3);
    }

    @Override
    public Object part2() {
        return null;
    }
}
