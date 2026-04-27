package cl.sda1085.productos.service;

import cl.sda1085.productos.dto.ProductoResponseDTO;
import cl.sda1085.productos.model.Producto;
import cl.sda1085.productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductoService {

    //Vínculo con 'repository'
    private final ProductoRepository productoRepository;

    private ProductoResponseDTO mapToDTO(Producto producto){
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getAutor(),
                producto.getPeriodo(),
                producto.getTecnica(),
                producto.getDimensiones(),
                producto.getPrecioBase(),
                producto.getEstadoAutenticidad(),
                producto.getUrlImagen(),
                producto.getIdCategoria(),
                producto.getIdVendedor()
        );
    }

    //Obtener todos
    public List<ProductoResponseDTO> obtenerTodos(){
        return productoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    //Obtener por ID
    //Guardar
    //Actualizar
    //Eliminar
}
