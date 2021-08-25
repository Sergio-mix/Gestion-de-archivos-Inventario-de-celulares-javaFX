package co.edu.unbosque.controller;

import co.edu.unbosque.model.TipoDeCelularVO;
import co.edu.unbosque.model.dto.TipoDeCelularBO;
import co.edu.unbosque.model.persistence.OperacioArchivo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTipoDeCelular implements Initializable {

    @FXML
    private TableView<TipoDeCelularVO> tableCelulares;

    @FXML
    private TableColumn<TipoDeCelularVO, Object> tableNombre;

    @FXML
    private TableColumn<TipoDeCelularVO, Object> tablePrecio;

    @FXML
    private TextField txtFiltrar;

    private ObservableList<TipoDeCelularVO> filtrarTipoDeCelularVO = FXCollections.observableArrayList();

    private ControllerIndex controllerIndex = new ControllerIndex();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tableNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            tablePrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
            addRow();
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para pasar a la ventana de celular
     *
     * @param event
     */
    @FXML
    private void buttonCelulares(ActionEvent event) throws IOException {
        App.setRoot("index");
    }

    /**
     * Método para abrir ventana de registrar tipo de celular
     */
    @FXML
    private void buttonAbrirVentanaRegistrar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/unbosque/controller/registerTipo.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ControllerRegistrarTipoDeCelular controllerRegistrarTipoDeCelular = (ControllerRegistrarTipoDeCelular) fxmlLoader.getController();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Agregar Celular");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para agregar lista de tipo de celulares a la tabla
     */
    @FXML
    public void addRow() {
        try {
            this.tableCelulares.setItems(TipoDeCelularBO.getList());
        } catch (Exception ignored) {

        }
    }

    /**
     * Método para actualizar la tabla
     */
    @FXML
    public void updateTable() {
        try {
            tableCelulares.refresh();
        } catch (Exception ignored) {

        }
    }

    /**
     * Método para eliminar un tipo celular de la lista y del archivo
     */
    @FXML
    private void eliminarTipoCelular(ActionEvent event) {
        try {
            TipoDeCelularVO tipoDeCelularVO = tableCelulares.getSelectionModel().getSelectedItem();
            if (tipoDeCelularVO != null) {
                TipoDeCelularBO.eliminar(tipoDeCelularVO.getNombre());//Método eliminar
                OperacioArchivo.escribirArchivoTipoDeCelular(ControllerIndex.ARCHIVODETIPOS);
                tableCelulares.refresh();
                this.filtrar();
                controllerIndex.mostrarAlertInfo("El Celular fue borrado exitosamente");
            } else {
                controllerIndex.mostrarAlertInfo("Seleccione un Celular primero");
            }
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para modificar un tipo de celular de la lista y el archivo
     */
    @FXML
    private void actualizarTipoCelular(ActionEvent event) {
        TipoDeCelularVO tipoDeCelularVO = this.tableCelulares.getSelectionModel().getSelectedItem();

        if (tipoDeCelularVO == null) {
            controllerIndex.mostrarAlertInfo("Seleccione un celular primero");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/unbosque/controller/registerTipo.fxml"));

                Parent root = loader.load();

                ControllerRegistrarTipoDeCelular controlador = loader.getController();
                controlador.iniAttributes(tipoDeCelularVO);
                controlador.visibilidadActualizar();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Actualizar Tipo de Celular");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                controllerIndex.mostrarAlertError(ex.toString());
            }
        }
    }

    /**
     * Método para ver La información del objeto tipo de Celular
     */
    @FXML
    private void informacionTipoCelular(ActionEvent event) {
        TipoDeCelularVO tipoDeCelularVO = this.tableCelulares.getSelectionModel().getSelectedItem();

        if (tipoDeCelularVO == null) {
            controllerIndex.mostrarAlertInfo("Seleccione un celular primero");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/unbosque/controller/registerTipo.fxml"));

                Parent root = loader.load();

                ControllerRegistrarTipoDeCelular controlador = loader.getController();
                controlador.iniAttributes(tipoDeCelularVO);
                controlador.visibilidadInformacion();
                controlador.disableCampos();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Información Tipo de Celular");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                controllerIndex.mostrarAlertError(ex.toString());
            }
        }
    }

    /**
     * Método para filtrar los datos de la tabla
     */
    @FXML
    public void filtrar() {
        try {
            String filtro = this.txtFiltrar.getText().toLowerCase();

            if (filtro.isEmpty()) {
                this.tableCelulares.setItems(TipoDeCelularBO.getList());
            } else {
                this.filtrarTipoDeCelularVO.clear();

                for (TipoDeCelularVO tipoDeCelularVO : TipoDeCelularBO.getList()) {
                    String nombre = tipoDeCelularVO.getNombre().toLowerCase();
                    String precio = String.valueOf(tipoDeCelularVO.getPrecio());
                    if (nombre.contains(filtro)
                            || precio.contains(filtro)) {

                        this.filtrarTipoDeCelularVO.add(tipoDeCelularVO);
                    }
                }
                this.tableCelulares.setItems(filtrarTipoDeCelularVO);
            }
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }
}
