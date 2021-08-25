package co.edu.unbosque.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@EqualsAndHashCode
public class CaracteristicasTecnicas implements Serializable {
    @Getter
    @Setter
    private Integer capacidad_de_la_Bateria;

    @Getter
    @Setter
    private Boolean resistencia_al_Agua;

    @Getter
    @Setter
    private List<String> opciones_de_Conectividad;

}
