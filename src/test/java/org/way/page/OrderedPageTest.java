package org.way.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.way.Main;
import org.way.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderedPageTest {

    @Test
    public void orderedPage() {
        MockedStatic<Main> mainMockedStatic = Mockito.mockStatic(Main.class);
        mainMockedStatic.when(Main::render).thenAnswer(invocationOnMock -> null);
        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(1);

        Main.openOrder = new Order(0);
        OrderedPage.orderedPage("0");
        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(2);
        Main.router.add("Router 1");
        Main.router.add("Router 2");
        Main.listOrders.add(Main.openOrder);
        OrderedPage.orderedPage("0");
        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(3);
        Main.router.add("Router 2");
        Main.openOrder = new Order(0);
        OrderedPage.orderedPage("0");
        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(1);
        OrderedPage.orderedPage("0");
        OrderedPage.orderedPage("0");
        OrderedPage.orderedPage("0");
        OrderedPage.orderedPage("0");
        Main.router.add("Router 2");
        Main.listOrders.add(Main.openOrder);
        OrderedPage.orderedPage("0");
        mainMockedStatic.close();
    }
}