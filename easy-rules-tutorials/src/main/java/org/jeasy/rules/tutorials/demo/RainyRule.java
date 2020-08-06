package org.jeasy.rules.tutorials.demo;

import org.jeasy.rules.annotation.*;

@Rule(name = "Rainy rule", description = "Sometimes rains")
public class RainyRule {
    private String person;

    public RainyRule(String person) {
        this.person = person;
    }

    @Condition
    public boolean isRainy(@Fact("rainy") String isRainy){
        return isRainy.equals("yes");
    }

    @Action
    public void drop(){
        Raindrop raindrop = new Raindrop("heavy raindrop");
        raindrop.dropOn(this.person);
    }

    @Priority
    public int priority(){
        return 1;
    }
}
