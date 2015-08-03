package lema.generadorCodigo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {
    public String ruta;
    FileWriter w;
    BufferedWriter bw;
    PrintWriter wr; 
    
    public Archivo(String nomArchivo){
        setRuta(nomArchivo);
    }
    public void setRuta(String nomArchivo)
    {
        ruta = "d:/" + nomArchivo + ".ll";
    }
    
    public void crearArchivoIR() throws IOException{
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear el fichero de texto.");
        }
    }
    public void abrir(){
        try{
            w = new FileWriter(ruta);
            bw = new BufferedWriter(w);
            wr = new PrintWriter(bw);  
        }catch(IOException e){};
    }
    public void cerrar(){
        try{
            wr.close();
            bw.close();  
            wr = null;
        }catch(IOException e){};
    }
    public void reescrbirIR(String codigo){
        abrir();
        wr.write(codigo);//escribimos en el archivo
    }
    public void escrbirIR(String codigo){
        if(wr == null)
            abrir();
        wr.append(codigo); //concatenamos en el archivo sin borrar lo existente
    }
    public void leer(){
        if(wr != null)
            cerrar();
        try{
            FileReader lector=new FileReader(ruta);
            BufferedReader contenido=new BufferedReader(lector);
            
            String texto="";
            while((texto=contenido.readLine())!=null){
                System.out.println(texto);
            }
        }catch(Exception e){
            System.out.println("Error al leer");
        }
    }
}
