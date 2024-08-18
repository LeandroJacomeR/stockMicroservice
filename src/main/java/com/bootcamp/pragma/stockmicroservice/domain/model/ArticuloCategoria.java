package com.bootcamp.pragma.stockmicroservice.domain.model;

public class ArticuloCategoria {
    private Long id;
    private Articulo articulo;
    private Category categoria;

    public ArticuloCategoria(Long id, Articulo articulo, Category categoria) {
        this.id = id;
        this.articulo = articulo;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
    }
}
