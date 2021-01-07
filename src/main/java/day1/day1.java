package day1;

import utils.Input;

import java.util.Collections;
import java.util.List;

public class day1 {

    private static final String PATH = "src/main/resources/input_day1";

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part2() {
        System.out.println("------ PART 2 ------");
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
        System.out.println("Answer: " + answer);

    }

    private static void part1() {
        System.out.println("------ PART 1 ------");
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
            System.out.println("NO ANSWER!");
        } else {
            System.out.println("Answer: " + lowerAnswer * higherAnswer);
        }

    }
}
