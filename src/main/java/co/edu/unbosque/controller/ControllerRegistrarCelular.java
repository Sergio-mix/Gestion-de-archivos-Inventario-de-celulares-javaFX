package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.model.dto.CelularBO;
import co.edu.unbosque.model.dto.TipoDeCelularBO;
import co.edu.unbosque.model.persistence.OperacioArchivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ControllerRegistrarCelular implements Initializable {

    @FXML
    private TextField txtImei;

    @FXML
    private TextField txtFecha;

    @FXML
    private ComboBox<String> cTipoCelular;

    @FXML
    private Button buttonActualizar;

    @FXML
    private Button buttonRegistrar;

    String timeStamp;

    private ControllerIndex controllerIndex = new ControllerIndex();

    private CelularVO celularVOAux;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //Agregar tipos de Celulares al comboBox
            for (TipoDeCelularVO tipoDeCelularVO : TipoDeCelularBO.getList()) {
                cTipoCelular.getItems().addAll(tipoDeCelularVO.getNombre());
            }

            timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
            txtFecha.setText(timeStamp);
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para agregar atributos del objeto seleccionado en los campos de texto y combobox
     *
     * @param celularVO objeto de celular seleccionado
     */
    @FXML
    public void iniAttributes(CelularVO celularVO) {
        try {
            celularVOAux = celularVO;
            txtImei.setText(celularVO.getIMEI().toString());
            cTipoCelular.getSelectionModel().select(celularVO.getTipoDeCelular().getNombre());
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    @FXML
    public void visibilidadButtonActualizar() {
        try {
            buttonRegistrar.setVisible(false);
            buttonActualizar.setVisible(true);
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para registrar un celular en la lista de celulares y actualizar el archivo de celulares
     */
    public void registrarCelular(ActionEvent event) {
        try {
            if (CelularBO.registrar(
                    crearObjetoCelular(Long.valueOf(txtImei.getText()), TipoDeCelularBO.obtener(cTipoCelular.getValue()
                    )))) {
                OperacioArchivo.escribirArchivoCelular(ControllerIndex.ARCHIVO);
                salir();
                controllerIndex.mostrarAlertInfo("Registro Completado");
            } else {
                controllerIndex.mostrarAlertWarning("El IMEI ya se encuentra registrado");
            }
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para actualizar el objeto celular de la lista y el archivo
     */
    @FXML
    public void actualizarCelular(ActionEvent event) {
        try {
            Long iMEI = Long.valueOf(txtImei.getText());
            String tipoDeCelular = cTipoCelular.getValue();

            if (
                    CelularBO.actualizar(celularVOAux.getIMEI(), crearObjetoCelular(iMEI, TipoDeCelularBO.obtener(tipoDeCelular)
                    ))) {
                OperacioArchivo.escribirArchivoCelular(ControllerIndex.ARCHIVO);
                controllerIndex.updateTable();
                this.salir();
                controllerIndex.mostrarAlertInfo("actualización Completada");
            } else {
                controllerIndex.mostrarAlertWarning("Ya se encuentra registrado el Celular");
            }
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
            System.out.println(e);
        }
    }

    /**
     * Método para crear un objeto celular
     *
     * @return Objeto Celular
     */
    public CelularVO crearObjetoCelular(Long iMEI, TipoDeCelularVO tipoDeCelular) {
        try {
            //Objeto celular
            //-----------------------------------------------------------------------------------------------------------
            CelularVO celular = new CelularVO();//instancia
            celular.setIMEI(iMEI);//IMEI
            celular.setFecha(timeStamp);//Fecha
            celular.setTipoDeCelular(tipoDeCelular);//Tipo de celular
            celular.setNombre(tipoDeCelular.getNombre());
            celular.setPrecio(tipoDeCelular.getPrecio());
            celular.setCapacidadDeBateria(tipoDeCelular.getCaracteristicasTecnicas().getCapacidad_de_la_Bateria() + " mAh");
            celular.setTamanioDeLaPantalla(tipoDeCelular.getImagen_y_Pantalla().getTamanioPantalla() + " Pulgadas");
            //-----------------------------------------------------------------------------------------------------------

            return celular;//Objeto celular con atributos
        } catch (NumberFormatException e) {
            controllerIndex.mostrarAlertError(e.toString());
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }

        return null;
    }

    /**
     * Método para cerrar la ventana registrar
     */
    @FXML
    private void salir() {
        try {
            Stage stage = (Stage) this.buttonRegistrar.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }
}