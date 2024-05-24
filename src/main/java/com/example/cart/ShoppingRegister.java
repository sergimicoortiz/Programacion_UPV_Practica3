package com.example.cart;

import com.example.sales.SalesRegister;
import com.example.shop.ClothingItem;
import com.example.shop.Inventory;

public class ShoppingRegister {
    private LinkedCart cart;

    public ShoppingRegister() {
        cart = new LinkedCart();
    }

    // Funcion para quitar en massa items del inventory
    private void removeFromInventory(Inventory inventory, ClothingItem item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            inventory.removeItem(item.getName(), item.getSize());
        }
    }

    // Funcion para añadir en masa items al inventory
    private void addToInventory(Inventory inventory, ClothingItem item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            inventory.addItem(item);
        }
    }

    public void addToCart(Inventory inventory, String itemName, char size, int quantity) {
        int stock = inventory.checkStock(itemName, size);

        if (stock == 0) {
            System.out.println("No hay stock de este artículo.");
            return;
        }

        int indexItem = cart.find(itemName, size);
        int actualUnits = indexItem != -1 ? cart.find(indexItem).getUnits() : 0;

        if (stock >= actualUnits + quantity) {
            if (indexItem == -1) {
                ClothingItem item = inventory.extractItem(itemName, size);
                cart.insert(0, new CartItem(item, quantity));
                this.removeFromInventory(inventory, item, quantity - 1);
            } else {
                cart.find(indexItem).setUnits(actualUnits + quantity);
                this.removeFromInventory(inventory, cart.find(indexItem).getClothingItem(), quantity);
            }
        } else {
            System.out.println("No hay suficiente stock de este artículo.");
        }
    }

    public void removeFromCart(Inventory inventory, String itemName, char size, int quantity) {
        int indexItem = cart.find(itemName, size);
        if (indexItem == -1) {
            System.out.println("El artículo no se encuentra en el carrito.");
            return;
        }
        cart.find(indexItem).setUnits(cart.find(indexItem).getUnits() - quantity);
        this.addToInventory(inventory, cart.find(indexItem).getClothingItem(), quantity);
        if (cart.find(indexItem).getUnits() <= 0) {
            cart.remove(indexItem);
        }
    }

    public void confirmCart(Inventory inventory) {
        CartItemNode cartItemTmp = cart.getFirst();
        while (cartItemTmp != null) {
            ClothingItem item = cartItemTmp.getDato().getClothingItem();
            for (int i = 0; i < cartItemTmp.getDato().getUnits(); i++) {
                inventory.addItem(item);
                SalesRegister.processSale(inventory, item.getName(), item.getSize());
            }
            cartItemTmp = cartItemTmp.getNext();
        }
        cart.setFirst(null);
    }

    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("El carrito esta vacio");
            return;
        }
        CartItemNode cartItemTmp = cart.getFirst();
        while (cartItemTmp != null) {
            System.out.println(cartItemTmp.getDato().toString());
            cartItemTmp = cartItemTmp.getNext();
        }
    }
}
