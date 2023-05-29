package proyectofinal_appdistribuidoradevales;

public abstract class Cliente {
    
    protected String nombre;
    protected String telefono;
    protected String direccion;
    protected int dia_pago;
    protected String datos;
    
//------------------------------------------------------------------------------
    
    //Constructor default
    public Cliente() {
        this.direccion = "-----";
        this.nombre = "-----";
        this.telefono = "----";
        this.dia_pago = 0;
    }
    
    //Constructor con argumentos
    public Cliente(String nombre, String telefono, String direccion, int dia_pago) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dia_pago = dia_pago;
    }
    
//------------------------------------------------------------------------------
    
    //Métodos get y set
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public void setDatos(String datos){
        this.datos = datos;
    }
    
}
