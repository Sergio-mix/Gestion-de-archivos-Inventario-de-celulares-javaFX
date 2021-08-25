package co.edu.unbosque.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Camara implements Serializable {
    @Getter
    @Setter
    private String tipo_de_CamaraFrontal;

    @Getter
    @Setter
    private Integer resolucionCamaraFrontalPrincipal;

    @Getter
    @Setter
    private String tipo_de_CamaraPosterior;

    @Getter
    @Setter
    private Integer resolucionCamaraPosteriorPrincipal;

    @Getter
    @Setter
    private List<Integer> resolucionOtrasCamarasPosteriores;

    @Getter
    @Setter
    private Boolean flashFrontal;

    @Getter
    @Setter
    private Boolean flashPosterior;
}
