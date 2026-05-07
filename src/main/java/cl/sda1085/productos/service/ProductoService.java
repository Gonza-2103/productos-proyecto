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

    //Método de apoyo para encapsulamiento de datos
    private ProductoResponseDTO mapToDTO(Producto producto){
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getAutor(),
                producto.getDescripcion(),
                producto.getPrecioBase(),
                producto.getIdCategoria(),
                producto.getIdVendedor()
        );
    }

    //Método auxiliar de conversión (reutilizable)
    private ProductoResponseDTO convertirADTO(Producto producto){
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getAutor(),
                producto.getDescripcion(),
                producto.getPrecioBase(),
                producto.getIdCategoria(),
                producto.getIdVendedor()
        );
    }

    //CRUD estándar

    //Obtener todos los productos
    public List<ProductoResponseDTO> obtenerTodos(){
        return productoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    //Obtener producto por ID
    public Optional<ProductoResponseDTO> obtenerPorId(Long id){  //'Optional' permite contener un objeto que puede o no ser nulo
        return productoRepository.findById(id).map(this::mapToDTO);
    }

    //Crear (guardar) nuevo producto
    public ProductoResponseDTO guardar(ProductoRequestDTO dto){
        if (productoRepository.existsByNombreAndIdVendedor(dto.getNombre(), dto.getIdVendedor())){
            throw new RuntimeException("Ya tienes un producto registrado con este nombre.");
        }

        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecioBase(dto.getPrecioBase());
        producto.setIdCategoria(dto.getIdCategoria());
        producto.setIdVendedor(dto.getIdVendedor());

        //Guardar en la base de datos
        Producto productoGuardado = productoRepository.save(producto);

        //Devolver la respuesta como DTO
        return convertirADTO(productoGuardado);
    }

    //Actualizar producto existente
    public Optional<ProductoResponseDTO> actualizar(Long id, ProductoRequestDTO dto){
        return productoRepository.findById(id).map(productoDisponible -> {
            productoDisponible.setNombre(dto.getNombre());
            productoDisponible.setDescripcion(dto.getDescripcion());
            productoDisponible.setPrecioBase(dto.getPrecioBase());
            productoDisponible.setIdCategoria(dto.getIdCategoria());

            return mapToDTO(productoRepository.save(productoDisponible));
        });
    }

    //Eliminar producto
    public void eliminar(Long id){
        productoRepository.deleteById(id);
    }


    //CRUD personalizado

    //Buscar producto por nombre
    public List<ProductoResponseDTO> buscarPorNombre(String nombre){
        return productoRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    //Buscar producto por ID de categoría
    public List<ProductoResponseDTO> buscarPorIdCategoria(Long idCategoria){
        return productoRepository.findByIdCategoria(idCategoria).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    //Buscar el producto más caro del catálogo
    public Optional<ProductoResponseDTO> obtenerProductoMasCaro(){
        return productoRepository.findTopByOrderByPrecioBaseDesc()
                .map(this::mapToDTO);
    }

    //Verificar duplicados de producto para un mismo vendedor
    public boolean existeProductoDuplicado(String nombre, Long idVendedor){
        return productoRepository.existsByNombreAndIdVendedor(nombre, idVendedor);
    }

    //Contar cuántos productos tiene un vendedor específico
    public long contarProductosDeVendedor(Long idVendedor){
        return productoRepository.countByIdVendedor(idVendedor);
    }
}
