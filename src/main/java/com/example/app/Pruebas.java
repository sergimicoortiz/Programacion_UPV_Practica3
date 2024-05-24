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
        Inventory inventory = new Inventory(10);
        ShoppingRegister shop = new ShoppingRegister();
        ClothingItem a = new ClothingItem("test1", 12, 'S');
        ClothingItem b = new ClothingItem("test2", 12, 'S');
        inventory.addItem(a);
        inventory.addItem(a);

        inventory.addItem(b);
        inventory.addItem(b);
        inventory.addItem(b);
        inventory.addItem(b);

        shop.addToCart(inventory, "test1", 'S', 2);
        shop.addToCart(inventory, "test2", 'S', 1);
        shop.removeFromCart(inventory, "test1", 'S', 2);
        shop.addToCart(inventory, "test2", 'S', 2);
        shop.showCart();
        shop.confirmCart(inventory);
        shop.showCart();
    }
}
