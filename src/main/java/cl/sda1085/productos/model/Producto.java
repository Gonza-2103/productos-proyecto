package cl.sda1085.productos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "productos")

public class Producto {
    //comentario de prueba

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false, length = 50)  //Nombre del artista o fabricante de la antigüedad
    private String autor;

    @Column(nullable = false, length = 30)  //Epoca de creación
    private String periodo;

    @Column(nullable = false, length = 50)
    private String tecnica;

    @Column(nullable = false, length = 30)
    private String dimensiones;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal precioBase;

    @Column(nullable = false, length = 10)  //Pendiente, validado o rechazado
    private String estadoAutenticidad;

    @Column(nullable = false)
    private String urlImagen;

    @Column(name = "id_categoria", nullable = false)  //Relación lógica con el microservicio 'categorías'
    private Long idCategoria;

    @Column(nullable = false)
    private Long idVendedor;
}
