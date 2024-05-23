package com.example.cart;

import com.example.sales.SalesRegister;
import com.example.shop.ClothingItem;
import com.example.shop.Inventory;

public class ShoppingRegister {
    private static LinkedCart cart = new LinkedCart();
    // TODO testear classe entero y verificar el stock de los productos antes de
    // añadirlos

    // public ShoppingRegister() {
    // cart = new LinkedCart();
    // }

    public static void addToCart(Inventory inventory, String itemName, char size, int quantity) {
        if (inventory.checkStock(itemName, size) == 0) {
            System.out.println("No hay stock de este artículo.");
            return;
        }
        int indexItem = cart.find(itemName, size);
        if (indexItem != -1) {
            cart.find(indexItem).setUnits(cart.find(indexItem).getUnits() + quantity);
        } else {
            ClothingItem item = inventory.extractItem(itemName, size);
            cart.insert(0, new CartItem(item, quantity));
        }
    }

    public static void removeFromCart(Inventory inventory, String itemName, char size, int quantity) {
        int indexItem = cart.find(itemName, size);
        if (indexItem == -1) {
            System.out.println("El artículo no se encuentra en el carrito.");
            return;
        }
        cart.find(indexItem).setUnits(cart.find(indexItem).getUnits() - quantity);
        if (cart.find(indexItem).getUnits() <= 0) {
            cart.remove(indexItem);
        }
    }

    public static void confirmCart(Inventory inventory) {
        CartItemNode cartItemTmp = cart.getFirst();
        while (cartItemTmp.getNext() != null) {
            ClothingItem item = cartItemTmp.getDato().getClothingItem();
            for (int i = 1; i <= cartItemTmp.getDato().getUnits(); i++) {
                SalesRegister.processSale(inventory, item.getName(), item.getSize());
            }
            cartItemTmp = cartItemTmp.getNext();
        }
        cart.setFirst(null);
    }

    public static void showCart() {
        if (cart.isEmpty()) {
            System.out.println("El carrito esta vacio");
            return;
        }
        CartItemNode cartItemTmp = cart.getFirst();
        while (cartItemTmp.getNext() != null) {
            System.out.println(cartItemTmp.getDato());
            cartItemTmp = cartItemTmp.getNext();
        }
    }
}
