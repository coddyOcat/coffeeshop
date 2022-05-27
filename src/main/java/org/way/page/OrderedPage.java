package org.way.page;

import static org.way.Main.*;

public class OrderedPage {
    public static void orderedPage(String numOrder) {
        printLineLayout("Thông tin đơn hàng " + numOrder, 2);
        openOrder.print();
        String nextStatus;
        if (openOrder.getStatus() + 1 < statuses.size()) {
            nextStatus = statuses.get(openOrder.getStatus() + 1);
            String[] options = {
                    "Cập nhật trạng thái: " + nextStatus,
                    "Hủy đơn hàng \u2718",
                    "Quay lại \u21A9",
            };
            String[] route = {
                    "orderedPage",
                    "listOrdersPage",
                    "listOrdersPage",
            };
            int option = printMenuOption(options);
            if (option != 0) {
                switch (option) {
                    case 1:
                        openOrder.setStatus(selectedNotifier);
                        break;
                    case 2:
                        router.remove(1);
                        listOrders.remove(openOrder);
                        openOrder.setDelOrder(selectedNotifier);
                        openOrder = null;
                        System.gc();
                        break;
                    case 3:
                        router.remove(1);
                        break;
                    default:
                }
                routeOption(option, route);
            }
        } else {
            router.remove(1);
            listOrders.remove(openOrder);
            openOrder = null;
            System.gc();
            router.set(0, "listOrdersPage");
            render();
        }

    }
}
