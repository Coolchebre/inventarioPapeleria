package com.mycompany.inventariopapeleria;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jonathan Pedroza Bernal
 */
public class InventarioPapeleria {
    private static Inventario inventario = new Inventario();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }
    
    private static void mostrarMenu() {
        int opcion;

        do {
            System.out.println("------- Menú -------");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Listar productos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        buscarProducto();
                        break;
                    case 3:
                        listarProductos();
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el búfer del scanner
                opcion = 0;
            }
        } while (opcion != 4);
    }

    private static void agregarProducto() {
        try {
            System.out.print("Ingrese el ID del producto: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();

            System.out.print("Ingrese el stock del producto: ");
            int stock = scanner.nextInt();

            Producto producto = new Producto(id, nombre, precio, stock);
            inventario.agregarProducto(producto);

            System.out.println("Producto agregado exitosamente.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese valores válidos.");
            scanner.nextLine(); // Limpiar el búfer del scanner
        }
    }

    private static void buscarProducto() {
        try {
            System.out.print("Ingrese el ID del producto a buscar: ");
            int id = scanner.nextInt();

            Producto producto = inventario.buscarProducto(id);

            if (producto != null) {
                System.out.println("Producto encontrado:");
                System.out.println(producto);
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un ID válido.");
            scanner.nextLine(); // Limpiar el búfer del scanner
        }
    }

    private static void listarProductos() {
        System.out.println("Lista de productos:");
        for (Producto producto : inventario.listarProductos()) {
            System.out.println(producto);
        }
        if (inventario.listarProductos().isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        }
    }
}