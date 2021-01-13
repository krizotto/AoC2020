package day13;

import utils.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day13 {
    private static final String path = "src/main/resources/input_day13";
    private static final List<String> input = Input.getInput(path, Input.NEW_LINE_DELIMITER);
    private static final List<Integer> availableBuses = new ArrayList<>();
    private static final int timestamp = Integer.parseInt(input.get(0));

    public static void main(String[] args) {
        //prepare busses
        final String[] busesList = input.get(1).split(",");
        for (String bus : busesList) {
            if (!bus.equals("x")) {
                availableBuses.add(Integer.valueOf(bus));
            } else {
                availableBuses.add(-1);
            }
        }

        part1();
        part2();
    }

    private static void part1() {
        System.out.println("------ PART 1 ------");
        int closestTimeToWait = Integer.MAX_VALUE;
        int closestBus = 0;
        for (Integer bus : availableBuses) {
            if (bus == -1) continue;
            int timeToWait = bus - timestamp % bus;
            if (timeToWait < closestTimeToWait) {
                closestTimeToWait = timeToWait;
                closestBus = bus;
            }
        }
        System.out.println(closestBus * closestTimeToWait);
    }

    private static void part2() {
        System.out.println("------ PART 2 ------");
        final List<Indexer> busses = new ArrayList<>();
        for (int i = 0; i < availableBuses.size(); i++) {
            if (availableBuses.get(i) != -1) {
                busses.add(new Indexer(i, availableBuses.get(i)));
            }
        }

        Collections.sort(busses);

        long time = busses.get(0).getValue();
        long increment = busses.get(0).getValue();
        for (int i = 1; i < busses.size(); i++) {
            Indexer indexer = busses.get(i);
            while ((time + indexer.getIndex()) % indexer.getValue() != 0) {
                time += increment;
            }
            increment *= indexer.getValue();
        }
        System.out.println(time);

    }

}
