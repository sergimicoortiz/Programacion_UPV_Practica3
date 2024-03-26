package com.example.sales;

import com.example.shop.ClothingItem;
import com.example.shop.Inventory;

public class SalesRegister {
    private static long totalSalesCount;
    private static double totalSalesAmount;

    public static ClothingItem processSale(Inventory inventory, String name, char size) {
        ClothingItem item = inventory.extractItem(name, size);
        if (item == null) {
            System.out.println("Item no encontrado");
            return null;
        }
        totalSalesCount++;
        totalSalesAmount += item.getPrice();
        return item;
    }

    public static long getTotalSalesCount() {
        return totalSalesCount;
    }

    public static double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public static String getBalance() {
        return "Count: " + getTotalSalesCount() + "Amount: " + getTotalSalesAmount();
    }

    public static void resetTotalSalesCount() {
        totalSalesCount = 0;
    }

    public static void resetTotalSalesAmount() {
        totalSalesAmount = 0;
    }
}
