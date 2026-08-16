package com.factor_design_pattern.practice.simple_factory;


import java.util.Map;

// this is simple factory
// based on some logic we create object.
public class SimpleFactory {

    // The problem here as number of levels increases
    // we have add that conditon which is not scalable and easy to mantain
    // Here we are breaking OCP as well
    public IEnemy getEnemy(String level) {
        if (level.equals("LEVEL1")) {
            return new Goblin();
        } else if (level.equals("LEVEL2")) {
            return new SandMan();
        } else if (level.equals("LEVEL3")) {
            return new SnowMan();
        }
        return new Goblin();
    }

    // this similar way alternative to the above function
    public IEnemy getEnemyS(String level) {
        Map<String, IEnemy> map  = Map.of("LEVEL1", new Goblin(),"LEVEL2", new SandMan(),"LEVEL3", new SnowMan());
        return map.get(level);

    }
}
