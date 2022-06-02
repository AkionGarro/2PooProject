/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecservices;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Producto implements IProducto {

    private JFrame ventana;
    private javax.swing.JTextField costoProductoField;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JTextField nombreProductoField;
    protected javax.swing.JPanel productoPanel;
    private javax.swing.JTextField tipoProductoField;
    private Boolean flag = false;
    private String nombreProducto;
    private Integer cantidad;
    private String tipo;
    private Double costo;
    private Empresa empresa;

    public Producto() {
        setProducto();
    }

    private Producto(String nombre, String tipo, Double costo, Empresa empresa) {
        this.nombreProducto = nombre;
        this.tipo = tipo;
        this.costo = costo;
        this.empresa = empresa;
        this.cantidad = 0;
    }

    @Override
    public double getCosto() {
        return this.costo;

    }

    @Override
    public IEmpresa getEmpresa() {
        return this.empresa;
    }

    protected void agregarEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    private void configComponents() {
        ventana = new JFrame();
        ventana.setVisible(true);
        ventana.setLocation(200, 92);
        productoPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        nombreProductoField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tipoProductoField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        costoProductoField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        ventana.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ventana.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productoPanel.setBackground(new java.awt.Color(255, 255, 255));
        productoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Producto");
        productoPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 80));

        jLabel22.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Nombre Producto:");
        productoPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 160, 30));

        nombreProductoField.setBackground(new java.awt.Color(255, 255, 255));
        nombreProductoField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nombreProductoField.setForeground(new java.awt.Color(0, 0, 0));

        productoPanel.add(nombreProductoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 180, 30));

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Tipo Producto:");
        productoPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 130, 30));

        tipoProductoField.setBackground(new java.awt.Color(255, 255, 255));
        tipoProductoField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tipoProductoField.setForeground(new java.awt.Color(0, 0, 0));

        productoPanel.add(tipoProductoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 180, 30));

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Costo:");
        productoPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 60, 30));

        costoProductoField.setBackground(new java.awt.Color(255, 255, 255));
        costoProductoField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        costoProductoField.setForeground(new java.awt.Color(0, 0, 0));

        productoPanel.add(costoProductoField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 180, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Registrar Producto");

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        productoPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        ventana.getContentPane().add(productoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 600));

        ventana.pack();
    }

    @Override
    public void setProducto() {
        configComponents();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (costoProductoField.getText().equals("") || nombreProductoField.getText().equals("") || tipoProductoField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        } else {
            JOptionPane.showMessageDialog(null, "Registrado Correctamente");
            this.flag = true;
            this.costo = Double.parseDouble(costoProductoField.getText());
            this.nombreProducto = nombreProductoField.getText();
            this.tipo = tipoProductoField.getText();
            this.cantidad = 0;

            this.ventana.dispose();

        }
    }

    public void cleanFields() {
        this.costoProductoField.setText("");
        nombreProductoField.setText("");
        tipoProductoField.setText("");
    }

    @Override
    public String getDetalles() {

        if (this.cantidad > 0) {
            String detalles1 = "<html>" + "-------Datos empresa----- " + "<br/>"
                    + this.empresa.getDescripcion()
                    + "<html>" + "-------Datos producto----- " + "<br/>"
                    + "<html>" + "Nombre Producto: " + this.nombreProducto + "<br/>"
                    + "<html>" + "Costo: " + this.costo + "<br/>"
                    + "<html>" + "Tipo: " + this.tipo + "<br/>"
                    + "<html>" + "Cantidad: " + this.cantidad + "<br/>";
            return detalles1;
        } else {
            String detalles2 = "<html>" + "Nombre Producto: " + this.nombreProducto + "<br/>"
                    + "<html>" + "Costo: " + this.costo + "<br/>"
                    + "<html>" + "Tipo: " + this.tipo + "<br/>";
            return detalles2;
        }

    }

    public static ArrayList<IProducto> generatedProductsComidasRapida(Empresa empresa) {
        ArrayList<IProducto> productosIniciales = new ArrayList<IProducto>();
        Producto p1 = new Producto("Hamburguesa", "Comida", 5000d, empresa);
        Producto p2 = new Producto("Taco", "Comida", 3000d, empresa);
        Producto p3 = new Producto("Quesadilla", "Comida", 4000d, empresa);
        Producto p4 = new Producto("Coca cola", "Refresco", 1000d, empresa);
        Producto p5 = new Producto("Ginger", "Refresco", 1000d, empresa);
        Producto p6 = new Producto("Pizza", "Comida", 12000d, empresa);
        Producto p7 = new Producto("Cajeta", "Comida", 1000d, empresa);
        Producto p8 = new Producto("Helado", "Comida", 2000d, empresa);

        productosIniciales.add(p1);
        productosIniciales.add(p2);
        productosIniciales.add(p3);
        productosIniciales.add(p4);
        productosIniciales.add(p5);
        productosIniciales.add(p6);
        productosIniciales.add(p7);
        productosIniciales.add(p8);

        return productosIniciales;
    }

    public static ArrayList<IProducto> generatedProductsRestaurante(Empresa empresa) {
        ArrayList<IProducto> productosIniciales = new ArrayList<IProducto>();
        Producto p1 = new Producto("Helado Frutas", "Comida", 5000d, empresa);
        Producto p2 = new Producto("Salchipapa", "Comida", 3000d, empresa);
        Producto p3 = new Producto("Gordita Camaron", "Comida", 4000d, empresa);
        Producto p4 = new Producto("Pepsi", "Refresco", 1000d, empresa);
        Producto p5 = new Producto("Fanta", "Refresco", 1000d, empresa);
        Producto p6 = new Producto("Arroz con camarones", "Comida", 12000d, empresa);
        Producto p7 = new Producto("Banana split", "Comida", 1000d, empresa);
        Producto p8 = new Producto("Crepa", "Comida", 2000d, empresa);

        productosIniciales.add(p1);
        productosIniciales.add(p2);
        productosIniciales.add(p3);
        productosIniciales.add(p4);
        productosIniciales.add(p5);
        productosIniciales.add(p6);
        productosIniciales.add(p7);
        productosIniciales.add(p8);

        return productosIniciales;
    }

    public static ArrayList<IProducto> generatedProductsSupermercado(Empresa empresa) {
        ArrayList<IProducto> productosIniciales = new ArrayList<IProducto>();
        Producto p1 = new Producto("Jabon", "Limpieza", 5000d, empresa);
        Producto p2 = new Producto("Shampoo", "Higiene", 3000d, empresa);
        Producto p3 = new Producto("Arroz", "Comida", 4000d, empresa);
        Producto p4 = new Producto("Desodorante", "Higiene", 1000d, empresa);
        Producto p5 = new Producto("Papel", "Higiene", 1000d, empresa);
        Producto p6 = new Producto("Frijoles", "Comida", 12000d, empresa);
        Producto p7 = new Producto("Aceite", "Comida", 1000d, empresa);
        Producto p8 = new Producto("Sal", "Comida", 2000d, empresa);

        productosIniciales.add(p1);
        productosIniciales.add(p2);
        productosIniciales.add(p3);
        productosIniciales.add(p4);
        productosIniciales.add(p5);
        productosIniciales.add(p6);
        productosIniciales.add(p7);
        productosIniciales.add(p8);

        return productosIniciales;
    }

    public static ArrayList<IProducto> generatedProductsFarmacia(Empresa empresa) {
        ArrayList<IProducto> productosIniciales = new ArrayList<IProducto>();
        Producto p1 = new Producto("Acetaminofen", "Enfermedades", 5000d, empresa);
        Producto p2 = new Producto("Ibuprofeno", "Enfermedades", 3000d, empresa);
        Producto p3 = new Producto("Tabcin Dia", "Enfermedades", 4000d, empresa);
        Producto p4 = new Producto("Curitas", "Accidente", 1000d, empresa);
        Producto p5 = new Producto("Vendas", "Accidente", 1000d, empresa);
        Producto p6 = new Producto("Ensure", "Crecimiento", 12000d, empresa);
        Producto p7 = new Producto("Dexametazona", "Infecciones", 1000d, empresa);
        Producto p8 = new Producto("Cataflan", "Infecciones", 2000d, empresa);

        productosIniciales.add(p1);
        productosIniciales.add(p2);
        productosIniciales.add(p3);
        productosIniciales.add(p4);
        productosIniciales.add(p5);
        productosIniciales.add(p6);
        productosIniciales.add(p7);
        productosIniciales.add(p8);

        return productosIniciales;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    

}
