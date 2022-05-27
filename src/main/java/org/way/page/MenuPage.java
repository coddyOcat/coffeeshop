package org.way.page;

import org.way.BeverageFactory;

import static org.way.Main.*;

public class MenuPage {
    public static void menuPage(int level) {
        printLineLayout("Đơn hàng hiện tại", 2);
        newOrder.print();
        if (newOrder.getOrderType() == null) {
            printLineLayout("Tại cửa hàng/Mang đi", 2);
            String[] options = {
                    "Tại cửa hàng",
                    "Mang đi"
            };
            int option = printMenuOption(options);
            if (option != 0) {
                newOrder.setOrderType(option);
                render();
            }
        } else {
            printLineLayout("Danh sách đồ uống", 2);

            String[] mutableOptions = new String[0];
            if (level == 0) {
                mutableOptions = menu.keySet().toArray(new String[0]);
            } else if (level == 1) {
                mutableOptions = menu.get(router.get(1)).toArray(new String[0]);
            }

            String[] options = new String[mutableOptions.length + 1];
            String[] route = new String[mutableOptions.length + 1];
            if (level == 0) {
                for (int i = 0; i < mutableOptions.length; i++) {
                    options[i] = mutableOptions[i];
                    route[i] = "menuPage";
                }
                options[options.length - 1] = "Dừng chọn món \u2398";
                route[route.length - 1] = "orderPage";
                int option = printMenuOption(options);
                if (option != 0) {
                    if (option > 0 && option < options.length) {
                        router.add(mutableOptions[option - 1]);
                    }
                    routeOption(option, route);
                }
            } else if (level == 1) {
                for (int i = 0; i < mutableOptions.length; i++) {
                    options[i] = mutableOptions[i];
                    route[i] = "beveragePage";
                }
                options[options.length - 1] = "Quay lại \u21A9";
                route[route.length - 1] = "menuPage";
                int option = printMenuOption(options);
                if (option != 0) {
                    if (option > 0 && option < options.length) {
                        router.add(options[option - 1]);
                        newBeverage = BeverageFactory.create(router.get(2));
                    } else {
                        router.remove(1);
                    }
                    routeOption(option, route);
                }
            }
        }
    }
}
