package org.way;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {

    final Order orderTest = new Order(0);

    @Test
    public void getOrderType() {
        orderTest.setOrderType(1);
        assertEquals("TẠI CỬA HÀNG", orderTest.getOrderType());

        orderTest.setOrderType(2);
        assertEquals("MANG ĐI", orderTest.getOrderType());

        orderTest.setOrderType(0);
        assertNull(orderTest.getOrderType());
    }
}