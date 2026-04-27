package cl.sda1085.productos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductoRequestDTO {

    //ID se genera automáticamente

    @NotBlank(message = "El nombre NO debe estar vacío.")
    private String nombre;

    @NotBlank(message = "El autor NO debe estar vacío.")
    private String autor;

    @NotBlank(message = "La descripción NO debe estar vacía.")
    private String descripcion;

    @NotBlank(message = "El período NO debe estar vacío.")
    private String periodo;

    @NotBlank(message = "La técnica NO debe estar vacía.")
    private String tecnica;

    @NotBlank(message = "Las dimensiones NO deben estar vacías.")
    private String dimensiones;

    @NotNull(message = "El precio base es obligatorio.")
    @Positive(message = "El precio base debe ser mayor a cero,")
    private BigDecimal precioBase;

    @NotBlank(message = "El estado de autenticidad NO debe estar vacío.")
    private String estadoAutenticidad;

    @NotBlank(message = "La URL de la imagen NO debe estar vacío.")
    @URL(message = "La URL de la imagen debe ser un formato de link válido.")
    private String urlImagen;

    @NotNull(message = "El ID de categoría es obligatorio.")
    @Positive(message = "El ID de categoría debe ser mayor a cero.")
    private Long idCategoria;

    @NotNull(message = "El ID del vendedor es obligatorio.")
    @Positive(message = "El ID del vendedor debe ser mayor a cero.")
    private Long idVendedor;
}
