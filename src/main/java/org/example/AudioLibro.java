package org.example;

public class AudioLibro extends Material {
    private static final double PRECIO_BASE = 2800.0;
    private static final double RECARGO_DURACION = 1.15;

    private int duracionMinutos;

    public AudioLibro(String titulo, int anioPublicacion, int copiasDisponibles, int duracionMinutos) {
        super(titulo, anioPublicacion, copiasDisponibles);
        setDuracionMinutos(duracionMinutos);
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duración en minutos debe ser mayor que cero.");
        }
        this.duracionMinutos = duracionMinutos;
    }

    @Override
    public double calcularCostoPrestamo() {
        double costo = PRECIO_BASE;
        if (this.duracionMinutos > 300) {
            costo *= RECARGO_DURACION;
        }
        return costo;
    }
}