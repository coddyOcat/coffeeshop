package org.way;

import org.jetbrains.annotations.NotNull;
import org.way.notifier.Telegram;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import static org.way.page.BeveragePage.beveragePage;
import static org.way.page.HomePage.homePage;
import static org.way.page.ListOrdersPage.listOrdersPage;
import static org.way.page.MenuPage.menuPage;
import static org.way.page.OrderPage.orderPage;
import static org.way.page.OrderedPage.orderedPage;

public class Main {

    // hardcore menu
    public static final Hashtable<String, ArrayList<String>> menu = new Hashtable<>() {
        {
            put(
                    "Cà phê",
                    new ArrayList<>() {{
                        add("Cà phê truyền thống");
                        add("Capuccino");
                    }}
            );
            put(
                    "Trà",
                    new ArrayList<>() {{
                        add("Trà xanh");
                        add("Trà đào");
                        add("Trà sữa");
                    }}
            );
        }
    };
    public static final List<String> toppings = new ArrayList<>() {{
        add("Trứng phô mai");
        add("Bánh pudding");
        add("Trân châu");
    }};
    public static final List<String> statuses = new ArrayList<>() {{
        add("Đang tạo đơn hàng...");
        add("Đơn hàng đã được tạo...");
        add("Đơn hàng đang được xử lý...");
        add("Đơn hàng đang giao...");
        add("Đơn hàng hoàn tất");
    }};
    static final NotifierService notifier = Notifier.getInstance();
    static final NotifierService justTelegramNotifier = new Telegram(notifier);
    //    !static final NotifierService justZaloNotifier = new Zalo(notifier);
//    !static NotifierService bothZaloAndTelegramNotifier = new Zalo(justTelegramNotifier);
    public static final NotifierService selectedNotifier = justTelegramNotifier;
    // attributes
    public static final List<String> router = new ArrayList<>();
    public static String error = null;
    public static int numOrderInRun = 0;
    public static Order newOrder = null;
    public static Beverage newBeverage = null;
    public static final int maxTopping = 3;
    public static Order openOrder = null;
    public static final List<Order> listOrders = new ArrayList<>();

    // main function
    public static void main(String[] args) {
        router.add("homePage");
        render();
    }

    // functions
    public static void render() {
        // clear
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // render
        printLineLayout("CỬA HÀNG CÀ PHÊ", 1);
        if (router.size() > 0) {
            switch (router.get(0)) {
                case "homePage":
                    homePage();
                    break;
                case "menuPage":
                    if (router.size() > 1) {
                        menuPage(1);
                    } else menuPage(0);
                    break;
                case "beveragePage":
                    beveragePage();
                    break;
                case "listOrdersPage":
                    listOrdersPage();
                    break;
                case "orderPage":
                    orderPage();
                    break;
                case "orderedPage":
                    orderedPage(router.get(1));
                    break;
                default:
                    exit();
            }
        }
    }

    public static void printLineLayout(@NotNull String title, int level) {
        int width = 100;
        int titleLen = title.length();
        int numEqual;
        if (titleLen % 2 == 0) {
            title = " " + title + " ";
            numEqual = (width - titleLen - 2) / 2;
        } else {
            title = " " + title + "  ";
            numEqual = (width - titleLen - 3) / 2;
        }
        switch (level) {
            case 1:
                System.out.print("=".repeat(numEqual));
                System.out.print(title);
                System.out.println("=".repeat(numEqual));
                break;
            case 2:
                System.out.print("-".repeat(numEqual));
                System.out.print(title);
                System.out.println("-".repeat(numEqual));
                break;
            case 10:
                System.out.println("\n".repeat(2));
                System.out.print(" ".repeat(numEqual));
                System.out.print(title);
                System.out.println(" ".repeat(numEqual));
                System.out.println("\n".repeat(2));
                break;
            default:
                System.out.println(title);
        }
        System.out.println();
    }

    public static int printMenuOption(String @NotNull [] options) {
        int index = 1;
        for (String option : options) {
            System.out.println("[" + index + "]" + " " + option);
            index++;
        }
        System.out.println();
        if (error != null) {
            System.out.println(error);
            error = null;
        }
        System.out.print("Nhập số để lựa chọn: ");
        Scanner scanner = new Scanner(System.in);
        int option;
        try {
            option = scanner.nextInt();
            if (option < 1 || option > options.length) {
                error = "Xin hãy nhập những lựa chọn trong menu......";
                render();
                option = 0;
            }
        } catch (Exception ex) {
            error = "Xin hãy nhập số tự nhiên......";
            render();
            option = 0;
        }
        return option;
    }

    public static void routeOption(int option, String @NotNull [] route) {
        router.set(0, route[option - 1]);
        render();
    }

    public static void exit() {
        printLineLayout("CẢM ƠN VÌ ĐÃ SỬ DỤNG HỆ THỐNG", 10);
    }
}
