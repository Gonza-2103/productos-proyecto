package cl.sda1085.productos.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component

public class ProductoClient {

    private final WebClient webClientProductos;

    public ProductoClient(
            @Value("${productos-services.url}") String urlProductos) {

        this.webClientProductos = WebClient.builder().baseUrl(urlProductos).build();}



}
