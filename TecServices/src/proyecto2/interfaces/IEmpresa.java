package proyecto2.interfaces;

import java.util.ArrayList;

/**
 * Establece los métodos necesarios para el registro de productos ofrecidos para una empresa
 * @author Leonardo Víquez Acuña
 */
public interface IEmpresa {
    public ArrayList<IProducto> getProductos();
    public void addProducto();
    public String getInformacion();
}
