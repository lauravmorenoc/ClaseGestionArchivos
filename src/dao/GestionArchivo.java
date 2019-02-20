/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

/**
 *
 * @author lamorenoca
 */

//Esta es la parte de persistencia
public class GestionArchivo {
    private String ruta;
    public GestionArchivo(String ruta){
        this.ruta=ruta;
    }
    
    public boolean guardar(ArrayList<Integer> bd) throws FileNotFoundException, IOException{ //Guarda los datos del arraylist en un archivo, separados por espacios
        File archivo=new File(this.ruta);
        if(!archivo.exists())
            archivo.createNewFile();//le coloca como nombre la ruta de esta clase (this.ruta)
        PrintStream salida=new PrintStream(archivo);
        
        for(Integer value:bd){
            salida.print(value);
            salida.print(" ");
        }
        salida.flush(); //Hace que la informacion se quede en el archivo
        salida.close();
        return true;
    }
    
    //Carga los datos del archivo en el arreglo y lo retorna;
    public ArrayList<Integer> cargar() throws FileNotFoundException{ //añade todos los enteros de este archivo, los coloca en un arreglo y lo retorna
        ArrayList<Integer> data=new ArrayList<>();
        Scanner lectura= new Scanner(new File(this.ruta));
        while(lectura.hasNextInt()){
            data.add(lectura.nextInt());
        }
        lectura.close();
        return data;
    }
    
}
