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
public class OrderPageTest {

    @Test
    public void orderPage() {
        MockedStatic<Main> mainMockedStatic = Mockito.mockStatic(Main.class);
        mainMockedStatic.when(Main::render).thenAnswer(invocationOnMock -> null);
        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(1);
        Main.newOrder = new Order(0);
        OrderPage.orderPage();

        Main.newOrder = new Order(0);
        Main.newOrder.addBeverage(new Beverage("Super"));
        OrderPage.orderPage();

        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(3);
        Main.newOrder = new Order(0);
        OrderPage.orderPage();

        mainMockedStatic.close();
    }
}