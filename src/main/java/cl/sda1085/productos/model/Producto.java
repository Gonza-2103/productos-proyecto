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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)  //Detalle sobre el producto
    private String descripcion;

    @Column(nullable = false, length = 40)  //Nombre del artista o fabricante de la antigüedad
    private String autor;

    @Column(nullable = false, length = 30)  //Época de creación
    private String periodo;

    @Column(nullable = false, length = 50)  //Materiales utilizados
    private String tecnica;

    @Column(nullable = false, length = 30)  //Medidas físicas del producto
    private String dimensiones;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioBase;

    @Column(nullable = false, length = 10)  //Validación de autenticidad: Pendiente, validado o rechazado
    private String estadoAutenticidad;

    @Column(nullable = false, length = 500)  //Enlace a la fotografía del producto
    private String urlImagen;

    @Column(name = "id_categoria", nullable = false)  //Relación (vínculo) lógica con el microservicio 'categorías'
    private Long idCategoria;

    @Column(nullable = false)  //ID del usuario que pone la obra en subasta
    private Long idVendedor;
}
