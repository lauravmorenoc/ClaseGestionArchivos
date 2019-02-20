/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execute;

import Gui.Gui;
import dao.DAO;
import dao.GestionArchivo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamorenoca
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Gestion de Enteros");
        Gui gui=new Gui();
        DAO bd=new DAO();
        GestionArchivo archivos=new GestionArchivo("enteros.txt");
        Scanner lectura=new Scanner(System.in);
        int opcion=0;
        int valor1=0;
        int valor2=0;
        while(true){
            opcion=gui.menu();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese dato");
                    valor1=lectura.nextInt();
                    bd.addBd(valor1);
                    break;
                case 2:
                    System.out.println("Guardando..");
                    try{
                    archivos.guardar(bd.getBd());
                    }catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    System.out.println("Cargando archivo");
                    ArrayList <Integer> respaldo = null;
                    try {
                        respaldo = archivos.cargar();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    bd.setBd(archivos.cargar());
                    break;
                case 4:
                    System.out.println("Lista");
                    int contador=0;
                    for(Integer dato:bd.getBd()){
                        System.out.println("Dato numero " + contador + ": " + dato);
                    }
                    break;
                case 5:
                    System.out.println("Ingrese posicion");
                    valor1=lectura.nextInt();
                    System.out.println("Ingrese numero");
                    valor2=lectura.nextInt();
                    bd.modificar(valor2, valor1);
                    break;
            }
        }
    }
}
