package entities;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString (exclude = "promociones")
@Setter
@Builder
public class Articulo {
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;
    private UnidadMedida unidadMedida;
    private Imagen imagen;

    @Builder.Default
    private Set<Promocion> promociones = new HashSet<>();
}
