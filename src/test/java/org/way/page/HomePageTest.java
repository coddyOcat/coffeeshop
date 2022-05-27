package org.way.page;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.way.Main;
import org.way.Order;

@RunWith(MockitoJUnitRunner.class)
public class HomePageTest {

    @Test
    public void homePage() {
        MockedStatic<Main> mainMockedStatic = Mockito.mockStatic(Main.class);
        mainMockedStatic.when(Main::render).thenAnswer(invocationOnMock -> null);
        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(1);
        HomePage.homePage();
        mainMockedStatic.when(() -> Main.printMenuOption(Mockito.any())).thenReturn(3);
        Main.listOrders.add(new Order(0));
        HomePage.homePage();
        mainMockedStatic.close();
    }
}