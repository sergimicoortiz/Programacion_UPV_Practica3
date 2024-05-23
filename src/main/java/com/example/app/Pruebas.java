package com.example.app;

import com.example.cart.CartItem;
import com.example.cart.CartItemNode;
import com.example.cart.LinkedCart;
import com.example.cart.ShoppingRegister;
import com.example.shop.ClothingItem;
import com.example.shop.Inventory;

@SuppressWarnings("unused")
public class Pruebas {
    public static void main(String[] args) {
        ClothingItem a = new ClothingItem("test1", 12, 'S');
        ClothingItem b = new ClothingItem("test2", 12, 'S');
        ClothingItem c = new ClothingItem("test3", 12, 'S');
        Inventory inventory = new Inventory(10);
        inventory.addItem(a);
        inventory.addItem(b);
        inventory.addItem(c);
        ShoppingRegister.addToCart(inventory, "test1", 'S', 1);
        ShoppingRegister.showCart();
    }
}
