package org.way;

public class Topping {
    private final String _name;
    private int _cost;

    public Topping(String name) {
        this._name = name;
        this._cost = 0;
    }

    public int getCost() {
        return this._cost;
    }

    public void setCost(int cost) {
        this._cost = cost;
    }

    public String toString() {
        String message = "";
        message += "\t\t" + this._name + "\n";
        return message;
    }

    public void print() {
        System.out.println("\t\t" + this._name);
    }
}
