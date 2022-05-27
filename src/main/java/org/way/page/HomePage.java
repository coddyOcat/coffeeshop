package org.way.page;

import org.way.Order;

import static org.way.Main.*;

public class HomePage {
    public static void homePage() {
        printLineLayout("Trang chủ", 2);
        String[] options = {
                "Tạo đơn hàng mới \u271A",
                "Danh sách những đơn hàng \u2398",
                "Dừng hệ thống \u2718"
        };
        String[] route = {
                "menuPage",
                "listOrdersPage",
                "exit"
        };
        int option = printMenuOption(options);
        if (option != 0) {
            switch (option) {
                case 1:
                    numOrderInRun++;
                    newOrder = new Order(numOrderInRun);
                    break;
                case 3:
                    if (listOrders.size() > 0) {
                        error = "CÒN NHỮNG ĐƠN HÀNG CHƯA ĐƯỢC XỬ LÝ......"; // (Bạn có chắc chắc muốn dừng)
                        route[2] = "homePage";
                    }
                default:
            }
            routeOption(option, route);
        }
    }
}
