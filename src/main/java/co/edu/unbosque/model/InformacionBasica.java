package co.edu.unbosque.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
public class InformacionBasica implements Serializable {
    @Getter
    @Setter
    private String marca;

    @Getter
    @Setter
    private String modelo;

    @Getter
    @Setter
    private Boolean esSmartphone;

    @Getter
    @Setter
    private String color;

    @Getter
    @Setter
    private Integer garantía_del_Fabricante;
}
