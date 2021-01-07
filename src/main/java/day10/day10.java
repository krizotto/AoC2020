package day10;

import utils.Input;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class day10 {

    private static final String path = "src/main/resources/input_day10";
    public static final List<Integer> input = Input.getIntInput(path);

    public static void main(String[] args) {
        part1();
    }

    private static void part1() {
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
        System.out.println("Answer: " + (count.get(1) * count.get(3)));
    }
}
