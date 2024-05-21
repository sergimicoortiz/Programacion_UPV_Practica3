package com.example.cart;

public class LinkedCart {
    public CartItemNode first;
    private int size = 0;

    public LinkedCart() {
    }

    public boolean isEmpty() {
        return this.first == null;
        // TODO testear
    }

    public int find(String itemName, char size) {
        CartItemNode tmp = this.first;
        int index = 0;
        while (tmp != null) {
            if (tmp.getDato().getClothingItem().getName().equals(itemName)
                    && tmp.getDato().getClothingItem().getSize() == size) {
                return index;
            }
            index++;
        }
        return -1;
        // TODO testear
    }

    public CartItem find(int index) {
        CartItemNode tmp = this.first;
        if (index == 0) {
            return this.first.getDato();
        }
        for (int i = 1; i <= index; i++) {
            tmp = tmp.getNext();
            if (tmp == null) {
                return null;
            }
        }
        return tmp.getDato();
    }

    public int size() {
        return this.size;
        // TODO testear
    }

    public void insert(int index, CartItem item) {
        if (this.find(index) == null) {
            index = this.size;
        }
        if (index == 0) {
            this.first = new CartItemNode(item);
            return;
        }
        CartItemNode tmp = this.first;
        CartItemNode newNode = new CartItemNode(item);
        for (int i = 1; i <= index; i++) {
            tmp = tmp.getNext(); // nodo actual
            if (i == index) {
                newNode.setNext(tmp.getNext()); // redirigimos el proximo nodo al nuevo que insertamos
                tmp.setNext(newNode);
                this.size++;
            }
        }
        // TODO testear
    }

    public CartItem remove(int index) {
        return null;
        // TODO
    }

    public String toString() {
        String msg = "";
        CartItemNode tmp = this.first;
        for (int i = 0; i < this.size; i++) {
            msg += tmp.getDato().toString();
            tmp = tmp.getNext();
        }
        return msg;
    }

}