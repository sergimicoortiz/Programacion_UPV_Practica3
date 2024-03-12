package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.shop.ClothingItem;
import com.example.shop.Inventory;

public class TestInventory {
    @Test
    public void shouldAnswerWithTrue() {
        try {
            Inventory inventory = new Inventory(4);
            inventory.addItem(new ClothingItem("Camisa1", 25.99, 'M'));
            inventory.addItem(new ClothingItem("Camisa2", 26.99, 'L'));
            inventory.addItem(new ClothingItem("Camisa3", 27.99, 'S'));
            inventory.addItem(new ClothingItem("Camisa3", 27.99, 'L'));
            boolean check1 = inventory.getItemCount() == 4;
            inventory.removeItem("Camisa2", 'L');
            boolean check2 = inventory.checkStock("Camisa2", 'L') == 0;
            ClothingItem item = inventory.extractItem("Camisa3", 'S');
            boolean check3 = inventory.getItemCount() == 2;
            assertTrue(inventory != null
                    && inventory instanceof Inventory
                    && check1
                    && check2
                    && check3
                    && item != null
                    && item instanceof ClothingItem);
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}
