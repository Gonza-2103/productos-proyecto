package cl.sda1085.productos.config;


import cl.sda1085.productos.model.Producto;
import cl.sda1085.productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor

public class DataInitializer implements CommandLineRunner {

    private final ProductoRepository productoRepository;

    @Override
    public void run (String... args) {

        //Verificar si existen productos para no duplicarlos
        if (productoRepository.count()>0) {
            log.info("Base de datos de productos ya contiene datos. Omitiendo inicialización");

        }

        log.info("Iniciando la creación de productos de prueba...");


        //Crear productos para la base de datos
        Producto p1 = new Producto(null, "Vasija Precolombina",
                "Cultura Mapuche",
                "Vasija ceremonial utilizada en rituales",
                "Siglo XV",
                "Cerámica",
                "30cm x 20cm",
                new BigDecimal("150000"),
                "Pendiente",
                "https://ejemplo.com/vasija.jpg",
                1L,
                100L );

        Producto p2 = new Producto(
                null,
                "Espada Medieval",
                "Desconocido",
                "Espada de combate con empuñadura de cuero",
                "Siglo XII",
                "Acero y cuero",
                "90cm",
                new BigDecimal("300000"),
                "Validado",
                "https://ejemplo.com/espada.jpg",
                2L,
                101L
        );

        Producto p3 = new Producto(
                null,
                "Pintura Colonial",
                "Autor Anónimo",
                "Retrato de época colonial",
                "Siglo XVIII",
                "Óleo sobre tela",
                "60cm x 40cm",
                new BigDecimal("500000"),
                "Pendiente",
                "https://ejemplo.com/pintura.jpg",
                3L,
                102L);

        Producto p4 = new Producto(
                null,
                "Máscara Tribal Africana",
                "Tribu Yoruba",
                "Máscara ceremonial utilizada en rituales espirituales",
                "Siglo XIX",
                "Madera tallada",
                "50cm x 25cm",
                new BigDecimal("220000"),
                "Pendiente",
                "https://ejemplo.com/mascara.jpg",
                1L,
                103L
        );

        Producto p5 = new Producto(
                null,
                "Reloj de Bolsillo Antiguo",
                "Omega",
                "Reloj mecánico de bolsillo en perfecto estado",
                "1900",
                "Oro y vidrio",
                "5cm diámetro",
                new BigDecimal("400000"),
                "Validado",
                "https://ejemplo.com/reloj.jpg",
                2L,
                104L
        );

        Producto p6 = new Producto(
                null,
                "Escultura de Mármol",
                "Miguel Ángel (réplica)",
                "Réplica detallada de escultura renacentista",
                "Siglo XVI",
                "Mármol",
                "70cm",
                new BigDecimal("350000"),
                "Pendiente",
                "https://ejemplo.com/escultura.jpg",
                3L,
                105L
        );

        Producto p7 = new Producto(
                null,
                "Libro Antiguo",
                "Autor Desconocido",
                "Libro histórico con encuadernación original",
                "Siglo XVIII",
                "Papel y cuero",
                "25cm x 15cm",
                new BigDecimal("180000"),
                "Pendiente",
                "https://ejemplo.com/libro.jpg",
                1L,
                106L
        );

        Producto p8 = new Producto(
                null,
                "Moneda Romana",
                "Imperio Romano",
                "Moneda de bronce con inscripciones originales",
                "Siglo I",
                "Bronce",
                "3cm",
                new BigDecimal("270000"),
                "Validado",
                "https://ejemplo.com/moneda.jpg",
                2L,
                107L
        );

        Producto p9 = new Producto(
                null,
                "Jarrón Chino Antiguo",
                "Dinastía Ming",
                "Jarrón decorativo con detalles pintados a mano",
                "Siglo XV",
                "Porcelana",
                "40cm",
                new BigDecimal("600000"),
                "Pendiente",
                "https://ejemplo.com/jarron.jpg",
                3L,
                108L
        );

        Producto p10 = new Producto(
                null,
                "Cámara Fotográfica Vintage",
                "Kodak",
                "Cámara analógica en funcionamiento",
                "1950",
                "Metal y plástico",
                "15cm x 10cm",
                new BigDecimal("210000"),
                "Validado",
                "https://ejemplo.com/camara.jpg",
                2L,
                109L
        );

        Producto p11 = new Producto(
                null,
                "Tapiz Medieval",
                "Taller Europeo",
                "Tapiz decorativo con escenas de caza",
                "Siglo XIV",
                "Lana y lino",
                "200cm x 150cm",
                new BigDecimal("520000"),
                "Pendiente",
                "https://ejemplo.com/tapiz.jpg",
                1L,
                110L
        );

        Producto p12 = new Producto(
                null,
                "Anillo Victoriano",
                "Joyero Anónimo",
                "Anillo antiguo con incrustaciones de piedras",
                "Siglo XIX",
                "Oro y amatista",
                "Talla 7",
                new BigDecimal("310000"),
                "Validado",
                "https://ejemplo.com/anillo.jpg",
                2L,
                111L
        );

        Producto p13 = new Producto(
                null,
                "Mapa Antiguo de América",
                "Cartógrafo Europeo",
                "Mapa detallado previo a divisiones modernas",
                "1700",
                "Papel pergamino",
                "60cm x 45cm",
                new BigDecimal("450000"),
                "Pendiente",
                "https://ejemplo.com/mapa.jpg",
                3L,
                112L
        );

        Producto p14 = new Producto(
                null,
                "Armadura Samurai",
                "Artesano Japonés",
                "Armadura tradicional completa",
                "Siglo XVII",
                "Hierro y seda",
                "Tamaño adulto",
                new BigDecimal("800000"),
                "Validado",
                "https://ejemplo.com/armadura.jpg",
                2L,
                113L
        );

        Producto p15 = new Producto(
                null,
                "Caja Musical Antigua",
                "Francia",
                "Caja musical funcional con melodía clásica",
                "Siglo XIX",
                "Madera y metal",
                "20cm x 10cm",
                new BigDecimal("260000"),
                "Pendiente",
                "https://ejemplo.com/cajamusical.jpg",
                1L,
                114L
        );

        Producto p16 = new Producto(
                null,
                "Lámpara de Aceite",
                "Imperio Otomano",
                "Lámpara decorativa de uso doméstico",
                "Siglo XVIII",
                "Bronce",
                "25cm",
                new BigDecimal("190000"),
                "Pendiente",
                "https://ejemplo.com/lampara.jpg",
                3L,
                115L
        );

        Producto p17 = new Producto(
                null,
                "Busto Romano",
                "Escultor Desconocido",
                "Escultura representando figura romana",
                "Siglo II",
                "Mármol",
                "45cm",
                new BigDecimal("670000"),
                "Validado",
                "https://ejemplo.com/busto.jpg",
                2L,
                116L
        );

        Producto p18 = new Producto(
                null,
                "Espejo Antiguo",
                "Italia",
                "Espejo con marco ornamentado",
                "Siglo XVIII",
                "Madera y vidrio",
                "80cm x 50cm",
                new BigDecimal("340000"),
                "Pendiente",
                "https://ejemplo.com/espejo.jpg",
                1L,
                117L
        );

        Producto p19 = new Producto(
                null,
                "Pluma Estilográfica Vintage",
                "Montblanc",
                "Pluma de colección en excelente estado",
                "1950",
                "Resina y metal",
                "14cm",
                new BigDecimal("230000"),
                "Validado",
                "https://ejemplo.com/pluma.jpg",
                3L,
                118L
        );

        Producto p20 = new Producto(
                null,
                "Baúl Antiguo",
                "Europa",
                "Baúl de viaje con herrajes originales",
                "Siglo XIX",
                "Madera y hierro",
                "90cm x 50cm",
                new BigDecimal("380000"),
                "Pendiente",
                "https://ejemplo.com/baul.jpg",
                2L,
                119L
        );

        productoRepository.saveAll(List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
                                            p11,p12,p13,p14,p15,p16,p17,p18,p19,p20));

        log.info("Productos creados correctamente");

    }


}
