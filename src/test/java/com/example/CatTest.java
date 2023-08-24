package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;
    @Mock
    private Feline feline; //создали мок для объекта Feline
    //будет использоваться в тестах с зависимостями

    @Test
    public void getSoundTest() {
        cat = new Cat(new Feline());
        String actualSound = cat.getSound();
        String expectedSound = cat.getSound();
        Assert.assertEquals("кот должен мяукать", actualSound, expectedSound);
    }

    //этот тест проверяем через Mock
    // После вызова метода проверим, что метод-зависимость вызвался 1 раз
    @Test
    public void getFood() throws Exception {
        cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> listOfActualFood = cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        List<String> listOfExpectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(listOfExpectedFood, listOfActualFood);

    }
}