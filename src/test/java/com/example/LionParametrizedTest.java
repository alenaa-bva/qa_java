package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private final String sex;
    private final Boolean doesHaveMane;

    public LionParametrizedTest(String sex, Boolean doesHaveMane){
        this.sex = sex;
        this.doesHaveMane = doesHaveMane;
    }

    @Parameterized.Parameters
            public static Object[][] getData(){
                    return new Object[][]{
                            {"Самец", true},
                            {"Самка", false},
                    };
    }

    Lion lion;
    Feline feline;

    @Test
    public void doesHaveMane() throws Exception {
        lion = new Lion(sex, feline);
        //передали в первом прогоне{"Самец", true}
        // передали во втором прогоне{"Самка", false}

        Boolean actualDoesHaveMane = lion.doesHaveMane();
        //при вызове метода возвращается значение переменной lion.hasMane
        //в первом прогоне lion.hasMane = true
        //в первом прогоне lion.hasMane = false

        Assert.assertEquals(doesHaveMane, actualDoesHaveMane);
    }
}