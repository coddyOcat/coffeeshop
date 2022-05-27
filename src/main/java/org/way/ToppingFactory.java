package org.way;

import org.way.topping.CheeseEggs;
import org.way.topping.Pudding;
import org.way.topping.TapiocaPearls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ToppingFactory {
    static @Nullable Topping create(@NotNull String beverageName) {
        switch (beverageName) {
            case "Trứng phô mai":
                return new CheeseEggs();
            case "Bánh pudding":
                return new Pudding();
            case "Trân châu":
                return new TapiocaPearls();
        }
        return null;
    }
}
