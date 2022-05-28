package tecservices;

/**
 * Establece los métodos básicos que debe cumplir toda venta
 * @author Leonardo Víquez Acuña
 */
public interface IVenta
{
    public void agregarProductos(IProducto producto);
    public void eliminarProducto(IProducto producto);
}