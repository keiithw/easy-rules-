package org.jeasy.rules.tutorials.demo;

import org.jeasy.rules.annotation.*;

@Rule(name = "umbrella die rule",description = "umbrella can not open")
public class UmbrellaDieRule {
    @Condition
    public boolean isUmbrellaDead(@Fact("umbrellaHealth") String umbrellaHealth){
        return !umbrellaHealth.equals("healthy");
    }
    @Action
    public void oops(){
        System.out.println("oops! but umbrella can not open, he gets wet!");
    }
    @Priority
    public int priority(){
        return 5;
    }
}
