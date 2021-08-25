package co.edu.unbosque.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Conectividad implements Serializable {
    @Getter
    @Setter
    private List<String> red_de_Transmision_de_Datos;

    @Getter
    @Setter
    private Integer espaciosParaSIMCard;

    @Getter
    @Setter
    private List<String> tipos_de_PuertosEntradas_y_Salidas;
}
