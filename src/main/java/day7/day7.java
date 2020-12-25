package day7;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class day7 {
    public static final String path = "src/main/resources/input_day7";
    public static final List<String> input = getInput();

    public static final List<Bag> rules = fillRules();
    private static final String SHINY_GOLD = "shiny gold";

    public static void main(String[] args) {
        part1();
        part2();
    }

    private static void part1() {
        int count = 0;
        for (Bag rule : rules) {
            count += doesContainShinyGold(rule);
        }
        System.out.println(count);
    }

    private static int doesContainShinyGold(Bag rule) {
        if (!rule.containsOther() || rule.getColor().equals(SHINY_GOLD)) {
            return 0;
        } else if (rule.containsShinyGold()) {
            return 1;
        } else {
            int numberContains = 0;
            for (String contain : rule.getContains()) {
                numberContains += doesContainShinyGold(rules.stream().filter(b -> b.getColor().equals(contain)).findAny().orElseThrow());
            }
            return numberContains == 0 ? 0 : 1;
        }

    }

    private static List<Bag> fillRules() {
        List<Bag> rules = new ArrayList<>();
        for (String s : input) {
            Bag temp = new Bag();
            final String[] split = s.split("\\s?bags contain\\s?");
            final String[] bags = split[1].split("\\s?\\bbags?\\b([,.]?)\\s?");
            temp.setColor(split[0]);
            for (String bag : bags) {
                if (bag.charAt(0) == 'n') {
                    break;
                }
                int quantity = Integer.parseInt(String.valueOf(bag.charAt(0)));
                String color = bag.substring(2);
                temp.getQuantities().add(quantity);
                temp.getContains().add(color);
            }
            rules.add(temp);
        }

        return rules;
    }

    private static void part2() {
    }

    private static List<String> getInput() {
        Path filePath = Paths.get(path);
        List<String> input = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(filePath).useDelimiter("\\.\n");
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
