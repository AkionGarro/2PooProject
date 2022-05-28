/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecservices;

/**
 *
 * @author garroakion
 */
public class Producto implements IProducto {

    private String nombreProducto;
    private Integer cantidad;
    private String tipo;
    private Double costo;
    private IEmpresa empresa;

    public Producto() {
        setProducto();

    }

    @Override
    public double getCosto() {
        return this.costo;

    }

    @Override
    public IEmpresa getEmpresa() {

        return this.empresa;

    }

    @Override
    public void setProducto() {

        ingresarProducto ventana = new ingresarProducto();
        ventana.setVisible(true);
        if (ventana.flag == true) {
            this.nombreProducto = ventana.getNombreProducto();
            this.tipo = ventana.getTipoProducto();
            this.costo = ventana.getCostoProducto();
            this.empresa = (IEmpresa) this;
            ventana.dispose();
        }

    }

    @Override
    public String getDetalles() {

        String detalles = "Nombre Producto: " + this.nombreProducto + "\n"
                + "Costo: " + this.costo + "\n"
                + "Tipo: " + this.tipo + "\n";

        return detalles;

    }

}
