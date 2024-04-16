package com.example.shop;

public class ClothingItem {

    private String name;
    private double price;
    private char size;

    public ClothingItem(String name, double price, char size) {
        this.name = name;
        this.price = price;

        switch (size) {
            case 'S':
            case 'M':
            case 'L':
                this.size = size;
                break;
            default:
                this.size = 'S';
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        switch (size) {
            case 'S':
            case 'M':
            case 'L':
                this.size = size;
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return this.name + "         " + this.price + "          " + this.size + "\n";
    }

}
