import org.krizotto.utils.Solution;

import java.util.Scanner;

public class Main {

    public static final int MAX_SOLUTION_DAY = 15;

    public static void main(String[] args) throws Exception {

        final Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter the day to solve (1-%d, 0 to quit, 99 to solve all): ", MAX_SOLUTION_DAY);

        final int day = scanner.nextInt();
        double totalTime = 0;

        if (day == 99) {
            for (int i = 1; i <= MAX_SOLUTION_DAY; i++) {
                long startTime = System.nanoTime();
                getSolution(i);
                long stopTime = System.nanoTime();
                final double execTime = ((double) stopTime - (double) startTime) / 1000000;
                totalTime += execTime;
                System.out.printf("Execution time: %.2f ms.%n", execTime);
            }
            System.out.printf("***********%nTotal execution time: %.3f s.", totalTime/1000);
        }

        if (day > 0 && day < 26) {
            getSolution(day);
        }

        //performance test
        if (day == 98) {
            for (int i = 1; i <= MAX_SOLUTION_DAY; i++) {
                System.out.printf("Day %d:", i);
                long startTime = System.nanoTime();
                int precision = 1000;
                if (i == 7) {
                    precision = 10;
                }
                for (int j = 0; j < precision; j++) {
                    getNoSolution(i);
                }
                long stopTime = System.nanoTime();
                double result = ((double) stopTime - (double) startTime) / (100000 * precision);
                System.out.printf(" %.2f ms%n", result);
            }
        }

        System.out.println();
        System.out.println("Happy Holidays!");
        scanner.close();

    }

    private static void getNoSolution(int i) throws Exception {
        final Solution solution = Solution.getSolution(i);
        solution.part1();
        solution.part2();
    }

    private static void getSolution(int i) throws Exception {
        final Solution solution = Solution.getSolution(i);
        System.out.println("\nDay " + i + " solutions!");
        System.out.println("\tPart 1: " + solution.part1());
        System.out.println("\tPart 2: " + solution.part2());
        System.out.print("\n");
    }
}
