package com.krizotto.day09;

import com.krizotto.utils.Input;
import com.krizotto.utils.Solution;

import java.util.Comparator;
import java.util.List;

public class day09 extends Solution {

    private static final int preambleSize = 25;
    private static final List<Integer> input = Input.getIntInput(path);
    private int invalidNumber;

    @Override
    public Object part2() {
        int beginIndex;
        int endIndex;
        for (int i = 0; i < input.size(); i++) {
            int sum = 0;
            for (int j = i; j < input.size(); j++) {
                sum += input.get(j);
                if (sum == invalidNumber) {
                    beginIndex = i;
                    endIndex = j;
                    List<Integer> subList = input.subList(beginIndex, endIndex + 1);
                    if (subList.size() > 1) {
                        int min = subList.stream().min(Comparator.naturalOrder()).orElseThrow();
                        int max = subList.stream().max(Comparator.naturalOrder()).orElseThrow();
                        return (min + max);
                    }
                    break;
                } else if (sum > invalidNumber) {
                    break;
                }

            }

        }
        return "....";
    }

    @Override
    public Object part1() {
        for (int i = preambleSize; i < input.size(); i++) {
            int result = input.get(i);
            if (!checkSums(i, result)) {
                invalidNumber = input.get(i);
                return invalidNumber;
            }
        }
        return "....";
    }

    private boolean checkSums(int i, int result) {
        List<Integer> preambleList = input.subList(i - preambleSize, i);
        for (int j = 0; j < preambleSize; j++) {
            for (int k = 0; k < preambleSize; k++) {
                if (k == j) {
                    continue;
                }
                if (preambleList.get(j) + preambleList.get(k) == result) {
                    return true;
                }
            }

        }
        return false;
    }
}
