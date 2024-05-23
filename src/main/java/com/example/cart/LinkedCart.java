package com.example.cart;

public class LinkedCart {
    private CartItemNode first;
    private int size = 0;

    public LinkedCart() {
    }

    public CartItemNode getFirst() {
        return this.first;
    }

    public void setFirst(CartItemNode first) {
        this.first = first;
    }

    public boolean isEmpty() {
        return this.first == null;
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
            tmp = tmp.getNext();
        }
        return -1;
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
    }

    public void insert(int index, CartItem item) {
        CartItemNode cartNode = new CartItemNode(item);
        this.size++;
        if (this.first == null) {
            this.first = cartNode;
            return;
        }
        if (index == 0) {
            cartNode.setNext(this.first);
            this.first = cartNode;
        } else {
            CartItemNode tmp = this.first;
            for (int i = 1; i <= index; i++) {
                if (tmp.getNext() == null) {
                    tmp.setNext(cartNode);
                    return;
                }
                tmp = tmp.getNext();
                if (index == i) {
                    cartNode.setNext(tmp.getNext());
                    tmp.setNext(cartNode);
                }
            }
        }
    }

    public CartItem remove(int index) {
        CartItemNode cartItemNode = null;
        if (index == 0) {
            cartItemNode = this.first;
            this.first = cartItemNode.getNext();
            this.size--;
        } else {
            CartItemNode tmp = this.first;
            // debemos de llegar a index-1 para que el siguiente sea el que eliminemos
            for (int i = 0; i < index; i++) {
                if (i == index - 1) {
                    cartItemNode = tmp.getNext();
                    tmp.setNext(cartItemNode.getNext());
                    this.size--;
                } else {
                    tmp = tmp.getNext();
                }
            }
        }
        cartItemNode.setNext(null);
        return cartItemNode.getDato();
    }

    public String toString() {
        String msg = "";
        CartItemNode tmp = this.first;
        for (int i = 0; i < this.size; i++) {
            msg += tmp.getDato().toString();
            msg += "\n";
            tmp = tmp.getNext();
        }
        return msg;
    }

}