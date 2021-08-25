package co.edu.unbosque.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@ToString
@EqualsAndHashCode
public class ResolucionPantalla implements Serializable {
    @Getter
    @Setter
    private Integer ancho;
    @Getter
    @Setter
    private Integer largo;
    @Getter
    @Setter
    private String calidad;
}
