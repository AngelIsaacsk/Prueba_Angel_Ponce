package org.example;

import java.util.ArrayList;
import java.util.List;

public class GestorBiblioteca {
    private List<Material> coleccion;

    public GestorBiblioteca() {
        this.coleccion = new ArrayList<>();
    }

    public void registrarMaterial(Material material) {
        if (material == null) {
            throw new IllegalArgumentException("El material no puede ser nulo.");
        }
        coleccion.add(material);
    }

    public List<Material> buscarPorTitulo(String titulo) {
        List<Material> resultados = new ArrayList<>();

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título de búsqueda no puede estar vacío.");
        }

        for (Material m : coleccion) {
            if (m.getTitulo().equalsIgnoreCase(titulo.trim())) {
                resultados.add(m);
            }
        }
        return resultados;
    }

    public List<Material> listaMateriales() {
        return new ArrayList<>(coleccion);
    }
}

