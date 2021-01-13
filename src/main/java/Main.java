import utils.Solution;

import java.util.Scanner;

public class Main {

    public static final int MAX_SOLUTION_DAY = 13;

    public static void main(String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Please enter the day to solve (1-%d, 0 to quit, 99 to solve all): ", MAX_SOLUTION_DAY);

            final int day = scanner.nextInt();
            if (day == 0) {
                break;
            }

            if (day == 99) {
                for (int i = 1; i <= MAX_SOLUTION_DAY; i++) {
                    getSolution(i);
                }
                break;
            }

            if (day > 0 && day < 26) {
                getSolution(day);
            }
        }

        System.out.println();
        System.out.println("Happy Holidays!");
        scanner.close();

    }

    private static void getSolution(int i) throws Exception {
        final Solution solution = Solution.getSolution(i);
        System.out.println("\nDay " + i + " solutions!");
        System.out.println("\tPart 1: " + solution.part1());
        System.out.println("\tPart 2: " + solution.part2());
        System.out.print("\n");
    }
}
