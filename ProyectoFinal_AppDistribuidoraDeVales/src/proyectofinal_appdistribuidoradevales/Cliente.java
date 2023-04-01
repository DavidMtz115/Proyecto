
package proyectofinal_appdistribuidoradevales;

/*
 David, Iram, Angel, Luis
 */
public abstract class Cliente {
    
    protected String nombre_cliente;
    protected String telefono;
    protected String direccion;
    protected int dia_pago;
    
    //-----------------------------
    public Cliente() {
        this.direccion = "-----";
        this.nombre_cliente = "-----";
        this.telefono = "----";
        this.dia_pago = 0;
    }
    public Cliente(String nombre_cliente, String telefono, String direccion, int dia_pago) {
        this.nombre_cliente = nombre_cliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dia_pago = dia_pago;
    }
    
    //-------------------------------------------
    public String getNombre_cliente() {
        return nombre_cliente;
    }
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getDia_pago() {
        return dia_pago;
    }
    public void setDia_pago(int dia_pago) {
        this.dia_pago = dia_pago;
    }
    
}
