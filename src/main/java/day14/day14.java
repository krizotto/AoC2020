package day14;

import utils.Input;
import utils.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class day14 extends Solution {

    private final List<String> input = Input.getInput(path, Input.NEW_LINE_DELIMITER);

    @Override
    public Object part1() {
        final HashMap<Long, Long> memory = new HashMap<>();
        char[] mask = new char[36];
        for (Object op : getOperations()) {
            if (op instanceof char[]) {
                mask = (char[]) op;
            } else {
                final long[] kv = (long[]) op;
                memory.put(kv[0], applyMask(kv[1], mask));
            }
        }

        return memory.values().stream().reduce(Long::sum).orElseThrow();
    }

    @Override
    public Object part2() {
        final HashMap<Long, Long> memory = new HashMap<>();
        char[] mask = new char[36];
        for (Object op : getOperations()) {
            if (op instanceof char[]) {
                mask = (char[]) op;
            } else {
                final long[] kv = (long[]) op;
                for (long addr : applyAddressMask(kv[0], mask)) {
                    memory.put(addr, kv[1]);
                }
            }
        }

        return memory.values().stream().reduce(Long::sum).orElseThrow();
    }

    private Object[] getOperations() {
        final Object[] operations = new Object[input.size()];
        for (int i = 0; i < input.size(); i++) {
            final String line = input.get(i);
            if (line.charAt(1) == 'a') {
                operations[i] = line.substring(line.lastIndexOf(' ') + 1).toCharArray();
            } else {
                final long k = Long.parseLong(line.substring(line.lastIndexOf('[') + 1, line.lastIndexOf(']')));
                final long v = Long.parseLong(line.substring(line.lastIndexOf(' ') + 1));
                operations[i] = new long[]{k, v};
            }
        }
        return operations;
    }

    private static long applyMask(long n, char[] mask) {
        for (int i = 0; i < mask.length; i++) {
            final long bit = 1L << (mask.length - i - 1);
            if (mask[i] == '1') {
                n |= bit;
            } else if (mask[i] == '0') {
                n &= ~bit;
            }
        }

        return n;
    }

    private static List<Long> applyAddressMask(long addr, char[] mask) {
        List<Long> addrs = new ArrayList<>();
        addrs.add(addr);
        for (int i = 0; i < mask.length; i++) {
            final long bit = 1L << (mask.length - i - 1);
            if (mask[i] != '0') {
                addrs = addrs.stream().map(a -> a | bit).collect(Collectors.toList());

                if (mask[i] == 'X') {
                    addrs.addAll(addrs.stream().map(a -> a & ~bit).collect(Collectors.toList()));
                }
            }
        }

        return addrs.stream().distinct().collect(Collectors.toList());
    }


}
