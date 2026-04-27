package cl.sda1085.productos.dto;

//No hay anotaciones de validación.
//DTO de salida.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductoResponseDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String autor;
    private String periodo;
    private String tecnica;
    private String dimensiones;
    private BigDecimal precioBase;
    private String estadoAutenticidad;
    private String urlImagen;
    private Long idCategoria;
    private Long idVendedor;
}
