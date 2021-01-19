package com.krizotto.utils;

public abstract class Solution {

    protected static String path;
    protected static String testPath;

    public static Solution getSolution(int day) throws Exception {

        path = String.format("src/main/resources/input_day%02d", day);
        testPath = String.format("src/main/resources/input_day%02d_test", day);

        return (Solution) Class.forName(String.format("com.krizotto.day%02d.day%02d", day, day)).getConstructor().newInstance();
    }

    public abstract Object part1();

    public abstract Object part2();

}
