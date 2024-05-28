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
        return this.itemLength;
    }

    private int getIndex(String name, char size) {
        for (int i = 0; i <= this.itemLength; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(name) && this.items[i].getSize() == size) {
                return i;
            }
        }
        return -1;
    }

    public void addItem(ClothingItem item) {
        if (this.itemLength != this.MAX_SIZE) {
            this.items[this.itemLength] = item;
            this.itemLength++;
        } else {
            System.out.println("Inventory is full");
        }
    }

    public int checkStock(String name, char size) {
        int cont = 0;
        for (int i = 0; i <= this.itemLength; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(name) && this.items[i].getSize() == size) {
                cont++;
            }
        }
        return cont;
    }

    public void removeItem(String name, char size) {
        int index = this.getIndex(name, size);
        if (index == -1) {
            return;
        }
        for (int i = index; i <= this.itemLength; i++) {
            if (i == this.itemLength) {
                this.items[i] = null;
            } else {
                this.items[i] = this.items[i + 1];
            }
        }
        this.itemLength--;
    }

    public ClothingItem extractItem(String name, char size) {
        int index = this.getIndex(name, size);
        if (index == -1) {
            return null;
        }
        ClothingItem item = this.items[index];
        this.removeItem(name, size);
        return item;
    }

    public String toString() {
        String msg = "Inventario: => itemLength=" + this.itemLength + ", MAX_SIZE=" + this.MAX_SIZE + "\n";
        msg += "Nombre          Precio          Talla\n";
        msg += "-------------------------------------\n";
        for (int i = 0; i <= this.itemLength; i++) {
            if (items[i] != null) {
                msg += (items[i].toString() + "\n");
            }
        }
        return msg;
    }
}