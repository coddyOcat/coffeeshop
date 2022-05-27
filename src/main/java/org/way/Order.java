package org.way;

import java.util.ArrayList;
import java.util.List;

import static org.way.Main.statuses;

public class Order {
    private final int _id;
    private int _cost;
    private int _orderType;
    private String _status;
    private int _stepStatus;
    private final List<Beverage> _beverages;

    public Order(int id) {
        this._id = id;
        this._cost = 0;
        this._orderType = 0;
        this._status = "Đang tạo đơn hàng...";
        this._stepStatus = 0;
        this._beverages = new ArrayList<>();
    }

    public String getOrderType() {
        if (this._orderType == 1) {
            return "TẠI CỬA HÀNG";
        } else if (this._orderType == 2) {
            return "MANG ĐI";
        } else {
            return null;
        }
    }

    public void setOrderType(int orderType) {
        this._orderType = orderType;
    }

    public List<Beverage> getBeverages() {
        return this._beverages;
    }

    public void addBeverage(Beverage beverage) {
        this._beverages.add(beverage);
        this.calcCost();
    }

    public int getId() {
        return this._id;
    }

    public void calcCost() {
        Beverage lastBeverage = this._beverages.get(this._beverages.size() - 1);
        this._cost += lastBeverage.getCost();
    }

    public void setStatus(NotifierService notifier) {
        this._stepStatus++;
        this._status = statuses.get(_stepStatus);
        notifier.send(toString());
    }

    public void sendBill(NotifierService notifier) {
        StringBuilder message = new StringBuilder();
        message.append("HÓA ĐƠN (Order ").append(this._id).append(")").append("\n");
        if (this._orderType != 0)
            message.append(getOrderType()).append("\n");
        message.append("Đã chọn: ");
        message.append("\n\n");
        for (Beverage beverage : this._beverages) {
            message.append(beverage.toString());
        }
        message.append("\n");
        String costStr = _cost + "";
        int numDot = (costStr.length() + 2) / 3 - 1;
        StringBuilder printCost = new StringBuilder(costStr.substring(0, costStr.length() - numDot * 3));
        for (int i = 0; i < numDot; i++) {
            printCost.append(".").append(costStr, costStr.length() - (i + 1) * 3, costStr.length() - i * 3);
        }
        message.append("Tổng: ").append(printCost).append(" VNĐ").append("\n\n");
        notifier.send(String.valueOf(message));
    }

    public void setDelOrder(NotifierService notifier) {
        this._status = "Đơn hàng đã bị hủy";
        notifier.send(toString());
    }

    public int getStatus() {
        return this._stepStatus;
    }

    public String toString() {
        StringBuilder message = new StringBuilder();
        if (this._orderType != 0)
            message.append(getOrderType()).append(" (").append(this._status).append(")").append("\n");
        message.append("Đã chọn: ");
        message.append("\n\n");
        for (Beverage beverage : this._beverages) {
            message.append(beverage.toString());
        }
        message.append("\n");
        String costStr = _cost + "";
        int numDot = (costStr.length() + 2) / 3 - 1;
        StringBuilder printCost = new StringBuilder(costStr.substring(0, costStr.length() - numDot * 3));
        for (int i = 0; i < numDot; i++) {
            printCost.append(".").append(costStr, costStr.length() - (i + 1) * 3, costStr.length() - i * 3);
        }
        message.append("Tổng: ").append(printCost).append(" VNĐ").append("\n\n");
        return message.toString();
    }

    public void print() {
        if (this._orderType != 0)
            System.out.println(getOrderType() + " (" + this._status + ")");
        System.out.print("Đã chọn: ");
        if (_beverages.isEmpty()) {
            System.out.println("(Trống)");
        } else {
            System.out.println();
            System.out.println();
            for (Beverage beverage : this._beverages) {
                beverage.print();
            }
        }
        System.out.println();
        String costStr = _cost + "";
        int numDot = (costStr.length() + 2) / 3 - 1;
        StringBuilder printCost = new StringBuilder(costStr.substring(0, costStr.length() - numDot * 3));
        for (int i = 0; i < numDot; i++) {
            printCost.append(".").append(costStr, costStr.length() - (i + 1) * 3, costStr.length() - i * 3);
        }
        System.out.println("Tổng: " + printCost + " VNĐ");
        System.out.println();
    }

}
