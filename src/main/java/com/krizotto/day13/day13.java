package com.krizotto.day13;

import com.krizotto.utils.Input;
import com.krizotto.utils.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day13 extends Solution {
    private final List<String> input = Input.getLineInput(path);
    private final List<Integer> availableBuses = new ArrayList<>();
    private final int timestamp = Integer.parseInt(input.get(0));

    public void prepareBusses() {
        final String[] busesList = input.get(1).split(",");
        for (String bus : busesList) {
            if (!bus.equals("x")) {
                availableBuses.add(Integer.valueOf(bus));
            } else {
                availableBuses.add(-1);
            }
        }
    }

    @Override
    public Object part1() {
        prepareBusses();
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
        return closestBus * closestTimeToWait;
    }

    @Override
    public Object part2() {
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
        return time;
    }
}
