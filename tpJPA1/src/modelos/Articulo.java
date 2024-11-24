package modelos;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;

    //relacion de uno a uno con imagen - imagen
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_imagen")
    private Imagen imagen;

    //relacion de muchos a uno con unidadMedida - unidadMedida
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_unidadMedida")
    private UnidadMedida unidadMedida;
}
