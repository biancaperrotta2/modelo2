package entities;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString (exclude = "articulos")
@Setter
@Builder
public class Promocion {
    private Long id;
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;

    @Builder.Default
    private Set<Imagen> promoImagen = new HashSet<>();

    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();
}
