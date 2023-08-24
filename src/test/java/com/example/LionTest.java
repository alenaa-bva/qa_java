package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline; //создали мок для объекта Feline
    //будет использоваться в тестах с зависимостями

    //этот тест проверяем через Mock
    // После вызова метода проверим, что метод-зависимость вызвался 1 раз
    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualCount = lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        int expectedCount = 1;
        Assert.assertEquals(actualCount, expectedCount);
    }

    //отдельный тест для эксепшена
    @Test(expected = Exception.class)
    public void lionException() throws Exception {
        Lion lion = new Lion("не определен", feline);
    }

    //этот тест проверяем через Mock
    // После вызова метода проверим, что метод-зависимость вызвался 1 раз с конкретным параметром
    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> listOfActualFood = lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        List<String>  listOfExpectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(listOfActualFood, listOfExpectedFood);
    }
}