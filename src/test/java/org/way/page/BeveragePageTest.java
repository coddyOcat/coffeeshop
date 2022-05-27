package org.way.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.way.Beverage;
import org.way.Main;
import org.way.Order;


@RunWith(MockitoJUnitRunner.class)
public class BeveragePageTest {

    @Test
    public void beveragePage() {
        Main.router.add("Router 1");
        Main.router.add("Router 2");
        Main.router.add("Router 3");
        Main.newOrder = new Order(0);
        Main.newBeverage = new Beverage("Super");
        MockedStatic<Main> mainMockedStatic = Mockito.mockStatic(Main.class);
        mainMockedStatic.when(Main::render).thenAnswer(invocationOnMock -> null);
        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(1);
        BeveragePage.beveragePage();
        BeveragePage.beveragePage();
        BeveragePage.beveragePage();
        BeveragePage.beveragePage();
        BeveragePage.beveragePage();
        BeveragePage.beveragePage();
        mainMockedStatic.close();
    }
}