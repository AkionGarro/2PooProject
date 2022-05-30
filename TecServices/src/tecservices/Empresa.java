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

}
