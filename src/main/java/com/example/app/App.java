package com.example.app;

import java.util.Scanner;

import com.example.sales.SalesRegister;
import com.example.shop.ClothingItem;
import com.example.shop.Inventory;
import com.example.test.TestClothingItem;
import com.example.test.TestInventory;
import com.example.test.TestSalesRegister;

@SuppressWarnings("unused")
public class App {
    private static Scanner tec = new Scanner(System.in);
    private static Inventory inventory = new Inventory(20);

    public static void printMenu() {
        System.out.println("*** Bienvenido a Strafalarius ***");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar nueva prenda al inventario");
        System.out.println("2. Mostrar inventario");
        System.out.println("3. Procesar venta");
        System.out.println("4. Mostrar estadisticas de venta");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opción (1-5): ");
    }

    public static int userSelect() {
        String option = tec.nextLine();
        try {
            return Integer.parseInt(option);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void option1() {
        System.out.println("Name:");
        String name = tec.nextLine();
        System.out.println("Size:");
        char size = tec.nextLine().charAt(0);
        System.out.println("Price:");
        double price = Double.parseDouble(tec.nextLine());
        inventory.addItem(new ClothingItem(name, price, size));
    }

    public static void option2() {
        System.out.println(inventory);
    }

    public static void option3() {
        System.out.println("Name:");
        String name = tec.nextLine();
        System.out.println("Size:");
        char size = tec.nextLine().charAt(0);
        ClothingItem item = SalesRegister.processSale(inventory, name, size);
        if (item != null) {
            System.out.println("Venta realizada correctamente.");
            System.out.println(item);
        } else {
            System.out.println("No se ha podido realizar la venta, Prenda no encontrada.");
        }
    }

    public static void option4() {
        System.out.println("Ventas amount: " + SalesRegister.getTotalSalesAmount());
        System.out.println("Ventas count: " + SalesRegister.getTotalSalesCount());
    }

    public static void menu() {
        int option = 0;

        while (option != 5) {
            printMenu();
            option = userSelect();
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    option3();
                    break;
                case 4:
                    option4();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("La opción debe de ser un número entre 1 y 5.");
                    break;
            }
            System.out.println("Pulse cualquier tecla para continuar.");
            tec.nextLine();
        }
    }

    public static void main(String[] args) {
        // TestClothingItem.checkClass(ClothingItem.class);
        // TestInventory.checkClass(Inventory.class);
        // TestSalesRegister.checkSalesRegister();

        menu();

    }
}
