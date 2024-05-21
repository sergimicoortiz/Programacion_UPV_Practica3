package com.example.cart;

import com.example.shop.ClothingItem;

public class CartItem {
    private ClothingItem clothingItem;
    private int units = 0;

    public CartItem(ClothingItem clothingItem, int units) {
        this.clothingItem = clothingItem;
        this.units = units;
    }

    public ClothingItem getClothingItem() {
        return this.clothingItem;
    }

    public void setClothingItem(ClothingItem clothingItem) {
        this.clothingItem = clothingItem;
    }

    public int getUnits() {
        return this.units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String toString() {
        return "Item: " + this.clothingItem.toString() + "Unidades: " + this.units;
    }

}
