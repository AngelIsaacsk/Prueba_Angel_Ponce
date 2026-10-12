package org.example;

public abstract class Material {
    private String titulo;
    private int anioPublicacion;
    private int copiasDisponibles;

    public Material(String titulo, int anioPublicacion, int copiasDisponibles) {
        setTitulo(titulo);
        setAnioPublicacion(anioPublicacion);
        setCopiasDisponibles(copiasDisponibles);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo ni vacío.");
        }
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion < 1450 || anioPublicacion > 2026) {
            throw new IllegalArgumentException("El año de publicación debe encontrarse en el rango entre 1450 y 2026.");
        }
        this.anioPublicacion = anioPublicacion;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        if (copiasDisponibles <= 0) {
            throw new IllegalArgumentException("Las copias disponibles deben ser un valor mayor que cero.");
        }
        this.copiasDisponibles = copiasDisponibles;
    }

    public abstract double calcularCostoPrestamo();

    @Override
    public String toString() {
        return "Titulo: " + titulo + " | Año: " + anioPublicacion;
    }
}