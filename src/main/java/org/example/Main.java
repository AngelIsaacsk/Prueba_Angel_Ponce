package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();

        try {
            // 1. Instanciación según la tabla de datos
            Libro libro1 = new Libro("Cien Años de Soledad", 1967, 5, "Gabriel García Márquez", "Bueno");
            Libro libro2 = new Libro("El Principito", 1943, 3, "Antoine de Saint-Exupéry", "Deteriorado");
            AudioLibro audio1 = new AudioLibro("Cien Años de Soledad", 1967, 2, 620);
            AudioLibro audio2 = new AudioLibro("Sapiens", 2011, 4, 480);

            // 2. Registro en el gestor con mensaje en consola
            gestor.registrarMaterial(libro1);
            System.out.println(libro1.getTitulo() + " (Libro) registrado correctamente.");

            gestor.registrarMaterial(libro2);
            System.out.println(libro2.getTitulo() + " (Libro) registrado correctamente.");

            gestor.registrarMaterial(audio1);
            System.out.println(audio1.getTitulo() + " (AudioLibro) registrado correctamente.");

            gestor.registrarMaterial(audio2);
            System.out.println(audio2.getTitulo() + " (AudioLibro) registrado correctamente.");

            // 3. Marcar libro como reservado
            libro1.reservar();

            // 4. Búsqueda por título
            System.out.println("\n*** BUSQUEDA POR TITULO: \"Cien Años de Soledad\" ***");
            List<Material> resultados = gestor.buscarPorTitulo("Cien Años de Soledad");

            for (Material material : resultados) {
                if (material instanceof Libro) {
                    Libro libro = (Libro) material;
                    System.out.println(
                            "Tipo: Libro | Titulo: " + libro.getTitulo() +
                                    " | Año: " + libro.getAnioPublicacion() +
                                    " | Copias: " + libro.getCopiasDisponibles() +
                                    " | Autor: " + libro.getAutor() +
                                    " | Estado: " + libro.getEstadoConservacion() +
                                    " | Reserva: " + (libro.estaReservado() ? "Reservado" : "Disponible") +
                                    " | Costo préstamo: $" + String.format("%.0f", libro.calcularCostoPrestamo())
                    );
                    System.out.println("---");
                } else if (material instanceof AudioLibro) {
                    AudioLibro audio = (AudioLibro) material;
                    System.out.println(
                            "Tipo: Audio Libro | Titulo: " + audio.getTitulo() +
                                    " | Año: " + audio.getAnioPublicacion() +
                                    " | Copias: " + audio.getCopiasDisponibles() +
                                    " | Duracion: " + audio.getDuracionMinutos() + " min" +
                                    " | Costo prestamo: $" + String.format("%.0f", audio.calcularCostoPrestamo())
                    );
                    System.out.println("---");
                }
            }

            // 5. Listado de todos los materiales usando su método toString()
            System.out.println("\n*** LISTADO DE MATERIALES ***");
            for (Material material : gestor.listaMateriales()) {
                System.out.println(material);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los datos: " + e.getMessage());
        }
    }
}