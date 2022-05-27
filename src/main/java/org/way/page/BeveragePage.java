package org.way.page;

import org.way.Topping;
import org.way.ToppingFactory;

import static org.way.Main.*;

public class BeveragePage {
    static boolean selectingTopping = false;
    static int numSelectedTopping = 0;

    public static void beveragePage() {
        printLineLayout("Đơn hàng hiện tại", 2);
        newOrder.print();

        printLineLayout(router.get(2), 2);
        if (newBeverage != null) {
            if (newBeverage.getSize() == null) {
                printLineLayout("Chọn size:", 0);
                String[] options = {
                        "Nhỏ (S)",
                        "Trung bình (M)",
                        "Lớn (L)"
                };
                int option = printMenuOption(options);
                if (option != 0) {
                    newBeverage.setSize(option);
                    selectingTopping = true;
                    numSelectedTopping = 0;
                    render();
                }
            } else if (selectingTopping) {
                printLineLayout("Size: " + newBeverage.getSize(), 0);
                if (newBeverage.getToppings().size() != 0) {
                    printLineLayout("Toppings: ", 0);
                    for (Topping topping : newBeverage.getToppings()) {
                        topping.print();
                    }
                }
                printLineLayout("Chọn topping:", 0);
                String[] options = new String[toppings.size() + 1];
                for (int i = 0; i < toppings.size(); i++) {
                    options[i] = toppings.get(i);
                }
                options[options.length - 1] = "Dừng chọn topping \u2398";
                int option = printMenuOption(options);
                if (option != 0) {
                    if (option > 0 && option < options.length) {
                        if (numSelectedTopping < maxTopping) {
                            Topping newTopping = ToppingFactory.create(options[option - 1]);
                            numSelectedTopping++;
                            newBeverage.addTopping(newTopping);
                        } else {
                            error = "Số lượng topping được giới hạn..." + "(không quá " + maxTopping + " toppings)";
                            selectingTopping = false;
                            numSelectedTopping = 0;
                        }
                    } else {
                        selectingTopping = false;
                    }
                    render();
                }
            } else {
                newBeverage.print();
                String[] options = {
                        "Thêm vào đơn hàng \u271A",
                        "Hủy món \u2718",
                };
                String[] route = {
                        "menuPage",
                        "menuPage"
                };
                int option = printMenuOption(options);
                if (option != 0) {
                    if (option == 1) {
                        newOrder.addBeverage(newBeverage);
                    }
                    newBeverage = null;
                    System.gc();
                    router.remove(2);
                    routeOption(option, route);
                }
            }
        }

    }
}
