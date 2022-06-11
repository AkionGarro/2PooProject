package proyecto2.interfaces;

/**
 * Establece los métodos necesarios para agregrar y eliminar productos de una venta
 * @author Leonardo Víquez Acuña
 */
public interface IVenta
{
    public void agregarProductos(IProducto producto);
    public void eliminarProducto(IProducto producto);
}