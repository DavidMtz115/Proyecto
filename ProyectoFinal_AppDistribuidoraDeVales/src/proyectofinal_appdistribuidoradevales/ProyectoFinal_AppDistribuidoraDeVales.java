package proyectofinal_appdistribuidoradevales;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
ÁNGEL EDUARDO ARIZPE CARRILLO
IRAM ARREDONDO RAMIREZ
DAVID ALBERTO MARTÍNEZ ESPINOZA
LUIS CARLOS MEZA LÓPEZ
 */

public class ProyectoFinal_AppDistribuidoraDeVales {

    public static void main(String[] args) {
        
        /* Llamada al método generarVale para la creación de los vales en
        documentos de texto una vez introducidos los datos */
        try {
            generarVale();
        } catch (IOException ex) {
            Logger.getLogger(ProyectoFinal_AppDistribuidoraDeVales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
//------------------------------------------------------------------------------

    public static void generarVale() throws IOException {
        
        /* Pregunta al usuario cuantos vales desea crear y se crea un arreglo del 
        mismo tamaño de objetos de tipo vale que el usuario haya querido crear */
        Cliente[] cli;
        Scanner A = new Scanner(System.in);
        System.out.println("¿Cuántos vales quiere generar?");
        int cant = A.nextInt();
        cli = new Cliente[cant];
        
        /* Ciclo for que repite las preguntas referentes a los datos hasta haber 
        alcanzado la cantidad de objetos que el usuario indicó anteriormente */
        for (int i = 0; i < cant; i++) {
            Vale val = new Vale();
            val.setDatos(A.nextLine()); //Esto se agrego como respuesta a que no se salteara el nextline del nombre
            System.out.println("Introduzca el nombre del cliente");
            val.setNombre(A.nextLine());
            System.out.println("Introduzca el tipo de vale");
            val.setTipo(A.nextLine());
            System.out.println("Introduzca el número de teléfono del cliente");
            val.setTelefono(A.nextLine());
            System.out.println("Introduzca la dirección del cliente");
            val.setDireccion(A.nextLine());
            //La cantidad del vale definirá las quincenas dadas para pagarlo
            System.out.println("Introduzca la cantidad del vale (0-4000)");
            do {
                val.setCantidad(A.nextInt());
            } while (val.getCantidad() < 0 && val.getCantidad() > 4000);
            if (val.getCantidad() <= 1000) {
                val.setQuincena(2);
            } else if (val.getCantidad() > 1000 && val.getCantidad() <= 2000) {
                val.setQuincena(4);
            } else if (val.getCantidad() > 2000 && val.getCantidad() <= 3000) {
                val.setQuincena(6);
            } else if (val.getCantidad() > 3000 && val.getCantidad() <= 4000) {
                val.setQuincena(8);
            }
            
            /* El día de pago servirá para calcular un posible cargo extra por
            un pago fuera de tiempo */
            System.out.println("Número del día en que pagó");
            val.setDia_pago(A.nextInt());
            System.out.println("Cantidad depositada");
            val.setDeposito(A.nextInt());
            cli[i] = val;
            System.out.println("");
        }
        
        /* Creación de los documentos de texto con los datos de cada cliente 
        hasta alcanzar la cantidad definida anteriormente*/
        //Uso del buffered writer
        for (int i = 0; i < cli.length; i++) {
            Vale val = (Vale) cli[i];
            val.calcularAdeudo();
            val.pagos();
            String ruta = "C:\\Archivos\\Clientes\\";
            String cliente = val.getNombre() + ".txt";
            writeUsingBufferedWriter(ruta + cliente, "Nombre: " + val.getNombre() + "\n"
                    + "Asunto del Vale: " + val.getTipo() + "\n"
                    + "Telefono: " + val.getTelefono() + "\n"
                    + "Dirección: " + val.getDireccion() + "\n"
                    + "Cantidad solicitada: $" + val.getCantidad() + "\n"
                    + "Quincena: " + val.getQuincena() + "\n"
                    + "Adeudo: $" + val.getAdeudo());
            System.out.println("");
        }
    }
    
//------------------------------------------------------------------------------
    
    /* Creación de la estructura del buffered writer para la generación de los
    documentos de texto */
    public static void writeUsingBufferedWriter(String ruta, String datos) throws IOException {
        File file = new File(ruta);
        FileWriter filewriter = new FileWriter(file);
        BufferedWriter bufwriter = new BufferedWriter(filewriter);
        bufwriter.write(datos);
        bufwriter.newLine();
        bufwriter.close();
        filewriter.close();
    }
}
