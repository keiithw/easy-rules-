package org.jeasy.rules.tutorials.demo;

import org.jeasy.rules.annotation.*;
@Rule(name = "Sunny rule", description = "Sometimes rains")
public class SunnyRule {

    @Condition
    public boolean isRainy(@Fact("rainy") String isRainy){
        return isRainy.equals("no");
    }

    @Action
    public void print(){
        System.out.println("it is sunny");
    }

    @Priority
    public int priority(){
        return 6;
    }
}


