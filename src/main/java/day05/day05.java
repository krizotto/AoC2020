package day05;

import utils.Input;
import utils.Solution;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toSet;

public class day05 extends Solution {

    private static final List<BoardingPass> passes = new ArrayList<>();

    void prepare() {
        passes.clear();
        for (String s : Input.getInput(PATH)) {
            BoardingPass temp = new BoardingPass();
            temp.setCode(s);
            passes.add(temp);
        }
    }

    @Override
    public Object part2() {
        prepare();
        for (BoardingPass bp : passes) {
            findSeat(bp);
            countId(bp);
        }

        final Set<Integer> idsStream = passes.stream().map(BoardingPass::getId).collect(toSet());
        Integer minimum = Collections.min(idsStream);
        Integer maximum = Collections.max(idsStream);
        return IntStream.range(minimum, maximum)
                .boxed()
                .filter(not(idsStream::contains))
                .findAny()
                .orElseThrow();
    }


    @Override
    public Object part1() {
        prepare();
        for (BoardingPass bp : passes) {
            findSeat(bp);
            countId(bp);
        }

        return passes.stream().map(BoardingPass::getId).max(Comparator.naturalOrder()).orElse(-1);
    }

    public void countId(BoardingPass bp) {
        bp.setId(8 * bp.getRow() + bp.getColumn());
    }

    public void findSeat(BoardingPass bp) {
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
