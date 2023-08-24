package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline;//создали шпиона для объекта Feline
    //будет использоваться в тестах с зависимостями



    //этот тест проверяем через Mock
    // После вызова метода проверим, что метод-зависимость вызвался 1 раз с конкретным параметром
    @Test
    public void eatMeatSpy() throws Exception {
        List<String> listOfActualFood = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        List<String> listOfExpectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(listOfExpectedFood, listOfActualFood);
    }

    //отдельный тест для эксепшена
    @Test(expected = Exception.class)
    public void getFoodException() throws Exception {
        feline.getFood("Парнокопытное");
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        String expectedFamily = "Кошачьи";
        Assert.assertEquals(expectedFamily, actualFamily);
    }

    //этот тест проверяем через Spy. То есть он отработает как настоящий
    // После вызова метода проверим, что метод-зависимость вызвался 1 раз с конкретным параметром
    @Test
    public void getKittens() {
        int actualKittensCount = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        int expectedKittensCount = 1;
        Assert.assertEquals(actualKittensCount, expectedKittensCount);
    }

    @Test
    public void getKittensSpy() {
        feline = new Feline();
        int actualKittensCount = feline.getKittens(3);
        int expectedKittensCount = 3;
        Assert.assertEquals(actualKittensCount, expectedKittensCount);
    }

}