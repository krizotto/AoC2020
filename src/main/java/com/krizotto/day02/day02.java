package com.krizotto.day02;

import com.krizotto.utils.Input;
import com.krizotto.utils.Solution;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class day02 extends Solution {

    @Override
    public Object part2() {
        List<String> input = Input.getInput(path);
        int totalCorrect = 0;

        for (int i = 2; i < input.size(); i += 3) {
            char checkedChar = input.get(i - 1).charAt(0);
            String[] split = input.get(i - 2).split("-");
            int firstPosition = Integer.parseInt(split[0]);
            int secondPosition = Integer.parseInt(split[1]);

            totalCorrect += validatePassword2(input.get(i), checkedChar, firstPosition - 1, secondPosition - 1);
        }
        return totalCorrect;

    }

    private int validatePassword2(String password, char checkedChar, int firstPosition, int secondPosition) {
        final char[] charPassword = password.toCharArray();
        boolean firstPresent = charPassword[firstPosition] == checkedChar;
        boolean secondPresent = charPassword[secondPosition] == checkedChar;
        if (firstPresent ^ secondPresent) {
            return 1;
        }
        return 0;
    }

    @Override
    public Object part1() {
        List<String> input = Input.getInput(path);
        int totalCorrect = 0;

        for (int i = 2; i < input.size(); i += 3) {
            char checkedChar = input.get(i - 1).charAt(0);
            String[] split = input.get(i - 2).split("-");
            int min = Integer.parseInt(split[0]);
            int max = Integer.parseInt(split[1]);

            totalCorrect += validatePassword1(input.get(i), checkedChar, min, max);
        }
        return totalCorrect;
    }

    private int validatePassword1(String password, char checkedChar, int min, int max) {
        final int count = StringUtils.countMatches(password, String.valueOf(checkedChar));
        if (count >= min && count <= max) {
            return 1;
        }
        return 0;
    }
}
