package com.example.shop;

public class Inventory {
    private ClothingItem[] items;
    private int itemLength;
    private int MAX_SIZE;

    public Inventory(int MAX_SIZE) {
        this.items = new ClothingItem[MAX_SIZE];
        this.itemLength = 0; // No se utiliza
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

    // public int getMAX_SIZE() {
    // return this.MAX_SIZE;
    // }

    // public void setMAX_SIZE(int MAX_SIZE) {
    // if (this.getItemLength() == 0) {
    // this.MAX_SIZE = MAX_SIZE;
    // this.items = new ClothingItem[this.MAX_SIZE];
    // this.itemLength = 0;
    // } else {
    // System.out.println("Necesitas vaciar el inventario para cambiar su tamaño.");
    // }
    // }

    // public ClothingItem[] getItems() {
    // return this.items;
    // }

    // public void setItems(ClothingItem[] items) {
    // this.items = items;
    // this.itemLength = items.length;
    // if (this.MAX_SIZE < this.itemLength) {
    // this.MAX_SIZE = this.itemLength;
    // }
    // }

    // public int getItemLength() {
    // return this.itemLength;
    // }

    // TODO: Preguntar per els getters y setters comentats

    public void addItem(ClothingItem item) {
        if (this.getItemCount() != this.MAX_SIZE) {
            for (int i = 0; i < this.items.length; i++) {
                if (this.items[i] == null) {
                    this.items[i] = item;
                    break;
                }
            }
        } else {
            System.out.println("Inventory is full");
            // throw new Exception("Inventory is full");
        }
    }

    public int checkStock(String name, char size) {
        int cont = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(name) && this.items[i].getSize() == size) {
                cont++;
            }
        }
        return cont;
    }

    public void removeItem(String name, char size) {
        boolean removed = false;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null &&
                    !removed &&
                    this.items[i].getName().equals(name) &&
                    this.items[i].getSize() == size) {
                this.items[i] = null;
                removed = true;
            }
            if (removed && this.items[i] != null) {
                this.items[i - 1] = this.items[i];
                this.items[i] = null;
            }
        }

    }

    public ClothingItem extractItem(String name, char size) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(name) && this.items[i].getSize() == size) {
                ClothingItem itemTmp = this.items[i];
                this.removeItem(name, size);
                return itemTmp;
            }
        }
        return null;
    }

    public String toString() {
        String msg = "Inventario: => itemLength=" + this.itemLength + ", MAX_SIZE=" + this.MAX_SIZE + "\n";
        msg += "Nombre          Precio          Talla\n";
        msg += "-------------------------------------\n";
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                msg += (items[i].toString() + "\n");
            }
        }
        return msg;
    }
}