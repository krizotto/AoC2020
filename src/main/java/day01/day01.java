package day01;

import utils.Input;
import utils.Solution;

import java.util.Collections;
import java.util.List;

public class day01 extends Solution {

    @Override
    public Object part2() {
        List<Integer> input = Input.getIntInput(PATH);
        int answer = -1;

        for (Integer first : input) {
            for (Integer second : input) {
                Integer third = 2020 - first - second;
                if (input.contains(third)) {
                    answer = first * second * third;
                }
            }
        }
        return answer;
    }

    @Override
    public Object part1() {
        int lowerAnswer = -1;
        int higherAnswer = -1;
        List<Integer> input = Input.getIntInput(PATH);
        Collections.sort(input);

        int bottom = 0;
        int top = input.size() - 1;

        while (bottom < input.size() && top > 0) {
            int lower = input.get(bottom);
            int higher = input.get(top);
            int sum = lower + higher;

            if (sum == 2020) {
                lowerAnswer = lower;
                higherAnswer = higher;
                break;
            } else if (sum > 2020) {
                top--;
            } else {
                bottom++;
            }
        }
        if (lowerAnswer < 0 || higherAnswer < 0) {
            return "NO ANSWER!";
        } else {
           return (lowerAnswer * higherAnswer);
        }

    }
}
