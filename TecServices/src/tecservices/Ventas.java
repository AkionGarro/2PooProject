package tecservices;

import proyecto2.interfaces.IVenta;
import proyecto2.interfaces.IProducto;
import java.util.ArrayList;

/**
 * 
 * @author garroakion
 */
public class Ventas implements IVenta {

    private Double montoTotal;
    private Double montoSinImpuesto;
    private Double Impuesto;
    private Double costpEnvio;
    private String detalleProductos;
    private ArrayList<IProducto> carritoCompras;

    /**
     * Asignar producto a la venta
     * @param producto 
     */
    @Override
    public void agregarProductos(IProducto producto) {

    }

    /**
     * Eliminar producto de la venta
     * @param producto 
     */
    @Override
    public void eliminarProducto(IProducto producto) {

    }

    /**
     * Obtener el monto total
     * @return 
     */
    public Double getMontoTotal() {
        return montoTotal;
    }

    /**
     * Asignar monto total 
     * @param montoTotal 
     */
    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * Obtener monto sin impuesto
     * @return 
     */
    public Double getMontoSinImpuesto() {
        return montoSinImpuesto;
    }

    /**
     * Asignar monto sin puesto
     * @param montoSinImpuesto 
     */
    public void setMontoSinImpuesto(Double montoSinImpuesto) {
        this.montoSinImpuesto = montoSinImpuesto;
    }

    /**
     * Obtener el impuesto
     * @return 
     */
    public Double getImpuesto() {
        return Impuesto;
    }

    /**
     * Asignar impuesto
     * @param Impuesto 
     */
    public void setImpuesto(Double Impuesto) {
        this.Impuesto = Impuesto;
    }

    /**
     * Obtener costo de envio
     * @return 
     */
    public Double getCostpEnvio() {
        return costpEnvio;
    }

    /**
     * Asignar costo de envio
     * @param costpEnvio 
     */
    public void setCostpEnvio(Double costpEnvio) {
        this.costpEnvio = costpEnvio;
    }

    /**
     * Obtner los detalles de la venta
     * @return 
     */
    public String getDetalleProductos() {
        return detalleProductos;
    }

    /**
     * Asignar los detalles de la venta
     * @param detalleProductos 
     */
    public void setDetalleProductos(String detalleProductos) {
        this.detalleProductos = detalleProductos;
    }

    /**
     * Obtener el los productos de la venta
     * @return 
     */
    public ArrayList<IProducto> getCarritoCompras() {
        return carritoCompras;
    }

    /**
     * Asignar productos a la venta
     * @param carritoCompras 
     */
    public void setCarritoCompras(ArrayList<IProducto> carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    /**
     * Obtener la informacion de las compras
     * @return 
     */
    public String obtenerInformacionCompras() {

        String detalles
                = "<html>" + "Monto Total: " + this.montoTotal + "<br/>"
                + "<html>" + "Monto sin impuesto: " + this.montoSinImpuesto + "<br/>"
                + "<html>" + "Impuesto: " + this.Impuesto + "<br/>"
                + "<html>" + "Costo Envio: " + this.costpEnvio + "<br/>";
        return detalles;

    }
}
