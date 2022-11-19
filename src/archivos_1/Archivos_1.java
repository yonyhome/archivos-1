
package archivos_1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Archivos_1 {

    static String nombre;
    static int s=0;

    public static void main(String[] args) {
        mostrarMenu();
    }
    
    
    public static void mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;
 
        do {
 
            System.out.println("1-.Crear Fichero");
            System.out.println("2-.Mostrar Fichero");
            System.out.println("3-.Insertar Registros");
            System.out.println("4-.Salir");
            System.out.print("Digite opcion: "); 
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1: {
                    crearFichero();
                    break;
                }
                case 2: {
                    //if(s==1){
                      //  System.out.println("yy");
                    mostrarFichero();
                    //}
                    //else
                     //   System.out.println("Debe crear primero el archivo");
                    break;
                }
                case 3:{
                    //if (s==1){
                    ingresarFichero();
                    //}
                    //else
                       // System.out.println("Debe crear primero el archivo");
                    break;
                }
                case 4: {
                    System.out.println("Gracias por usar el programa");
                break;
                }
                default: {
                    System.out.println("Opcion incorrecta");
                }
 
            }
        } while (opcion != 4);
    }
 
    public static String elegirNombre() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el nombre del Archivo");
        nombre = teclado.nextLine();
        return nombre;
    }
    
     public static String devolverNombre() {
        return nombre;
    }
    
    public static void crearFichero() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("archivo.txt");
            //File archivo = new File("archivo.txt");
            PrintWriter pw = new PrintWriter(fw);
            /*if(archivo.exists()) {
                System.out.println("Archivo creado");
                s=1;
            }
            else{*/
              
            escribirFichero(pw);
            //}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
 
    }
 
 
 
 
    public static void escribirFichero(PrintWriter pw) throws Exception {
        Scanner teclado = new Scanner(System.in);
        String opcion;
        System.out.println("Introduce tu nombre");
        opcion = teclado.nextLine();
        pw.print(opcion+", ");
        System.out.println("Introduce tus apellidos");
        opcion = teclado.nextLine();
        pw.print(opcion+", ");
        System.out.println("Introduce tu lugar de nacimiento");
        opcion = teclado.nextLine();
        pw.print(opcion);
        pw.println();
    }
    public static void leerFichero(BufferedReader br) throws Exception {
        String linea;
        linea = br.readLine();
        while (linea != null) {
 
            System.out.println(linea);
            linea = br.readLine();
 
        }
    }
 
    public static void ingresarFichero() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("archivo.txt",true);
            PrintWriter pw = new PrintWriter(fw);
            escribirFichero(pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
 
    }
    
    public static void mostrarFichero() {
        FileReader fr = null;
        try {
            File fichero = new File("archivo.txt");
            fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            leerFichero(br);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
 
    }
 
    
 
}
