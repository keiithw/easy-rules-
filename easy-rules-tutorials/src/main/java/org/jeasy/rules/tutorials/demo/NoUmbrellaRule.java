package org.jeasy.rules.tutorials.demo;

import org.jeasy.rules.annotation.*;

@Rule(name="No umbrella rule", description = "person does not take umbrella")
public class NoUmbrellaRule {
    private String person;

    @Condition
    public boolean isTakeUmbrella(@Fact("isTakeUmbrella") String isTakeUmbrella){
        return isTakeUmbrella.equals("no");
    }
    @Action
    public void print(){
        System.out.println(this.person+" get wet");
    }
    @Priority
    public int priority(){
        return 2;
    }

    public NoUmbrellaRule(String person) {
        this.person = person;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
