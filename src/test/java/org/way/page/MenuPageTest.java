package org.way.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.way.Main;
import org.way.Order;

@RunWith(MockitoJUnitRunner.class)
public class MenuPageTest {
    @Test
    public void menuPage() {
        MockedStatic<Main> mainMockedStatic = Mockito.mockStatic(Main.class);
        mainMockedStatic.when(Main::render).thenAnswer(invocationOnMock -> null);
        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(1);
        Main.newOrder = new Order(0);

        MenuPage.menuPage(0);
        MenuPage.menuPage(0);
        Main.router.add("Router 1");
        Main.router.add("Router 2");
        Main.router.set(1, "Cà phê");
        MenuPage.menuPage(1);

        mainMockedStatic.close();
    }
}