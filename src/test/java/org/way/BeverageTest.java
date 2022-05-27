package org.way;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BeverageTest {

    final Beverage beverage = new Beverage("Super");
    final Topping topping = new Topping("topping");

    @Test
    public void setCost() {
        beverage.setCost(10000);
        assertEquals(10000, beverage.getCost());
    }

    @Test
    public void getSize() {
        assertNull(beverage.getSize());

        beverage.setSize(1);
        assertEquals("Nhỏ (S)", beverage.getSize());

        beverage.setSize(2);
        assertEquals("Trung bình (M)", beverage.getSize());

        beverage.setSize(3);
        assertEquals("Lớn (L)", beverage.getSize());
    }

    @Test
    public void getToppings() {
        beverage.addTopping(topping);
        List<Topping> expected = new ArrayList<>() {{
            add(topping);
        }};
        assertEquals(expected, beverage.getToppings());
    }

    @Test
    public void toStringz() {
        beverage.setCost(10000);
        beverage.addTopping(topping);
        assertEquals("\tSuper (null)\n" + topping + "\t== 10.000 VNĐ ==\n" + "\n", beverage.toString());
    }
}