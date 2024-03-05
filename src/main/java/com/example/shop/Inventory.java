package com.example.shop;

public class Inventory {
    private ClothingItem[] items;
    private int itemLength;
    private int MAX_SIZE;

    public Inventory(int MAX_SIZE) {
        this.items = new ClothingItem[MAX_SIZE];
        this.itemLength = 0;
        this.MAX_SIZE = MAX_SIZE;
    }

    public int getItemCount() {
        int cont = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                cont++;
            }
        }
        return cont;
    }

    public void addItem(ClothingItem item) {
        if (this.itemLength != this.MAX_SIZE) {
            for (int i = 0; i < this.items.length; i++) {
                if (this.items[i] == null) {
                    this.items[i] = item;
                }
            }
        } else {
            // TODO: lanzar exepcion
        }
    }
}