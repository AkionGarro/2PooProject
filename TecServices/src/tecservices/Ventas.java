package tecservices;

import proyecto2.interfaces.IVenta;
import proyecto2.interfaces.IProducto;
import java.util.ArrayList;

public class Ventas implements IVenta {

    private Double montoTotal;
    private Double montoSinImpuesto;
    private Double Impuesto;
    private Double costpEnvio;
    private String detalleProductos;
    private ArrayList<IProducto> carritoCompras;

    @Override
    public void agregarProductos(IProducto producto) {

    }

    @Override
    public void eliminarProducto(IProducto producto) {

    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getMontoSinImpuesto() {
        return montoSinImpuesto;
    }

    public void setMontoSinImpuesto(Double montoSinImpuesto) {
        this.montoSinImpuesto = montoSinImpuesto;
    }

    public Double getImpuesto() {
        return Impuesto;
    }

    public void setImpuesto(Double Impuesto) {
        this.Impuesto = Impuesto;
    }

    public Double getCostpEnvio() {
        return costpEnvio;
    }

    public void setCostpEnvio(Double costpEnvio) {
        this.costpEnvio = costpEnvio;
    }

    public String getDetalleProductos() {
        return detalleProductos;
    }

    public void setDetalleProductos(String detalleProductos) {
        this.detalleProductos = detalleProductos;
    }

    public ArrayList<IProducto> getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(ArrayList<IProducto> carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    public String obtenerInformacionCompras() {

        String detalles
                = "<html>" + "Monto Total: " + this.montoTotal + "<br/>"
                + "<html>" + "Monto sin impuesto: " + this.montoSinImpuesto + "<br/>"
                + "<html>" + "Impuesto: " + this.Impuesto + "<br/>"
                + "<html>" + "Costo Envio: " + this.costpEnvio + "<br/>";
        return detalles;

    }
}
