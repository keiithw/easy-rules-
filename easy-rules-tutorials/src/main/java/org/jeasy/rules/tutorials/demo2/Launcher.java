package org.jeasy.rules.tutorials.demo2;

import org.jeasy.rules.api.*;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;

public class Launcher {
    public static void main(String[] args) {
        Rule rainyRule = new RuleBuilder()
                .name("rainy rule")
                .description("if it rains then if person take umbrella?")
                .when(facts -> facts.get("rainy").equals("yes"))
                .then(facts -> System.out.println("it rains ..."))
                .priority(1)
                .build();

        Rule noUmbrellaRule = new RuleBuilder()
                .name("no umbrella rule")
                .description("person does not take umbrella")
                .when(facts -> facts.get("rainy").equals("yes") && facts.get("takeUmbrella").equals("no"))
                .then(facts -> System.out.println("and person dose not take umbrella. he gets wet."))
                .priority(3)
                .build();

        Rule hasGoodUmbrellaRule = new RuleBuilder()
                .name("has healthy umbrella rule")
                .description("person takes a good umbrella")
                .when(facts -> facts.get("rainy").equals("yes") && facts.get("takeUmbrella").equals("yes") && facts.get("umbrellaHeath").equals("yes"))
                .then(facts -> System.out.println("and person takes a good umbrella. he does not get wet."))
                .priority(4)
                .build();

        Rule hasBadUmbrellaRule = new RuleBuilder()
                .name("has bad umbrella rule")
                .description("person takes a bad umbrella")
                .when(facts -> facts.get("rainy").equals("yes") && facts.get("takeUmbrella").equals("yes") && facts.get("umbrellaHeath").equals("no"))
                .then(facts -> System.out.println("and person takes a bad umbrella. he still gets wet."))
                .priority(5)
                .build();

        Rule sunnyRule = new RuleBuilder()
                .name("sunny rule")
                .description("it is sunny,everything is good")
                .when(facts -> facts.get("rainy").equals("no"))
                .then(facts -> System.out.println("sunshine is beautiful ..."))
                .priority(2)
                .build();

        Rules rules = new Rules(rainyRule,noUmbrellaRule,hasBadUmbrellaRule,hasGoodUmbrellaRule,sunnyRule);
        Facts facts = new Facts();
        Fact<String> weatherFact = new Fact<>("rainy", "no");
        Fact<String> hasUmbrellaFact = new Fact<>("takeUmbrella", "yes");
        Fact<String> umbrellaHeath = new Fact<>("umbrellaHeath", "yes");
        facts.add(weatherFact);
        facts.add(hasUmbrellaFact);
        facts.add(umbrellaHeath);

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules,facts);
    }
}
