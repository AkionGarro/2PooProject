/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2.empresas;

import proyecto2.interfaces.IProducto;
import proyecto2.interfaces.IEmpresa;
import java.util.ArrayList;
import java.util.Set;

/**
 * Clase para la creacion de empresas
 * @author garroakion
 */
public class Empresa implements IEmpresa {

    private String nombre;
    private String direccion;
    private String tipo;
    private Integer telefono;
    private ArrayList<IProducto> productosEmpresa;
    private static Empresa instance = null;

    /**
     * Constructor para el singlethon
     */
    private Empresa() {
        this.nombre = "Happy Pub";
        this.direccion = "Frente al tec";
        this.tipo = "Restaurante";
        this.telefono = 24756364;
        productosEmpresa = new ArrayList<IProducto>();
        productosEmpresa = Producto.generatedProductsComidasRapida(this);

    }

    /**
     * Constructor para agilizar el proceso de creacion de empresas
     * @param nombre
     * @param dir
     * @param tipo
     * @param telefono 
     */
    private Empresa(String nombre, String dir, String tipo, Integer telefono) {
        this.nombre = nombre;
        this.direccion = dir;
        this.tipo = tipo;
        this.telefono = telefono;
        productosEmpresa = new ArrayList<IProducto>();
    }

    /**
     * Obtener la instancia de la empresa
     * @return Empresa creada
     */
    public static Empresa getInstance() {
        if (instance == null) {
            instance = new Empresa();
        }
        return instance;
    }

    /**
     * Obtener los productos de la empresa
     * @return 
     */
    @Override
    public ArrayList<IProducto> getProductos() {
        return this.productosEmpresa;
    }

    /**
     * Agregar productos a la empresa
     */
    @Override
    public void addProducto() {
        Producto p1 = Producto.getInstance();
        p1.setEmpresa(this);
        this.productosEmpresa.add(p1);
        p1.cleanFields();

    }



    /**
     * Obtener Nombre de la empresa
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtener direccion de la empresa
     * @return Direccion
     */
    public String getDireccion() {
        return direccion;
    }

    
    /**
     * Obtener tipo de empresa
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtener telefono
     * @return 
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * Obtener los productos de la empresas
     * @return 
     */
    public ArrayList<IProducto> getProductosEmpresa() {
        return productosEmpresa;
    }

    /**
     *  Asignar productos a la empresa
     * @param productosEmpresa 
     */
    public void setProductosEmpresa(ArrayList<IProducto> productosEmpresa) {
        this.productosEmpresa = productosEmpresa;
    }

    /**
     * Obtener la informacion de la empresa
     * @return 
     */
    @Override
    public String getInformacion() {
        String dsc = "<html>" + "Nombre: " + this.nombre + "<br/>"
                + "<html>" + "Dirección: " + this.direccion + "<br/>"
                + "<html>" + "Tipo: " + this.tipo + "<br/>"
                + "<html>" + "Telefono: " + this.telefono + "<br/>";

        return dsc;
    }

    /**
     * Obtener empresas generadas para una implementacion rapida
     * @return 
     */
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
