package org.way.page;

import static org.way.Main.*;

public class OrderPage {
    public static void orderPage() {
        printLineLayout("Thông tin đơn hàng hiện tại", 2);
        newOrder.print();

        String[] options = {
                "Xác nhận \u2714",
                "Thêm món \u271A",
                "Hủy đơn \u2718",
        };
        String[] route = {
                "homePage",
                "menuPage",
                "homePage",
        };
        int option = printMenuOption(options);
        if (option != 0) {
            switch (option) {
                case 1:
                    if (!newOrder.getBeverages().isEmpty()) {
                        newOrder.sendBill(selectedNotifier);
                        newOrder.setStatus(selectedNotifier);
                        listOrders.add(newOrder);
                        newOrder = null;
                        System.gc();
                    } else {
                        route[0] = "orderPage";
                        error = "Đơn hàng trống......";
                    }
                    break;
                case 3:
                    numOrderInRun--;
                    newOrder = null;
                    System.gc();
                    break;
                default:
            }
            routeOption(option, route);
        }
    }
}
