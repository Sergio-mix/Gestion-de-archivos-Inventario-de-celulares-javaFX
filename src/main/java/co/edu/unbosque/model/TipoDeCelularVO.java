package co.edu.unbosque.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
public class TipoDeCelularVO implements Serializable {
    
    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private Float precio;

    @Getter
    @Setter
    private InformacionBasica informacionBasica;

    @Getter
    @Setter
    private Almacenamiento_y_Procesamiento almacenamiento_y_procesamiento;

    @Getter
    @Setter
    private Imagen_y_Pantalla imagen_y_Pantalla;

    @Getter
    @Setter
    private Camara camara;

    @Getter
    @Setter
    private CaracteristicasTecnicas caracteristicasTecnicas;

    @Getter
    @Setter
    private Conectividad conectividad;
}
