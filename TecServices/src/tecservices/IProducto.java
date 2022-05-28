package tecservices;


import tecservices.IEmpresa;


/**
 * Establece los métodos necesarios para la integración de productos con las empresas y las ventas respectivas
 * @author Leonardo Víquez Acuña
 */
public interface IProducto
{
    public double getCosto();
    public IEmpresa getEmpresa();
    public void setProducto();
    public String getDetalles();
}
