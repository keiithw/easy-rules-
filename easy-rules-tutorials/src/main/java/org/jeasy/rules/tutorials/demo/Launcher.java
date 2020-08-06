package org.jeasy.rules.tutorials.demo;

import org.jeasy.rules.api.Fact;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.support.composite.ActivationRuleGroup;

public class Launcher {
    public static void main(String[] args) {
        String person = "tom";

        ActivationRuleGroup isUmbrellaGoodGroup = new ActivationRuleGroup("umbrella health group", "is umbrella Good",3);
        isUmbrellaGoodGroup.addRule(new UmbrellaHealthRule());
        isUmbrellaGoodGroup.addRule(new UmbrellaDieRule());

//        ActivationRuleGroup umbrellaTakenGroup = new ActivationRuleGroup("umbrella taken group", "is take umbrella?", 2);
//        umbrellaTakenGroup.addRule(new TakeUmbrellaRule(person));
//        umbrellaTakenGroup.addRule(new NoUmbrellaRule(person));

//        ActivationRuleGroup weatherGroup = new ActivationRuleGroup("weather group", "is rainy or sunny?", 1);
//        weatherGroup.addRule(new SunnyRule());
//        weatherGroup.addRule(new RainyRule(person));
//        Rules rules = new Rules();

        ActivationRuleGroup hasUmbrellaGroup = new ActivationRuleGroup("has umbrella group", "has umbrella");
        hasUmbrellaGroup.addRule(new TakeUmbrellaRule(person));
        hasUmbrellaGroup.addRule(isUmbrellaGoodGroup);

        ActivationRuleGroup umbrellaTakenGroup = new ActivationRuleGroup("umbrella taken group", "is take umbrella?");
        umbrellaTakenGroup.addRule(new NoUmbrellaRule(person));
        umbrellaTakenGroup.addRule(hasUmbrellaGroup);

        ActivationRuleGroup rainyGroup = new ActivationRuleGroup("rainy group", "is rainy ", 1);
        rainyGroup.addRule(new RainyRule(person));
        rainyGroup.addRule(umbrellaTakenGroup);

        Rules rules = new Rules();

        rules.register(rainyGroup,new SunnyRule());

        Facts facts = new Facts();
        Fact<String> isTakeUmbrella = new Fact<>("isTakeUmbrella","yes");
        Fact<String> isRainy = new Fact<>("rainy","no");
        Fact<String> umbrellaHealth = new Fact<>("umbrellaHealth","bad");
        facts.add(isTakeUmbrella);
        facts.add(isRainy);
        facts.add(umbrellaHealth);
        DefaultRulesEngine rulesEngine = new DefaultRulesEngine(new RulesEngineParameters());
        rulesEngine.fire(rules,facts);

    }
}
