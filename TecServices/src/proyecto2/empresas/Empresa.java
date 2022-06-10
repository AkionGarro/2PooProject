/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2.empresas;

import proyecto2.interfaces.IProducto;
import proyecto2.interfaces.IEmpresa;
import java.util.ArrayList;
import java.util.Set;

public class Empresa implements IEmpresa {

    private String nombre;
    private String direccion;
    private String tipo;
    private Integer telefono;
    private ArrayList<IProducto> productosEmpresa;
    private static Empresa instance = null;

    public Empresa() {
        this.nombre = "Happy Pub";
        this.direccion = "Frente al tec";
        this.tipo = "Restaurante";
        this.telefono = 24756364;
        productosEmpresa = new ArrayList<IProducto>();
        productosEmpresa = Producto.generatedProductsComidasRapida(this);

    }

    private Empresa(String nombre, String dir, String tipo, Integer telefono) {
        this.nombre = nombre;
        this.direccion = dir;
        this.tipo = tipo;
        this.telefono = telefono;
        productosEmpresa = new ArrayList<IProducto>();
    }

    public static Empresa getInstance() {
        if (instance == null) {
            instance = new Empresa();
        }
        return instance;
    }

    @Override
    public ArrayList<IProducto> getProductos() {
        return this.productosEmpresa;
    }

    @Override
    public void addProducto() {
        Producto p1 = new Producto();
        p1.setEmpresa(this);
        this.productosEmpresa.add(p1);
        p1.cleanFields();

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

    @Override
    public String getInformacion() {
        String dsc = "<html>" + "Nombre: " + this.nombre + "<br/>"
                + "<html>" + "Dirección: " + this.direccion + "<br/>"
                + "<html>" + "Tipo: " + this.tipo + "<br/>"
                + "<html>" + "Telefono: " + this.telefono + "<br/>";

        return dsc;
    }

    public static ArrayList<IEmpresa> getEmpresasGeneradas() {
        ArrayList<IEmpresa> empresasTemp = new ArrayList<IEmpresa>();

        Empresa e1 = new Empresa("Happy pub", "Santa Clara", "Restaurante", 24606096);
        Empresa e2 = new Empresa("Talamanca", "Florencia", "Farmacia", 24607080);
        Empresa e3 = new Empresa("Pali", "Florencia", "Supermercado", 24758596);
        Empresa e4 = new Empresa("Kenko", "Ciudad Quesada", "Restaurante", 24758522);

        e1.setProductosEmpresa(Producto.generatedProductsComidasRapida(e1));
        e2.setProductosEmpresa(Producto.generatedProductsFarmacia(e2));
        e3.setProductosEmpresa(Producto.generatedProductsSupermercado(e3));
        e4.setProductosEmpresa(Producto.generatedProductsRestaurante(e4));

        empresasTemp.add(e1);
        empresasTemp.add(e2);
        empresasTemp.add(e3);
        empresasTemp.add(e4);

        return empresasTemp;
    }

}
