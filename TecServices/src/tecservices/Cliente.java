package tecservices;

import proyecto2.interfaces.IProducto;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase para crear nuevos clientes de la aplicacion
 *
 * @author garroakion
 */
public class Cliente {

    private String cedula;
    private String nombre;
    private String direccion;
    private ArrayList<String> telefonos;
    private String contra;
    private ArrayList<Ventas> comprasRealizadas;
    private ArrayList<IProducto> carritoCompras;

    /**
     * Constructor para crear nuevos clientes
     *
     * @param cedula Asigna la cedula al cliente
     * @param nombre Asigna el nombre al cliente
     * @param direccion Asigna la direccion al cliente
     * @param telefonos Asigna los telefonos al cliente
     * @param contra Asigna la contra al cliente
     */
    public Cliente(String cedula, String nombre, String direccion, ArrayList<String> telefonos, String contra) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.contra = contra;
        this.comprasRealizadas = new ArrayList<Ventas>();
        this.carritoCompras = new ArrayList<IProducto>();
    }

    /**
     * Obtener la cedula del cliente
     * @return
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Obtener el nombre del cliente
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtener direccion del cliente
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Obtener telefonos
     * @return 
     */
    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    /**
     * Agregar una nueva compra asociada al cliente
     * @param venta 
     */
    public void agregarCompra(Ventas venta) {
        this.comprasRealizadas.add(venta);
    }

    /**
     * Obteniene las ventas agregadas al cliente
     * @return 
     */
    public ArrayList<Ventas> getComprasRealizadas() {
        return comprasRealizadas;
    }

    /**
     * Obtener la conta 
     * @return 
     */
    public String getContra() {
        return contra;
    }

    /**
     * Agrega un producto al carrito del cliente
     * @param producto 
     */
    public void AgregarCarrito(IProducto producto) {
        this.carritoCompras.add(producto);
    }

    /**
     * Obtener los productos agregados al carrito
     * @return 
     */
    public ArrayList<IProducto> getCarritoCompras() {
        return carritoCompras;
    }

    /**
     * Obtener una venta al usuario
     * @param comprasRealizadas 
     */
    public void addComprasRealizada(Ventas comprasRealizadas) {
        this.comprasRealizadas.add(comprasRealizadas);
    }

    /**
     * Limpiar la parte grafica
     */
    public void clearCarrito() {
        this.carritoCompras.clear();
    }

}
