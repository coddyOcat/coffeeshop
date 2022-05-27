package org.way;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.way.page.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Test
    public void main() {
        MockedStatic<Main> mainMockedStatic = Mockito.mockStatic(Main.class);
        mainMockedStatic.when(Main::render).thenAnswer(invocationOnMock -> null);
        Main.main(Mockito.any(String[].class));
        mainMockedStatic.close();
    }

    @Test
    public void render() {
        MockedStatic<HomePage> homePageMockedStatic = Mockito.mockStatic(HomePage.class);
        homePageMockedStatic.when(HomePage::homePage).thenAnswer(invocationOnMock -> null);
        if (Main.router.size() > 0) {
            Main.router.set(0, "homePage");
        } else {
            Main.router.add("homePage");
        }
        Main.render();
        homePageMockedStatic.close();

        MockedStatic<MenuPage> menuPageMockedStatic = Mockito.mockStatic(MenuPage.class);
        menuPageMockedStatic.when(() -> MenuPage.menuPage(Mockito.any(Integer.class))).thenAnswer(invocationOnMock -> null);
        Main.router.set(0, "menuPage");
        while (Main.router.size() > 1) {
            Main.router.remove(Main.router.size() - 1);
        }
        Main.render();
        Main.router.add("menuPage level 1");
        Main.render();
        menuPageMockedStatic.close();

        MockedStatic<BeveragePage> beveragePageMockedStatic = Mockito.mockStatic(BeveragePage.class);
        beveragePageMockedStatic.when(BeveragePage::beveragePage).thenAnswer(invocationOnMock -> null);
        Main.router.set(0, "beveragePage");
        Main.render();
        beveragePageMockedStatic.close();

        MockedStatic<ListOrdersPage> listOrdersPageMockedStatic = Mockito.mockStatic(ListOrdersPage.class);
        listOrdersPageMockedStatic.when(ListOrdersPage::listOrdersPage).thenAnswer(invocationOnMock -> null);
        Main.router.set(0, "listOrdersPage");
        Main.render();
        listOrdersPageMockedStatic.close();

        MockedStatic<OrderPage> orderPageMockedStatic = Mockito.mockStatic(OrderPage.class);
        orderPageMockedStatic.when(OrderPage::orderPage).thenAnswer(invocationOnMock -> null);
        Main.router.set(0, "orderPage");
        Main.render();
        orderPageMockedStatic.close();

        MockedStatic<OrderedPage> orderedPageMockedStatic = Mockito.mockStatic(OrderedPage.class);
        orderedPageMockedStatic.when(() -> OrderedPage.orderedPage(Mockito.any(String.class))).thenAnswer(invocationOnMock -> null);
        Main.router.set(0, "orderedPage");
        Main.router.set(1, "orderedPage level 1");
        Main.render();
        orderedPageMockedStatic.close();

        Main.router.set(0, "Exit");
        Main.render();
        Main.router.remove(0);
    }

    @Test
    public void printLineLayout() {
        Main.printLineLayout("Chan", 1);
        Main.printLineLayout("Lez", 2);
        Main.printLineLayout("Other", 0);
    }

    @Test
    public void printMenuOption() {
        String[] options = {
                "option 1",
                "option 2",
        };
        String input;
        InputStream in;

        input = "1";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(1, Main.printMenuOption(options));

        input = "0";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(0, Main.printMenuOption(options));

        input = "abc";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(0, Main.printMenuOption(options));
    }

    @Test
    public void routeOption() {
        String[] options = {
                "option 1",
                "option 2",
        };
        Main.router.add("Router 0");
        Main.routeOption(2, options);
    }
}