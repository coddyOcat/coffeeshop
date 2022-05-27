package org.way;

import java.util.ArrayList;
import java.util.List;

public class Beverage {
    private final String _name;

    private int _cost;
    private int _sizeType;
    private final List<Topping> _toppings;

    public Beverage(String name) {
        this._name = name;
        this._cost = 0;
        this._sizeType = 0;
        this._toppings = new ArrayList<>();
    }

    public int getCost() {
        return this._cost;
    }

    public void setCost(int cost) {
        this._cost = cost;
    }

    public void calcCost() {
        Topping lastTopping = this._toppings.get(this._toppings.size() - 1);
        this._cost += lastTopping.getCost();
    }

    public String getSize() {
        switch (this._sizeType) {
            case 1:
                return "Nhỏ (S)";
            case 2:
                return "Trung bình (M)";
            case 3:
                return "Lớn (L)";
            default:
                return null;
        }
    }

    public void setSize(int sizeType) {
        this._sizeType = sizeType;
        switch (this._sizeType) {
            case 1:
                this._cost += 0;
                break;
            case 2:
                this._cost += 5000;
                break;
            case 3:
                this._cost += 10000;
                break;
        }
    }

    public void addTopping(Topping topping) {
        this._toppings.add(topping);
        this.calcCost();
    }

    public List<Topping> getToppings() {
        return _toppings;
    }

    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("\t").append(_name).append(" (").append(getSize()).append(")").append("\n");
        for (Topping topping : _toppings) {
            message.append(topping.toString());
        }
        String costStr = _cost + "";
        int numDot = (costStr.length() + 2) / 3 - 1;
        StringBuilder printCost = new StringBuilder(costStr.substring(0, costStr.length() - numDot * 3));
        for (int i = 0; i < numDot; i++) {
            printCost.append(".").append(costStr, costStr.length() - (i + 1) * 3, costStr.length() - i * 3);
        }
        message.append("\t== ").append(printCost).append(" VNĐ ==").append("\n\n");
        return message.toString();
    }

    public void print() {
        System.out.println("\t" + _name + " (" + getSize() + ")");
        for (Topping topping : _toppings) {
            topping.print();
        }
        String costStr = _cost + "";
        int numDot = (costStr.length() + 2) / 3 - 1;
        StringBuilder printCost = new StringBuilder(costStr.substring(0, costStr.length() - numDot * 3));
        for (int i = 0; i < numDot; i++) {
            printCost.append(".").append(costStr, costStr.length() - (i + 1) * 3, costStr.length() - i * 3);
        }
        System.out.println("\t== " + printCost + " VNĐ ==");
        System.out.println();
    }
}