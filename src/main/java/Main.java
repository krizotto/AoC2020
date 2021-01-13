import utils.Solution;

public class Main {

    public static final int MAX_SOLUTION_DAY = 3;

    public static void main(String[] args) throws Exception {

        for (int i = 1; i <= MAX_SOLUTION_DAY; i++) {
            final Solution solution = Solution.getSolution(i);
            System.out.println("\nDay " + i + " solutions!");
            System.out.println("\tPart 1: " + solution.part1());
            System.out.println("\tPart 2: " + solution.part2());
            System.out.print("\n");
        }

    }
}
