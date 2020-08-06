package org.jeasy.rules.tutorials.demo;

import org.jeasy.rules.annotation.*;

@Rule(name="Umbrella health rule", description = "umbrella die or not")
public class UmbrellaHealthRule {

    @Condition
    public boolean isUmbrellaGood(@Fact("umbrellaHealth") String umbrellaHealth){
        return umbrellaHealth.equals("healthy");
    }
    @Action
    public void open(){
        System.out.println("umbrella is open,he is fine and is not wet!");
    }
    @Priority
    public int priority(){
        return 4;
    }
}
