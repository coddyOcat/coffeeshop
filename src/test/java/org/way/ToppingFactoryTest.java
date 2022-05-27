package org.way;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.way.topping.CheeseEggs;
import org.way.topping.Pudding;
import org.way.topping.TapiocaPearls;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ToppingFactoryTest {

    @Test
    public void create() {
        assertTrue(ToppingFactory.create("Trứng phô mai") instanceof CheeseEggs);
        assertTrue(ToppingFactory.create("Bánh pudding") instanceof Pudding);
        assertTrue(ToppingFactory.create("Trân châu") instanceof TapiocaPearls);
        assertNull(ToppingFactory.create("Other"));
    }

}