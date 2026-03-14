package model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Clase modelo que representa una reserva de un espacio de coworking.
 * Esta clase se mapea a la tabla "reservas" de la base de datos usando JPA.
 */
@Entity // Define Una Clase Como Entidad
@Table(name = "reservas") // Nombre de la tabla en Base de datos
public class Reserva {
    // Atributo Id Autoincrementable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // No puede ser falsa y nombre de la columna
    private String nombre;

    @Column(nullable = false) // No puede ser falsa y nombre de la columna
    private String espacio;

    @Column(nullable = false) // No puede ser falsa y nombre de la columna
    private Integer duracion;

    @Column(nullable = false) // No puede ser falsa y el nombre de la columna
    private LocalDate fecha;

    // Constructor vacio
    public Reserva() {
    }

    // Constructor Con Argumentos
    public Reserva(String nombre, String espacio, Integer duracion, LocalDate fecha) {
        this.nombre = nombre;
        this.espacio = espacio;
        this.duracion = duracion;
        this.fecha = fecha;
    }


    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
