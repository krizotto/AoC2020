package day06;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private final List<Character> answers = new ArrayList<>();
    private Set<Character> distinctAnswers = new LinkedHashSet<>();
    private Set<Character> commonAnswers = new LinkedHashSet<>();
    private int count;
    private int numberOfPeople;

    public List<Character> getAnswers() {
        return answers;
    }

    public Set<Character> getDistinctAnswers() {
        return distinctAnswers;
    }

    public void setDistinctAnswers(Set<Character> distinctAnswers) {
        this.distinctAnswers = distinctAnswers;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Set<Character> getCommonAnswers() {
        return commonAnswers;
    }

    public void setCommonAnswers(Set<Character> commonAnswers) {
        this.commonAnswers = commonAnswers;
    }
}
