package ficjhonar;

import java.io.*;

/**
 *
 * @author Jhoel Alexander Narváez Valarezo
 */
public class FicJhoNar {
    //funcion que imprimer carpetas y subcarpetas

    public static void imprimir(File archivos) {
        File[] archivosApli = archivos.listFiles();
        for (File archivo : archivosApli) {
            System.out.printf("Nombre: %s %n", archivo);
            //se llama a si mismo por si tiene subdirectorios
            if (archivo.isDirectory()) {
                imprimir(archivo);
            } else if (archivo.isFile()) {
                String txt = "";
                try (FileReader fileLeer = new FileReader(archivo)) {
                    BufferedReader bF = new BufferedReader(fileLeer);
                    System.out.println("El contenido de "+ archivo.getName()+" es: ");
                    while ((txt = bF.readLine()) != null) {
                        System.out.println(txt);
                    }
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo: " + archivo.getName());
                }

            }
        }
    }

    public static void main(String[] args) {
        //declaramos el padre
        File padre = new File("ejMs");
        padre.mkdir(); //creamos al padre con esto
        //ahora APLI y subcarpetas
        File apli = new File(padre, "APLI");
        apli.mkdir();
        //definimos
        File word = new File(apli, "WORD");
        File excel = new File(apli, "EXCEL");
        File access = new File(apli, "ACCESS");
        //creamos
        word.mkdir();
        excel.mkdir();
        access.mkdir();
        //ahora APLI y subcarpetas
        File prog = new File(padre, "PROG");
        prog.mkdir();
        //definimos
        File basic = new File(prog, "BASIC");
        File pascal = new File(prog, "PASCAL");
        File fortran = new File(prog, "FORTRAN");
        //creamos
        basic.mkdir();
        pascal.mkdir();
        fortran.mkdir();
        //directorio varios
        File varios = new File(padre, "VARIOS");
        varios.mkdir();

        //EJERCICIO 2 
        System.out.println("Contenido de ejMS: ");
        imprimir(padre);

        //Ejercicio 3
        //borrar pascal y varios
        if (pascal.delete() && varios.delete()) {
            System.out.println("\nSe han borrado las carpetas de PASCAL y VARIOS\n");
            imprimir(padre);
            System.out.println("");
        }

        //EJERCICIO 4
        //mostrar APLI y Subcarpetas
        System.out.println("Contenido de APLI: ");
        //guarda lista de archivos en un arrays de ficheros
        File[] archivosApli = apli.listFiles();
        System.out.printf("Ficheros en el directorio actual: %d %n", archivosApli.length);
        System.out.println("");
        //bucle que recorra el array
        for (File archivo : archivosApli) {
            //va mostrando los archivos del arrays
            System.out.printf("Nombre: %s %n", archivo);
            //guardamos en otro array los ficheros de los ficheros de archivos
            File[] archi = archivo.listFiles();
            for (File archi1 : archi) {
                //ahora si es un directorio, el bucle lo recorre mostrando su contenido
                if (archi1.isDirectory()) {
                    System.out.println("Nombre: " + archi1);
                }
            }

        }
        //EJERCICIO 5
        File nuevo = new File(word, "NUEVO");

        if (nuevo.mkdir()) {
            System.out.println("\nSe ha creado la carpeta NUEVO\n");
        }
        //mostrar APLI y Subcarpetas
        System.out.println("Contenido de APLI: ");
        imprimir(apli);

        //EJERCICIO 6
        System.out.println("\nRenombrando Fortran a java y basic a PHP\n");
        //la gaurdamos en una variable porque la vamos a udar luego
        File java = new File(prog, "JAVA");
        fortran.renameTo(java);
        basic.renameTo(new File(prog, "PHP"));
        imprimir(prog);

        //ejercicio 7
        //crear ejercicios.txt en JAVA
        //  File eje = new File(java, "EJERCICIOS.TXT");
        File eje = new File(java, "EJERCICIOS.TXT");
        try {
            //creamos el fichero ejerrr
           
            if ( eje.createNewFile()) {
                System.out.println("Se ha creado EJERCICIOS.TXT");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //Ejercicio 8
        //escribir el Ejercicios.txt
        String txt = "";
        try (FileWriter fileEscribir = new FileWriter(eje)) {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader bF = new BufferedReader(isr);
            System.out.println("Inserte el texto que desea escribir en el fichero: ");
            txt = bF.readLine();
            fileEscribir.write(txt);
        } catch (IOException e) {
            System.out.println("Error");
        }

        //Ejercicio 9
        try (FileReader fileLeer = new FileReader(eje)) {
            BufferedReader bF = new BufferedReader(fileLeer);
            System.out.println("El contenido del fichero es: ");
            bF.readLine();
            while (txt != null) {
                System.out.println(txt);
                txt = bF.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        System.out.println("");
        
        //EJercicio 10
        imprimir(padre);
    }

}
