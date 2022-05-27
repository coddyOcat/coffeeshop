package org.way.page;

import static org.way.Main.*;

public class ListOrdersPage {
    public static void listOrdersPage() {
        printLineLayout("Danh sách những đơn hàng (chưa hoàn thành)", 2);
        String[] options = new String[listOrders.size() + 1];
        String[] route = new String[listOrders.size() + 1];
        for (int i = 0; i < listOrders.size(); i++) {
            options[i] = "Order" + "(" + listOrders.get(i).getId() + ")";
            route[i] = "orderedPage";
        }
        options[options.length - 1] = "Quay lại \u21A9";
        route[route.length - 1] = "homePage";

        int option = printMenuOption(options);
        if (option != 0) {
            if (option > 0 && option < options.length) {
                openOrder = listOrders.get(option - 1);
                router.add("(" + openOrder.getId() + ")");
            }
            routeOption(option, route);
        }
    }
}
