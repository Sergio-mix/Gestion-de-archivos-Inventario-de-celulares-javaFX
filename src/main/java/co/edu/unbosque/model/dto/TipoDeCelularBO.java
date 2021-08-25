package co.edu.unbosque.model.dto;

import co.edu.unbosque.model.TipoDeCelularVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class TipoDeCelularBO {

    private static ObservableList<TipoDeCelularVO> list = FXCollections.observableArrayList();

    public TipoDeCelularBO() {

    }

    /**
     * Método para agregar un objeto tipo de celular a la lista de tipos de celulares
     *
     * @param TipoDeCelularVO objeto tipo De celular nuevo
     * @return true si el registro fue correcto || false si hay alguna inconsistencia en el proceso
     */
    public static boolean registrar(TipoDeCelularVO TipoDeCelularVO) {
        if (TipoDeCelularVO != null
                && !list.contains(TipoDeCelularVO)
                && obtener(TipoDeCelularVO.getNombre()) == null) {
            return list.add(TipoDeCelularVO);
        }
        return false;
    }

    /**
     * Método para eliminar un objeto tipo de celular de la lista de tipos de celulares
     *
     * @param nombre nombre del tipo de celular a eliminar
     * @return true si la eliminación fue correcta || false si hay alguna inconsistencia en el proceso
     */
    public static boolean eliminar(String nombre) {
        if (nombre != null
                && !list.isEmpty()) {
            return list.removeIf(tipoDeCelular -> (Objects.equals(tipoDeCelular.getNombre(), nombre)));
        }
        return false;
    }

    /**
     * Método para actualizar un objeto tipo de celular
     *
     * @param nombre          nombre del tipo de celular a modificar
     * @param tipoDeCelularVO nuevo objeto tipo de celular
     * @return true si la actualización fue correcta || false si hay alguna inconsistencia en el proceso
     */
    public static boolean actualizar(String nombre, TipoDeCelularVO tipoDeCelularVO) {
        if (!list.isEmpty()
                && nombre != null
                && tipoDeCelularVO != null) {
            list.set(list.indexOf(obtener(nombre)), tipoDeCelularVO);
            return true;
        }
        return false;
    }

    /**
     * Método para obtener un objeto de topo de celular por nombre
     *
     * @param nombre nombre del tipo de celular a obtener
     * @return Objeto tipo de celular || null si no existe un objeto tipo de celular con el nombre
     */
    public static TipoDeCelularVO obtener(String nombre) {
        if (!list.isEmpty()
                && nombre != null) {
            for (TipoDeCelularVO tipoDeCelularVO : list) {
                if (tipoDeCelularVO.getNombre().equals(nombre)) {
                    return tipoDeCelularVO;
                }
            }
        }
        return null;
    }

    /**
     * Obtener lista de tipo de celular
     *
     * @return lista de objetos tipo de celular
     */
    public static ObservableList<TipoDeCelularVO> getList() {
        return list;
    }

    /**
     * Insertar en la lista de tipo de Celulares
     *
     * @param list lista de objetos tipo de celulares
     */
    public static void setList(ObservableList<TipoDeCelularVO> list) {
        TipoDeCelularBO.list = list;
    }
}
