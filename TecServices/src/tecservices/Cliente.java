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

    public Cliente(String cedula, String nombre, String direccion, ArrayList<String> telefonos, String contra) {
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

    public String getDatos() {


        String dsc = "Nombre: " + this.nombre + "\n"
                + "Cedula: " + this.cedula + "\n"
                + "Direccion: " + this.direccion + "\n";
        
        for(int i=0;i<this.telefonos.size();i++){
            dsc += "Telefono " + (i+1)+ ": " + this.telefonos.get(i) + "\n";
        }
                

        return dsc;
    }

}
