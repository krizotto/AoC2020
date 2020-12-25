package day8;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class day8 {
    public static final String path = "src/main/resources/input_day8";
    public static final List<String> input = getInput();

    public static void main(String[] args) {
        part1();
       // part2();
    }

    private static void part1() {
        CurrentPos curr = new CurrentPos();
        checkInfinite(curr);
        System.out.println(curr.getAcc());
    }

    private static boolean checkInfinite(CurrentPos curr) {
        Set<Integer> oldPos = new HashSet<>();
        while(true) {
            oldPos.add(curr.getPos());
            curr = processPos(curr);
            if (oldPos.contains(curr.getPos())) {
                return false;
            }
            if(curr.getPos() == input.size()) {
                return true;
            }
        }
    }

    private static void part2() {

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

    private static List<String> getInput() {
        Path filePath = Paths.get(path);
        List<String> input = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(filePath).useDelimiter("\n");
            while (scanner.hasNext()) {
                input.add(scanner.next());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.of(input).orElse(Collections.emptyList());
    }
}
