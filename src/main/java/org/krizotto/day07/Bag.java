package org.krizotto.day07;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private static final String SHINY_GOLD = "shiny gold";
    private final List<String> contains = new ArrayList<>();
    private final List<Integer> quantities = new ArrayList<>();
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getContains() {
        return contains;
    }


    public List<Integer> getQuantities() {
        return quantities;
    }


    boolean containsOther() {
        return !this.contains.isEmpty();
    }

    boolean containsShinyGold() {
        return this.getContains().stream().anyMatch(s -> s.contains(SHINY_GOLD));
    }
}
