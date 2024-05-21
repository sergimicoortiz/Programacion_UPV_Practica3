package com.example.app;

import com.example.cart.CartItem;
import com.example.cart.CartItemNode;
import com.example.cart.LinkedCart;
import com.example.shop.ClothingItem;

public class Pruebas {
    public static void main(String[] args) {
        LinkedCart cart = new LinkedCart();
        ClothingItem a = new ClothingItem("test", 12, 'S');
        ClothingItem b = new ClothingItem("test2", 12, 'S');
        ClothingItem c = new ClothingItem("test3", 12, 'S');
        CartItemNode cnode = new CartItemNode(new CartItem(a, 1));
        cnode.setNext(new CartItemNode(new CartItem(b, 2)));
        cnode.getNext().setNext(new CartItemNode(new CartItem(c, 5)));
        cart.first = cnode;
        // cart.insert(0, new CartItem(a, 3));
        System.out.println(cart.find("tets2", 'S'));
        // TODO continuar revisando el find for nombre y talla
    }
}
