
package tecservices;

import java.util.ArrayList;


public class Ventas implements IVenta{
    
    	private Double montoTotal;
	private Double montoSinImpuesto;
	private Double Impuesto;
	private Double costEnvio;
        private ArrayList<IProducto> carritoCompras;

    @Override
    public void agregarProductos(IProducto producto) {
      
    }

    @Override
    public void eliminarProducto(IProducto producto) {
       
    }
        
    

    
}
