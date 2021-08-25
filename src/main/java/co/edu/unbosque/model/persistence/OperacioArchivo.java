package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.CelularVO;
import co.edu.unbosque.model.TipoDeCelularVO;
import co.edu.unbosque.model.dto.CelularBO;
import co.edu.unbosque.model.dto.TipoDeCelularBO;
import javafx.collections.FXCollections;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class OperacioArchivo {
    /**
     * Método para leer un archivo
     *
     * @param archivo archivo a leer
     */
    public static void leerArchivoCelular(String archivo) {
        FileInputStream fichero = null;
        try {
            fichero = new FileInputStream(archivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fichero);
            List<CelularVO> list = (List<CelularVO>) objectInputStream.readObject();
            CelularBO.setList(FXCollections.observableList(list));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para escribir en un archivo
     *
     * @param archivo archivo a escribir
     */
    public static void escribirArchivoCelular(String archivo) {
        FileOutputStream fichero = null;
        try {
            fichero = new FileOutputStream(archivo);
            ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(fichero);
            ObjectOutputStream.writeObject(new ArrayList<CelularVO>(CelularBO.getList()));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                assert fichero != null;
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Método para leer un archivo
     *
     * @param archivo archivo a leer
     */
    public static void leerArchivoTipoDeCelular(String archivo) {
        FileInputStream fichero = null;
        try {
            fichero = new FileInputStream(archivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fichero);
            List<TipoDeCelularVO> list = (List<TipoDeCelularVO>) objectInputStream.readObject();
            TipoDeCelularBO.setList(FXCollections.observableList(list));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para escribir en un archivo
     *
     * @param archivo archivo a escribir
     */
    public static void escribirArchivoTipoDeCelular(String archivo) {
        FileOutputStream fichero = null;
        try {
            fichero = new FileOutputStream(archivo);
            ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(fichero);
            ObjectOutputStream.writeObject(new ArrayList<TipoDeCelularVO>(TipoDeCelularBO.getList()));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                assert fichero != null;
                fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
