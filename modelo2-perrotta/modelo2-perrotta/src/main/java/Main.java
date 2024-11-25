import entities.*;
import repositories.InMemoryRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // CREAMOS UN REPOSITORIO PARA CADA CLASE
        InMemoryRepository<Promocion> promocionRepository = new InMemoryRepository<>();
        InMemoryRepository<Articulo> articuloRepository = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepository = new InMemoryRepository<>();
        InMemoryRepository<Imagen> imagenRepository = new InMemoryRepository<>();

        // Crear unidades de medida y guardarlas en el repositorio correspondiente
        UnidadMedida ochoPorciones = UnidadMedida.builder().denominacion("8 porciones").build();
        UnidadMedida cuatroPorciones = UnidadMedida.builder().denominacion("4 porciones").build();
        UnidadMedida unLitro = UnidadMedida.builder().denominacion("1 litro").build();

        unidadMedidaRepository.save(ochoPorciones);
        unidadMedidaRepository.save(cuatroPorciones);
        unidadMedidaRepository.save(unLitro);

        // Crear imagenes y guardarlas en el repositorio correspondiente
        Imagen imagen1 = Imagen.builder().denominacion("Pizza grande Hawaiana").build();
        Imagen imagen2 = Imagen.builder().denominacion("Pizza grande Napolitana").build();
        Imagen imagen3 = Imagen.builder().denominacion("Pizza grande Muzza").build();
        Imagen imagen4 = Imagen.builder().denominacion("Pizza chica Hawaiana").build();
        Imagen imagen5 = Imagen.builder().denominacion("Pizza chica Napolitana").build();
        Imagen imagen6 = Imagen.builder().denominacion("Pizza chica Napo").build();
        Imagen imagen7 = Imagen.builder().denominacion("Cerveza Andes").build();
        Imagen imagen8 = Imagen.builder().denominacion("Cerveza Quilmes").build();
        Imagen imahappy1 = Imagen.builder().denominacion("Promo Happy Hour!").build();
        Imagen imahappy2 = Imagen.builder().denominacion("Promo Happy Hour!").build();
        Imagen verano1 = Imagen.builder().denominacion("Promo Verano!").build();
        Imagen verano2 = Imagen.builder().denominacion("Promo Verano!").build();
        Imagen invierno1 = Imagen.builder().denominacion("Promo Invierno!").build();
        Imagen invierno2 = Imagen.builder().denominacion("Promo Invierno!").build();

        imagenRepository.save(imagen1);
        imagenRepository.save(imagen2);
        imagenRepository.save(imagen3);
        imagenRepository.save(imagen4);
        imagenRepository.save(imagen5);
        imagenRepository.save(imagen6);
        imagenRepository.save(imagen7);
        imagenRepository.save(imagen8);
        imagenRepository.save(imahappy1);
        imagenRepository.save(imahappy2);
        imagenRepository.save(verano1);
        imagenRepository.save(verano2);
        imagenRepository.save(invierno1);
        imagenRepository.save(invierno2);

        // Crear articulos
        // PIZZA GRANDE HAWAIANA
        Articulo pizzaHawaianaGrande = Articulo.builder()
                .denominacion("Pizza grande Hawaiana.")
                .precioVenta(10500D)
                .precioCompra(8900D)
                .stockActual(80)
                .stockMaximo(100)
                .unidadMedida(ochoPorciones)
                .imagen(imagen1)
                .build();
        // PIZZA CHICA HAWAIANA
        Articulo pizzaHawaianaChica = Articulo.builder()
                .denominacion("Pizza chica Hawaiana.")
                .precioVenta(8500D)
                .precioCompra(6950D)
                .stockActual(70)
                .stockMaximo(120)
                .unidadMedida(cuatroPorciones)
                .imagen(imagen4)
                .build();
        // PIZZA GRANDE NAPOLITANA
        Articulo pizzaNapolitanaGrande = Articulo.builder()
                .denominacion("Pizza grande Napolitana")
                .precioVenta(10000D)
                .precioCompra(8500D)
                .stockActual(50)
                .stockMaximo(90)
                .unidadMedida(ochoPorciones)
                .imagen(imagen2)
                .build();
        // PIZZA CHICA NAPOLITANA
        Articulo pizzaNapolitanaChica = Articulo.builder()
                .denominacion("Pizza chica Napolitana")
                .precioVenta(9000D)
                .precioCompra(7900D)
                .stockActual(60)
                .stockMaximo(100)
                .unidadMedida(cuatroPorciones)
                .imagen(imagen5)
                .build();
        // PIZZA GRANDE MUZZA
        Articulo pizzaMuzzaGrande = Articulo.builder()
                .denominacion("Pizza grande Muzza")
                .precioVenta(7500D)
                .precioCompra(5000D)
                .stockActual(90)
                .stockMaximo(150)
                .unidadMedida(ochoPorciones)
                .imagen(imagen3)
                .build();
        // PIZZA CHICA MUZZA
        Articulo pizzaMuzzaChica = Articulo.builder()
                .denominacion("Pizza chica Muzza")
                .precioVenta(6000D)
                .precioCompra(3500D)
                .stockActual(120)
                .stockMaximo(200)
                .unidadMedida(cuatroPorciones)
                .imagen(imagen6)
                .build();
        // CERVEZA ANDES
        Articulo cervezaAndes = Articulo.builder()
                .denominacion("Cerveza Andes")
                .precioVenta(2000D)
                .precioCompra(1500D)
                .stockActual(40)
                .stockMaximo(60)
                .unidadMedida(unLitro)
                .imagen(imagen7)
                .build();
        // CERVEZA QUILMES
        Articulo cervezaQuilmes = Articulo.builder()
                .denominacion("Cerveza Quilmes")
                .precioVenta(2000D)
                .precioCompra(1500D)
                .stockActual(30)
                .stockMaximo(60)
                .unidadMedida(unLitro)
                .imagen(imagen8)
                .build();
        // Guardar articulos en su repositorio
        articuloRepository.save(pizzaHawaianaGrande);
        articuloRepository.save(pizzaHawaianaChica);
        articuloRepository.save(pizzaNapolitanaGrande);
        articuloRepository.save(pizzaNapolitanaChica);
        articuloRepository.save(pizzaMuzzaGrande);
        articuloRepository.save(pizzaMuzzaChica);
        articuloRepository.save(cervezaAndes);
        articuloRepository.save(cervezaQuilmes);

        // Crear promociones
        // PROMO HAPPY HOUR
        Promocion promoHappyHour = Promocion.builder()
                .denominacion("Promocion Happy Hour Mes de la primavera!")
                .fechaDesde(LocalDate.of(2024, 9,1))
                .fechaHasta(LocalDate.of(2024, 9, 30))
                .horaDesde(LocalTime.of(15, 0))
                .horaHasta(LocalTime.of(23,55))
                .descripcionDescuento("Promocion por el mes de la primavera, 20% de descuento pidiendo 1 pizza grande Hawaiana + 1 pizza grande Muzza + 1 cerveza Quilmes.")
                .tipoPromocion(TipoPromocion.happyHour)
                .build();
        promoHappyHour.getPromoImagen().add(imahappy1);
        promoHappyHour.getPromoImagen().add(imahappy2);
        promoHappyHour.getArticulos().add(pizzaHawaianaGrande);
        promoHappyHour.getArticulos().add(pizzaMuzzaGrande);
        promoHappyHour.getArticulos().add(cervezaQuilmes);

        Double precioPromoHappy = 0D;
        for (Articulo art : promoHappyHour.getArticulos()){
            precioPromoHappy += art.getPrecioVenta();
            art.getPromociones().add(promoHappyHour);
        }
        promoHappyHour.setPrecioPromocional(precioPromoHappy * 0.80);
        // Agregar al repositorio
        promocionRepository.save(promoHappyHour);
        // PROMO VERANO
        Promocion promoVerano = Promocion.builder()
                .denominacion("Promocion Happy Hour")
                .fechaDesde(LocalDate.of(2024, 11,12))
                .fechaHasta(LocalDate.of(2025, 2, 24))
                .horaDesde(LocalTime.of(12, 0))
                .horaHasta(LocalTime.of(23,55))
                .descripcionDescuento("Promocion por el mes VERANO, 25% de descuento pidiendo 1 pizza chica Hawaiana + 1 pizza grande Napolitana + 1 cerveza Andes.")
                .tipoPromocion(TipoPromocion.Verano)
                .build();
        promoVerano.getPromoImagen().add(verano1);
        promoVerano.getPromoImagen().add(verano2);
        promoVerano.getArticulos().add(pizzaHawaianaChica);
        promoVerano.getArticulos().add(pizzaNapolitanaGrande);
        promoVerano.getArticulos().add(cervezaAndes);

        Double precioPromoVerano = 0D;
        for (Articulo art : promoVerano.getArticulos()){
            precioPromoVerano += art.getPrecioVenta();
            art.getPromociones().add(promoHappyHour);
        }
        promoVerano.setPrecioPromocional(precioPromoVerano * 0.75);
        // Agregar al repositorio
        promocionRepository.save(promoVerano);
        // PROMO INVIERNO
        Promocion promoInvierno = Promocion.builder()
                .denominacion("Promocion Invierno Feliz!")
                .fechaDesde(LocalDate.of(2025, 5,1))
                .fechaHasta(LocalDate.of(2025, 7, 31))
                .horaDesde(LocalTime.of(12, 0))
                .horaHasta(LocalTime.of(23,55))
                .descripcionDescuento("Promocion por el mes INVIERNO, 15% de descuento pidiendo 1 pizza grande Hawaiana + 1 pizza chica Muzza + 1 cerveza Quilmes.")
                .tipoPromocion(TipoPromocion.Invierno)
                .build();
        promoInvierno.getPromoImagen().add(invierno1);
        promoInvierno.getPromoImagen().add(invierno2);
        promoInvierno.getArticulos().add(pizzaHawaianaGrande);
        promoInvierno.getArticulos().add(pizzaMuzzaChica);
        promoInvierno.getArticulos().add(cervezaQuilmes);

        Double precioInvierno = 0D;
        for (Articulo art : promoInvierno.getArticulos()){
            precioInvierno += art.getPrecioVenta();
            art.getPromociones().add(promoHappyHour);
        }
        promoInvierno.setPrecioPromocional(precioInvierno * 0.85);
        // Agregar al repositorio
        promocionRepository.save(promoInvierno);

        // Mostrar promociones
        System.out.println("--PROMOCIONES--");
        List<Promocion> todasPromos = promocionRepository.findAll();
        todasPromos.forEach(System.out::println);

        // Mostrar articulos
        System.out.println("--ARTICULOS--");
        List<Articulo> todosArticulos = articuloRepository.findAll();
        todosArticulos.forEach(System.out::println);

        // Mostrar promos por separado
        System.out.println("--DETALLE PROMOCIONES--");
        for (Promocion promo : promocionRepository.findAll()) {
            System.out.println("PROMOCION " + promo.getId() +
                    "\nNombre: " + promo.getDenominacion() +
                    "\nDescripcion: " + promo.getDescripcionDescuento() +
                    "\nArticulos: " + listarArticulos(promo.getArticulos()) +
                    "\nPrecio: " + promo.getPrecioPromocional() +
                    "\n------------------------------------");
        }

        // Dia y horario de la promo verano
        System.out.println("--DETALLE FECHA PROMO VERANO--");
        Optional<Promocion> promocionVerano = promocionRepository.findById(2L);
        promocionVerano.ifPresent(promocion -> System.out.println("-Nombre: " + promocion.getDenominacion()
                + "\n -Desde: " + promocion.getFechaDesde()
                + "\n -Hasta: " + promocion.getFechaHasta()
                + "\n -Hora Inicio: " + promocion.getHoraDesde()
                + "\n -Hora Fin: " + promocion.getHoraHasta()));

        // Promo mas economica
        System.out.println("--PROMO MAS ECONOMICA--");
        double economica = 0;
        long id = 0;
        for (Promocion promo : todasPromos) {
            if (promo.getPrecioPromocional() < economica || id == 0) {
                economica = promo.getPrecioPromocional();
                id = promo.getId();
            }
        }
        promocionRepository.findById(id).ifPresent(promo -> System.out.println("La promocion mas economica es:\n"
                + promo.getDenominacion()
                + "\nPrecio: $" + promo.getPrecioPromocional()));
    }
    public static String listarArticulos (Set<Articulo> articulos) {
         String detalle = "";
         for (Articulo art : articulos) {
             detalle += art.getDenominacion() + " ";
         }
         return detalle;
    }
}
