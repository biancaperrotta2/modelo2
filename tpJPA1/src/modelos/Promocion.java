package modelos;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id ;
    private String denominacion;
    private LocalDate FechaDesde;
    private LocalDate FechaHasta;
    private LocalTime HoraDesde;
    private LocalTime HoraHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    @Enumerated(EnumType.STRING)
    private TipoPromocion tipoPromocion;

    //relacion de uno a muchos con imagen - promoImagen
    @OneToMany(cascade=CascadeType.ALL)
    private Set<Imagen> promoImagen = new HashSet<>();

    //relacion de muchos a muchos con articulo - articulos
    @ManyToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_promocion",
            joinColumns =@JoinColumn(name = "promocion_id"),
            inverseJoinColumns = @JoinColumn(name ="articulo_id")
    )
    private Set<Articulo> articulos = new HashSet<>();


}
