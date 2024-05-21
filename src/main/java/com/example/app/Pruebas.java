package com.example.app;

import com.example.cart.CartItem;
import com.example.cart.CartItemNode;
import com.example.cart.LinkedCart;
import com.example.shop.ClothingItem;

public class Pruebas {
    public static void main(String[] args) {
        LinkedCart cart = new LinkedCart();
        ClothingItem a = new ClothingItem("test1", 12, 'S');
        ClothingItem b = new ClothingItem("test2", 12, 'S');
        ClothingItem c = new ClothingItem("test3", 12, 'S');
        cart.insert(0, new CartItem(a, 12));
        cart.insert(0, new CartItem(b, 2));
        cart.insert(2, new CartItem(c, 1));
        System.out.println(cart);
        cart.remove(2);
        cart.remove(0);
        System.out.println(cart);
    }
}
