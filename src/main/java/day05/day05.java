package day05;

import utils.Input;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toSet;

public class day05 {

    private static final String path = "src/main/resources/input_day05";
    private static final List<BoardingPass> passes = new ArrayList<>();

    public static void main(String[] args) {
        for (String s : Input.getInput(path)) {
            BoardingPass temp = new BoardingPass();
            temp.setCode(s);
            passes.add(temp);
        }

        part1();
        part2();
    }

    private static void part2() {
        System.out.println("------ PART 2 ------");
        for (BoardingPass bp : passes) {
            findSeat(bp);
            countId(bp);
        }

        final Set<Integer> idsStream = passes.stream().map(BoardingPass::getId).collect(toSet());
        Integer minimum = Collections.min(idsStream);
        Integer maximum = Collections.max(idsStream);
        final Integer answer = IntStream.range(minimum, maximum)
                .boxed()
                .filter(not(idsStream::contains))
                .findAny()
                .orElseThrow();
        System.out.println("Answer: " + answer);


    }


    private static void part1() {
        System.out.println("------ PART 1 ------");
        for (BoardingPass bp : passes) {
            findSeat(bp);
            countId(bp);
        }

        final Integer max = passes.stream().map(BoardingPass::getId).max(Comparator.naturalOrder()).orElse(-1);
        System.out.println("Answer: " + max);

    }

    public static void countId(BoardingPass bp) {
        bp.setId(8 * bp.getRow() + bp.getColumn());
    }

    public static void findSeat(BoardingPass bp) {
        int lowerRow = 0;
        int upperRow = 127;
        int lowerColumn = 0;
        int upperColumn = 7;
        final char[] chars = bp.getCode().toCharArray();
        for (char c : chars) {
            if (c == 'F') {
                if (upperRow - lowerRow == 1) {
                    bp.setRow(lowerRow);
                } else {
                    upperRow = (lowerRow + upperRow) / 2;
                }
            }
            if (c == 'B') {
                if (upperRow - lowerRow == 1) {
                    bp.setRow(upperRow);
                } else {
                    lowerRow = (lowerRow + upperRow) / 2 + (lowerRow + upperRow) % 2;
                }
            }
            if (c == 'L') {
                if (upperColumn - lowerColumn == 1) {
                    bp.setColumn(lowerColumn);
                } else {
                    upperColumn = (lowerColumn + upperColumn) / 2;
                }
            }
            if (c == 'R') {
                if (upperColumn - lowerColumn == 1) {
                    bp.setColumn(upperColumn);
                } else {
                    lowerColumn = (lowerColumn + upperColumn) / 2 + (lowerColumn + upperColumn) % 2;
                }
            }

        }
    }
}
