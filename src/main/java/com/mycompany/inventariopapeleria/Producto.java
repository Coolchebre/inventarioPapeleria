package com.mycompany.inventariopapeleria;

/**
 *
 * @author Jonathan Pedroza Bernal
 */
public class Producto {
    // Atributos de la clase Producto
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    
    // Constructor de la clase Producto
    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    // Métodos Getters y Setters para los atributos

    /**
     * Obtiene el ID del producto.
     *
     * @return El ID del producto.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * Obtiene el stock actual del producto.
     *
     * @return El stock actual del producto.
     */
    public int getStock() {
        return stock;
    }
    
    /**
     * Establece el stock actual del producto.
     *
     * @param stock El nuevo stock del producto.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    // Otros métodos de la clase Producto

    /**
     * Actualiza el stock del producto sumando la cantidad especificada.
     *
     * @param cantidad La cantidad a sumar al stock (debe ser mayor o igual a cero).
     * @throws IllegalArgumentException Si la cantidad es negativa.
     */
    public void actualizarStock(int cantidad) {
        if (cantidad >= 0) {
            stock += cantidad;
        } else {
            throw new IllegalArgumentException("La cantidad debe ser mayor o igual a cero.");
        }
    }

    /**
     * Intenta vender una cantidad específica del producto.
     *
     * @param cantidad La cantidad a vender.
     * @return true si la venta fue exitosa, false si no hay suficiente stock.
     */
    public boolean vender(int cantidad) {
        if (cantidad > 0 && cantidad <= stock) {
            stock -= cantidad;
            return true; // Venta exitosa
        } else {
            return false; // No hay suficiente stock para la venta
        }
    }

    /**
     * Calcula el valor total del inventario de este producto.
     *
     * @return El valor total del inventario (precio * stock).
     */
    public double calcularValorInventario() {
        return precio * stock;
    }

    /**
     * Verifica si el producto está agotado (sin stock).
     *
     * @return true si el stock es cero, false de lo contrario.
     */
    public boolean estaAgotado() {
        return stock == 0;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio + ", Stock: " + stock;
    }
}