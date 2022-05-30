/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecservices;

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

    private void nombreProductoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void tipoProductoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void costoProductoActionPerformed(java.awt.event.ActionEvent evt) {

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

        String detalles = "Nombre Producto: " + this.nombreProducto + "\n"
                + "Costo: " + this.costo + "\n"
                + "Tipo: " + this.tipo + "\n";

        return detalles;

    }

}
