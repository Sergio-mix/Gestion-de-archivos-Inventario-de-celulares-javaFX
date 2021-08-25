package co.edu.unbosque.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
public class CelularVO implements Serializable {
    @Getter
    @Setter
    private Long iMEI;

    @Getter
    @Setter
    private String fecha;

    @Getter
    @Setter
    private TipoDeCelularVO tipoDeCelular;

    //----- Información Tabla --------------
    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private Float precio;

    @Getter
    @Setter
    private String capacidadDeBateria;

    @Getter
    @Setter
    private String tamanioDeLaPantalla;

}
