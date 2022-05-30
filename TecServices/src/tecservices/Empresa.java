/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecservices;

import java.util.ArrayList;

public class Empresa implements IEmpresa {

    private String nombre;
    private String direccion;
    private String tipo;
    private Integer telefono;
    private ArrayList<IProducto> productosEmpresa;

    public Empresa() {
        this.nombre = "Happy Pub";
        this.direccion = "Frente al tec";
        this.tipo = "Restaurante";
        this.telefono = 24756364;
        productosEmpresa = new ArrayList<IProducto>();

    }

    @Override
    public ArrayList<IProducto> getProductos() {
        return this.productosEmpresa;
    }

    @Override
    public void addProducto() {
        Producto p1 = new Producto();
        this.productosEmpresa.add(p1);
        p1.cleanFields();

    }

    @Override
    public void getInformacion() {

    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public ArrayList<IProducto> getProductosEmpresa() {
        return productosEmpresa;
    }

    public void setProductosEmpresa(ArrayList<IProducto> productosEmpresa) {
        this.productosEmpresa = productosEmpresa;
    }

    public String getDescripcion() {
        String dsc = "<html>" + "Nombre: " + this.nombre + "<br/>"
                + "<html>" + "Dirección: " + this.direccion + "<br/>"
                + "<html>" + "Tipo: " + this.tipo + "<br/>"
                + "<html>" + "Telefono: " + this.telefono + "<br/>";

        return dsc;
    }

}
