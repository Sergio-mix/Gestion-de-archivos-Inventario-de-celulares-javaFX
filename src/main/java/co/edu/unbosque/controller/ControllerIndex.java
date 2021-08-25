package co.edu.unbosque.controller;

import co.edu.unbosque.model.CelularVO;
import co.edu.unbosque.model.TipoDeCelularVO;
import co.edu.unbosque.model.dto.CelularBO;
import co.edu.unbosque.model.persistence.OperacioArchivo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerIndex implements Initializable {

    @FXML
    private TableView<CelularVO> tableCelulares;

    @FXML
    private TableColumn<TipoDeCelularVO, Object> tableIMEI;

    @FXML
    private TableColumn<TipoDeCelularVO, String> tableFecha;

    @FXML
    private TableColumn<TipoDeCelularVO, String> tableNombre;

    @FXML
    private TableColumn<TipoDeCelularVO, String> tablePrecio;

    @FXML
    private TableColumn<TipoDeCelularVO, Object> tableCapacidadDeBateria;

    @FXML
    private TableColumn<TipoDeCelularVO, Object> tableTamanioPantalla;


    @FXML
    private TextField txtFiltrar;

    private ObservableList<CelularVO> filtrarCelularVO = FXCollections.observableArrayList();

    public static final String ARCHIVO = "src\\main\\resources\\database\\Celulares.data";
    public static final String ARCHIVODETIPOS = "src\\main\\resources\\database\\Tipos de celulares.data";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            File archivo = new File(ARCHIVO);
            File archivo2 = new File(ARCHIVODETIPOS);

            if (archivo.exists()) {
                try {
                    OperacioArchivo.leerArchivoCelular(ARCHIVO);
                } catch (Exception e) {
                    this.mostrarAlertError(e.toString());
                }
            }

            if (archivo2.exists()) {
                try {
                    OperacioArchivo.leerArchivoTipoDeCelular(ARCHIVODETIPOS);
                } catch (Exception e) {
                    this.mostrarAlertError(e.toString());
                }
            }

            tableIMEI.setCellValueFactory(new PropertyValueFactory<>("iMEI"));
            tableFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            tableNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            tablePrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
            tableCapacidadDeBateria.setCellValueFactory(new PropertyValueFactory<>("capacidadDeBateria"));
            tableTamanioPantalla.setCellValueFactory(new PropertyValueFactory<>("tamanioDeLaPantalla"));
            addRow();
        } catch (Exception e) {
            mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para pasar a la ventana de tipo de celular
     *
     * @param event
     */
    @FXML
    private void buttonTipoDeCelulares(ActionEvent event) throws IOException {
        App.setRoot("ventanaTipoDeCelular");
    }

    /**
     * Método para agregar lista de celulares a la tabla
     */
    @FXML
    public void addRow() {
        try {
            this.tableCelulares.setItems(CelularBO.getList());
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
     * Método para eliminar un celular de la lista y del archivo
     */
    @FXML
    private void eliminarCelular(ActionEvent event) {
        try {
            CelularVO celularVO = tableCelulares.getSelectionModel().getSelectedItem();
            if (celularVO != null) {
                CelularBO.eliminar(celularVO.getIMEI());//Método eliminar
                OperacioArchivo.escribirArchivoCelular(ARCHIVO);
                tableCelulares.refresh();
                this.filtrar();
                mostrarAlertInfo("El Celular fue borrado exitosamente");
            } else {
                mostrarAlertInfo("Seleccione un Celular primero");
            }
        } catch (Exception e) {
            mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para abrir la ventana de registro
     */
    @FXML
    private void buttonAbrirVentanaRegistrarCelular(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/unbosque/controller/registrarCelular.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ControllerRegistrarCelular controllerRegister = (ControllerRegistrarCelular) fxmlLoader.getController();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Agregar Celular");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            this.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para ver La información del objeto Celular
     */
    @FXML
    private void informacionCelular(ActionEvent event) {
        CelularVO celularVO = this.tableCelulares.getSelectionModel().getSelectedItem();

        if (celularVO == null) {
            mostrarAlertInfo("Seleccione un celular primero");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/unbosque/controller/registerTipo.fxml"));

                Parent root = loader.load();

                ControllerRegistrarTipoDeCelular controlador = loader.getController();
                controlador.iniAttributes(celularVO.getTipoDeCelular());
                controlador.visibilidadInformacion();
                controlador.disableCampos();
                controlador.visibilidadImei(celularVO.getIMEI());

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Información Celular");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                mostrarAlertError(ex.toString());
            }
        }
    }

    /**
     * Método para modificar un celular de la lista y el archivo
     */
    @FXML
    private void actualizarCelular(ActionEvent event) {
        CelularVO celularVO = this.tableCelulares.getSelectionModel().getSelectedItem();

        if (celularVO == null) {
            mostrarAlertInfo("Seleccione un celular primero");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/unbosque/controller/registrarCelular.fxml"));

                Parent root = loader.load();

                ControllerRegistrarCelular controlador = loader.getController();
                controlador.iniAttributes(celularVO);
                controlador.visibilidadButtonActualizar();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Actualizar Celular");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                mostrarAlertError(ex.toString());
            }
        }
    }

    /**
     * Método para filtrar los datos de la tabla
     */
    @FXML
    public void filtrar() {
        try {
            String filtro = this.txtFiltrar.getText();

            if (filtro.isEmpty()) {
                this.tableCelulares.setItems(CelularBO.getList());
            } else {
                this.filtrarCelularVO.clear();

                for (CelularVO celularVO : CelularBO.getList()) {
                    String iMEI = String.valueOf(celularVO.getIMEI());
                    if (iMEI.contains(filtro)) {
                        this.filtrarCelularVO.add(celularVO);
                    }
                }
                this.tableCelulares.setItems(filtrarCelularVO);
            }
        } catch (Exception e) {
            mostrarAlertError(e.toString());
        }
    }

    /**
     * Alert de error
     *
     * @param text texto del alert
     */
    @FXML
    public void mostrarAlertError(String text) {
        try {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(text);
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Alert de info
     *
     * @param text texto del alert
     */
    @FXML
    public void mostrarAlertInfo(String text) {
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Información");
            alert.setContentText(text);
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Alert de advertencia
     *
     * @param text texto del alert
     */
    @FXML
    public void mostrarAlertWarning(String text) {
        try {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Advertencia");
            alert.setContentText(text);
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
