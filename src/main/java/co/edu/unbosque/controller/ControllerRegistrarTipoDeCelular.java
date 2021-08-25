package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.model.dto.TipoDeCelularBO;
import co.edu.unbosque.model.persistence.OperacioArchivo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerRegistrarTipoDeCelular implements Initializable {
    @FXML
    private Pane panel1;

    @FXML
    private ComboBox<String> cMarca;

    @FXML
    private TextField cModelo;

    @FXML
    private ComboBox<String> cEsSmartphone;

    @FXML
    private TextField txtColor;

    @FXML
    private ComboBox<Integer> cGarantia;

    @FXML
    private ComboBox<Integer> cMemoriaInterna;

    @FXML
    private ComboBox<Integer> cMemoriaExpandible;

    @FXML
    private ComboBox<Integer> cMemoriaRam;

    @FXML
    private ComboBox<String> cMarcaProcesador;

    @FXML
    private ComboBox<String> cSistemaOperativo;

    @FXML
    private TextField txtVersionDelSistemaOperativo;

    @FXML
    private ComboBox<Integer> cNumeroDeNucleos;

    @FXML
    private ComboBox<Float> cVelocidadDelProcesador;

    @FXML
    private Pane panel2;

    @FXML
    private ComboBox<Integer> cAnchoDeLaPantalla;

    @FXML
    private ComboBox<Integer> cLargoDeLaPantalla;

    @FXML
    private ComboBox<String> cCalidadDeLaPantalla;

    @FXML
    private ComboBox<String> cTipoDePantalla;

    @FXML
    private ComboBox<Integer> cResolucionDeLaPantalla;

    @FXML
    private ComboBox<Float> cTamanioDeLaPantalla;

    @FXML
    private ComboBox<String> cTipoDeCamaraFrontal;

    @FXML
    private ComboBox<Integer> cResolucionDeLaCamaraFrontalPrincipal;

    @FXML
    private ComboBox<String> cTipoDeCamaraPosterior;

    @FXML
    private ComboBox<Integer> cResolucionCamaraPosterior;

    @FXML
    private Pane panel3;

    @FXML
    private ComboBox<List<Integer>> cResolucionOtrasCamarasPosteriores;

    @FXML
    private ComboBox<String> CFlashFrontal;

    @FXML
    private ComboBox<String> cFlashPosterior;

    @FXML
    private ComboBox<Integer> cCapasidadDeLaBateria;

    @FXML
    private ComboBox<String> cResistenciaAlAgua;

    @FXML
    private ComboBox<List<String>> cOpcionesDeConectividad;

    @FXML
    private ComboBox<List<String>> cRedDeTransmisionDeDatos;

    @FXML
    private ComboBox<Integer> cEspaciosParaSimCard;

    @FXML
    private ComboBox<List<String>> cTiposDePuertosYSalidas;

    @FXML
    private TextField txtPrecio;

    @FXML
    private Button buttonRegistrar;

    @FXML
    private Button buttonActualizar;

    @FXML
    private TextField txtImei;

    @FXML
    private Text tImei;


    private TipoDeCelularVO tipoDeCelularVOAux;


    private ControllerIndex controllerIndex = new ControllerIndex();
    private ControllerTipoDeCelular controllerTipoDeCelular = new ControllerTipoDeCelular();

    /**
     * Método para añadir los valores seleccionables
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            cMarca.getItems().addAll(
                    "Apple", "Asus", "Google", "HTC", "Motorola", "Huawei",
                    "Lenovo", "LG", "Meizu", "Nokia", "Nubia", "OnePlus",
                    "Oppo", "Samsung", "Sony", "Vivo", "Xiaomi", "ZTE");

            cEsSmartphone.getItems().addAll(
                    "Si es Smartphone",
                    "No es Smartphone");

            cGarantia.getItems().addAll(1, 2, 3, 6, 12, 18, 24, 42);

            cMemoriaInterna.getItems().addAll(4, 8, 16, 32, 64, 128, 256, 512);

            cMemoriaExpandible.getItems().addAll(32, 64, 128, 256, 512, 1000);

            cMemoriaRam.getItems().addAll(1, 2, 3, 4, 5, 6, 8, 10, 12, 16, 20);

            cMarcaProcesador.getItems().addAll("Exynos", "MediaTek", "Kirin", "Snapdragon", "Apple ARM");

            cSistemaOperativo.getItems().addAll("Android", "ios", "Symbian", "BlackBerry OS");

            cNumeroDeNucleos.getItems().addAll(4, 6, 8);

            cVelocidadDelProcesador.getItems().addAll(1.0f, 1.4f, 1.6f, 1.8f, 2.0f, 2.4f, 2.6f, 2.8f);

            cAnchoDeLaPantalla.getItems().addAll(360, 480, 640, 720, 800, 828, 1080, 1440);

            cLargoDeLaPantalla.getItems().addAll(800, 854, 960, 640, 1136, 1600, 1704, 1792, 1920, 2400, 2560);

            cCalidadDeLaPantalla.getItems().addAll("Estándar", "HD", "HD+", "ULTRA HD");

            cTipoDePantalla.getItems().addAll(
                    "TFT", "Retina", "IPS", "LCD-IPS",
                    "Gorilla Glass LCD", "DINAMIC AMOLED 2X", "OLED", "AMOLED", "LCD", "Dynamic AMOLED",
                    "Liquid Crystal Display"
            );

            cTamanioDeLaPantalla.getItems().addAll(
                    3.3f, 3.5f, 4.0f, 4.3f, 4.7f, 5.0f, 5.2f, 5.5f, 5.8f, 5.7f, 5.9f, 6.0f, 6.1f, 6.3f, 6.5f,
                    7.0f, 7.9f, 8.0f, 8.0f, 4f, 8.9f, 9.4f, 9.7f, 10.1f, 12.9f, 13.5f
            );

            cTipoDeCamaraFrontal.getItems().addAll("Ninguna", "Sencilla", "Doble", "Triple");

            cResolucionDeLaCamaraFrontalPrincipal.getItems().addAll(5, 8, 10, 12, 13, 16, 18, 20);

            cTipoDeCamaraPosterior.getItems().addAll("Ninguna", "Sencilla", "Doble", "Triple", "Quadruple");

            cResolucionOtrasCamarasPosteriores.getItems().addAll(List.of(12, 10, 10), List.of(8, 5, 5), List.of(8, 2, 2), List.of(12, 12), List.of(2, 2), List.of(0));

            cResolucionCamaraPosterior.getItems().addAll(4, 8, 12, 16, 20, 42, 48, 52, 64, 77, 108);

            CFlashFrontal.getItems().addAll("Si tiene", "No tiene");

            cFlashPosterior.getItems().addAll("Si tiene", "No tiene");

            cOpcionesDeConectividad.getItems().addAll(
                    List.of("Bluetooth", "USB", "WiFi"),
                    List.of("Bluetooth", "Conexión Con Cable", "WiFi"),
                    List.of("Bluetooth", "WiFi"),
                    List.of("Bluetooth", "NFC", "WiFi")
            );

            cCapasidadDeLaBateria.getItems().addAll(2000, 1500, 3000, 3300, 4000, 5000, 5020, 5200);

            cResistenciaAlAgua.getItems().addAll(
                    "No Resistente al Agua",
                    "Si Resistente al Agua"
            );

            cRedDeTransmisionDeDatos.getItems().addAll(
                    List.of("2G", "3G"),
                    List.of("2G", "3G", "4G"),
                    List.of("2G", "3G", "4G", "5G")
            );

            cEspaciosParaSimCard.getItems().addAll(1, 2, 3, 4);

            cTiposDePuertosYSalidas.getItems().addAll(
                    List.of("Entrada Tarjeta Micro SD")
                    , List.of("Entrada Tarjeta Micro SD",
                            "Puerto USB Tipo C",
                            "Salida de Audífonos",
                            "Salida de Parlantes"),
                    List.of("Entrada Tarjeta Micro SD",
                            "Puerto USB Tipo C",
                            "Salida de Audífonos"),
                    List.of("Puerto Lightning")
            );
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }


    @FXML
    private void buttonSiguientePanel1(ActionEvent event) {
        try {
            panel3.setVisible(false);
            panel1.setVisible(false);
            panel2.setVisible(true);
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    @FXML
    private void buttonAtrasPanel2(ActionEvent event) {
        try {
            panel3.setVisible(false);
            panel2.setVisible(false);
            panel1.setVisible(true);
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    @FXML
    private void buttonSiguientePanel2(ActionEvent event) {
        try {
            panel1.setVisible(false);
            panel2.setVisible(false);
            panel3.setVisible(true);
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    @FXML
    private void buttonAtrasPanel3(ActionEvent event) {
        try {
            panel3.setVisible(false);
            panel1.setVisible(false);
            panel2.setVisible(true);
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    @FXML
    public void visibilidadActualizar() {
        try {
            buttonRegistrar.setVisible(false);
            buttonActualizar.setVisible(true);
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    @FXML
    public void visibilidadInformacion() {
        try {
            buttonRegistrar.setVisible(false);
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    @FXML
    public void visibilidadImei(Long imei) {
        try {
            txtImei.setVisible(true);
            tImei.setVisible(true);
            txtImei.setText(imei.toString());
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para cerrar la ventana registrar
     */
    @FXML
    private void salir() {
        try {
            Stage stage = (Stage) this.panel1.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para registrar tipo de celular en la lista y el archivo
     */
    @FXML
    private void registrarTipoDeCelular(ActionEvent event) {
        try {
            float precio = Float.parseFloat(txtPrecio.getText());
            String marca = cMarca.getValue();
            String modelo = cModelo.getText();
            String esSmartphoneString = cEsSmartphone.getValue();
            String color = txtColor.getText();
            Integer garantia = cGarantia.getValue();
            Integer memoriaInterna = cMemoriaInterna.getValue();
            Integer memoriaExpandible = cMemoriaExpandible.getValue();
            Integer memoriaRam = cMemoriaRam.getValue();
            String marcaProcesador = cMarcaProcesador.getValue();
            String sistemaOperativo = cSistemaOperativo.getValue();
            Float versionSistemaOperativo = Float.valueOf(txtVersionDelSistemaOperativo.getText());
            Integer no_de_Nucleos_del_Procesador = cNumeroDeNucleos.getValue();
            Float velocidad_del_Procesador = cVelocidadDelProcesador.getValue();
            Integer ancho = cAnchoDeLaPantalla.getValue();
            Integer largo = cLargoDeLaPantalla.getValue();
            String calidad = cCalidadDeLaPantalla.getValue();
            String tipoDePantalla = cTipoDePantalla.getValue();
            Integer resolucionDeLaPantalla = cResolucionDeLaPantalla.getValue();
            Float tamanioPantalla = cTamanioDeLaPantalla.getValue();
            String tipoDeCamaraFrontal = cTipoDeCamaraFrontal.getValue();
            Integer resolucionCamaraFrontalPrincipal = cResolucionDeLaCamaraFrontalPrincipal.getValue();
            String tipo_de_CamaraPosterior = cTipoDeCamaraPosterior.getValue();
            List<Integer> resolucionOtrasCamarasPosteriores = cResolucionOtrasCamarasPosteriores.getValue();
            Integer resolucionCamaraPosteriorPrincipal = cResolucionCamaraPosterior.getValue();
            String flashFrontal = CFlashFrontal.getValue();
            String flashPosterior = cFlashPosterior.getValue();
            List<String> opciones_de_Conectividad = cOpcionesDeConectividad.getValue();
            Integer capacidad_de_la_Bateria = cCapasidadDeLaBateria.getValue();
            String resistencia_al_Agua = cResistenciaAlAgua.getValue();
            Integer espaciosParaSIMCard = cEspaciosParaSimCard.getValue();
            List<String> red_de_Transmision_de_Datos = cRedDeTransmisionDeDatos.getValue();
            List<String> tipos_de_PuertosEntradas_y_Salidas = cTiposDePuertosYSalidas.getValue();

            boolean esSmartphoneStringBoolean;
            boolean flashFrontalBoolean;
            boolean flashPosteriorBoolean;
            boolean resistencia_al_AguaBoolean;

            esSmartphoneStringBoolean = esSmartphoneString.equals("Si es Smartphone");
            flashFrontalBoolean = flashFrontal.equals("Si tiene");
            flashPosteriorBoolean = flashPosterior.equals("Si tiene");
            resistencia_al_AguaBoolean = resistencia_al_Agua.equals("Si Resistente al Agua");

            if (TipoDeCelularBO.registrar(crearObjetoTipoDeCelular(
                    precio, marca, modelo, esSmartphoneStringBoolean, color, garantia, memoriaInterna, memoriaExpandible,
                    memoriaRam, marcaProcesador, sistemaOperativo, versionSistemaOperativo, no_de_Nucleos_del_Procesador,
                    velocidad_del_Procesador, ancho, largo, calidad, tipoDePantalla, tamanioPantalla, resolucionOtrasCamarasPosteriores,
                    tipoDeCamaraFrontal, resolucionCamaraFrontalPrincipal, tipo_de_CamaraPosterior, resolucionCamaraPosteriorPrincipal,
                    flashFrontalBoolean, flashPosteriorBoolean, opciones_de_Conectividad, capacidad_de_la_Bateria, resistencia_al_AguaBoolean,
                    red_de_Transmision_de_Datos, espaciosParaSIMCard, tipos_de_PuertosEntradas_y_Salidas
            ))) {
                OperacioArchivo.escribirArchivoTipoDeCelular(ControllerIndex.ARCHIVODETIPOS);
                controllerTipoDeCelular.addRow();
                this.salir();
                controllerTipoDeCelular.filtrar();
                controllerIndex.mostrarAlertInfo("Registro Completado");
            } else {
                controllerIndex.mostrarAlertWarning("Ya se encuentra registrado el tipo de Celular");
            }
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para agregar atributos del objeto seleccionado en los campos de texto y combobox
     *
     * @param tipoDeCelularVO objeto tipo de celular seleccionado
     */
    public void iniAttributes(TipoDeCelularVO tipoDeCelularVO) {
        try {
            tipoDeCelularVOAux = tipoDeCelularVO;
            txtPrecio.setText(String.valueOf(tipoDeCelularVO.getPrecio()));
            cMarca.getSelectionModel().select(tipoDeCelularVO.getInformacionBasica().getMarca());
            cModelo.setText(tipoDeCelularVO.getInformacionBasica().getModelo());
            String esSmartphone;
            if (tipoDeCelularVO.getInformacionBasica().getEsSmartphone()) {
                esSmartphone = "Si es Smartphone";
            } else {
                esSmartphone = "No es Smartphone";
            }
            cEsSmartphone.getSelectionModel().select(esSmartphone);
            txtColor.setText(tipoDeCelularVO.getInformacionBasica().getColor());
            cGarantia.getSelectionModel().select(tipoDeCelularVO.getInformacionBasica().getGarantía_del_Fabricante());
            cMemoriaInterna.getSelectionModel().select(tipoDeCelularVO.getAlmacenamiento_y_procesamiento().getMemoriaInterna());
            cMemoriaExpandible.getSelectionModel().select(tipoDeCelularVO.getAlmacenamiento_y_procesamiento().getMemoriaExpandible());
            cMemoriaRam.getSelectionModel().select(tipoDeCelularVO.getAlmacenamiento_y_procesamiento().getMemoriaRAM());
            cMarcaProcesador.getSelectionModel().select(tipoDeCelularVO.getAlmacenamiento_y_procesamiento().getMarcaProcesador());
            cSistemaOperativo.getSelectionModel().select(tipoDeCelularVO.getAlmacenamiento_y_procesamiento().getSistemaOperativo());
            txtVersionDelSistemaOperativo.setText(tipoDeCelularVO.getAlmacenamiento_y_procesamiento().getVersionSistemaOperativo().toString());
            cNumeroDeNucleos.getSelectionModel().select(tipoDeCelularVO.getAlmacenamiento_y_procesamiento().getNo_de_Nucleos_del_Procesador());
            cVelocidadDelProcesador.getSelectionModel().select(tipoDeCelularVO.getAlmacenamiento_y_procesamiento().getVelocidad_del_Procesador());
            cAnchoDeLaPantalla.getSelectionModel().select(tipoDeCelularVO.getImagen_y_Pantalla().getResolucion_Pantalla().getAncho());
            cLargoDeLaPantalla.getSelectionModel().select(tipoDeCelularVO.getImagen_y_Pantalla().getResolucion_Pantalla().getLargo());
            cCalidadDeLaPantalla.getSelectionModel().select(tipoDeCelularVO.getImagen_y_Pantalla().getResolucion_Pantalla().getCalidad());
            cTipoDePantalla.getSelectionModel().select(tipoDeCelularVO.getImagen_y_Pantalla().getTipo_de_Pantalla());

            cResolucionDeLaPantalla.setPromptText(
                    tipoDeCelularVO.getImagen_y_Pantalla().getResolucion_Pantalla().getAncho()
                            + "X" +
                            tipoDeCelularVO.getImagen_y_Pantalla().getResolucion_Pantalla().getLargo() +
                            " " + tipoDeCelularVO.getImagen_y_Pantalla().getResolucion_Pantalla().getCalidad());

            cTamanioDeLaPantalla.getSelectionModel().select(tipoDeCelularVO.getImagen_y_Pantalla().getTamanioPantalla());
            cTipoDeCamaraFrontal.getSelectionModel().select(tipoDeCelularVO.getCamara().getTipo_de_CamaraFrontal());
            cResolucionDeLaCamaraFrontalPrincipal.getSelectionModel().select(tipoDeCelularVO.getCamara().getResolucionCamaraFrontalPrincipal());
            cTipoDeCamaraPosterior.getSelectionModel().select(tipoDeCelularVO.getCamara().getTipo_de_CamaraPosterior());
            cResolucionOtrasCamarasPosteriores.getSelectionModel().select(tipoDeCelularVO.getCamara().getResolucionOtrasCamarasPosteriores());
            cResolucionCamaraPosterior.getSelectionModel().select(tipoDeCelularVO.getCamara().getResolucionCamaraPosteriorPrincipal());

            String flashFrontal;
            if (tipoDeCelularVO.getCamara().getFlashFrontal()) {
                flashFrontal = "Si tiene";
            } else {
                flashFrontal = "No tiene";
            }

            CFlashFrontal.getSelectionModel().select(flashFrontal);
            String flashPosterior;

            if (tipoDeCelularVO.getCamara().getFlashPosterior()) {
                flashPosterior = "Si tiene";
            } else {
                flashPosterior = "No tiene";
            }

            cFlashPosterior.getSelectionModel().select(flashPosterior);
            cOpcionesDeConectividad.getSelectionModel().select(tipoDeCelularVO.getCaracteristicasTecnicas().getOpciones_de_Conectividad());
            cCapasidadDeLaBateria.getSelectionModel().select(tipoDeCelularVO.getCaracteristicasTecnicas().getCapacidad_de_la_Bateria());
            String resistencia_al_Agua;

            if (tipoDeCelularVO.getCaracteristicasTecnicas().getResistencia_al_Agua()) {
                resistencia_al_Agua = "Si Resistente al Agua";
            } else {
                resistencia_al_Agua = "No Resistente al Agua";
            }

            cResistenciaAlAgua.getSelectionModel().select(resistencia_al_Agua);
            cRedDeTransmisionDeDatos.getSelectionModel().select(tipoDeCelularVO.getConectividad().getRed_de_Transmision_de_Datos());
            cEspaciosParaSimCard.getSelectionModel().select(tipoDeCelularVO.getConectividad().getEspaciosParaSIMCard());
            cTiposDePuertosYSalidas.getSelectionModel().select(tipoDeCelularVO.getConectividad().getTipos_de_PuertosEntradas_y_Salidas());

        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para actualizar el objeto Tipo de celular de la lista y el archivo
     */
    @FXML
    private void actualizar(ActionEvent event) {
        try {
            float precio = Float.parseFloat(txtPrecio.getText());
            String marca = cMarca.getValue();
            String modelo = cModelo.getText();
            String esSmartphoneString = cEsSmartphone.getValue();
            String color = txtColor.getText();
            Integer garantia = cGarantia.getValue();
            Integer memoriaInterna = cMemoriaInterna.getValue();
            Integer memoriaExpandible = cMemoriaExpandible.getValue();
            Integer memoriaRam = cMemoriaRam.getValue();
            String marcaProcesador = cMarcaProcesador.getValue();
            String sistemaOperativo = cSistemaOperativo.getValue();
            Float versionSistemaOperativo = Float.valueOf(txtVersionDelSistemaOperativo.getText());
            Integer no_de_Nucleos_del_Procesador = cNumeroDeNucleos.getValue();
            Float velocidad_del_Procesador = cVelocidadDelProcesador.getValue();
            Integer ancho = cAnchoDeLaPantalla.getValue();
            Integer largo = cLargoDeLaPantalla.getValue();
            String calidad = cCalidadDeLaPantalla.getValue();
            String tipoDePantalla = cTipoDePantalla.getValue();
            //Integer resolucionDeLaPantalla = cResolucionDeLaPantalla.getValue();
            Float tamanioPantalla = cTamanioDeLaPantalla.getValue();
            String tipoDeCamaraFrontal = cTipoDeCamaraFrontal.getValue();
            Integer resolucionCamaraFrontalPrincipal = cResolucionDeLaCamaraFrontalPrincipal.getValue();
            String tipo_de_CamaraPosterior = cTipoDeCamaraPosterior.getValue();
            List<Integer> resolucionOtrasCamarasPosteriores = cResolucionOtrasCamarasPosteriores.getValue();
            Integer resolucionCamaraPosteriorPrincipal = cResolucionCamaraPosterior.getValue();
            String flashFrontal = CFlashFrontal.getValue();
            String flashPosterior = cFlashPosterior.getValue();
            List<String> opciones_de_Conectividad = cOpcionesDeConectividad.getValue();
            Integer capacidad_de_la_Bateria = cCapasidadDeLaBateria.getValue();
            String resistencia_al_Agua = cResistenciaAlAgua.getValue();
            List<String> red_de_Transmision_de_Datos = cRedDeTransmisionDeDatos.getValue();
            Integer espaciosParaSIMCard = cEspaciosParaSimCard.getValue();
            List<String> tipos_de_PuertosEntradas_y_Salidas = cTiposDePuertosYSalidas.getValue();

            boolean esSmartphoneStringBoolean;
            boolean flashFrontalBoolean;
            boolean flashPosteriorBoolean;
            boolean resistencia_al_AguaBoolean;

            esSmartphoneStringBoolean = esSmartphoneString.equals("Si es Smartphone");
            flashFrontalBoolean = flashFrontal.equals("Si tiene");
            flashPosteriorBoolean = flashPosterior.equals("Si tiene");
            resistencia_al_AguaBoolean = resistencia_al_Agua.equals("Si Resistente al Agua");

            if (TipoDeCelularBO.actualizar(tipoDeCelularVOAux.getNombre(), crearObjetoTipoDeCelular(
                    precio, marca, modelo, esSmartphoneStringBoolean, color, garantia, memoriaInterna, memoriaExpandible,
                    memoriaRam, marcaProcesador, sistemaOperativo, versionSistemaOperativo, no_de_Nucleos_del_Procesador,
                    velocidad_del_Procesador, ancho, largo, calidad, tipoDePantalla, tamanioPantalla, resolucionOtrasCamarasPosteriores,
                    tipoDeCamaraFrontal, resolucionCamaraFrontalPrincipal, tipo_de_CamaraPosterior, resolucionCamaraPosteriorPrincipal,
                    flashFrontalBoolean, flashPosteriorBoolean, opciones_de_Conectividad, capacidad_de_la_Bateria, resistencia_al_AguaBoolean,
                    red_de_Transmision_de_Datos, espaciosParaSIMCard, tipos_de_PuertosEntradas_y_Salidas
            ))) {
                OperacioArchivo.escribirArchivoTipoDeCelular(ControllerIndex.ARCHIVODETIPOS);
                controllerTipoDeCelular.updateTable();
                this.salir();
                controllerTipoDeCelular.filtrar();
                controllerIndex.mostrarAlertInfo("actualización Completada");
            } else {
                controllerIndex.mostrarAlertWarning("Ya se encuentra registrado el tipo de Celular");
            }
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }

    /**
     * Método para crear un objeto celular
     *
     * @return Objeto Celular
     */
    public TipoDeCelularVO crearObjetoTipoDeCelular(
            Float precio, String marca, String modelo, Boolean esSmartphone, String color,
            Integer garantia, Integer memoriaInterna, Integer memoriaExpandible, Integer memoriaRAM,
            String marcaProcesador, String sistemaOperativo, Float versionSistemaOperativo,
            Integer no_de_Nucleos_del_Procesador, Float velocidad_del_Procesador, Integer ancho,
            Integer largo, String calidad, String tipo_de_Pantalla, Float tamanioPantalla,
            List<Integer> resolucionOtrasCamarasPosteriores, String tipo_de_CamaraFrontal,
            Integer resolucionCamaraFrontalPrincipal, String tipo_de_CamaraPosterior,
            Integer resolucionCamaraPosteriorPrincipal, Boolean flashFrontal, Boolean flashPosterior,
            List<String> opciones_de_Conectividad, Integer capacidad_de_la_Bateria, Boolean resistencia_al_Agua,
            List<String> red_de_Transmision_de_Datos, Integer espaciosParaSIMCard, List<String> tipos_de_PuertosEntradas_y_Salidas
    ) {
        try {
            //informacion Basica
            //--------------------------------------------------------------------------------------------------------------------------------
            InformacionBasica informacionBasica = new InformacionBasica();//instancia
            informacionBasica.setMarca(marca);//marca
            informacionBasica.setModelo(modelo);//modelo
            informacionBasica.setEsSmartphone(esSmartphone);//es Smartphone
            informacionBasica.setColor(color);//color
            informacionBasica.setGarantía_del_Fabricante(garantia);//garantia
            //--------------------------------------------------------------------------------------------------------------------------------

            //almacenamiento y procesamiento
            //--------------------------------------------------------------------------------------------------------------------------------
            Almacenamiento_y_Procesamiento almacenamiento_y_procesamiento = new Almacenamiento_y_Procesamiento();//instancia
            almacenamiento_y_procesamiento.setMemoriaInterna(memoriaInterna);//memoria Interna
            almacenamiento_y_procesamiento.setMemoriaExpandible(memoriaExpandible);//memoria Expandible
            almacenamiento_y_procesamiento.setMemoriaRAM(memoriaRAM);//memoria RAM
            almacenamiento_y_procesamiento.setMarcaProcesador(marcaProcesador);//marca del Procesador
            almacenamiento_y_procesamiento.setSistemaOperativo(sistemaOperativo);//sistema Operativo
            almacenamiento_y_procesamiento.setVersionSistemaOperativo(versionSistemaOperativo);//version del Sistema Operativo
            almacenamiento_y_procesamiento.setNo_de_Nucleos_del_Procesador(no_de_Nucleos_del_Procesador);//numero de Nucleos del Procesador
            almacenamiento_y_procesamiento.setVelocidad_del_Procesador(velocidad_del_Procesador);//velocidad del Procesador
            //--------------------------------------------------------------------------------------------------------------------------------

            //resolucion de la Pantalla
            //--------------------------------------------------------------------------------------------------------------------------------
            ResolucionPantalla resolucionPantalla = new ResolucionPantalla();//instancia
            resolucionPantalla.setAncho(ancho);//ancho
            resolucionPantalla.setLargo(largo);//largo
            resolucionPantalla.setCalidad(calidad);//calidad
            //--------------------------------------------------------------------------------------------------------------------------------

            //imagen y pantalla
            //--------------------------------------------------------------------------------------------------------------------------------
            Imagen_y_Pantalla imagen_y_pantalla = new Imagen_y_Pantalla();//instancia
            imagen_y_pantalla.setTipo_de_Pantalla(tipo_de_Pantalla);//tipo de Pantalla
            imagen_y_pantalla.setResolucion_Pantalla(resolucionPantalla);//resolucion de la Pantalla
            imagen_y_pantalla.setTamanioPantalla(tamanioPantalla);//tamanio de la Pantalla
            //--------------------------------------------------------------------------------------------------------------------------------

            //camara
            //--------------------------------------------------------------------------------------------------------------------------------
            Camara camara = new Camara();//instancia
            camara.setTipo_de_CamaraFrontal(tipo_de_CamaraFrontal);//tipo de Camara Frontal
            camara.setResolucionCamaraFrontalPrincipal(resolucionCamaraFrontalPrincipal);//resolucion de la Camara Frontal Principal
            camara.setTipo_de_CamaraPosterior(tipo_de_CamaraPosterior);//tipo de Camara Posterior
            camara.setResolucionCamaraPosteriorPrincipal(resolucionCamaraPosteriorPrincipal);//resolucion de la Camara Posterior Principal
            camara.setResolucionOtrasCamarasPosteriores(resolucionOtrasCamarasPosteriores);//resolucion de las Camaras Posteriores
            camara.setFlashFrontal(flashFrontal);//flash Frontal
            camara.setFlashPosterior(flashPosterior);//flash Posterior
            //--------------------------------------------------------------------------------------------------------------------------------

            //caracteristicas Tecnicas
            //--------------------------------------------------------------------------------------------------------------------------------
            CaracteristicasTecnicas caracteristicasTecnicas = new CaracteristicasTecnicas();//instancia
            caracteristicasTecnicas.setCapacidad_de_la_Bateria(capacidad_de_la_Bateria);//capacidad de la Bateria
            caracteristicasTecnicas.setResistencia_al_Agua(resistencia_al_Agua);//resistencia al Agua
            caracteristicasTecnicas.setOpciones_de_Conectividad(opciones_de_Conectividad);//opciones de Conectividad
            //--------------------------------------------------------------------------------------------------------------------------------

            //conectividad
            //--------------------------------------------------------------------------------------------------------------------------------
            Conectividad conectividad = new Conectividad();//instancia
            conectividad.setRed_de_Transmision_de_Datos(red_de_Transmision_de_Datos);//red de Transmision de Datos
            conectividad.setEspaciosParaSIMCard(espaciosParaSIMCard);//espacios Para la SIM Card
            conectividad.setTipos_de_PuertosEntradas_y_Salidas(tipos_de_PuertosEntradas_y_Salidas);//tipos de Puertos Entradas y Salidas
            //--------------------------------------------------------------------------------------------------------------------------------

            //Tipo de celular
            //--------------------------------------------------------------------------------------------------------------------------------
            TipoDeCelularVO tipoDeCelular = new TipoDeCelularVO();
            tipoDeCelular.setNombre(
                    "Celular "
                            + informacionBasica.getMarca()
                            + " " + informacionBasica.getModelo()
                            + " " + almacenamiento_y_procesamiento.getMemoriaInterna() + "GB"
                            + " " + informacionBasica.getColor()
            );//Nombre
            tipoDeCelular.setPrecio(precio);//Precio
            tipoDeCelular.setInformacionBasica(informacionBasica);//Informacion del celular
            tipoDeCelular.setAlmacenamiento_y_procesamiento(almacenamiento_y_procesamiento);//almacenamiento y procesamiento
            tipoDeCelular.setImagen_y_Pantalla(imagen_y_pantalla);//imagen y pantalla
            tipoDeCelular.setCamara(camara);//camara
            tipoDeCelular.setCaracteristicasTecnicas(caracteristicasTecnicas);//caracteristicas Tecnicas
            tipoDeCelular.setConectividad(conectividad);//conectividad
            //--------------------------------------------------------------------------------------------------------------------------------

            return tipoDeCelular;//Objeto celular con atributos
        } catch (NumberFormatException e) {
            controllerIndex.mostrarAlertError(e.toString());
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }

        return null;
    }

    @FXML
    public void disableCampos() {
        try {
            txtPrecio.setDisable(true);
            cMarca.setDisable(true);
            cModelo.setDisable(true);
            cEsSmartphone.setDisable(true);
            txtColor.setDisable(true);
            cGarantia.setDisable(true);
            cMemoriaInterna.setDisable(true);
            cMemoriaExpandible.setDisable(true);
            cMemoriaRam.setDisable(true);
            cMarcaProcesador.setDisable(true);
            cSistemaOperativo.setDisable(true);
            txtVersionDelSistemaOperativo.setDisable(true);
            cNumeroDeNucleos.setDisable(true);
            cVelocidadDelProcesador.setDisable(true);
            cAnchoDeLaPantalla.setDisable(true);
            cLargoDeLaPantalla.setDisable(true);
            cCalidadDeLaPantalla.setDisable(true);
            cTipoDePantalla.setDisable(true);
            cResolucionDeLaPantalla.setDisable(true);
            cTamanioDeLaPantalla.setDisable(true);
            cTipoDeCamaraFrontal.setDisable(true);
            cResolucionDeLaCamaraFrontalPrincipal.setDisable(true);
            cTipoDeCamaraPosterior.setDisable(true);
            cResolucionOtrasCamarasPosteriores.setDisable(true);
            cResolucionCamaraPosterior.setDisable(true);
            CFlashFrontal.setDisable(true);
            cFlashPosterior.setDisable(true);
            cOpcionesDeConectividad.setDisable(true);
            cCapasidadDeLaBateria.setDisable(true);
            cResistenciaAlAgua.setDisable(true);
            cRedDeTransmisionDeDatos.setDisable(true);
            cEspaciosParaSimCard.setDisable(true);
            cTiposDePuertosYSalidas.setDisable(true);
        } catch (Exception e) {
            controllerIndex.mostrarAlertError(e.toString());
        }
    }
}
