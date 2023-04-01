
package proyectofinal_appdistribuidoradevales;

/*
 David, Iram, Angel, Luis
 */
public class Vale extends Cliente implements Calculos{
    
    private int cantidad;
    private int quincena;
    private String tipo;
    private double adeudo;
    private int deposito;    
    
    //-------------------------------
    public Vale() { 
        super();
        this.cantidad = 0;
        this.quincena = 0;
        this.tipo = "-------";
        this.deposito = 0;
    }
    public Vale(int cantidad, int quincena, String tipo,int deposito, String nombre_cliente, String telefono, String direccion, int dia_pago) {
        super(nombre_cliente, telefono, direccion, dia_pago);
        this.cantidad = cantidad;
        this.quincena = quincena;
        this.tipo = tipo;
        this.deposito = deposito;
    }

    //---------------------------------------
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getQuincena() {
        return quincena;
    }
    public void setQuincena(int quincena) {
        this.quincena = quincena;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getAdeudo() {
        return adeudo;
    }
    public int getDeposito() {
        return deposito;
    }
    public void setDeposito(int deposito) {
        this.deposito = deposito;
    }
    
    //--------------------------------------
    @Override
    public double calcularAdeudo() {
        
        if (cantidad <= 1000 && quincena == 2){
            adeudo = 1500.0;
        }else if(cantidad <= 2000 && quincena == 4){
            adeudo = 3000.0;
        }else if(cantidad <= 3000 && quincena == 6){
            adeudo = 4500.0;
        }else if(cantidad <= 4000 && quincena == 8){
            adeudo = 6000.0;
        } 
            return adeudo;
    }

    @Override
    public double pagos() {
        if(dia_pago == 15 || dia_pago == 30){
            adeudo = adeudo - deposito;
        }else if(dia_pago != 15 || dia_pago != 30){
            adeudo = adeudo + (adeudo * .20);
        }
            return adeudo;
    }

    @Override
    public void imprimirDatos() {
        System.out.println("VALE:");
        System.out.println("Nombre del Cliente: " +nombre_cliente);
        System.out.println("Asunto del Vale: " +tipo);
        System.out.println("Telefono: " +telefono);
        System.out.println("Dirección: " +direccion);
        System.out.println("Cantidad solicitada: $" +cantidad);
        System.out.println("Quincensa: " +quincena);
        System.out.println("Aduedo: $" +adeudo);
    }
    
}
