package com.example.app;

import java.util.Scanner;

import com.example.shop.ClothingItem;
import com.example.shop.Inventory;

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) {
        // Scanner tec = new Scanner(System.in);
        ClothingItem item1 = new ClothingItem("Camisa1", 25.99, 'M');
        ClothingItem item2 = new ClothingItem("Camisa2", 26.99, 'L');
        ClothingItem item3 = new ClothingItem("Camisa3", 27.99, 'A');
        Inventory inventory = new Inventory(5);
        System.out.println(inventory.getItemCount());
        inventory.addItem(item1);
        System.out.println(inventory.getItemCount());
        // TODO revisar no funciona correctamente
        // tec.close();
    }
}
