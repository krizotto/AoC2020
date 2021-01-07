package day9;

import utils.Input;

import java.util.Comparator;
import java.util.List;

public class day9 {

    public static final int preambleSize = 25;
    private static final String path = "src/main/resources/input_day9";
    public static final List<Integer> input = Input.getIntInput(path);
    public static int invalidNumber;

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part2() {
        System.out.println("------ PART 2 ------");
        int beginIndex, endIndex;
        for (int i = 0; i < input.size(); i++) {
            int sum = 0;
            for (int j = i; j < input.size(); j++) {
                sum += input.get(j);
                if (sum == invalidNumber) {
                    beginIndex = i;
                    endIndex = j;
                    List<Integer> subList = input.subList(beginIndex, endIndex + 1);
                    if (subList.size() > 1) {
                        int min = subList.stream().min(Comparator.naturalOrder()).get();
                        int max = subList.stream().max(Comparator.naturalOrder()).get();
                        System.out.println("Answer: " + (min + max));
                    }
                    break;
                } else if (sum > invalidNumber) {
                    break;
                }

            }

        }
    }

    private static void part1() {
        System.out.println("------ PART 1 ------");
        for (int i = preambleSize; i < input.size(); i++) {
            int result = input.get(i);
            if (!checkSums(i, result)) {
                invalidNumber = input.get(i);
                System.out.println("Answer: " + invalidNumber);
                break;
            }
        }
    }

    private static boolean checkSums(int i, int result) {
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
