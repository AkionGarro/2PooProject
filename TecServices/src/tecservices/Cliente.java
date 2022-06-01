package tecservices;

import java.util.ArrayList;
import java.util.Arrays;

public class Cliente {

    private String cedula;
    private String nombre;
    private String direccion;
    private ArrayList<String> telefonos;
    private String contra;
    private ArrayList<IVenta> comprasRealizadas;
    private ArrayList<IProducto> carritoCompras;

    public Cliente(String cedula, String nombre, String direccion, ArrayList<String> telefonos, String contra) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.contra = contra;
        this.comprasRealizadas = new ArrayList<IVenta>();
        this.carritoCompras = new ArrayList<IProducto>();
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void agregarCompra(IVenta venta) {
        this.comprasRealizadas.add(venta);
    }

    public ArrayList<IVenta> getComprasRealizadas() {
        return comprasRealizadas;
    }

    public String getContra() {
        return contra;
    }

    public void AgregarCarrito(IProducto producto) {
        this.carritoCompras.add(producto);
    }

    public ArrayList<IProducto> getCarritoCompras() {
        return carritoCompras;
    }

    public void addComprasRealizada(IVenta comprasRealizadas) {
        this.comprasRealizadas.add(comprasRealizadas);
    }
    public void clearCarrito(){
        this.carritoCompras.clear();
    }

    
    
}
