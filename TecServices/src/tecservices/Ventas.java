
package tecservices;

import java.util.ArrayList;


public class Ventas implements IVenta{
    
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
        
    

    
}
