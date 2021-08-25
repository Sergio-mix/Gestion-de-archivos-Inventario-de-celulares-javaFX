package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.CelularVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class CelularBO {

    private static ObservableList<CelularVO> list = FXCollections.observableArrayList();

    public CelularBO() {
    }

    /**
     * Método para agregar un objeto celular a la lista de celulares
     *
     * @param celular objeto celular nuevo
     * @return true si el registro fue correcto || false si hay alguna inconsistencia en el proceso
     */
    public static boolean registrar(CelularVO celular) {
        if (celular != null
                && !list.contains(celular)
                && obtener(celular.getIMEI()) == null) {
            return list.add(celular);
        }
        return false;
    }

    /**
     * Método para eliminar un objeto celular de la lista de celulares
     *
     * @param iMEI identificación del celular a eliminar
     * @return true si la eliminación fue correcta || false si hay alguna inconsistencia en el proceso
     */
    public static boolean eliminar(Long iMEI) {
        if (iMEI != null
                && !list.isEmpty()) {
            return list.removeIf(celular -> (Objects.equals(celular.getIMEI(), iMEI)));
        }
        return false;
    }

    /**
     * Método para actualizar un objeto celular
     *
     * @param iMEI    identificación del celular a modificar
     * @param celular nuevo objeto celular
     * @return true si la actualización fue correcta || false si hay alguna inconsistencia en el proceso
     */
    public static boolean actualizar(Long iMEI, CelularVO celular) {
        if (!list.isEmpty()
                && iMEI != null
                && celular != null) {
            list.set(list.indexOf(obtener(iMEI)), celular);
            return true;
        }
        return false;
    }

    /**
     * Método para obtener un objeto celular por IMEI
     *
     * @param iMEI identificación del celular a obtener
     * @return Objeto celular || null si no existe un objeto celular con el numero de IMEI
     */
    public static CelularVO obtener(Long iMEI) {
        if (!list.isEmpty()
                && iMEI != null) {
            for (CelularVO celular : list) {
                if (celular.getIMEI().equals(iMEI)) {
                    return celular;
                }
            }
        }
        return null;
    }

    /**
     * Obtener lista celular
     *
     * @return lista de objetos celular
     */
    public static ObservableList<CelularVO> getList() {
        return list;
    }

    /**
     * Insertar en la lista de Celulares
     *
     * @param list lista de objetos celular
     */
    public static void setList(ObservableList<CelularVO> list) {
        CelularBO.list = list;
    }
}
