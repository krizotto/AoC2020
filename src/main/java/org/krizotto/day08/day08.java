package org.krizotto.day08;

import org.krizotto.utils.Input;
import org.krizotto.utils.Solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day08 extends Solution {

    private static final List<String> input = Input.getInput(path, Input.NEW_LINE_DELIMITER);

    @Override
    public Object part1() {
        CurrentPos curr = new CurrentPos();
        checkNoLoop(curr);
        return curr.getAcc();

    }

    private boolean checkNoLoop(CurrentPos curr) {
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

    @Override
    public Object part2() {
        String[] split;

        for (int i = 0; i < input.size(); i++) {
            CurrentPos curr = new CurrentPos();
            split = input.get(i).split(" ");
            if (split[0].equals("nop")) {
                input.set(i, "jmp " + split[1]);
                if (checkNoLoop(curr)) {
                    return curr.getAcc();
                }
                input.set(i, "nop " + split[1]);
            } else if (split[0].equals("jmp")) {
                input.set(i, "nop " + split[1]);
                if (checkNoLoop(curr)) {
                    return curr.getAcc();
                }
                input.set(i, "jmp " + split[1]);
            }
        }
        return "something gone wrong...";
    }

    private CurrentPos processPos(CurrentPos curr) {
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
            default:
                System.out.println("unhandled...");
                break;
        }
        return curr;
    }
}
