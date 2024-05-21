package com.example.cart;

public class CartItemNode {
    private CartItem dato;
    private CartItemNode next;

    public CartItemNode(CartItem dato) {
        this.dato = dato;
    }

    public CartItemNode(CartItem dato, CartItemNode next) {
        this.dato = dato;
        this.next = next;
    }

    public CartItem getDato() {
        return this.dato;
    }

    public void setDato(CartItem dato) {
        this.dato = dato;
    }

    public CartItemNode getNext() {
        return this.next;
    }

    public void setNext(CartItemNode next) {
        this.next = next;
    }
}
