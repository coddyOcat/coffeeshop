package org.way;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.way.beverage.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BeverageFactoryTest {

    @Test
    public void create() {
        assertTrue(BeverageFactory.create("Cà phê truyền thống") instanceof PureCoffee);
        assertTrue(BeverageFactory.create("Capuccino") instanceof Capuccino);
        assertTrue(BeverageFactory.create("Trà xanh") instanceof GreenTea);
        assertTrue(BeverageFactory.create("Trà đào") instanceof RedTea);
        assertTrue(BeverageFactory.create("Trà sữa") instanceof MilkTea);
        assertNull(BeverageFactory.create("Other"));
    }
}