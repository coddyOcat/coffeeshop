package org.way.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.way.Main;
import org.way.Order;

@RunWith(MockitoJUnitRunner.class)
public class ListOrdersPageTest {

    @Test
    public void listOrdersPage() {
        MockedStatic<Main> mainMockedStatic = Mockito.mockStatic(Main.class);
        mainMockedStatic.when(Main::render).thenAnswer(invocationOnMock -> null);
        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(1);
        Main.listOrders.add(new Order(0));
        ListOrdersPage.listOrdersPage();
        mainMockedStatic.close();
    }
}