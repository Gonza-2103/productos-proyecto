package cl.sda1085.productos.repository;

import cl.sda1085.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    //Buscar nombre del producto
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    //Buscar por categoria
    List<Producto> findByIdCategoria(Long idCategoria);

    //Buscar el producto más caro del catálogo
    Optional<Producto> findTopByOrderByPrecioBaseDesc();

    //Verificar duplicados de producto para un mismo vendedor
    boolean existsByNombreAndIdVendedor(String nombre, Long idVendedor);

    //Contar cuántos productos tiene un vendedor específico
    long countByIdVendedor(Long idVendedor);
}
