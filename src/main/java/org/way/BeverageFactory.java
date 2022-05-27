package org.way;

import org.way.beverage.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface BeverageFactory {
    static @Nullable Beverage create(@NotNull String beverageName) {
        switch (beverageName) {
            case "Cà phê truyền thống":
                return new PureCoffee();
            case "Capuccino":
                return new Capuccino();
            case "Trà xanh":
                return new GreenTea();
            case "Trà đào":
                return new RedTea();
            case "Trà sữa":
                return new MilkTea();
        }
        return null;
    }
}
