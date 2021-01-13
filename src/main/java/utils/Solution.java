package utils;

public abstract class Solution {

    public static String PATH;
    public static String TEST_PATH;
    public static Solution getSolution(int day) throws Exception {

        PATH = String.format("src/main/resources/input_day%02d", day);
        TEST_PATH = String.format("src/main/resources/input_day%02d_test", day);

        return (Solution)Class.forName(String.format("day%02d.day%02d",
                day, day)).getConstructor().newInstance();
    }

    public abstract Object part1();

    public abstract Object part2();

}
