package day8;

import utils.Input;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day8 {

    private static final String path = "src/main/resources/input_day8";
    public static final List<String> input = Input.getInput(path, "\n");

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        System.out.println("------ PART 1 ------");
        CurrentPos curr = new CurrentPos();
        System.out.println("There is " + (checkNoLoop(curr) ? "no loop" : "a loop"));
        System.out.println("Answer: " + curr.getAcc());

    }

    private static boolean checkNoLoop(CurrentPos curr) {
        Set<Integer> oldPos = new HashSet<>();
        while (true) {
            oldPos.add(curr.getPos());
            if (curr.getPos() == input.size()) {
                return true;
            }
            curr = processPos(curr);
            if (oldPos.contains(curr.getPos())) {
                return false;
            }
        }
    }

    private static void part2() {
        System.out.println("------ PART 2 ------");
        String[] split;

        for (int i = 0; i < input.size(); i++) {
            CurrentPos curr = new CurrentPos();
            split = input.get(i).split(" ");
            if (split[0].equals("nop")) {
                input.set(i, "jmp " + split[1]);
                if (checkNoLoop(curr)) {
                    System.out.println("Answer: " + curr.getAcc());
                    break;
                }
                input.set(i, "nop " + split[1]);
            } else if (split[0].equals("jmp")) {
                input.set(i, "nop " + split[1]);
                if (checkNoLoop(curr)) {
                    System.out.println("Answer: " + curr.getAcc());
                    break;
                }
                input.set(i, "jmp " + split[1]);
            }
        }
    }

    private static CurrentPos processPos(CurrentPos curr) {
        final String[] action = input.get(curr.getPos()).split(" ");
        final int value = Integer.parseInt(action[1]);
        switch (action[0]) {
            case "nop":
                curr.setPos(curr.getPos() + 1);
                break;
            case "acc":
                curr.setAcc(curr.getAcc() + value);
                curr.setPos(curr.getPos() + 1);
                break;
            case "jmp":
                curr.setPos(curr.getPos() + value);
                break;
        }
        return curr;
    }
}
