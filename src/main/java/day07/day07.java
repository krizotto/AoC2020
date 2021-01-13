package day07;

import utils.Input;
import utils.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class day07 extends Solution {

    public static final String BAGS_CONTAIN_REGEX = "\\s?bags contain\\s?";
    public static final String BAGS_REGEX = "\\s?\\bbags?\\b([,.]?)\\s?";
    public static final List<String> input = Input.getInput(PATH, "\\.\n");
    public final List<Bag> rules = fillRules();
    private static final String SHINY_GOLD = "shiny gold";

    private List<Bag> fillRules() {
        List<Bag> rules = new ArrayList<>();
        for (String s : input) {
            Bag temp = new Bag();
            final String[] split = s.split(BAGS_CONTAIN_REGEX);
            final String[] bags = split[1].split(BAGS_REGEX);
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

    private int doesContainShinyGold(Bag rule) {
        if (!rule.containsOther() || rule.getColor().equals(SHINY_GOLD)) {
            return 0;
        } else if (rule.containsShinyGold()) {
            return 1;
        } else {
            int numberContains = 0;
            for (String contain : rule.getContains()) {
                numberContains += doesContainShinyGold(rules.stream().
                        filter(b -> b.getColor().equals(contain))
                        .findAny()
                        .orElseThrow());
            }
            return numberContains == 0 ? 0 : 1;
        }
    }

    private int getCapacity(Bag bag) {
        if (bag.getContains().size() == 0) {
            return 0;
        } else {
            int total = 0;
            for (int i = 0; i < bag.getContains().size(); i++) {
                final String contain = bag.getContains().get(i);
                final int quantity = bag.getQuantities().get(i);
                total += quantity * getCapacity(rules.stream()
                        .filter(b -> b.getColor().equals(contain))
                        .findAny()
                        .orElseThrow()) + quantity;
            }
            return total;
        }
    }

    @Override
    public Object part1() {
        int count = 0;
        for (Bag rule : rules) {
            count += doesContainShinyGold(rule);
        }
        return count;
    }

    @Override
    public Object part2() {
        final Optional<Bag> shinyGoldOptional = rules.stream()
                .filter(b -> b.getColor().equals(SHINY_GOLD))
                .findFirst();
        if (shinyGoldOptional.isPresent()) {
            return getCapacity(shinyGoldOptional.get());
        } else return "no answer....";
    }
}
