package com.example.Celda;

public class Celda {
    private Celda anterior;
    private Celda siguiente;
    private Integer valor;

    public Celda getAnterior() {
        return anterior;
    }

    public void setAnterior(Celda anterior) {
        this.anterior = anterior;
    }

    public Celda getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Celda siguiente) {
        this.siguiente = siguiente;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Celda(Integer valor) {
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
    }

    

    @Override
    public String toString() {
        return super.toString();
    }
    
}
