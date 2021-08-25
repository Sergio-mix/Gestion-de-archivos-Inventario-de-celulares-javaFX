package co.edu.unbosque.model;

import lombok.*;

import java.io.Serializable;


@ToString
@EqualsAndHashCode
public class Almacenamiento_y_Procesamiento implements Serializable {
    @Getter
    @Setter
    private Integer memoriaInterna;

    @Getter
    @Setter
    private Integer memoriaExpandible;

    @Getter
    @Setter
    private Integer memoriaRAM;

    @Getter
    @Setter
    private String marcaProcesador;

    @Getter
    @Setter
    private String sistemaOperativo;

    @Getter
    @Setter
    private Float versionSistemaOperativo;

    @Getter
    @Setter
    private Integer no_de_Nucleos_del_Procesador;

    @Getter
    @Setter
    private Float velocidad_del_Procesador;

}
