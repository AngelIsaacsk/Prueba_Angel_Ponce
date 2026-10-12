package org.example;

public class Libro extends Material implements Reservable {
    private static final double PRECIO_BASE = 3500.0;
    private static final double RECARGO_ESTADO = 1.20;

    private String autor;
    private String estadoConservacion;
    private boolean reservado;

    public Libro(String titulo, int anioPublicacion, int copiasDisponibles, String autor, String estadoConservacion) {
        super(titulo, anioPublicacion, copiasDisponibles);
        setAutor(autor);
        setEstadoConservacion(estadoConservacion);
        this.reservado = false;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser nulo ni vacío.");
        }
        this.autor = autor;
    }

    public String getEstadoConservacion() {
        return estadoConservacion;
    }

    public void setEstadoConservacion(String estadoConservacion) {
        if (estadoConservacion == null || estadoConservacion.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado de conservación no puede ser nulo ni vacío.");
        }
        this.estadoConservacion = estadoConservacion;
    }

    @Override
    public boolean estaReservado() {
        return this.reservado;
    }

    @Override
    public void reservar() {
        this.reservado = true;
    }

    @Override
    public double calcularCostoPrestamo() {
        double costo = PRECIO_BASE;
        if (!"Bueno".equalsIgnoreCase(this.estadoConservacion)) {
            costo *= RECARGO_ESTADO;
        }
        return costo;
    }
}