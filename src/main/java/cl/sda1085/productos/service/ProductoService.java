package cl.sda1085.productos.service;

import cl.sda1085.productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ProductoService {

    //Vínculo con 'repository'
    private final ProductoRepository productoRepository;


}
