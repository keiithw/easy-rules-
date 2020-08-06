package org.jeasy.rules.tutorials.demo;

import org.jeasy.rules.annotation.*;

@Rule(name = "Take umbrella rule", description = "person is take umbrella")
public class TakeUmbrellaRule {
    private String person;

    @Condition
    public boolean isTakeUmbrella(@Fact("isTakeUmbrella") String isTakeUmbrella) {
        return isTakeUmbrella.equals("yes");
    }

    @Action
    public void print() {
        System.out.println(this.person + " takes umbrella. ");
    }

    @Priority
    public int priority() {
        return 3;
    }

    public TakeUmbrellaRule(String person) {
        this.person = person;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
