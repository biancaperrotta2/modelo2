package org.example;

import modelos.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenciaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        //creo la enumeracion tipo promocion con sus 3 elementos:
//        //HAPPY HOUR
//        Promocion promocion = new Promocion();
//        promocion.setDenominacion("happyHour");
//        promocion.setTipoPromocion(TipoPromocion.happyHour);
//        //VERANO
//        promocion.setDenominacion("verano");
//        promocion.setTipoPromocion(TipoPromocion.Verano);
//        //INVIERNO
//        promocion.setDenominacion("invierno");
//        promocion.setTipoPromocion(TipoPromocion.Invierno);
//        entityManager.getTransaction().begin();

        //creo las unidades de medida
        UnidadMedida ochoPorciones = new UnidadMedida().builder().denominacion("Ocho porciones").build();
        UnidadMedida cuatroPorciones = new UnidadMedida().builder().denominacion("Cuatro porciones").build();
        UnidadMedida unLitro = new UnidadMedida().builder().denominacion("Un litro").build();

        //creo las imagenes para las 3 variedades de pizzas y tamaños
        Imagen imagen1 = new Imagen().builder().denominacion("Pizza grande hawaiana").build();
        Imagen imagen2 = new Imagen().builder().denominacion("Pizza grande napolitana").build();
        Imagen imagen3 = new Imagen().builder().denominacion("Pizza grande muzza").build();
        Imagen imagen4 = new Imagen().builder().denominacion("Pizza chica hawaiana").build();
        Imagen imagen5 = new Imagen().builder().denominacion("Pizza chica napolitana").build();
        Imagen imagen6 = new Imagen().builder().denominacion("Pizza chica muzza").build();
        Imagen imagen7 = new Imagen().builder().denominacion("Cerveza Andes").build();
        Imagen imagen8 = new Imagen().builder().denominacion("Cervez Quilmes").build();
        Imagen imahappy1 = new Imagen().builder().denominacion("Happy Hour").build();
        Imagen imahappy2 = new Imagen().builder().denominacion("Happy Hour").build();
        Imagen verano1 = new Imagen().builder().denominacion("Verano").build();
        Imagen verano2 = new Imagen().builder().denominacion("Verano").build();
        Imagen invierno1 = new Imagen().builder().denominacion("Invierno").build();
        Imagen invierno2 = new Imagen().builder().denominacion("Invierno").build();
        Imagen cerveza1 = new Imagen().builder().denominacion("Cerveza Andes").build();
        Imagen cerveza2 = new Imagen().builder().denominacion("Cerveza Quilmes").build();

        //creo articulos y los relaciono con sus imagenes
        Articulo pizzaGrandeHawaiana = new Articulo().builder()
                .denominacion("Pizza grande hawaiana")
                .precioCompra(3.000)
                .precioVenta(9.000)
                .stockActual(50)
                .stockMaximo(100)
                .unidadMedida(ochoPorciones)
                .build();
        Articulo pizzaChicaHawaiana = new Articulo().builder()
                .denominacion("Pizza chica hawaiana")
                .precioCompra(1.000)
                .precioVenta(3.000)
                .stockActual(50)
                .stockMaximo(100)
                .unidadMedida(cuatroPorciones)
                .build();

        Articulo pizzaGrandeNapolitana = new Articulo().builder()
                .denominacion("Pizza grande napolitana")
                .precioCompra(2.000)
                .precioVenta(8.000)
                .stockActual(50)
                .stockMaximo(100)
                .unidadMedida(ochoPorciones)
                .build();

        Articulo pizzaChicaNapolitana = new Articulo().builder()
                .denominacion("Pizza chica napolitana")
                .precioCompra(700.0)
                .precioVenta(2.100)
                .stockActual(50)
                .stockMaximo(100)
                .unidadMedida(cuatroPorciones)
                .build();

        Articulo pizzaGrandeMuzza = new Articulo().builder()
                .denominacion("Pizza grande muzza")
                .precioCompra(1.000)
                .precioVenta(3.000)
                .stockActual(50)
                .stockMaximo(100)
                .unidadMedida(ochoPorciones)
                .build();

        Articulo pizzaChicaMuzza = new Articulo().builder()
                .denominacion("Pizza chica muzza")
                .precioCompra(500.0)
                .precioVenta(1.500)
                .stockActual(50)
                .stockMaximo(100)
                .unidadMedida(cuatroPorciones)
                .build();
        

        Articulo cervezaAndes = new Articulo().builder()
                .denominacion("Cerveza Andes")
                .precioCompra(1.000)
                .precioVenta(2.500)
                .stockActual(50)
                .stockMaximo(100)
                .unidadMedida(unLitro)
                .build();

            Articulo cervezaQuilmes = new Articulo().builder()
                .denominacion("Cerveza Quilmes")
                .precioCompra(1.500)
                .precioVenta(2.700)
                .stockActual(50)
                .stockMaximo(100)
                .unidadMedida(unLitro)
                .build();

            //creo las promociones HAPPY HOUR y las relaciono con sus articulos e imagenes
            Promocion happyHour = new Promocion().builder()
                    .denominacion("Happy Hour")
                    .descripcionDescuento("1 Pizza grande Hawaiana,  1 Pizza grande Muzza, 1 Cerveza Quilmes")
                    .FechaDesde(LocalDate.now())
                    .FechaHasta(LocalDate.now())
                    .HoraDesde(LocalTime.now())
                    .HoraHasta(LocalTime.now())
                    .precioPromocional(13.000)
                    .build();
            
            //relacion con articulos e imagenes
            happyHour.getArticulos().add(pizzaGrandeHawaiana);
            happyHour.getArticulos().add(pizzaGrandeMuzza);
            happyHour.getArticulos().add(cervezaQuilmes);
            happyHour.getPromoImagen().add(imahappy1);

            //creo la promocion verano y la relaciono con articulos e imagen
            Promocion verano = new Promocion().builder()
                    .denominacion("Verano")
                    .descripcionDescuento("1 Pizza chica Hawaiana,  1 Pizza grande Napolitana, 1 Cerveza Quilmes y 1 Cerveza Andes")
                    .FechaDesde(LocalDate.now())
                    .FechaHasta(LocalDate.now())
                    .HoraDesde(LocalTime.now())
                    .HoraHasta(LocalTime.now())
                    .precioPromocional(14.000)
                    .build();

            //relacion con articulos e imagen
            verano.getArticulos().add(pizzaChicaHawaiana);
            verano.getArticulos().add(pizzaGrandeNapolitana);
            verano.getArticulos().add(cervezaAndes);
            verano.getArticulos().add(cervezaQuilmes);
            verano.getPromoImagen().add(verano1);

            //creo la promocion invierno y la relaciono con articulos e imagen
            Promocion invierno = new Promocion().builder()
                    .denominacion("Invierno")
                    .descripcionDescuento("1 Pizza grande Hawaiana,  1 Pizza chica Muzza, 1 Cerveza Quilmes")
                    .FechaDesde(LocalDate.now())
                    .FechaHasta(LocalDate.now())
                    .HoraDesde(LocalTime.now())
                    .HoraHasta(LocalTime.now())
                    .precioPromocional(11.500)
                    .build();

            //relacion con articulos e imagen
            invierno.getArticulos().add(pizzaGrandeHawaiana);
            invierno.getArticulos().add(pizzaChicaMuzza);
            invierno.getArticulos().add(cervezaQuilmes);
            invierno.getPromoImagen().add(invierno1);

            //MUESTRO TODAS LAS PROMOCIONES:
            System.out.println("-----PROMOCIONES-----");
            List<Promocion> promociones = new ArrayList<>();
            Collections.addAll(promociones,happyHour,verano,invierno);
            for (Promocion promocion : promociones){
                System.out.println(promocion);
            }

            //MUESTRO TODOS LOS ARTICULOS:
            System.out.println("-----ARTICULOS-----");
            List<Articulo> articulos = new ArrayList<>();
            Collections.addAll(articulos,pizzaChicaNapolitana,pizzaGrandeNapolitana,pizzaChicaHawaiana,pizzaGrandeHawaiana,pizzaChicaMuzza,pizzaGrandeMuzza,cervezaQuilmes,cervezaAndes);
            for (Articulo articulo : articulos){
                System.out.println(articulo);
            }





    }
}