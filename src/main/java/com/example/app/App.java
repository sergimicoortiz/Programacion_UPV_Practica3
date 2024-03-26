package com.example.app;

import java.util.Scanner;

import com.example.TestClothingItem;
import com.example.TestInventory;
import com.example.TestSalesRegister;
import com.example.sales.SalesRegister;
import com.example.shop.ClothingItem;
import com.example.shop.Inventory;

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) {
        TestClothingItem.checkClass(ClothingItem.class);
        TestInventory.checkClass(Inventory.class);
        TestSalesRegister.checkSalesRegister();
        // Scanner tec = new Scanner(System.in);
        // ClothingItem item1 = new ClothingItem("Camisa1", 25.99, 'M');
        // ClothingItem item2 = new ClothingItem("Camisa2", 26.99, 'L');
        // ClothingItem item3 = new ClothingItem("Camisa3", 27.99, 'S');
        // ClothingItem item4 = new ClothingItem("Camisa3", 27.99, 'L');
        // Inventory inventory = new Inventory(4);
        // inventory.addItem(item1);
        // inventory.addItem(item2);
        // inventory.addItem(item3);
        // inventory.addItem(item4);

        // tec.close();
    }
}
