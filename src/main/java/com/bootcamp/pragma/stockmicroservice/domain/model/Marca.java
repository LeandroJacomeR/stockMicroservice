package com.bootcamp.pragma.stockmicroservice.domain.model;

public class Marca {
    private String nombre;
    private String descripcion;

    public Marca(String nombre, String descripcion) {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
