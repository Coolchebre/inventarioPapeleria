package com.mycompany.inventariopapeleria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan Pedroza Bernal
 */
public class Inventario {
    // Atributo para almacenar la lista de productos
    private List<Producto> productos;
    
    // Constructor de la clase Inventario
    public Inventario() {
        productos = new ArrayList<>(); // Inicializar la lista de productos
    }
    
    // Método para agregar un producto a la lista
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }
    
    // Método para buscar un producto por su ID en la lista
    public Producto buscarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto; // Devolver el producto si se encuentra
            }
        }
        return null; // Si no se encuentra el producto
    }
    
    // Método para obtener la lista completa de productos
    public List<Producto> listarProductos() {
        return productos;
    }
}