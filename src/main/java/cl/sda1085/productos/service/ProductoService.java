package cl.sda1085.productos.service;

import cl.sda1085.productos.dto.ProductoRequestDTO;
import cl.sda1085.productos.dto.ProductoResponseDTO;
import cl.sda1085.productos.model.Producto;
import cl.sda1085.productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Optional<ProductoResponseDTO> obtenerPorId(Long id){  //'Optional' permite contener un objeto que puede o no ser nulo
        return productoRepository.findById(id).map(this::mapToDTO);
    }

    //Guardar
    public ProductoResponseDTO guardar(ProductoRequestDTO dto){
        Producto producto = new Producto(
                null,
                dto.getNombre(),
                dto.getAutor(),
                dto.getDescripcion(),
                dto.getPeriodo(),
                dto.getTecnica(),
                dto.getDimensiones(),
                dto.getPrecioBase(),
                dto.getEstadoAutenticidad(),
                dto.getUrlImagen(),
                dto.getIdCategoria(),
                dto.getIdVendedor()
        );
        return mapToDTO(productoRepository.save(producto));
    }
    //Actualizar
    //Eliminar
}
