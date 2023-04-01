
package proyectofinal_appdistribuidoradevales;

/*
 David, Iram, Angel, Luis
 */
public class ProyectoFinal_AppDistribuidoraDeVales {

    public static void main(String[] args) {
        // TODO code application logic here
        Vale val = new Vale(1001, 4, "Credito", 100, "Elangel", "56498162168", "Banca#14-Plaza Central", 16);
        val.calcularAdeudo();
        val.pagos();
        val.imprimirDatos();
        
        
    }
    
}
