package org.jeasy.rules.tutorials.demo;

public class Raindrop {
    private String water;

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public Raindrop(String water) {
        this.water = water;
    }

    public void dropOn(String person){
        System.out.println(water + " drop on " + person);
    }
}
