package com.example.app;

import java.util.Scanner;

import com.example.shop.ClothingItem;
import com.example.shop.Inventory;

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) {
        try {
            // Scanner tec = new Scanner(System.in);
            ClothingItem item1 = new ClothingItem("Camisa1", 25.99, 'M');
            ClothingItem item2 = new ClothingItem("Camisa2", 26.99, 'L');
            ClothingItem item3 = new ClothingItem("Camisa3", 27.99, 'S');
            ClothingItem item4 = new ClothingItem("Camisa3", 27.99, 'L');
            Inventory inventory = new Inventory(4);
            inventory.addItem(item1);
            inventory.addItem(item2);
            inventory.addItem(item3);
            inventory.addItem(item4);
            System.out.println(inventory.getItemCount());
            inventory.removeItem("Camisa2", 'L');
            System.out.println(inventory);
            System.out.println(inventory.extractItem("Camisa3", 'S'));
            inventory.addItem(new ClothingItem("test1", 1, 'L'));
            inventory.addItem(new ClothingItem("test2", 1, 'L'));
            inventory.addItem(new ClothingItem("test3", 1, 'L'));
            // tec.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
