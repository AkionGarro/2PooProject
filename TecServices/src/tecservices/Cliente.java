package tecservices;

import java.util.ArrayList;

public class Cliente {

    private String cedula;
    private String nombre;
    private String direccion;
    private ArrayList<Integer> telefonos;
    private String contra;
    private ArrayList<IVenta> comprasRealizadas;

    public Cliente(String cedula, String nombre, String direccion, ArrayList<Integer> telefonos, String contra) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.contra = contra;
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

    public ArrayList<Integer> getTelefonos() {
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
    
    

}
