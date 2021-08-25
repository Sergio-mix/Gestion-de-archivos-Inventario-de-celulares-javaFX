package co.edu.unbosque.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@ToString
@EqualsAndHashCode
public class Imagen_y_Pantalla implements Serializable {
    @Getter
    @Setter
    private String tipo_de_Pantalla;

    @Getter
    @Setter
    private ResolucionPantalla resolucion_Pantalla;

    @Getter
    @Setter
    private Float TamanioPantalla;
}
